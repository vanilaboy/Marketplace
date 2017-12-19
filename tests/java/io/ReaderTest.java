package io;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 19.12.17 with love.
 */
public class ReaderTest {

    private String pathToTestUsers = "/root/IdeaProjects/Marketplace/testUsers.txt";
    private String pathToTestBasket = "/root/IdeaProjects/Marketplace/testBasket.txt";


    @Test
    public void read() throws Exception {
        HashMap<String, String> sampleMap = new HashMap<String, String>();
        sampleMap.put("AAA", "SSS");
        sampleMap.put("wert", "drtyhjk");
        sampleMap.put("839cncxac", "34567yg$%hg");
        sampleMap.put("$%6ygKGFGHJkjh", "fghjhgFDR%^&UYTRDFGHTRe45tFGhuyTDE456Uyg");
        Reader reader = new Reader(pathToTestUsers);
        HashMap<String, String> testMap = reader.read();
        for(Map.Entry<String, String> entry : sampleMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String test = testMap.get(key);
            if(!test.equals(value)) {
                org.junit.Assert.fail();
            }
        }
    }

    @Test
    public void readBasket() throws Exception {
        try {
            Reader reader = new Reader(pathToTestBasket);
            HashMap<String, ArrayList<String>> sampleMap = new HashMap<String, ArrayList<String>>();
            HashMap<String, ArrayList<String>> testMap = reader.readBasket(pathToTestBasket);
            ArrayList<String> list = new ArrayList<String>();
            list.add("dfghjk");
            list.add("drt67ugffgh");
            list.add("UIHDWcoiw8d");
            sampleMap.put("FGHJhgfd56tGb", list);
            if(testMap.get("FGHJhgfd56tGb") == null) {
                org.junit.Assert.fail();
            } else {
                ArrayList<String> testList = testMap.get("FGHJhgfd56tGb");
                for(int i = 0; i < list.size(); i++) {
                    if(!testList.get(i).equals(list.get(i))) {
                        org.junit.Assert.fail();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            org.junit.Assert.fail();
        }
    }

}