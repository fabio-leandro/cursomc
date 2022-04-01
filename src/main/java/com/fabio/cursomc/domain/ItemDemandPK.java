package com.fabio.cursomc.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemDemandPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "demand_id")
    private Demand demand;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDemandPK that = (ItemDemandPK) o;
        return Objects.equals(demand, that.demand) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demand, product);
    }
}
