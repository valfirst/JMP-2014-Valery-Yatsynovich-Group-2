package com.springapp.mvc.dao.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 1/11/15.
 */
@Entity
@Table(name = "user")
public class User {
    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "user_id")
    private Set<Bookmark> bookmarks = new HashSet<Bookmark>();

    public User() {
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id_user=" + id_user +
//                ", name='" + name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (id_user != user.id_user) return false;
//        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id_user;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
//        return result;
//    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
