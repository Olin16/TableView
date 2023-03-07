package org.scienceleadership.Phone;

import java.io.Serializable;
import java.util.ArrayList;

class Phone implements Serializable {

    private static ArrayList<Phone> phones = new ArrayList<>();
    private String storage;
    private String screenSize;
    private int price;
    private String processor;
    private String chargerType;
    private String phoneType;


    public Phone(String phoneType, String storage, String screenSize, String processor, String chargerType) {
        this.setStorage(storage);
        this.setScreenSize(screenSize);
        this.setProcessor(processor);
        this.setChargerType(chargerType);
        this.setPhoneType(phoneType);
        phones.add(this);
        System.out.println(phones);
    }


    public static ArrayList<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(ArrayList<Phone> phones) {
        Phone.phones = phones;
    }


    String getStorage() {
        return storage;
    }

    void setStorage(String storage) {
        this.storage = storage;
    }

    String getScreenSize() {
        return screenSize;
    }

    void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    String getProcessor() {
        return processor;
    }

    void setProcessor(String processor) {
        this.processor = processor;
    }

    String getChargerType() {
        return chargerType;
    }

    void setChargerType(String chargerType) {
        this.chargerType = chargerType;
        this.phoneType = phoneType;
    }
    String getPhoneType() {
        return phoneType;
    }

    void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

 }