package com.ardelean.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)

public class OutputProduct {

    private String description;
    private String gtin;
    private Price price;
    private int orderid;

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int iD) {
        orderid = iD;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OutputProduct [description=");
        builder.append(description);
        builder.append(", gtin=");
        builder.append(gtin);
        builder.append(", price=");
        builder.append(price);
        builder.append(", ID=");
        builder.append(orderid);
        builder.append("]");
        return builder.toString();
    }
}
