/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gradesmart.GradeSmart;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wasfi
 */
@Entity
@Table(name = "USER_COURSES")
@NamedQueries({
    @NamedQuery(name = "UserCourses.findAll", query = "SELECT u FROM UserCourses u")
    , @NamedQuery(name = "UserCourses.findByCrn", query = "SELECT u FROM UserCourses u WHERE u.crn = :crn")
    , @NamedQuery(name = "UserCourses.findByCoursename", query = "SELECT u FROM UserCourses u WHERE u.coursename = :coursename")
    , @NamedQuery(name = "UserCourses.findByInstructor", query = "SELECT u FROM UserCourses u WHERE u.instructor = :instructor")})
public class UserCourses implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CRN")
    private Integer crn;
    @Column(name = "COURSENAME")
    private String coursename;
    @Column(name = "INSTRUCTOR")
    private String instructor;

    public UserCourses() {
    }

    public UserCourses(Integer crn) {
        this.crn = crn;
    }

    public Integer getCrn() {
        return crn;
    }

    public void setCrn(Integer crn) {
        Integer oldCrn = this.crn;
        this.crn = crn;
        changeSupport.firePropertyChange("crn", oldCrn, crn);
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        String oldCoursename = this.coursename;
        this.coursename = coursename;
        changeSupport.firePropertyChange("coursename", oldCoursename, coursename);
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        String oldInstructor = this.instructor;
        this.instructor = instructor;
        changeSupport.firePropertyChange("instructor", oldInstructor, instructor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crn != null ? crn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserCourses)) {
            return false;
        }
        UserCourses other = (UserCourses) object;
        if ((this.crn == null && other.crn != null) || (this.crn != null && !this.crn.equals(other.crn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gradesmart.GradeSmart.UserCourses[ crn=" + crn + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
