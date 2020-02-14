package ru.itmo.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"UnnecessaryBoxing", "deprecation", "CachedNumberConstructorCall", "RedundantCast"})
public class Task2Test {

    @Test
    public void test_fractionalPart() {
        Task2 inst = new Task2();

        Assert.assertEquals(0.9, inst.getFractionalPart(17.9), 1e-9);
        Assert.assertEquals(0.9999, inst.getFractionalPart(17.9999), 1e-9);

        Random random = new Random();

        for (int i = 0; i < 1_000_000; i++) {
            double number = random.nextDouble();
            double forCheck = inst.getFractionalPart(random.nextInt(100_000) + number);
            Assert.assertEquals(number, forCheck, 1e-11);
        }
    }

    @Test
    public void test_charCode() {
        Task2 inst = new Task2();

        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            char code = (char) random.nextInt(Character.MAX_VALUE);
            Assert.assertEquals(code, inst.charCode(code));
        }
    }

    @Test
    public void test_intsEqual() {
        Task2 inst = new Task2();

        Random random = new Random();

        for (int i = 0; i < 1_000_000; i++) {
            var a = random.nextInt(20);
            var b = random.nextInt(20);
            Assert.assertEquals(a == b, inst.testIfIntsEqual(new Integer(a), new Integer(b)));
        }
    }

    @Test
    public void test_anyIsDigit() {
        Task2 inst = new Task2();

        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            var a = (char) random.nextInt(13);
            var b = (char) random.nextInt(37);
            var c = (char) random.nextInt(58);

            boolean presented = c < 58 & c > 47;
            List<Character> integers = (List<Character>) Arrays.asList(a, b, c);

            if (presented) {
                Collections.shuffle(integers);
            }
            Assert.assertEquals(presented, inst.atLeastOneIsDigit(integers.get(0), integers.get(1), integers.get(2)));
        }
    }

    @Test
    public void test_digitInRange() {
        Task2 inst = new Task2();

        Random random = new Random();

        // 1
        Assert.assertFalse(inst.numberInRange(null, 0, 0, true));
        Assert.assertFalse(inst.numberInRange(null, 0, null, true));
        Assert.assertFalse(inst.numberInRange(0, 0, 0, null));
        Assert.assertFalse(inst.numberInRange(0, null, 0, true));
        Assert.assertFalse(inst.numberInRange(0, 0, null, true));

        // 2
        Assert.assertFalse(inst.numberInRange(72344656, 72347655, 72344656, true));
        Assert.assertFalse(inst.numberInRange(13, 13, 13, false));
        Assert.assertTrue(inst.numberInRange(13, 13, 13, true));
        Assert.assertTrue(inst.numberInRange(11, 10, 100_000_000, true));
        Assert.assertFalse(inst.numberInRange(10, 10, 100_000_000, false));

    }

}