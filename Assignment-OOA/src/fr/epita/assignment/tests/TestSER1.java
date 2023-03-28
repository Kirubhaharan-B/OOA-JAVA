package fr.epita.assignment.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestSER1 {
    public static void test() throws IOException{

        System.out.println();
        List<String> entries = Files.readAllLines(Path.of("data.csv"));
        entries.remove(0);
        List<String> duplicate = new ArrayList<>();
        for (String s : entries) {
            duplicate.add(s);
        }
        List<String> OutputListHasAge = new ArrayList<>();
        List<String> OutputListNoAge = new ArrayList<>();
        for (String word : duplicate){
            String[] strarr = word.split(";");
            String name = strarr[0].trim();
            String passengerClass = strarr[1].trim();
            String sex = strarr[3].trim();
            String survived =strarr[4].replaceAll(" ","");
            String survivedFinal = survived.replace(",","");
            String age = strarr[2].trim();
            if(age.isEmpty()){
                String[] noage = {"name= \""+name+"\"","PClass= \""+passengerClass+"\"","Age= \""+0+"\"","Sex= \""+sex+"\"","Survived= \""+survivedFinal+"\""};
                OutputListNoAge.add(Arrays.toString(noage));
               // System.out.println(strarr[2] + "Hello");
            }
            else{
                String[] newarr = {"name= \""+name+"\"","PClass= \""+passengerClass+"\"","Age= \""+age+"\"","Sex= \""+sex+"\"","Survived= \""+survivedFinal+"\""};
                OutputListHasAge.add(Arrays.toString(newarr));
            }
            //  System.out.println(name+" "+passengerClass+" "+age+" "+sex+" "+survived);
        }

        System.out.println(OutputListHasAge.get(0));
    }
}
