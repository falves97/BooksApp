package entities;

import utilities.MediaSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Librarian {
    private List<Media> library;

    public Librarian() {
        library = new ArrayList<>();
    }

    public Librarian(List<Media> library) {
        this.library = library;
    }

    public List<Media> getLibrary() {
        return library;
    }

    public void setLibrary(List<Media> library) {
        this.library = library;
    }

    public void addMedia(Media media) {
        getLibrary().add(media);
    }

    public void removeMedia(Media media) {
        getLibrary().remove(media);
    }

    public void removeMediaById(Long id) {
        Media m = MediaSearch.byId(getLibrary(), id);
        removeMedia(m);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Librarian)) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(getLibrary(), librarian.getLibrary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLibrary());
    }
}
