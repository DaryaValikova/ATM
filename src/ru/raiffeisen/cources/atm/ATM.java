package ru.raiffeisen.cources.atm;

import ru.raiffeisen.cources.atm.annotations.LimitOfOperation;
import ru.raiffeisen.cources.atm.annotations.MethodLimit;
import ru.raiffeisen.cources.atm.annotations.OperationLimit;
import ru.raiffeisen.cources.atm.model.constants.CurrencyHolder;
import ru.raiffeisen.cources.atm.model.money.Money;
import ru.raiffeisen.cources.atm.model.score.CreditScore;
import ru.raiffeisen.cources.atm.model.score.CurrentScore;
import ru.raiffeisen.cources.atm.model.score.DebetScore;
import ru.raiffeisen.cources.atm.model.score.Score;

import java.lang.annotation.Annotation;

public class ATM {
    private CurrentScore currentScore;
    private DebetScore debetScore;
    private CreditScore creditScore;


    public ATM() {
        this.creditScore =
                new CreditScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1);
        this.debetScore =
                new DebetScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.creditScore);
        this.currentScore =
                new CurrentScore(
                        new Money(1000.0d,
                                CurrencyHolder.getCurrencyByName("RUR").getName()
                        ), null, 1, this.debetScore);
    }

    public CurrentScore getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(CurrentScore currentScore) {
        this.currentScore = currentScore;
    }

    public DebetScore getDebetScore() {
        return debetScore;
    }

    public void setDebetScore(DebetScore debetScore) {
        this.debetScore = debetScore;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

//    public void getMethodLimits() {
//        int limitOfMethods = 0;
//
//        Class thisClass = this.getClass();
//
//        for (Annotation annotation : thisClass.getAnnotations())
//            if (annotation instanceof MethodLimit) {
//                MethodLimit methodLimit = (MethodLimit) annotation;
//                limitOfMethods++;
//                if (limitOfMethods == methodLimit.value()) {
//                    System.out.println("Превышен лимит методов по счету");
//                    break;
//                }
//                return;
//            }
//    }
}
