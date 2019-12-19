/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import entity.Buyer;
import entity.Product;
import entity.Purchase;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author pupil
 */
public interface Saveble {
    public void saveBuyers(ArrayList<Buyer> buyers);
    public Collection<? extends Buyer> loadBuyers();
    public void saveProducts(ArrayList<Product> products);
    public Collection<? extends Product> loadProducts();
    public void savePurchases(ArrayList<Purchase> purchases);
    public Collection<? extends Purchase> loadPurchase();
}
