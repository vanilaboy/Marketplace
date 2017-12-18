package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 17.12.17 with love.
 */
public class Writer extends Thread {
    private String path;
    private HashMap<String, String> hashMap;

    public Writer(HashMap<String, String> map, String path) {
        hashMap = map;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            File file = new File(path);
            if(file.exists()) {
                file.delete();
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : hashMap.entrySet()) {
                String str = entry.getKey() + ";;;;;;;;;;;;;;;;;;;;;" + entry.getValue();
                out.write(str);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}