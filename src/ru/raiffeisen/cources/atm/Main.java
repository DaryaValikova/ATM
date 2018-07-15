package ru.raiffeisen.cources.atm;

import ru.raiffeisen.cources.atm.model.money.Money;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите сумму");
        int val = scanner.nextInt();
//        atm.getMethodLimits();

        Money money = new Money(val, "RUR");
        System.out.println(atm.getCurrentScore().getBalance());
        atm.getCurrentScore().getMoney(100);
        System.out.println(atm.getCreditScore().getBalance());
        atm.getCreditScore().getMoney(8000);
        System.out.println(atm.getCreditScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());
        System.out.println(atm.getDebetScore().getBalance());


    }
}
