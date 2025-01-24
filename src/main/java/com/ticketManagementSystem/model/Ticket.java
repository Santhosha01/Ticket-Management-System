package com.ticketManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    // Primary key (ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Assigned to (nullable)
    @Column(name = "assignedby")
    private String assignedby;

    // Raised by user (non-nullable)
    @Column(name = "raisedby", nullable = false)
    private String raisedby;

    // Status of the ticket (nullable)
    @Column(name = "status", nullable = false)
    private String status;

    // Type of problem (non-nullable)
    @Column(name = "problemType", nullable = false)
    private String problemType;

    // Problem description (non-nullable)
    @Column(name = "problemDescription", nullable = false)
    private String problemDescription;


    @Column(name = "solution")
    private String solution;


    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }



    // Default constructor
    public Ticket() {}

    // Constructor to create a Ticket with all fields (for persistence)
    public Ticket(Long id, String assignedby, String raisedby, String status, String problemType, String problemDescription) {
        this.id = id;
        this.assignedby = assignedby;
        this.raisedby = raisedby;
        this.status = status;
        this.problemType = problemType;
        this.problemDescription = problemDescription;
    }

    // Constructor for creating a Ticket when raised (with just raisedby, problemType, and problemDescription)
    public Ticket(String raisedby, String problemType, String problemDescription) {
        this.raisedby = raisedby;
        this.status = "raised"; // Default status
        this.problemType = problemType;
        this.problemDescription = problemDescription;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignedby() {
        return assignedby;
    }

    public void setAssignedby(String assignedby) {
        this.assignedby = assignedby;
    }

    public String getRaisedby() {
        return raisedby;
    }

    public void setRaisedby(String raisedby) {
        this.raisedby = raisedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }


}
