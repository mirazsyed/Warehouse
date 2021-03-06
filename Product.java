import java.util.*;
import java.lang.*;
import java.io.*;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String prodName;
    private int quantity;
    private double price;
    private String id;
    private List productSuppliers = new LinkedList();
    private static final String PRODUCT_STRING = "P";

    // NOTE: Final design won't have the contructor list quantity, this comes from
    //       shipments in development stage 3.
    public Product(String prodName, int quantity, double price) {
        this.prodName = prodName;
        this.quantity = quantity;
        this.price = moneyRound(price);
        id = PRODUCT_STRING + (ProductIDServer.instance()).getID();
    }

    public String getProdName() {
        return prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getID() {
        return id;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    // Used to check equality in searching
    public boolean equals(String id) {
        return this.id.equals(id);
    }

    // Assign relationship between products and suppliers.
    public boolean link(Supplier supplier) {
        return productSuppliers.add(supplier) ? true : false;
    }

    // Unassign relationship between products and suppliers.
    public boolean unlink(Supplier supplier) {
        return productSuppliers.remove(supplier) ? true : false;
    }

    public double moneyRound(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    public String toString() {
        return "Product: " + prodName + " ID: " + id + " Price: $" + price + " Qty: " + quantity;

    }
}
