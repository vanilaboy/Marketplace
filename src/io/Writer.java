package io;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 17.12.17 with love.
 */
public class Writer extends Thread {
    private String path;
    private HashMap<String, String> hashMap;
    private HashMap<String, ArrayList<String>> usernameAndItem;

    public Writer(HashMap<String, String> map, String path) {
        hashMap = map;
        this.path = path;
    }

    public Writer(HashMap<String, ArrayList<String>> basket) {
        path = "/root/IdeaProjects/Marketplace/basket.txt";
        usernameAndItem = basket;
    }

    @Override
    public void run() {
        if(usernameAndItem == null) {
            try {
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                }
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String str = entry.getKey() + ";;;;;;;;;;;;;;;;;;;;;" + entry.getValue();
                    out.write(str);
                    out.newLine();
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                } else {
                    file.createNewFile();
                }
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                for(Map.Entry<String, ArrayList<String>> entry : usernameAndItem.entrySet()) {
                    StringBuilder res = new StringBuilder();
                    res.append(entry.getKey());
                    for(int i = 0; i < entry.getValue().size(); i++) {
                        res.append(";;;;;;;;;;;;;;;;;;;;;");
                        res.append(entry.getValue().get(i));
                    }
                    out.write(res.toString());
                    out.newLine();
                }
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}