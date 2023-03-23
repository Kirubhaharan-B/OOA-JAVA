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
        for(String entry: entries){
            String[] strarr = entry.split(";");
            String name = strarr[0].trim();
            String pClass = strarr[1].trim();
            String age = strarr[2].trim();
            String sex = strarr[3].trim();
            String survived = strarr[4].trim();
            Boolean flag = false;
            if(parseInt(survived)==1){
                flag = true;
            }
            //System.out.println(name+" "+survived);
            Passenger p = new Passenger(name,pClass,sex,Double.valueOf(age),flag);
            pass.add(p);
            //System.out.println(p);
        }
       // System.out.println(pass.get(0));
        Collections.sort(pass,new Passenger.orderByAge());
        for(Passenger p : pass){
            System.out.println(p.getName()+"\t"+p.getAge()+"\n");
        }
        return pass; //DUMMY
        //START
//        Dictionary dict = new Hashtable();
//        List<String> duplicate = new ArrayList<>();
//        for (String s : entries) {
//            duplicate.add(s);
//            //System.out.println(Arrays.toString(strarr) + "String");
//           // System.out.println(strarr[0]);
//        }
//        Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
//        for (String word : duplicate){
//            String[] strarr = word.split(";");
//            String name = strarr[0].trim();
//            String passengerClass = strarr[1].trim();
//            String age = strarr[2].trim();
//            String sex = strarr[3].trim();
//            String survived =strarr[4].trim();
//            String[] outputarray = {name+"; "+passengerClass+"; "+age+"; "+sex+"; "+survived};
//            hashTable.put(Integer.valueOf(age), Arrays.toString(outputarray));
//          //  System.out.println(name+" "+passengerClass+" "+age+" "+sex+" "+survived);
//        }
//        TreeMap<Integer,String> tm = new TreeMap<Integer,String>(hashTable);
//        Set<Integer> keys = tm.keySet();
//        Iterator<Integer> itr = keys.iterator();
//        LinkedHashSet<String> lh = new LinkedHashSet<String>();
//        while (itr.hasNext()) {
//            Integer i = itr.next();
//            lh.add(tm.get(i));
//           // System.out.println(tm.get(i));
//        }
//        List<String> outputArray = new ArrayList<String>(lh);
//        System.out.println(outputArray);
//        return outputArray;
       // CLEAR THE DOUBT IN HEIGHT BECAUSE THERE IS NO HEIGHT FIELD IN THE DATA.CSV
        // MODIFIED DATA.CSV FILE IN AGE COLUMN. SINCE THERE IS EMPTY STRINGS
    }

    public static void writeAll(List<Passenger> str){
        System.out.println(str);
        File file = new File("data_output.csv");
        try {
            Files.writeString(file.toPath(),"PClass;\tName;\tSex;\tAge;\tSurvived\n" , StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            for(Passenger p : str){
                Files.writeString(file.toPath(),p.getPassengerClass()+";\t"+p.getName()+";\t"+p.getSex()+";\t"+p.getAge()+";\t"+p.getSurvived()+"\n" , StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //START
//        String nameTag = "Name";
//        String pClassTag = "PClass";
//        String ageTag = "Age";
//        String sexTag = "Sex";
//        String survivedTag = "Survived";
//        String[] header = {pClassTag+";\t"+nameTag+";\t"+sexTag+";\t"+ageTag+";\t"+survivedTag};
//        List<String> modifiedList = new ArrayList<String>();
//        Collections.addAll(modifiedList,header);
//        for(Passenger word: str){
//            String[] strarr = word.split(";") ;
//            String name = strarr[0].replace("[","");
//            String passengerClass = strarr[1].trim();
//            String age = strarr[2].trim();
//            String sex = strarr[3].trim();
//            String survived =strarr[4].replace("]","").trim();
//            //System.out.println(name1+" "+name2);
//            String[] modifiedArray = {passengerClass+";\t"+name+";\t"+sex+";\t"+age+";\t"+survived};
//            //System.out.println(Arrays.toString(modifiedArray));
//            Collections.addAll(modifiedList,modifiedArray);
//            //System.out.println(Arrays.toString(modifiedArray));
//        }
//        //System.out.println(modifiedList);
//
//        File file = new File("data_output.csv");
//        try {
//            for(String word : modifiedList){
//                Files.writeString(file.toPath(), word.toString()+"\n", StandardOpenOption.CREATE,StandardOpenOption.APPEND);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }
}
