package com.fabio.cursomc.domain;

import com.fabio.cursomc.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer statusPayment;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "demand_id")
    @MapsId
    private Demand demand;

    public Payment(){}

    public Payment(Integer id, StatusPayment statusPayment, Demand demand) {
        this.id = id;
        this.statusPayment = statusPayment.getCod();
        this.demand = demand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPayment getStatusPayment() {
        return StatusPayment.toEnum(statusPayment);
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment.getCod();
    }

    public Demand getOrder() {
        return demand;
    }

    public void setOrder(Demand demand) {
        this.demand = demand;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
