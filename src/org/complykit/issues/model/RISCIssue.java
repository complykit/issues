/*
 * Created 21-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RISC stands for risk, issue, status, and category. It is the central
 * organizing unit of Complykit Issues.
 *
 * @author mrice
 */
@Entity
@Table(name="risc_issues")
public class RISCIssue {

    private Long id;
    
    private Double riskMagnitude=new Double(1);
    private Double riskProbability=new Double(0.0);

    private String issueTitle="";
    private String issueDescription="";

    private String statusTitle="";
    private String statusDescription="";
    private Date statusDate=new Date();

    private String category="";

    private Set steps=new HashSet();

    //private Group group;
    
    @Id @Column(name="risc_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="risk_magnitude")
    public Double getRiskMagnitude() {
        return riskMagnitude;
    }
    public void setRiskMagnitude(Double riskMagnitude) {
        this.riskMagnitude = riskMagnitude;
    }

    @Column(name="risk_probability")
    public Double getRiskProbability() {
        return riskProbability;
    }
    public void setRiskProbability(Double riskProbability) {
        this.riskProbability = riskProbability;
    }

    @Column(name="issue_title")
    public String getIssueTitle() {
        return issueTitle;
    }
    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    @Column(name="issue_description", columnDefinition="text")
    public String getIssueDescription() {
        return issueDescription;
    }
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="status_date")
    public Date getStatusDate() {
        return statusDate;
    }
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Column(name="status_description", columnDefinition="text")
    public String getStatusDescription() {
        return statusDescription;
    }
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Column(name="status_title", length=255)
    public String getStatusTitle() {
        return statusTitle;
    }
    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    @Column(name="category", length=255)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @OneToMany(targetEntity=org.complykit.issues.model.RISCIssueStep.class)
    @JoinColumn(name="risc_issue_fk")
    public Set getSteps() {
        return steps;
    }
    public void setSteps(Set steps) {
        this.steps = steps;
    }

    /*
    @ManyToOne
    @Column(name="group_id")
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    */



}
