package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String outFileName = "object.json";
    public static void main(String[] args) {
        List<TestDto> testDtoList = new ArrayList<>();

        for (int i = 1; i <= 5; i++){
            TestDto testDto = new TestDto();
            testDto.setFirstName("Firstname" + i);
            testDto.setLastName("Lastname" + i);
            testDto.setYear(20 + i);
            testDtoList.add(testDto);
        }

        ObjectMapper obj = new ObjectMapper();
        try {
            String jsonStr = obj.writeValueAsString(testDtoList);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
            writer.write(jsonStr);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}