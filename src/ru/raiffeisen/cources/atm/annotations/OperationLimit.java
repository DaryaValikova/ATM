package ru.raiffeisen.cources.atm.annotations;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface OperationLimit {
    int countOfOperationLimit();
}
