/*
 * Created 23-mar-2011 by Michael Rice
 */

package org.complykit.issues.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mrice
 */
@Entity
@Table(name="tickets")
public class Ticket {

    private Long id;

    private Date submittedDate=new Date(); //default to right now
    private Date resolvedDate=null;

    private String title;
    private String description;

    private String submitter;
    private String assignedTo;

    private String status;
    private String category;

    @Id @Column(name="ticket_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="submitted_date")
    public Date getSubmittedDate() {
        return submittedDate;
    }
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="resolved_date")
    public Date getResolvedDate() {
        return resolvedDate;
    }
    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Column(name="title", length=255)
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

    @Column(name="submitter", length=255)
    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    @Column(name="assigned_to", length=255)
    public String getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Column(name="status", length=255)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="category", length=255)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
}
