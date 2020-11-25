package oop.exams.generator;

import java.util.Random;

import oop.exams.exception.BadRegionException;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {
        if(state.charAt(0) != 'X'){

            String numerosValidos = "1234567890";
            String abreviaciones = "BCN, BCS, CHH, COA, NLE, SON, TAM";
            int total = numerosValidos.length();
            int totalAb = abreviaciones.length();
            int i;

            String first = "1";
            String second = "SON";
            Random index = new Random();

            for(i=0;i<2;i++){
                if(i == 0){
                    first += second;
                }
                first += numerosValidos.charAt(index.nextInt(total));
            }
            return first;

            
        
        }
        throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
        
    }
}

