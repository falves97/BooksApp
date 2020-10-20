package entities;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Book extends Media{
    private String isbn;
    private String publishingCompany;
    private int edition;

    public Book() {
        super();
        setType(MediaType.BOOK);
    }

    public Book(Long id, String title, String subTitle, Calendar releaseDate, List<Autor> autors, boolean readStatus, boolean acquisitionStatus, String isbn, String publishingCompany, int edition) {
        super(id, MediaType.BOOK, title, subTitle, releaseDate, autors, readStatus, acquisitionStatus);
        this.isbn = isbn;
        this.publishingCompany = publishingCompany;
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String getResume() {
        return super.getResume() +
                ", edition=" + edition +
                '}';
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                ", isbn='" + isbn + '\'' +
                ", publishingCompany='" + publishingCompany + '\'' +
                ", edition=" + edition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return getEdition() == book.getEdition() &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getPublishingCompany(), book.getPublishingCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIsbn(), getPublishingCompany(), getEdition());
    }
}
