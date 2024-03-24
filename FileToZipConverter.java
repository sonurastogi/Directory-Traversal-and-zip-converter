package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileToZipConverter {
    public  void zip(File file){
	String sourceFile = file.getAbsolutePath();
	String zipFile = file.getAbsolutePath()+".zip"; 

        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            addToZipFile(sourceFile, zos);
            zos.close();
            fos.close();
            System.out.println("File successfully converted to ZIP.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZipFile(String sourceFile, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        ZipEntry zipEntry = new ZipEntry(sourceFile);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}
