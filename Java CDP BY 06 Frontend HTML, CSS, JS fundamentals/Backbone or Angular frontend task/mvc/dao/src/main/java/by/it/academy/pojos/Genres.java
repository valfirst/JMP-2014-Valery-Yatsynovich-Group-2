package by.it.academy.pojos;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="genres")
public class Genres implements Serializable {
   private static final long serialVersionUID = 3L;
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column()
    private String genre;
    @OneToMany(mappedBy = "genre")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Books> books;

    public Genres() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genres genres = (Genres) o;

        if (genre != null ? !genre.equals(genres.genre) : genres.genre != null) return false;
        if (id != null ? !id.equals(genres.id) : genres.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}
