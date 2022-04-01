package com.fabio.cursomc.domain;

import com.fabio.cursomc.domain.enums.StatusPayment;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class SlipPayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Date dueDate;
    private Date paymentDate;

    public SlipPayment(){}

    public SlipPayment(Integer id, StatusPayment statusPayment, Demand demand, Date dueDate, Date paymentDate) {
        super(id, statusPayment, demand);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
