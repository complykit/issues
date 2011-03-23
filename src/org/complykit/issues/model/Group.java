/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.complykit.issues.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mrice
 */
@Entity
@Table(name="user_groups")
public class Group {
    private Long id;
    private String name;
    private Set users;

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

    //TODO should be many to many I think
    @OneToMany
    public Set getUsers() {
        return users;
    }
    public void setUsers(Set users) {
        this.users = users;
    }

}
