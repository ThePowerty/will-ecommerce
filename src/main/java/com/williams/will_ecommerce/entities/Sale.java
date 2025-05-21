package com.williams.will_ecommerce.entities;

import com.williams.will_ecommerce.entities.utils.PaymentMethod;
import com.williams.will_ecommerce.entities.utils.SaleStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long client_id;
    private Long car_id;
    private LocalDate sales_date;
    private Double sales_price;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    public Sale() {
    }

    public Sale(Long client_id, Long car_id, LocalDate sales_date, Double sales_price, PaymentMethod paymentMethod) {
        this.client_id = client_id;
        this.car_id = car_id;
        this.sales_date = sales_date;
        this.sales_price = sales_price;
        this.paymentMethod = paymentMethod;
        this.status = SaleStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public LocalDate getSales_date() {
        return sales_date;
    }

    public void setSales_date(LocalDate sales_date) {
        this.sales_date = sales_date;
    }

    public Double getSales_price() {
        return sales_price;
    }

    public void setSales_price(Double sales_price) {
        this.sales_price = sales_price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }
}
