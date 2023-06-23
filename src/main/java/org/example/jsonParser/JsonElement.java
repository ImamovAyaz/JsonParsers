package org.example.jsonParser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Аннотация доступна в runTime для использования в Reflection
@Target(ElementType.FIELD) //принимай аннотацию только к полям объекта
public @interface JsonElement {
    String key() default "";
}
