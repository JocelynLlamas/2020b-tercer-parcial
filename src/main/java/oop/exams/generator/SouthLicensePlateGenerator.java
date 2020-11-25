package oop.exams.generator;

import java.util.Random;

import oop.exams.exception.BadRegionException;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {
        if(state.charAt(0) != 'X'){

            String numerosValidos = "1234567890";
            int total = numerosValidos.length();
            int i;

            String first = "4";
            String second = "OAX";
            Random index = new Random();

            for(i=0;i<3;i++){
                if(i == 2){
                    first += second;
                }
                first += numerosValidos.charAt(index.nextInt(total));
            }
            return first;
        
        }
        throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
    }
}
