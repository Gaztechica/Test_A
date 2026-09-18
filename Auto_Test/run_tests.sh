#!/bin/bash

# Завершать скрипт при любой ошибке
set -e

echo "=== 1. Запуск инфраструктуры в Docker ==="
# Поднимаем контейнеры в фоне
docker compose up -d

echo "=== 2. Ожидание готовности базы данных и брокера ==="
# Ждем, пока отработают healthcheck'и, прописанные в docker-compose.yml
docker compose wait postgres redpanda

echo "=== 3. Запуск автоматических тестов (Maven) ==="
# Запускаем тесты. Используем || true, чтобы скрипт не упал до генерации отчета, если тесты упадут
mvn test || TEST_RESULT=$?

echo "=== 4. Генерация и сохранение Allure-отчета ==="
# Генерируем финальный отчет из результатов таргета
if command -v allure &> /dev/null; then
    allure generate target/allure-results --clean -o allure-report
    echo "Отчет успешно сохранен в папку allure-report/"
else
    echo "Предупреждение: утилита 'allure' не найдена в системе. Результаты сохранены в target/allure-results."
fi

echo "=== 5. Очистка окружения и удаление данных ==="
# Останавливаем контейнеры и полностью удаляем анонимные volumes (-v)
docker compose down -v

# Возвращаем исходный код завершения тестов для CI/CD систем
if [ -n "$TEST_RESULT" ]; then
    exit $TEST_RESULT
fi
