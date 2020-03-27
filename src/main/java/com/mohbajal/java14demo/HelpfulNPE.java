package com.mohbajal.java14demo;

// Pass -XX:+ShowCodeDetailsInExceptionMessages
public class HelpfulNPE
{
    public static void main(final String[] arguments)
    {
        final Person person = null;
        person.name(); //NPE
    }

    record Person (String name) {
    }

}
