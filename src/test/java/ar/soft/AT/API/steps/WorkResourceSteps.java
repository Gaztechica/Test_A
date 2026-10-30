package ar.soft.AT.API.steps;

import ar.soft.AT.API.models.workResource.request.LabourType;
import ar.soft.AT.API.models.workResource.request.ResourceType;
import ar.soft.AT.API.models.workResource.request.WorkResourceCreateRequest;
import ar.soft.AT.API.models.workResource.respons.ResponseDto;
import ar.soft.AT.API.models.workResource.respons.ResponseWorkResourceDto;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Step;
import java.time.LocalDate;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkResourceSteps {

//    private ResponseDto<?> apiResponse;
    // Вариант со знаком вопроса <?> (wildcard) означает «ответ с неизвестно какими данными внутри». Если оставить его,
    // то при попытке сделать apiResponse.getData().getId() Java выдаст ошибку, так как она не будет знать,
    // что внутри data есть метод getId().
    private ResponseDto<ResponseWorkResourceDto> apiResponse;


    private WorkResourceSteps lastResponse;
    private final RequestSpecification spec;

    public WorkResourceSteps(RequestSpecification spec) {
        this.spec = spec;
    }

    public WorkResourceSteps createWork(WorkResourceCreateRequest request) {
        step("API Шаг: Отправить POST-запрос на создание ресурса", () ->
                given()
                        .body(request, io.restassured.mapper.ObjectMapperType.JACKSON_2)
                        .when()
                        .post("work/create")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(new io.restassured.common.mapper.TypeRef<ResponseDto<ResponseWorkResourceDto>>() {})
        );
        return this;
    }


//    public WorkResourceSteps createWork(Long projectId, Long employmentId, LocalDate entryDate,
//                                        ResourceType resourceType, LabourType labourType, Integer planValue,
//                                        Integer factValue, Integer recommendedValue) {
//        apiResponse = step("API Шаг: Отправить POST-запрос на создание ресурса '" + lastResponse + "'", () ->
//                given()
//                        .body(WorkResourceCreateRequest.builder()
//                                .projectId(projectId)
//                                .employmentId(employmentId)
//                                .entryDate(entryDate)
//                                .resourceType(resourceType)
//                                .labourType(labourType)
//                                .planValue(planValue)
//                                .factValue(factValue)
//                                .recommendedValue(recommendedValue)
//                                .build())
//                        .when()
//                        .post("work/create")
//                        .then().log().all()
//                        .statusCode(200)
////                         Используем TypeRef, чтобы Jackson точно знал, как сматчить вложенный data в ResponseWorkResourceDto
////                         Использование TypeRef вместо .as(ResponseDto.class) — это важная фишка REST Assured.
////                        Она помогает Java не «терять» внутренние поля объекта data при чтении JSON.
//                        .extract().as(new io.restassured.common.mapper.TypeRef<ResponseDto<ResponseWorkResourceDto>>() {
//                        })
//        );
//        return this;
//    }

    @Step("API Проверка: Поля ответа соответствуют отправленному запросу")
    public WorkResourceSteps checkResponseMatches(WorkResourceCreateRequest request) {
        ResponseWorkResourceDto actualData = getResponseData();

        assertThat(actualData)
                .as("Бизнес-поля ответа должны полностью совпадать с запросом")
                .usingRecursiveComparison()
                // Игнорируем поля ответа, которых не было в запросе (id и флаги редактирования)
                .ignoringFields("id", "planEdited", "factEdited", "recommendedEdited", "mechanismTypeName", "employmentName")
                // Разрешаем сравнивать Enum с Enum из разных пакетов по их строковому значению
                .withEqualsForType((e1, e2) -> e1.toString().equals(e2.toString()), Enum.class)
                .isEqualTo(request);

        // Дополнительно проверяем то, что проигнорировали (если это необходимо)
        assertThat(actualData.getId()).as("ID ресурса").isNotNull();

        return this;
    }
//    @Step("API Проверка: Поля ответа соответствуют отправленному запросу")
//    public WorkResourceSteps checkResponseMatches(WorkResourceCreateRequest request) {
//        ResponseWorkResourceDto actualData = getResponseData(); // Используем созданный ранее метод
//
//        // Проверяем, что ID сгенерировался
//        assertThat(actualData.getId())
//                .as("ID созданного ресурса должен быть заполнен")
//                .isNotNull();
//
//        return this; // Возвращаем текущий класс шагов для продолжения цепочки
//    }

    public WorkResourceSteps verifyMetadataSuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
//            assertThat(lastResponse.getSuccess()).isEqualTo("object has been added to the catalog");
//            assertThat(lastResponse.getError()).isNull();
        });
        return this;
    }

    public Long getCreatedResourceId() {
        if (apiResponse == null || apiResponse.getData() == null) {
            throw new IllegalStateException("Не удалось получить ID: ответ от сервера пустой или не был получен!");
        }
        return apiResponse.getData().getId(); // Достаем id из вложенного бизнес-объекта
//        или
//        return apiResponse.getData(); // Возвращаем объект целиком
//        Как это использовать в тесте:
//        Теперь вы можете достать абсолютно всё, что захотите, прямо внутри теста:

//        var data = steps.getResponseData();
//
//        Long id = data.getId();
//        String name = data.getEmploymentName();
//        Integer plan = data.getPlanValue();
    }

        public ResponseWorkResourceDto getResponseData() {
            if (apiResponse == null || apiResponse.getData() == null) {
                throw new IllegalStateException("Ответ от сервера пустой или не был получен!");
            }
            return apiResponse.getData();
        }



}
