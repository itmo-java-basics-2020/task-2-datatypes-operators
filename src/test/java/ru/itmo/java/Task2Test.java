package ru.itmo.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

@SuppressWarnings({"UnnecessaryBoxing", "deprecation", "CachedNumberConstructorCall"})
public class Task2Test {

    @Test
    public void test_fractionalPart() {
        Task2 inst = new Task2();

        Assert.assertEquals(0.9, inst.getFractionalPart(17.9), 1e-9);
        Assert.assertEquals(0.9999, inst.getFractionalPart(17.9999), 1e-9);
    }

    @Test
    public void test_charCode() {
        Task2 inst = new Task2();

        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            char code = (char) random.nextInt(Character.MAX_VALUE) ;
            Assert.assertEquals(code, inst.charCode(code));
        }
    }

    @Test
    public void test_intsEqual() {
        Task2 inst = new Task2();

        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            var a = random.nextInt(20);
            var b = random.nextInt(20);
            Assert.assertEquals(a == b, inst.testIfIntsEqual(new Integer(a), new Integer(b)));
        }
    }
}