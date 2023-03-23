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
        List<String> OutputList = new ArrayList<>();
        for (String word : duplicate){
            String[] strarr = word.split(";");
            String name = strarr[0].trim();
            String passengerClass = strarr[1].trim();
            String age = strarr[2].trim();
            String sex = strarr[3].trim();
            String survived =strarr[4].trim();
            String[] newarr = {"name= \""+name+"\"","PClass= \""+passengerClass+"\"","Age= \""+age+"\"","Sex= \""+sex+"\"","Survived= \""+survived+"\""};
            OutputList.add(Arrays.toString(newarr));
            //  System.out.println(name+" "+passengerClass+" "+age+" "+sex+" "+survived);
        }

        System.out.println(OutputList.get(0));



//        List<String> entries = Files.readAllLines(Path.of("data.csv"));
//        //entries.remove(0);
//        List<String> modifiedStrings = new ArrayList<>();
//        for(String s : entries) {
//            String entry = Arrays.toString(s.split(";"));
//            //System.out.println(entry.length());
//            modifiedStrings.add(entry);
//          //  System.out.println("Hello"+entry);  TRY TO WORK ON THIS FOR TRIM AND STRIP FOR INDIVIDUAL ELEMENTS
//        }
//       System.out.println(modifiedStrings.get(1));
    }
}
