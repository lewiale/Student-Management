package com.lbs.studentmanagementapp.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id",length = 11)
    private int courseid;

    @Column(name="subject",length = 45)
    private String subject;

    @Column(name="syllabus",length = 60)
    private String syllabus;

    @Column(name="duration",length = 12)
    private Integer duration;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Batch> batches;


    public Course(int courseid, String subject, String syllabus, Integer duration) {
        this.courseid = courseid;
        this.subject = subject;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course(String subject, String syllabus, Integer duration) {
        this.subject = subject;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course() {
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", subject='" + subject + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
