package org.scienceleadership.Phone;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Apple.readAppleData();
        Samsung.readSamsungData();


        for (Phone phone : Phone.getPhones()) {
            System.out.println(phone.toString());
        }

        {

        }
    }
}