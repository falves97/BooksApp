package application;

import dao.DAOFactory;
import dao.EntitieDAO;
import model.entities.Book;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Book");
        book.setSubTitle("Book SubTitle");
        book.setReleaseDate(Calendar.getInstance());
        book.setAcquisitionStatus(true);
        book.setReadStatus(true);

        EntitieDAO bookDAOJDBC = DAOFactory.createBookDAO();
        bookDAOJDBC.insert(book);
    }

    public static void addMadia() {

    }

    public static boolean exit() {
        System.out.print("Deseja sair? (S/N)");
        String s = input.nextLine();
        return  s.compareToIgnoreCase("s") == 0;
    }
}
