package myclasses;

import entity.Buyer;
import entity.Product;
import entity.Purchase;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ShopProvider {
    private Scanner scanner = new Scanner(System.in);
    
    public Purchase takeOnProduct(ArrayList<Product> products, ArrayList<Buyer> buyers, ArrayList<Purchase>purchases){
        HashSet<Product> setProducts = new HashSet<>();
        int counterProducts = 0;
        
        boolean buys = true;
      
        
        System.out.println("Список продуктов: ");
        boolean flag = true;
        for (int i = 0; i < products.size(); i++) {
            for(Purchase purchase: purchases){
                if(purchase.getProduct().equals(products.get(i)) 
                        && purchase.getProduct() == null){
                    flag = false;
                    break;
                }
            }
            if(flag){
                setProducts.add(products.get(i));
            }
            flag=true;
            if(setProducts.contains(products.get(i))){
                System.out.println(i+1+". "+products.get(i).toString());
                counterProducts++;
            }
            
        }
        
        
        System.out.println("Выберите продукт: ");
        int indexProduct = scanner.nextInt();
        Product product = products.get(indexProduct-1);
        boolean next = true;
        do{
            if (product.getCount() == 0){
                System.out.println("Этого продукта нету");
                indexProduct = 0;
                System.out.println("Выберите продукт: ");
                
                indexProduct = scanner.nextInt();
                product = products.get(indexProduct-1);
                next = true;
            }else if(product.getCount() > 0){
                next = false;
            }
        }while(next);
        
        System.out.println("Выберите количество: ");
        int indexCount = scanner.nextInt();
        
        double countPrice = 0;
        if(product.getPrice() != 0){
            
            countPrice = countPrice + product.getPrice() * indexCount ;
            int countofProduct = product.getCount()-indexCount;
            product.setCount(countofProduct);
             
            
        }
        
       
        System.out.println("Покупатели: ");
        for (int i = 0; i < buyers.size(); i++) {
            Buyer buyer = buyers.get(i);
            System.out.println(i+1+". " + buyer.toString());
            int countOfMoney = 0;
            
               
            
        }
        
        System.out.println("Выберите Покупателя: ");
        int indexBuyer = scanner.nextInt();
        Buyer buyer = buyers.get(indexBuyer-1);
        long buyerid = buyer.getId();
        if( buyerid == indexBuyer ){
            if(product.getId() == indexProduct){
                double withdrawMoney = buyer.getMoney() - indexCount * product.getPrice();
                
                buyer.setMoney((int) withdrawMoney);
            
            }
            
        }
        
        System.out.println("Покупатель: "+buyer.getName()+" Корзина: "+countPrice);
//        Purchase purchase = new Purchase(new Date (), buyer, product, countPrice);
//        return purchase;
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setId(buyerid);
        purchase.setGiveOfDate(new Date());
        purchase.setMoneyOfShop(countPrice);
        
        
        return purchase;
        
       
        
    
   }
}