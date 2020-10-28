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
        book.setTitle("Book Alterrado");
        book.setSubTitle("Book SubTitle Alterado");
        book.setReleaseDate(Calendar.getInstance());
        book.setAcquisitionStatus(false);
        book.setReadStatus(true);
        book.setId(2L);

        EntitieDAO<Book> bookDAOJDBC = DAOFactory.createBookDAO();
        bookDAOJDBC.update(book);
    }

    public static void addMadia() {

    }

    public static boolean exit() {
        System.out.print("Deseja sair? (S/N)");
        String s = input.nextLine();
        return  s.compareToIgnoreCase("s") == 0;
    }
}
