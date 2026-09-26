package ar.soft.Test.producer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class TestConsumer {
    private final KafkaConsumer<String, String> consumer;
    private final Connection dbConnection;

    public TestConsumer(String bootstrapServers, Connection dbConnection) {
        this.dbConnection = dbConnection;

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        this.consumer = new KafkaConsumer<>(props);
    }

    // Метод вычитывает доступные сообщения и сохраняет в БД с защитой от дублей
    public void consumeAndSave(String topic) {
        consumer.subscribe(Collections.singletonList(topic));
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(2000));

        for (ConsumerRecord<String, String> record : records) {
            String orderId = record.key(); // Получаем orderId из ключа
            String jsonPayload = record.value();

            // Простая имитация парсинга статуса из JSON: {"orderId": "123", "status": "PAID"}
            String status = jsonPayload.contains("PAID") ? "PAID" : "UNKNOWN";

            saveOrderWithDeduplication(orderId, status);
        }
    }

    private void saveOrderWithDeduplication(String orderId, String status) {
        // Использование ИНДЕКСА или PRIMARY KEY + ON CONFLICT гарантирует идемпотентность на стороне БД
        String sql = "INSERT INTO orders (order_id, status) VALUES (?, ?) " +
                "ON CONFLICT (order_id) DO NOTHING";

        try (PreparedStatement pstmt = dbConnection.prepareStatement(sql)) {
            pstmt.setString(1, orderId);
            pstmt.setString(2, status);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Ошибка сохранения в БД: " + e.getMessage());
        }
    }

    public void close() {
        consumer.close();
    }
}

