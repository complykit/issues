/*
 * Created 21-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    private String title="";
    private String summary="";
    private String detailedDescription="";

    private String statusTitle="";
    private String statusDescription="";
    private Date statusDate=new Date();

    private String category="";

    private String displayOrder;

    private String instructionDisplayMode="bullets";
    private Set instructions=new HashSet();

    private Set authorities=new HashSet();

    private User submitter;
    private UserGroup userGroup;

    @Id @Column(name="risc_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="display_order")
    public String getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
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

    @Column(name="title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="summary", columnDefinition="text")
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name="detailed_description", columnDefinition="text")
    public String getDetailedDescription() {
        return detailedDescription;
    }
    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
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

    @Column(name="instr_disp_mode", length=255)
    public String getInstructionDisplayMode() {
        return instructionDisplayMode;
    }
    public void setInstructionDisplayMode(String instructionDisplayMode) {
        this.instructionDisplayMode = instructionDisplayMode;
    }

    @OneToMany(targetEntity=org.complykit.issues.model.RISCIssueInstruction.class)
    @JoinColumn(name="risc_issue_fk")
    public Set getInstructions() {
        return instructions;
    }
    public void setInstructions(Set instructions) {
        this.instructions = instructions;
    }

    @OneToMany(targetEntity=org.complykit.issues.model.RISCAuthority.class)
    @JoinColumn(name="risc_issue_fk")
    public Set getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Set authorities) {
        this.authorities = authorities;
    }

    @OneToOne
    @JoinColumn(name="submitter_fk")
    public User getSubmitter() {
        return submitter;
    }
    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    @OneToOne
    @JoinColumn(name="user_group_fk")
    public UserGroup getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

}
