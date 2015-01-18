package com.springapp.mvc.dao.pojo;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 1/11/15.
 */
@Entity
@Table(name = "tags")
public class Tag {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tags")
    private int id_tags;

    @Column(name = "tagname")
    private String tagname;

    @OneToMany(mappedBy = "tag_id")
    @JoinColumn(name = "tag_id")
    private Set<Bookmark> bookmarks = new HashSet<Bookmark>();

    public Tag() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (id_tags != tag.id_tags) return false;
        if (!tagname.equals(tag.tagname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_tags;
        result = 31 * result + tagname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id_tags=" + id_tags +
                ", tagname='" + tagname + '\'' +
                '}';
    }

    public int getId_tags() {
        return id_tags;
    }

    public void setId_tags(int id_tags) {
        this.id_tags = id_tags;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
