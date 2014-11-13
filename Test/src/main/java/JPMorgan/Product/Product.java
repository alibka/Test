package JPMorgan.Product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * Simple POJO to represent a product
 */
public class Product
{
    private float buy_price;
    private float sell_price;
    private float coupon;
    private String name;
    private String instrument_type;
    private int quantity;
    private float equityProf;
    private float bondProfit;
    StringBuilder builder = new StringBuilder();
    
    public Product() {
    }

    public Product(float sell_price, float coupon, float buy_price, String name, String instrument_type, int quantity) {
        this.buy_price = buy_price;
        this.name = name;
        this.instrument_type = instrument_type;
        this.quantity = quantity;
        this.sell_price = sell_price;
        this.coupon = coupon;
    }

    public float getbuy_price() {
        return buy_price;
    }
    
    public void setbuyPrice(String buy_price) {
        try{
            this.buy_price = Float.parseFloat(buy_price);
        }catch(NumberFormatException ex){
            System.out.println("Not a float, assigning 0");
            this.buy_price = 0;
        }
    }
    
    
    public float getsell_price() {
        return sell_price;
    }
    
    public void setsellPrice(String sell_price) {
        try{
            this.sell_price = Float.parseFloat(sell_price);
        }catch(NumberFormatException ex){
            System.out.println("Problem with the value, assigning 0");
            this.sell_price = 0;
        }        
    }
    
    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        try{
            this.coupon = Float.parseFloat(coupon);
        }catch(NumberFormatException ex){
            System.out.println("Problem with the value, assigning 0");
            this.coupon = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length()<0) throw new Exception();
        this.name = name;
    }

    public String getType() {
        return instrument_type;
    }

    public void setType(String instrument_type) throws Exception {
        if(instrument_type.length()<0) throw new Exception();
        this.instrument_type = instrument_type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        try{
            this.quantity = Integer.parseInt(quantity);
        }catch(NumberFormatException ex){
            System.out.println("Not a number, assigning 0");
            this.quantity = 0;
        }
    }
    
    public void setEquityProfit(){
        //Equity profit = (sell_price - buy_price) * quantity
        equityProf = (getsell_price() - getbuy_price() )*getQuantity();
    }
    
    public void setBondProfit(){
        //Bond profit = quantity * coupon
        bondProfit = getQuantity() * getCoupon();
    }
    
    public float getBondProfit(){
        return bondProfit;
    }
    
    public float getEquityProfit(){
        return equityProf;
    }
    
    public float getProfit(){
        return bondProfit+equityProf;
    }
    
    public String getRecordRow(){
            builder.append(getType());
            builder.append(",");
            builder.append(getName());
            builder.append(",");
            builder.append(String.valueOf(getQuantity()));
            builder.append(",");
            builder.append(String.valueOf(getProfit()));
        return builder.toString();
    }
}
