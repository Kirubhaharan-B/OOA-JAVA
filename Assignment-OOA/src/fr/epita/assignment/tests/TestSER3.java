package fr.epita.assignment.tests;

import fr.epita.assignment.datamodel.Passenger;
import fr.epita.assignment.datamodel.PassengerCSVDAO;

import java.io.IOException;
import java.util.List;

public class TestSER3 {
    public static void test() throws IOException {
        List<Passenger> str = PassengerCSVDAO.readAll();
        PassengerCSVDAO.writeAll(str);
    }
}
