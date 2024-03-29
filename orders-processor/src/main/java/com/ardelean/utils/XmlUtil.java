package com.ardelean.utils;

import com.ardelean.model.InputOrders;
import com.ardelean.model.OutputProducts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlUtil {


    public InputOrders unmarshalOrders(File inputFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(InputOrders.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputOrders orders = (InputOrders) unmarshaller.unmarshal(inputFile);
        return orders;
    }

    public void marshalOrders(OutputProducts products, File destination) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OutputProducts.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(products, destination);
    }
}
