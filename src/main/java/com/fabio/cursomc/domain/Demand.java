package com.fabio.cursomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "demand")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Demand(){}

    public Demand(Integer id, Date instant, Customer customer, Address address) {
        this.id = id;
        this.instant = instant;
        this.customer = customer;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        return Objects.equals(id, demand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
