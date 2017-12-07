package com.mkyong.model;

import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime dateTime;
    private String profAlias;
    private String bookStatus = "AVAILABLE";
    private String studentID = "N/A";

    public Slot(LocalDateTime dateTime, String profAlias) {
        this.dateTime = dateTime;
        this.profAlias = profAlias;
    }

    @Override
    public String toString() {
        return dateTime.toString() + " " + profAlias + " " + bookStatus + " " + studentID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getProfAlias() {
        return profAlias;
    }

    public void setProfAlias(String profAlias) {
        this.profAlias = profAlias;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
