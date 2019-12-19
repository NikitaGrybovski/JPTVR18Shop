package jptvr18shop;


import entity.Buyer;
import entity.Product;
import entity.Purchase;
import java.util.ArrayList;
import java.util.Scanner;
import myclasses.BuyerProvider;
import myclasses.ProductProvider;
import myclasses.ShopProvider;

import storage.Saveble;
import storage.SaverToBase;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pupil
 */
public class App {
    
private ArrayList<Product> product = new ArrayList<>();
private ArrayList<Buyer> buyer = new ArrayList<>();
private ArrayList<Purchase> purchases = new ArrayList<>();
private Saveble saveble;
    public App() {
        this.saveble = new SaverToBase();
        this.product.addAll(saveble.loadProducts());
        this.buyer.addAll(saveble.loadBuyers());
        this.purchases.addAll(saveble.loadPurchase());
    }

    public void run() {
        System.out.println("Магазин");
        boolean repeat = true;
        boolean buys = true;
        do {
            System.out.println("0. Выход из программы");
            System.out.println("1. Создание продукта");
            System.out.println("2. Создание покупателя");
            System.out.println("3. Покупка");
            System.out.println("4. Список всех товаров в магазине");
            System.out.println("5. Список пользователей магазина");
            System.out.println("6. Функция подсчета прибыли магазина");
            System.out.println("Выберите задачу: ");
            repeat = true;
            
            Scanner scanner = new Scanner(System.in);
            int task = scanner.nextInt();
            switch (task) {
                case 0:
                   System.out.println("Закрытие программы");
                    repeat = false;
                    break;
            
                case 1:
                   ProductProvider productProvider = new ProductProvider();
                   product.add(productProvider.createProduct());
                   saveble.saveProducts(product);
                   break;
                   
            
                case 2:
                    BuyerProvider buyerProvider = new BuyerProvider();
                    buyer.add(buyerProvider.createBuyer());
                    saveble.saveBuyers(buyer);
                    break;
                case 3:
                    
                    do{
                    ShopProvider shopProvider = new ShopProvider();
                    Purchase purchase = shopProvider.takeOnProduct(product, buyer, purchases);
                    saveble.savePurchases(purchases);
                    System.out.println("Продолжить покупку, если да то введите 1, если нет то 0");
                    int rep = scanner.nextInt();
                    if (rep == 0){
                        buys = false;
                    }else if(rep== 1){
                        buys = true;
                    }
                    }while(buys);
                    
                    
                    
                case 4:
                    for (int i = 0; i < product.size(); i++) {
                        
                        System.out.println(product.get(i).toString());
                        
                    }
                    
                    break;
            
                case 5:
                    for (int i = 0; i < buyer.size(); i++) {
                        
                        System.out.println(buyer.get(i).toString());
                        
                    }
                    
                    break;
                case 6:
                    
                    break;  
                default:
                    System.out.println("Выберите задачу из списка!");
                    break;
            }
        } while (repeat);
    }
}
