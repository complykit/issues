/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.complykit.issues.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mrice
 */
@Entity
@Table(name="users")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private boolean active=true;
    private boolean administrator=false;
    
    private UserGroup userGroup;

    @Id @Column(name="user_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="active_status")
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name="administrator_status")
    public boolean isAdministrator() {
        return administrator;
    }
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    @ManyToOne
    @JoinColumn(name="user_group_fk")
    public UserGroup getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

}
