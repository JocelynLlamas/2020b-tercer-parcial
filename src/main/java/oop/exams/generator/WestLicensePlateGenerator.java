package oop.exams.generator;

import java.util.Random;

import oop.exams.exception.BadRegionException;

public class WestLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {
        if(state.charAt(0) != 'X'){

            String numerosValidos = "1234567890";
            int total = numerosValidos.length();
            int i;

            String first = "2";
            String last = "SIN";
            Random index = new Random();

            for(i=0;i<1;i++){
                first += numerosValidos.charAt(index.nextInt(total));
                if(i == 0){
                    first += last;
                }
            }
            return first;
        }
        throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
    }

    public WestLicensePlateGenerator(){

    }

}
