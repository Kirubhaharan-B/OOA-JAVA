package fr.epita.assignment.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PassengerDataService {
    public static List<Passenger> filterSurvived(List<Passenger> pass,Boolean survived){
        List<Passenger> survivedList = new ArrayList<Passenger>();
        for(Passenger p : pass){
            if(p.getSurvived()==true){
                survivedList.add(p);
            }
        }
        System.out.println(survivedList + "LIST SURVIVAL");
        return survivedList;
    }

    public static int averageAge(List<Passenger> pass) {
        double sum = 0.0;
        double count = 0.0;
        for (Passenger p : pass) {
            sum += p.getAge();
            count++;
        }
        System.out.println((int)(sum/count)+"AVERAGE AGE");
        return (int) (sum/count);
    }

    public static Map<Double, Long> calculateAgeDistribution(List<Passenger> pass){
        Map<String, Double> map = new HashMap<>();
        for(Passenger p :pass){
            map.put(p.getName(),p.getAge());
        }
        Map<Double, Long> mapCount = map.values().stream().collect(
                        Collectors.groupingBy(Function.identity(),
                                HashMap::new,
                                Collectors.counting())
                );
//        mapCount.forEach((key, value) -> System.out.println(
//                "KEY : " + key  + "\t"  + "Count : "  + value
//        ));
        System.out.println(mapCount);
        return mapCount;
    }
}
