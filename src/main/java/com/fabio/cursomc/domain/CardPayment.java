package com.fabio.cursomc.domain;

import com.fabio.cursomc.domain.enums.StatusPayment;

import javax.persistence.Entity;

@Entity
public class CardPayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Integer numberPayments;

    public CardPayment(){}

    public CardPayment(Integer id, StatusPayment statusPayment, Demand demand, Integer numberPayments) {
        super(id, statusPayment, demand);
        this.numberPayments = numberPayments;
    }

    public Integer getNumberPayments() {
        return numberPayments;
    }

    public void setNumberPayments(Integer numberPayments) {
        this.numberPayments = numberPayments;
    }
}
