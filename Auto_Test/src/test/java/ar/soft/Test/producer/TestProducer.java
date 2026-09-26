package ar.soft.Test.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class TestProducer {
    private final KafkaProducer<String, String> producer;

    public TestProducer(String bootstrapServers) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.producer = new KafkaProducer<>(props);
    }

    public void sendOrderEvent(String topic, String orderId, String jsonMessage) {
        // Используем orderId в качестве ключа (Key) для обеспечения партиционирования
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, orderId, jsonMessage);
        try {
            producer.send(record).get(); // .get() для синхронной отправки в тестах
        } catch (Exception e) {
            throw new RuntimeException("Ошибка отправки в Kafka/Redpanda", e);
        }
    }

    public void close() {
        producer.close();
    }
}

