package io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 17.12.17 with love.
 */
public class Reader {

    private String path;

    public Reader(String path) {
        this.path = path;
    }

    public Reader() {};

    public HashMap<String, String> read() {
        try {
            HashMap<String, String> resultMap = new HashMap<String, String>();
            BufferedReader in = new BufferedReader(new FileReader(new File(path)));
            String tmp = in.readLine();
            while(tmp != null) {
                String[] usernameAndPassword = tmp.split(";;;;;;;;;;;;;;;;;;;;;");
                resultMap.put(usernameAndPassword[0], usernameAndPassword[1]);
                tmp = in.readLine();
            }
            in.close();
            return resultMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, ArrayList<String>> readBasket() throws IOException {
        HashMap<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
        String pathBasket = "/root/IdeaProjects/Marketplace/basket.txt";
        BufferedReader in = new BufferedReader(new FileReader(new File(pathBasket)));
        String tmp = in.readLine();
        while(tmp != null) {
            ArrayList<String> list = new ArrayList<String>();
            String[] usernameAndItems = tmp.split(";;;;;;;;;;;;;;;;;;;;;");
            for(int i = 1; i < usernameAndItems.length; i++) {
                list.add(usernameAndItems[i]);
            }
            res.put(usernameAndItems[0], list);
            tmp = in.readLine();
        }
        return res;
    }

    public HashMap<String, ArrayList<String>> readBasket(String path) throws IOException {
        HashMap<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
        String pathBasket = path;
        BufferedReader in = new BufferedReader(new FileReader(new File(pathBasket)));
        String tmp = in.readLine();
        while(tmp != null) {
            ArrayList<String> list = new ArrayList<String>();
            String[] usernameAndItems = tmp.split(";;;;;;;;;;;;;;;;;;;;;");
            for(int i = 1; i < usernameAndItems.length; i++) {
                list.add(usernameAndItems[i]);
            }
            res.put(usernameAndItems[0], list);
            tmp = in.readLine();
        }
        return res;
    }

}
