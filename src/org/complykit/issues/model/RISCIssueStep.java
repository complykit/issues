/*
 * Created 23-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mrice
 */
@Entity
@Table(name="risc_steps")
public class RISCIssueStep {

    private Long id;

    private String displayOrder;

    private String title;
    private String description;

    private String status;
    private String statusDescription;
    private Date statusDate;

    private RISCIssue issue;

    private User assignedTo;
    private User submitter;

    @Id @Column(name="step_id")
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

    @Column(name="title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="description", columnDefinition="text")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="status_description", columnDefinition="text")
    public String getStatusDescription() {
        return statusDescription;
    }
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="status_date")
    public Date getStatusDate() {
        return statusDate;
    }
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
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
    @JoinColumn(name="assigned_to_fk")
    public User getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(User assignedTo) {
        this.assignedTo=assignedTo;
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
