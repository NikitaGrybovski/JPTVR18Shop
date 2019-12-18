/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Buyer;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BuyerProvider {
    public Buyer createBuyer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание покупателя ---");
        System.out.println("Имя покупателя:");
        String name = scanner.nextLine();
        System.out.println("Деньги в кошельке:");
        int money = scanner.nextInt();
        scanner.nextLine();
        Buyer buyer = new Buyer(name, money);
        return buyer;
    }
}
