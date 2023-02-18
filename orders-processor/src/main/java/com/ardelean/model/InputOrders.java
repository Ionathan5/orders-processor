package com.ardelean.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputOrders {

    @XmlElement(name = "order")
    private List<InputOrder> orders;

    public List<InputOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<InputOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Orders [orders=");
        builder.append(orders);
        builder.append("]");
        return builder.toString();
    }
}
