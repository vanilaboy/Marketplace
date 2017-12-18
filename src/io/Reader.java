package io;

import java.io.*;
import java.util.HashMap;

/**
 * Created by root on 17.12.17 with love.
 */
public class Reader {

    private String path;

    public Reader(String path) {
        this.path = path;
    }

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

}
