package oop.exams.generator;

import java.util.Random;

import oop.exams.exception.BadRegionException;

public class EastLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {
        if(state.charAt(0) != 'X'){

            String numerosValidos = "1234567890";
            int total = numerosValidos.length();
            int i;

            String first = "3";
            String last = "Z";
            Random index = new Random();

            for(i=0;i<2;i++){
                first += numerosValidos.charAt(index.nextInt(total));
                if(i == 1){
                    first += last;
                }
            }
            return first;

        
        }
        throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
        
    }
}
