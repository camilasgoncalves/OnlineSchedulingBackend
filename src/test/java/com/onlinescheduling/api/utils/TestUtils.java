package com.onlinescheduling.api.utils;

import java.util.Random;

public class TestUtils {

    public static int getRandomId(int max) {
        return new Random().nextInt(max) + 1;
    }
}
