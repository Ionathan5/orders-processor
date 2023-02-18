package com.ardelean.model;

import com.ardelean.adapter.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "order")
public class InputOrder {
    @XmlAttribute(name = "ID")
    private int ID;

    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class)
    @XmlAttribute(name = "created")
    private LocalDateTime created;

    @XmlElement(name = "product")
    private List<InputProduct> products;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<InputProduct> getProducts() {
        return products;
    }

    public void setProducts(List<InputProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [ID=");
        builder.append(ID);
        builder.append(", created=");
        builder.append(created);
        builder.append(", products=");
        builder.append(products);
        builder.append("]");
        return builder.toString();
    }
}