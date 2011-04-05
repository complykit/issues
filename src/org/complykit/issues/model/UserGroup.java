/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.complykit.issues.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mrice
 */
@Entity
@Table(name="user_groups")
public class UserGroup {
    private Long id;
    private String name;
    private Set users=new HashSet();

    @Id @Column(name="group_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="group_name", length=255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity=org.complykit.issues.model.User.class)
    @JoinColumn(name="user_group_fk")
    public Set getUsers() {
        return users;
    }
    public void setUsers(Set users) {
        this.users = users;
    }

}
