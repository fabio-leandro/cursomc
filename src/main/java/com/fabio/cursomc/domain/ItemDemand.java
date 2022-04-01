package com.fabio.cursomc.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemDemand  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemDemandPK id = new ItemDemandPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemDemand(){}

    public ItemDemand(Demand demand, Product product, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setDemand(demand);
        id.setProduct(product);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Demand getDemand(){
        return id.getDemand();
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public ItemDemandPK getId() {
        return id;
    }

    public void setId(ItemDemandPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDemand that = (ItemDemand) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
