package pl.sda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private List<Long> productsIds = new ArrayList<>();

    public Integer getSize(){
        return productsIds.size();
    }

    public Basket( String user){
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Long> getProductsIds() {
        return productsIds;
    }
}
