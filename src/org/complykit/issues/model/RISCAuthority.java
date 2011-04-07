/*
 * Created 21-mar-2011 by Michael Rice
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
@Table(name="risc_authorities")
public class RISCAuthority {

    private Long id;

    private String type;
    private String source;

    private RISCIssue issue;

    @Id @Column(name="authority_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="authority_type")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="source")
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @ManyToOne
    @JoinColumn(name="risc_issue_fk")
    public RISCIssue getIssue() {
        return issue;
    }
    public void setIssue(RISCIssue issue) {
        this.issue = issue;
    }

}
