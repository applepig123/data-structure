package com.yh.test;

import java.io.*;

public class TestTableNameReplace {

    private String srcFile;

    private String dstFile;

    private Conversion conversion;

    public TestTableNameReplace(String srcFile, String dstFile, Conversion conversion) {
        this.srcFile = srcFile;
        this.dstFile = dstFile;
        this.conversion = conversion;
    }

    public void transfer() {
        FileReader fr = null;
        BufferedReader bf = null;
        PrintWriter writer = null;
        try {
            fr = new FileReader(srcFile);
            bf = new BufferedReader(fr);
            writer = new PrintWriter(new File(dstFile));
            String line = null, writeStr;
            while ((line = bf.readLine()) != null) {
                writeStr = conversion.convert(line);
                if(writeStr != null) {
                    writer.println(writeStr);
                    writer.flush();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                bf.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
