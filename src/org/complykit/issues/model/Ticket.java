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

    private Date openedDate=new Date(); //default to right now

    private String title;
    private String description;

    private String submitter;
    private String assignedTo;

    private String category;

    private boolean closed;
    private Date closedDate=null;
    private String closeComments;
    private boolean closedResolved;

    @Id @Column(name="ticket_id")
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="opened_date")
    public Date getOpenedDate() {
        return openedDate;
    }
    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
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

    @Column(name="category", length=255)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="closed_date")
    public Date getClosedDate() {
        return closedDate;
    }
    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    @Column(name="closed_comments", columnDefinition="text")
    public String getCloseComments() {
        return closeComments;
    }
    public void setCloseComments(String closeComments) {
        this.closeComments = closeComments;
    }

    @Column(name="closed_status")
    public boolean isClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Column(name="closed_resolved")
    public boolean isClosedResolved() {
        return closedResolved;
    }
    public void setClosedResolved(boolean closedResolved) {
        this.closedResolved = closedResolved;
    }

}
