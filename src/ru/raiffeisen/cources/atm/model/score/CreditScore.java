package ru.raiffeisen.cources.atm.model.score;

import ru.raiffeisen.cources.atm.annotations.OperationLimit;
import ru.raiffeisen.cources.atm.model.account.Account;
import ru.raiffeisen.cources.atm.model.money.Money;

@OperationLimit(countOfOperationLimit = 1)
public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

//    @Override
//    public Money getBalance(Money money){
//        return super.getBalance();
//    }

    @Override
    public void addMoney(Money money){
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess){
        return super.getMoney(balanceLess);
    }

    @Override
    public Money getMoneyWithoutLess(){
        return super.getMoneyWithoutLess();
    }

    @Override
    protected boolean checkBefore() {
        return true;
    }
}
