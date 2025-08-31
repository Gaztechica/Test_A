package ru.qa.annotation;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

/**
 * @author Slava Solodov
 * @created 31/03/2023 - 10:09
 * @email vsolodov@cbgr.ru
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "Section5")
public @interface Section5 {
    String value();
}
