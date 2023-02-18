package com.ardelean.service;

import com.ardelean.exceptions.FileNameException;
import com.ardelean.model.InputOrder;
import com.ardelean.model.InputOrders;
import com.ardelean.model.InputProduct;
import com.ardelean.model.OutputProduct;
import com.ardelean.model.OutputProducts;
import com.ardelean.utils.FileUtil;
import com.ardelean.utils.XmlUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrdersProcessor {

    XmlUtil xmlUtil = new XmlUtil();
    FileUtil fileUtil = new FileUtil();

    public void processInputFile(File ordersFile) {
        try {
            System.out.println("Processing file " + ordersFile.getName());
            validateInputFileName(ordersFile.getName());
            String suffix = getSuffix(ordersFile.getName());

            InputOrders inputOrders = xmlUtil.unmarshalOrders(ordersFile);

            Map<String, List<OutputProduct>> map = mapProductsToSupplier(inputOrders.getOrders());

            for (String supplier : map.keySet()) {
                OutputProducts output = new OutputProducts();
                output.setProducts(map.get(supplier));
                File fileDestination = fileUtil.getDestinationFile(supplier, suffix);
                xmlUtil.marshalOrders(output, fileDestination);
            }

            fileUtil.moveFileToArhive(ordersFile);
            System.out.println("File " + ordersFile.getName() + " was processed succesfully and moved to archive");
        } catch (Exception ex) {
            System.out.println("Error processing file " + ordersFile.getName());
            fileUtil.moveFileToError(ordersFile);
            ex.printStackTrace();
        }

    }


    private String getSuffix(String fileName) {
        return fileName.replace("orders", "").replace(".xml", "");
    }


    private Map<String, List<OutputProduct>> mapProductsToSupplier(List<InputOrder> inOrders) {
        Map<String, List<OutputProduct>> map = new HashMap<>();
        for (InputOrder order : inOrders) {
            for (InputProduct inProduct : order.getProducts()) {
                OutputProduct productWithId = com.ardelean.business.ProductMapper.map(inProduct, order.getId());
                String supplier = inProduct.getSupplier();
                if (map.containsKey(supplier)) {
                    List<OutputProduct> value = map.get(supplier);
                    value.add(productWithId);
                } else {
                    List<OutputProduct> newValue = new ArrayList<>();
                    newValue.add(productWithId);
                    map.put(supplier, newValue);
                }
            }
        }
        return map;
    }

    private void validateInputFileName(String fileName) {
        String pattern = "^(orders[0-9]*\\.xml)$";
        if (!fileName.matches(pattern)) {
            throw new FileNameException("File " + fileName + " could not be processed. It has not a valid name");
        }
    }
}