package gec.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


public class Filmtype {
    private Integer typeid;
    private String typename;
    private Set<Filminfo> filminfos;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmtype filmtype = (Filmtype) o;
        return typeid == filmtype.typeid &&
                Objects.equals(typename, filmtype.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeid, typename);
    }

    public Set<Filminfo> getFilminfos() {
        return filminfos;
    }

    public void setFilminfos(Set<Filminfo> filminfos) {
        this.filminfos = filminfos;
    }
}
