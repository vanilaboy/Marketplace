package io;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 19.12.17 with love.
 */
public class SendEmailTest {
    @Test
    public void send() throws Exception {
        try {
            new SendEmail().send("grok-97@mail.ru");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void send1() throws Exception {
        try {
            new SendEmail().send("grok-97@mail.ru", "Test complite");
        } catch (Exception e) {
            Assert.fail();
        }
    }

}