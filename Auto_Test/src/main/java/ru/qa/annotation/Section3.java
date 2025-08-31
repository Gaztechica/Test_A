package ru.qa.annotation;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

/**
 * @author Slava Solodov
 * @created 29/03/2023 - 13:30
 * @email vsolodov@cbgr.ru
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "Section3")
public @interface Section3 {
    String value();
}
