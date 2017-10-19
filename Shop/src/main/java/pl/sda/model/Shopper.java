package pl.sda.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopper")
public class Shopper {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "shoppers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    @OneToOne(mappedBy = "shopperS", targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User userU;

    public Shopper() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public User getUserU() {
        return userU;
    }

    public void setUserU(User userU) {
        this.userU = userU;
    }
}
