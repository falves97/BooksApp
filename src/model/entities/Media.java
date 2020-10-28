package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Media implements Serializable {
    private Long id;
    private MediaType type;
    private String title;
    private String subTitle;
    private Calendar releaseDate;
    private List<Autor> autors;
    private boolean acquisitionStatus;

    public Media() {
        autors = new ArrayList<>();
    }

    public Media(Long id, MediaType type, String title, String subTitle, Calendar releaseDate, List<Autor> autors, boolean acquisitionStatus) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
        this.releaseDate = releaseDate;
        this.autors = autors;
        this.acquisitionStatus = acquisitionStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
    }

    public boolean isAcquisitionStatus() {
        return acquisitionStatus;
    }

    public void setAcquisitionStatus(boolean acquisitionStatus) {
        this.acquisitionStatus = acquisitionStatus;
    }

    public void addAutor(Autor autor) {
        getAutors().add(autor);
    }

    public String getFullTitle() {
        return getTitle() + ": " + getSubTitle();
    }

    public String getResume() {
        return "{id=" + id +
                ", type=" + type +
                ", title='" + getFullTitle() + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return isAcquisitionStatus() == media.isAcquisitionStatus() &&
                Objects.equals(getId(), media.getId()) &&
                getType() == media.getType() &&
                Objects.equals(getTitle(), media.getTitle()) &&
                Objects.equals(getSubTitle(), media.getSubTitle()) &&
                Objects.equals(getReleaseDate(), media.getReleaseDate()) &&
                Objects.equals(getAutors(), media.getAutors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getTitle(), getSubTitle(), getReleaseDate(), getAutors(), isAcquisitionStatus());
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", autors=" + autors +
                ", acquisitionStatus=" + acquisitionStatus +
                '}';
    }
}
