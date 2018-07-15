package ru.raiffeisen.cources.atm.model.score;

import ru.raiffeisen.cources.atm.annotations.MethodLimit;
import ru.raiffeisen.cources.atm.annotations.OperationLimit;
import ru.raiffeisen.cources.atm.model.account.Account;
import ru.raiffeisen.cources.atm.model.constants.CurrencyHolder;
import ru.raiffeisen.cources.atm.model.money.Money;

@OperationLimit(countOfOperationLimit = 2)
public class CurrentScore extends Score{
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    @Override
    @MethodLimit( 1)
    public void addMoney(Money money){
        if(money.getValue() > 1000000) {
            Money moneyToDebet = new Money(2000, money.getCurrency().getName());
            debetScore.addMoney(moneyToDebet);
        }
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess){
        if(this.getBalance().getValue() - balanceLess <= 0) {
            System.out.println("No money!");
            return null;
        }

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
