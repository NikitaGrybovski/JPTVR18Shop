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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToBase implements Saveble {
    private EntityManager em;
    private EntityTransaction tx;
    
    public SaverToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR18ShopPU");
         this.em = emf.createEntityManager();
         this.tx = em.getTransaction();
         
        
    }
    
    @Override
    public void saveBuyers(ArrayList<Buyer> buyers) {
        tx.begin();
        for (int i = 0; i < buyers.size(); i++) {
            
            Buyer buyer = buyers.get(i);
            if(buyer.getId() == null){
                em.persist(buyer);
            }
            
            
            
            
        }
        tx.commit();
    }
    @Override
    public Collection<? extends Buyer> loadBuyers(){
        try{
            return em.createQuery("SELECT buyer FROM Buyer buyer")
                .getResultList();
        } catch (Exception e){
            return null;
           }
        
    }
    @Override
    public void saveProducts(ArrayList<Product> products){
       tx.begin();
        for (int i = 0; i < products.size(); i++) {
            
            Product product = products.get(i);
           if(product.getId() == null){
               em.persist(product);
            }
           
           
           
       }
       tx.commit();
  }
    @Override
    public Collection<? extends Product> loadProducts(){
        try{
           return em.createQuery("SELECT product FROM Product product")
               .getResultList();
       } catch (Exception e){
           return null;
          }
       
    }
    @Override
    public void savePurchases(ArrayList<Purchase> purchases) {
       tx.begin();
        for (int i = 0; i < purchases.size(); i++) {
            
            Purchase purchase = purchases.get(i);
           if(purchase.getId() == null){
               em.persist(purchase);
            }
           
           
           
       }
       tx.commit();
        
    }
    
    
    @Override
    public Collection<? extends Purchase> loadPurchase(){
    
        try{
           return em.createQuery("SELECT purchase FROM Purchase purchase")
               .getResultList();
       } catch (Exception e){
           return null;
          }
    }
}
