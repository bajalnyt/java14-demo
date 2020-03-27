package com.mohbajal.java14demo;

import java.util.Currency;
import java.util.Locale;

public class I18n {

    public static void main(String[] args) {
        for (Locale l:Locale.getAvailableLocales()) {
            System.out.println(l.getCountry() +":" + l.getDisplayLanguage());

        }
        for(Currency c: Currency.getAvailableCurrencies()){
            System.out.println(c.getCurrencyCode());
        }
    }
}
