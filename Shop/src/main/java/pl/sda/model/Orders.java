package pl.sda.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<JoinOrdersAndProduct> joinOrdersAndProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shoppers;

    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<JoinOrdersAndProduct> getJoinOrdersAndProducts() {
        return joinOrdersAndProducts;
    }

    public void setJoinOrdersAndProducts(List<JoinOrdersAndProduct> joinOrdersAndProducts) {
        this.joinOrdersAndProducts = joinOrdersAndProducts;
    }

    public Shopper getShoppers() {
        return shoppers;
    }

    public void setShoppers(Shopper shoppers) {
        this.shoppers = shoppers;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
