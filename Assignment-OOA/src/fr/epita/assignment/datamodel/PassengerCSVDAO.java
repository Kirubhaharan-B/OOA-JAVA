package fr.epita.assignment.datamodel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.lang.Integer.parseInt;

public class PassengerCSVDAO {


    public static List<Passenger> readAll() throws IOException {
        System.out.println();
        List<String> entries = Files.readAllLines(Path.of("data.csv"));
       // System.out.println(entries);
        entries.remove(0);
        List<Passenger> pass = new ArrayList<Passenger>();
        List<PassengerhasNoAge> passhasNoAge = new ArrayList<PassengerhasNoAge>();
        for(String entry: entries){
            String[] strarr = entry.split(";");
            String name = strarr[0].trim();
            String pClass = strarr[1].trim();
            String age = strarr[2].trim();
            String sex = strarr[3].trim();
            String survived = strarr[4].replaceAll(" ","");
            String survivedFinal = survived.replace(",","");
            Boolean flag = false;
            if(parseInt(survivedFinal)==1){
                flag = true;
            }
            if(age.isEmpty()){
                PassengerhasNoAge pNoAge = new PassengerhasNoAge(name,pClass,sex,flag);
                passhasNoAge.add(pNoAge);
            }
            else{
                Passenger p = new Passenger(name,pClass,sex,Double.valueOf(age),flag);
                pass.add(p);
            }
        }
        Collections.sort(pass,new Passenger.orderByAge());
        Integer count = 0;
        for(Passenger p : pass){
//            System.out.println(p.getName()+"\t"+p.getAge()+"\n");
            count +=1;
        }
        System.out.println(count + " Passengers has Age\n");
        return pass; //it passes the passenger list which only has age
        // passengers with no age are added to PassengerhasNoAge list
    }

    public static void writeAll(List<Passenger> str){
       // System.out.println(str);
        File file = new File("data_output.csv");
        try {
            Files.writeString(file.toPath(),"PClass;\tName;\tSex;\tAge;\tSurvived\n" , StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            for(Passenger p : str){
                Files.writeString(file.toPath(),p.getPassengerClass()+";\t"+p.getName()+";\t"+p.getSex()+";\t"+p.getAge()+";\t"+p.getSurvived()+"\n" , StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
