package ar.soft.AT.API.tests;

import ar.soft.AT.API.BaseApi.apiBaseTest.BaseTest;
import ar.soft.AT.API.models.workResource.request.LabourType;
import ar.soft.AT.API.models.workResource.request.ResourceType;
import ar.soft.AT.API.models.workResource.request.WorkResourceCreateRequest;
import ar.soft.AT.API.steps.WorkResourceSteps;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Тесты API Ресурсы и механизмы")
public class WorkResourceTest extends BaseTest {

    private Long createdId; // Переменная на уровне тестового класса для хранения ID

//    @Test
//    @Order(1)
//    @DisplayName("Успешное создание Ресурса")
//    public void createWorkResourceTest() {
//        WorkResourceSteps steps = new WorkResourceSteps(requestSpec);
//
//        // 1. Создаем ресурс
//        steps.createWork(893L, 205L, LocalDate.parse("2026-10-03"), ResourceType.LABOUR,
//                LabourType.WORKER, 4, 5, 3);
//
//        // 2. Достаем ID и сохраняем его в переменную класса
//        createdId = steps.getCreatedResourceId();
//
//        Assertions.assertNotNull(createdId, "ID ресурса не должен быть null!");
//    }

    @Test
    @Order(1)
    public void successCreateWorkResourceTest() {
        // 1. Сначала готовим тело запроса (чтобы передать его и в метод создания, и в метод проверки)
        WorkResourceCreateRequest requestBody = WorkResourceCreateRequest.builder()
                .projectId(893L)
                .employmentId(205L)
                .entryDate(LocalDate.parse("2026-09-26"))
//                Беру текущую дату и отнимаю от неё 5 дней (это в пределах 10 дней в прошлом)
//        .entryDate(LocalDate.now().minusDays(5))
                .resourceType(ResourceType.LABOUR)
                .labourType(LabourType.WORKER)
                .planValue(4)
                .factValue(5)
                .recommendedValue(3)
                .build();

        // 2. Вызываем шаги по цепочке: создаем -> проверяем
        new WorkResourceSteps(requestSpec)
                .createWork(requestBody)          // Передаем весь объект целиком
                .checkResponseMatches(requestBody); // И его же отправляем на проверку
    }

    @Test
    @Order(2)
    public void useCreatedResourceInNextTest() {
        // 3. Используем полученный ID в теле запроса следующего теста (например, для удаления или обновления)
//        new WorkResourceSteps(requestSpec)
//                .deleteWork(createdId); // Или передаем в builder другого запроса
    }
}
