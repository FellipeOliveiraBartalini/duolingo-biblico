package com.example.duolingo_biblico.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModel roleModel;

    public UserModel(String username, String password, String email, RoleModel roleModel) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleModel = roleModel;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // TODO: Plan how the password will be handled securely

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleModel getRole() {
        return roleModel;
    }

    public void setRole(RoleModel roleModel) {
        this.roleModel = roleModel;
    }
}
