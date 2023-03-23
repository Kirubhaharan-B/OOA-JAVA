package fr.epita.assignment.tests;

import fr.epita.assignment.datamodel.PassengerCSVDAO;

import java.io.IOException;

public class TestSER2 {
    public static void test() throws IOException {
        PassengerCSVDAO.readAll();
    }
}
