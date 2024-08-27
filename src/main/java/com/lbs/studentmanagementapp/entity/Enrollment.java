package com.lbs.studentmanagementapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="enroll_id",length = 11)
    private int enrollid;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;


    @Column(name="batch_name",length = 45)
    private String batchname;

    @Column(name="join_date",length = 12)
    private String joindate;

    @Column(name="fee",length = 12)
    private int fee;

    public Enrollment(int enrollid, Student student, Batch batch, String batchname, String joindate, int fee) {
        this.enrollid = enrollid;
        this.student = student;
        this.batch = batch;
        this.batchname = batchname;
        this.joindate = joindate;
        this.fee = fee;
    }

    public Enrollment() {
    }

    public Enrollment(Student student, Batch batch, String batchname, String joindate, int fee) {
        this.student = student;
        this.batch = batch;
        this.batchname = batchname;
        this.joindate = joindate;
        this.fee = fee;
    }

    public int getEnrollid() {
        return enrollid;
    }

    public void setEnrollid(int enrollid) {
        this.enrollid = enrollid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollid=" + enrollid +
                ", student=" + student +
                ", batch=" + batch +
                ", batchname='" + batchname + '\'' +
                ", joindate='" + joindate + '\'' +
                ", fee=" + fee +
                '}';
    }
}
