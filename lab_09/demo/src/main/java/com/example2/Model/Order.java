package Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;



@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "total_price")
    private Integer totalPrice;



    public  Order(){};

    public Order(Integer id, Integer amount, Integer customerId, Integer totalPrice) {
        this.id = id;
        this.amount = amount ;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}



