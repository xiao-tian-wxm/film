package gec.entity;

import java.util.Objects;

public class Filminfo {
    private Integer filmid;
    private String filmname;
    private String actor;
    private String director;
    private Double ticketprice;
    private Filmtype filmType;

    private Double smallprice;
    private Double bigprice;

    public Integer getFilmid() {
        return filmid;
    }

    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public Double getSmallprice() {
        return smallprice;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public Double getBigprice() {
        return bigprice;
    }

    public void setBigprice(Double bigprice) {
        this.bigprice = bigprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filminfo filminfo = (Filminfo) o;
        return filmid == filminfo.filmid &&
                Objects.equals(filmname, filminfo.filmname) &&
                Objects.equals(actor, filminfo.actor) &&
                Objects.equals(director, filminfo.director) &&
                Objects.equals(ticketprice, filminfo.ticketprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmid, filmname, actor, director, ticketprice);
    }

    public Filmtype getFilmType() {
        return filmType;
    }

    public void setFilmType(Filmtype filmType) {
        this.filmType = filmType;
    }

    public Filminfo(Filmtype filmType, String filmname, String actor, String director, Double bigprice, Double smallprice ) {
        this.bigprice = bigprice;
        this.smallprice = smallprice;
        this.filmname = filmname;
        this.actor = actor;
        this.director = director;
        this.filmType = filmType;
    }

    @Override
    public String toString() {
        return "Filminfo{" +
                "bigprice=" + bigprice +
                ", smallprice=" + smallprice +
                ", filmid=" + filmid +
                ", filmname='" + filmname + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", ticketprice=" + ticketprice +
                '}';
    }

    public Filminfo() {
    }
}
