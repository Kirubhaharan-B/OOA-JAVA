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
        Integer count= 0;
        for(Passenger p : pass){
            if(p.getSurvived()==true){
                survivedList.add(p);
                count +=1;
            }
        }
        System.out.printf(count+" LIST SURVIVAL");
        System.out.println("\n");
        return survivedList;
    }

    public static int averageAge(List<Passenger> pass) {
        double sum = 0.0;
        double count = 0.0;
        for (Passenger p : pass) {
            sum += p.getAge();
            count++;
        }
        System.out.printf("%.2f",(sum)/(count));
        System.out.println("\n");
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
        System.out.println(mapCount);
        System.out.println("\n");
        return mapCount;
    }
}
