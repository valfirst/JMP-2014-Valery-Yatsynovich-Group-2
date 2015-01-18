package com.springapp.mvc.dao.pojo;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

/**
 * Created by Юлия on 1/11/15.
 */
@Entity
@Table(name = "bookmark")
public class Bookmark {
    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "id_bookmark")
    private int id_bookmark;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    private Tag tag_id;

    public Bookmark() {
    }

//    @Override
//    public String toString() {
//        return "Bookmark{" +
//                "id_bookmark=" + id_bookmark +
//                ", url='" + url + '\'' +
//                ", title='" + title + '\'' +
//                ", tag_id=" + tag_id +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Bookmark)) return false;
//
//        Bookmark bookmark = (Bookmark) o;
//
//        if (id_bookmark != bookmark.id_bookmark) return false;
//        if (tag_id != null ? !tag_id.equals(bookmark.tag_id) : bookmark.tag_id != null) return false;
//        if (title != null ? !title.equals(bookmark.title) : bookmark.title != null) return false;
//        if (url != null ? !url.equals(bookmark.url) : bookmark.url != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id_bookmark;
//        result = 31 * result + (url != null ? url.hashCode() : 0);
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + (tag_id != null ? tag_id.hashCode() : 0);
//        return result;
//    }

    public Tag getTag_id() {
        return tag_id;
    }

    public void setTag_id(Tag tag_id) {
        this.tag_id = tag_id;
    }

    public int getId_bookmark() {
        return id_bookmark;
    }

    public void setId_bookmark(int id_bookmark) {
        this.id_bookmark = id_bookmark;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
