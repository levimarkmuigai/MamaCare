package com.example.MamaCare.MicroService.Id;

import java.security.SecureRandom;

public class GenerateId{
    
    private static final String DIGITS = "01234567890";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int ID_LENGTH  = 10;

    public Long generateId(){
        StringBuilder sb = new StringBuilder(ID_LENGTH);

        sb.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length() -1) +1));

        for(int i = 0; i < ID_LENGTH; i++){
            sb.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }

        return Long.parseLong(sb.toString());
    }
}
