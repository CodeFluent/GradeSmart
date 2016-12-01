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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wasfi
 */
@Entity
@Table(name = "COURSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c")
    , @NamedQuery(name = "Courses.findByCrn", query = "SELECT c FROM Courses c WHERE c.crn = :crn")
    , @NamedQuery(name = "Courses.findByCoursename", query = "SELECT c FROM Courses c WHERE c.coursename = :coursename")
    , @NamedQuery(name = "Courses.findByInstructor", query = "SELECT c FROM Courses c WHERE c.instructor = :instructor")})
public class Courses implements Serializable {

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

    public Courses() {
    }

    public Courses(Integer crn) {
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
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.crn == null && other.crn != null) || (this.crn != null && !this.crn.equals(other.crn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gradesmart.GradeSmart.Courses[ crn=" + crn + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
