package ru.itmo.java;

import org.junit.Assert;
import org.junit.Test;

public class Task2Test {

    @Test
    public void test_fractionalPart() {
        Task2 inst = new Task2();

        Assert.assertEquals(0.9, inst.getFractionalPart(17.9), 1e-9);
        Assert.assertEquals(0.9999, inst.getFractionalPart(17.9999), 1e-9);
    }

}