package com.example.MamaCare.MicroServices.GenerateId;

import java.security.SecureRandom;

public class GenerateId{
    private Long id;

    public GenerateId(Long id){
        this.id = id;
    }

    public GenerateId(){}

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long generateId(Long id){
        SecureRandom random = new SecureRandom();

        StringBuilder charPool = new StringBuilder();

        charPool.append("1234567890");
        charPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        StringBuilder generateId = new StringBuilder();

        for(int i = 0; i < 10; i++){
            int randomIndex = random.nextInt();

            generateId.append(randomIndex);
        }
        
        String genId = generateId.toString();

        id = Long.parseLong(genId);

        return id;
    }


}
