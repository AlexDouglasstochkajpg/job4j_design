package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        byte newByte = 1;
        short newShort = 150;
        int newInt = 150000;
        long newLong = 10000000000L;
        float newFloat = 10.5F;
        double newDouble = 10.5;
        char newChar = 'A';
        boolean newBoolean = true;
        LOG.debug("Byte: {}, short: {}, int: {}, long: {}, float: {}, double: {}, char: {}, boolean: {}",
                newByte, newShort, newInt, newLong, newFloat, newDouble, newChar, newBoolean);
    }
}