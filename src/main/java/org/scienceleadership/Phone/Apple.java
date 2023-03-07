package org.scienceleadership.Phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Apple extends Phone {

    private String faceTime;
    private String applePay;
    private String faceID;
    private String LiDAR;


    public Apple(String phoneType, String storage, String screenSize, String processor, String chargerType, String faceTime, String applePay, String faceID, String liDAR) {
        super(phoneType, storage, screenSize, processor, chargerType);
        this.faceTime = faceTime;
        this.applePay = applePay;
        this.faceID = faceID;
        this.LiDAR = liDAR;
    }

    String getFaceTime() {
        return faceTime;
    }

    void setFaceTime(String faceTime) {
        this.faceTime = faceTime;
    }

    String getApplePay() {
        return applePay;
    }

    void setApplePay(String applePay) {
        this.applePay = applePay;
    }

    String getFaceID() {
        return faceID;
    }

    void setFaceID(String faceID) {
        this.faceID = faceID;
    }

    String getLiDAR() {
        return LiDAR;
    }

    void setLiDAR(String liDAR) {
        LiDAR = liDAR;
    }

    public String toString() {
        return "APPLE: The " + super.getPhoneType() + " has " + super.getStorage() + "GB of storage, a screen size of " + super.getScreenSize() + " inches, a " + super.getProcessor() + " processor, and uses a " + super.getChargerType() + " charger. It is " + faceTime + " that it uses FaceTime. It is " + applePay + " that it uses applepay. It is " + faceID + " that it uses FaceID. It is " + LiDAR + "that it uses LiDAR.";
    }

    static void readAppleData() throws FileNotFoundException {
        File file = new File("Apple Phones Data");

        try {

            Scanner sc = new Scanner(file);

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scan = new Scanner(file);

        int lineNumber = 1;
        int howMuchData = 0;
        ArrayList<ArrayList> allArrays = new ArrayList<>();
        while (scan.hasNextLine()) {
            ArrayList<String> dataArray = new ArrayList<>();
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
            Scanner barScanner = new Scanner(file);

            barScanner.useDelimiter("\t");
            if (lineNumber == 1) {
                dataArray.add("Date");
            }
            while (barScanner.hasNext()) {
                String data = barScanner.next();
                dataArray.add(data);
                if (lineNumber == 1) {
                    howMuchData = howMuchData + 1;
                }
            }
            if (dataArray.size() > 1) {
                allArrays.add(dataArray);
            }

            if (dataArray.size() > 1) {
                allArrays.add(dataArray);
            }
            for (int index = 1; index < howMuchData ; index = index + 1) {
                String date = (String)allArrays.get(0).get(index);
                String screenSize = (String)allArrays.get(1).get(index);
                String HDR = (String)allArrays.get(2).get(index);
                String storage = (String)allArrays.get(3).get(index);
                String builtInMemory = (String)allArrays.get(4).get(index);
                String externalMemory = (String)allArrays.get(5).get(index);
                String flash = (String)allArrays.get(6).get(index);
                String opticalZoom = (String)allArrays.get(7).get(index);
                String videoCall = (String)allArrays.get(8).get(index);
                String opticalImage = (String)allArrays.get(9).get(index);
                String frontCamera = (String)allArrays.get(10).get(index);
                String liDARScanner = (String)allArrays.get(11).get(index);
                String productDetails = (String)allArrays.get(12).get(index);
                String processor = (String)allArrays.get(13).get(index);
                String ram = (String)allArrays.get(14).get(index);
                String simCard = (String)allArrays.get(15).get(index);
                String connector = (String)allArrays.get(16).get(index);

                // String phoneType, int storage, float screenSize, String processor, int price, String chargerType, String faceTime, String applePay, String faceID, String liDAR
               // new org.scienceleadership.Phone.Apple(date, screenSize, HDR, storage, builtInMemory, externalMemory, flash, opticalZoom, videoCall, opticalImage, frontCamera, liDARScanner, productDetails, processor, ram, simCard, connector);
            }

        }
    }

}





