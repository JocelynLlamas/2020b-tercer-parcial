package oop.exams.generator;

import java.util.Random;

import oop.exams.exception.BadRegionException;

public class DefaultLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {

        if(state.charAt(0) != 'X'){

            String numerosValidos = "1234567890";
            int total = numerosValidos.length();
            int i;

            String first = "5";
            Random index = new Random();

            for(i=0;i<7;i++){
                first += numerosValidos.charAt(index.nextInt(total));
            }
            return first;
        }
        throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
    }

    public DefaultLicensePlateGenerator(){

    }

    
}
