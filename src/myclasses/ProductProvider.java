/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Buyer;
import entity.Product;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ProductProvider {
    public Product createProduct(){
      Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание продукта ---");
        System.out.println("Название продукта:");
        String NameOfProduct = scanner.nextLine();
        System.out.println("цена:");
        double price = scanner.nextDouble();
        System.out.println("количество:");
        int count = scanner.nextInt();
        
        Product product = new Product(NameOfProduct, count, price);
        return product;
       
    }
}
