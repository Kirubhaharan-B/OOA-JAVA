package fr.epita.assignment.tests;

import fr.epita.assignment.datamodel.Passenger;
import fr.epita.assignment.datamodel.PassengerCSVDAO;
import fr.epita.assignment.datamodel.PassengerDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;


public class TestBLI1 {
    public static void test() throws IOException {
        List<Passenger> pass = PassengerCSVDAO.readAll();
        PassengerDataService.filterSurvived(pass,true);
        PassengerDataService.averageAge(pass);
        PassengerDataService.calculateAgeDistribution(pass);
    }
}
