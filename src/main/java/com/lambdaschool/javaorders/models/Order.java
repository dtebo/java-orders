package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordernum;

    private double ordamount;

    private double advanceamount;

    @OneToMany(mappedBy = "customer",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @Column(nullable = false)
    List<Order> orders = new ArrayList<>();

    private String orderdescription;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @ManyToMany()
    @JoinTable(name = "orderpayments",
               joinColumns = @JoinColumn(name = "ordernum"),
               inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Payment> payments = new HashSet<>();

    public Order() {
    }

    public Order(double ordamount, double advanceamount, List<Order> orders, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orders = orders;
        this.orderdescription = orderdescription;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordernum=" + ordernum +
                ", ordamount=" + ordamount +
                ", advanceamount=" + advanceamount +
                ", orders=" + orders +
                ", orderdescription='" + orderdescription + '\'' +
                '}';
    }
}
