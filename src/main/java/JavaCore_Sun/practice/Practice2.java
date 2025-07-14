package JavaCore_Sun.practice;// File: Practice2.java
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class Product {
    protected String id;
    protected String name;
    protected int quantity;
    protected double price;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = Math.max(quantity, 0);
        this.price = price;
    }

    public abstract double getVAT();
    public abstract String evaluate();

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("VAT: " + getVAT());
        System.out.println("Evaluation: " + evaluate());
    }
}

class Food extends Product {
    private LocalDate mfgDate;
    private LocalDate expDate;
    private String supplier;

    public Food(String id, String name, int quantity, double price, LocalDate mfgDate, LocalDate expDate, String supplier) {
        super(id, name, quantity, price);
        this.mfgDate = mfgDate;
        this.expDate = expDate.isAfter(mfgDate) || expDate.isEqual(mfgDate) ? expDate : mfgDate;
        this.supplier = supplier;
    }

    @Override
    public double getVAT() {
        return 0.05;
    }

    @Override
    public String evaluate() {
        return (quantity > 0 && expDate.isBefore(LocalDate.now())) ? "Khó bán" : "Không đánh giá";
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Mfg Date: " + mfgDate);
        System.out.println("Exp Date: " + expDate);
        System.out.println("Supplier: " + supplier);
    }
}

class Electronics extends Product {
    private int warrantyMonths;
    private double powerKW;

    public Electronics(String id, String name, int quantity, double price, int warrantyMonths, double powerKW) {
        super(id, name, quantity, price);
        this.warrantyMonths = Math.max(warrantyMonths, 0);
        this.powerKW = Math.max(powerKW, 0);
    }

    @Override
    public double getVAT() {
        return 0.10;
    }

    @Override
    public String evaluate() {
        return (quantity < 3) ? "Đã bán" : "Không đánh giá";
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty (months): " + warrantyMonths);
        System.out.println("Power (KW): " + powerKW);
    }
}

class Ceramic extends Product {
    private String manufacturer;
    private LocalDate importDate;

    public Ceramic(String id, String name, int quantity, double price, String manufacturer, LocalDate importDate) {
        super(id, name, quantity, price);
        this.manufacturer = manufacturer;
        this.importDate = importDate;
    }

    @Override
    public double getVAT() {
        return 0.10;
    }

    @Override
    public String evaluate() {
        long daysInStorage = ChronoUnit.DAYS.between(importDate, LocalDate.now());
        return (quantity > 50 && daysInStorage > 10) ? "Bán chậm" : "Không đánh giá";
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Import Date: " + importDate);
    }
}

class ProductManager {
    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product p) {
        for (Product existing : products) {
            if (existing.getId().equals(p.getId())) {
                System.out.println("Trùng mã sản phẩm! Không thêm được.");
                return false;
            }
        }
        products.add(p);
        return true;
    }

    public void displayAll() {
        for (Product p : products) {
            System.out.println("-----------------------");
            p.display();
        }
    }
}

public class Practice2 {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Thực phẩm
        manager.addProduct(new Food("F001", "Sữa", 10, 12000, LocalDate.of(2025,7,1), LocalDate.of(2025,7,30), "Vinamilk"));

        // Điện tử
        manager.addProduct(new Electronics("E001", "Tủ lạnh", 2, 8000000, 24, 0.5));

        // Đồ gốm
        manager.addProduct(new Ceramic("C001", "Bình gốm sứ", 60, 150000, "Bát Tràng", LocalDate.of(2025,6,20)));

        manager.displayAll();
    }
}
