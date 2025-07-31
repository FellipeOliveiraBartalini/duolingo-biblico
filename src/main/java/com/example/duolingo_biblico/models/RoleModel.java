package com.example.duolingo_biblico.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;

    @Column
    private String name;

    public RoleModel() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
