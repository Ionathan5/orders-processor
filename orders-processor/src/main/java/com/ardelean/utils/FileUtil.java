package com.ardelean.utils;

import static com.ardelean.utils.ConfigLoader.getProperty;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    private static String SEPARATOR = File.separator;

    public File getDestinationFile(String supplier, String suffix) {
        String outputPath = getProperty("orders.output.path");
        File outputDirectory = new File(outputPath);
        if (!outputDirectory.exists()) {
            outputDirectory.mkdir();
        }
        String fileName = supplier + suffix + ".xml";
        return new File(outputDirectory + SEPARATOR + fileName);
    }

    public void moveFileToError(File ordersFile) {
        String errorDirectoryPath = getProperty("input.files.error.path");
        createDirectory(errorDirectoryPath);
        File fileDestination = new File(errorDirectoryPath + SEPARATOR + ordersFile.getName());
        try {
            copyFile(ordersFile, fileDestination);
            System.out.println("File " + ordersFile + " was moved to error folder");
            ordersFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFileToArhive(File file) {
        String arhiveDirectoryPath = getProperty("input.files.archive.path");
        createDirectory(arhiveDirectoryPath);
        File fileDestination = new File(arhiveDirectoryPath + SEPARATOR + file.getName());
        try {
            copyFile(file, fileDestination);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyFile(File source, File destination) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    private File createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }
}
