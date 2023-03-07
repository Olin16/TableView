package org.scienceleadership.Phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Samsung extends Phone{
    private String externalMemory;

    private String fingerPrint;

    private String ram;


    public Samsung(String phoneType, String storage, String screenSize, String processor, String chargerType, String externalMemory, String fingerPrint, String ram) {
        super(phoneType, storage, screenSize, processor, chargerType);
        this.setExternalMemory(externalMemory);
        this.setFingerPrint(fingerPrint);
        this.setRam(ram);
        System.out.println(this);
    }


    String getExternalMemory() {
        return externalMemory;
    }

    void setExternalMemory(String externalMemory) {
        this.externalMemory = externalMemory;
    }

    String getFingerPrint() {
        return fingerPrint;
    }

    void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    String getRam() {
        return ram;
    }

    void setRam(String ram) {
        this.ram = ram;
    }

    public String toString() {
        return "Samsung: Does samsung have external memory: " + externalMemory + ". Does Samsung have finger print: " + fingerPrint + ". How much Ram does Samsung have: " + ram + "GB."  + "The " + super.getPhoneType() + " has " + super.getStorage() + "GB of storage, a screen size of " + super.getScreenSize() + " inches, a " + super.getProcessor() + " processor, it uses the " + super.getChargerType() + "charger.";
    }

    static void readSamsungData() throws FileNotFoundException {

        //creating File instance to reference text file in Java
        File file = new File("SamsungPhonesData");

        //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(file);


        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        int howMuchData = 0;
        ArrayList<ArrayList> allArrays = new ArrayList<>();
        while (scan.hasNextLine()) {
            ArrayList<String> dataArray = new ArrayList<>();
            String line = scan.nextLine();
            //System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("\t");

            while (lineScanner.hasNext()) {
                String data = lineScanner.next();
                dataArray.add(data);
                if (lineNumber == 1) {
                    howMuchData = howMuchData + 1;
                }
            }
            if (dataArray.size() > 1) {
                allArrays.add(dataArray);
            }
        }
        System.out.println(allArrays);

        // go through allArrays and extract Data strings and create objects

        for (int index = 1; index < allArrays.size() ; index = index + 1) {
            String phoneType = (String)allArrays.get(0).get(index);
            String storage = (String)(allArrays.get(1).get(index));
            String screenSize = (String)(allArrays.get(2).get(index));
            String processor = (String)allArrays.get(3).get(index);
            String chargerType = (String)allArrays.get(4).get(index);
            String externalMemory = (String)allArrays.get(5).get(index);
            String fingerprint = (String)allArrays.get(6).get(index);
            String ram = (String)allArrays.get(7).get(index);
            new Samsung(phoneType, storage, screenSize, processor, chargerType, externalMemory, fingerprint, ram);
        }
        System.out.println(Phone.getPhones());
    }
}
