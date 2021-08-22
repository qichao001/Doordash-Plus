package com.laioffer.onlineOrder.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String authorities;

    public String getEmail() {
        return email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
