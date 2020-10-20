package application;

import entities.Autor;
import entities.Book;
import entities.Librarian;
import entities.Media;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        Media media = new Book();
        List<Autor> autors = new ArrayList<>();

        autors.add(new Autor("Nome", "Sobrenome"));

        media.setId(1L);
        media.setTitle("Titulo");
        media.setSubTitle("Subtitulo");
        media.setReleaseDate(Calendar.getInstance());
        media.setAutors(autors);

        System.out.println(media.getResume());
    }

    public static void addMadia() {

    }

    public static boolean exit() {
        System.out.print("Deseja sair? (S/N)");
        String s = input.nextLine();
        return  s.compareToIgnoreCase("s") == 0;
    }
}
