/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pupil
 */

@Entity 
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Temporal(TemporalType.TIMESTAMP)
        private Date giveOfDate;
        @OneToOne
        private Buyer buyer;
        @OneToOne
        private Product product;
        
        private double moneyOfShop;

    public Purchase() {
    }

    public Purchase(Date giveOfDate, Buyer buyer, Product product, double moneyOfShop) {
        this.giveOfDate = giveOfDate;
        this.buyer = buyer;
        this.product = product;
        this.moneyOfShop = moneyOfShop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGiveOfDate() {
        return giveOfDate;
    }

    public void setGiveOfDate(Date giveOfDate) {
        this.giveOfDate = giveOfDate;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getMoneyOfShop() {
        return moneyOfShop;
    }

    public void setMoneyOfShop(double moneyOfShop) {
        this.moneyOfShop = moneyOfShop;
    }

    @Override
    public String toString() {
        return "Purchase{" + "giveOfDate=" + giveOfDate + ", buyer=" + buyer + ", product=" + product + ", moneyOfShop=" + moneyOfShop + '}';
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.giveOfDate);
        hash = 67 * hash + Objects.hashCode(this.buyer);
        hash = 67 * hash + Objects.hashCode(this.product);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.moneyOfShop) ^ (Double.doubleToLongBits(this.moneyOfShop) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        if (Double.doubleToLongBits(this.moneyOfShop) != Double.doubleToLongBits(other.moneyOfShop)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.giveOfDate, other.giveOfDate)) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    
    
        
        
        
        
    }
