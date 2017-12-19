package io;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by root on 19.12.17 with love.
 */
public class WriterTest {

    private String pathToTestWriter = "/root/IdeaProjects/Marketplace/testWriter.txt";

    @Test
    public void run() throws Exception {
        HashMap<String, String> test = new HashMap<String, String>();
        test.put("fghjk", "ftyhnjiu6");
        test.put("ui(YC&y2389HUOFDJNql", "iuchacOcjioJJ#)(JKc");
        test.put("asdfghjtrtyujhg567uytfGHUio", "GYUhgfRTYUi*&^543456yhNmkIuytfDcVHUIuytrds");
        test.put("fghjkYTRdfgh", "09876545678765456787^%HJb");
        Writer thread = new Writer(test, pathToTestWriter);
        thread.start();
        thread.join();
        HashMap<String, String> readed = new Reader(pathToTestWriter).read();
        if(!test.equals(readed)) {
            Assert.fail();
        }
    }

}