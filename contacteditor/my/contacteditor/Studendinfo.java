/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

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
 * @author Harpreet
 */
@Entity
@Table(name = "STUDENDINFO", catalog = "", schema = "HSINGH4")
@NamedQueries({
    @NamedQuery(name = "Studendinfo.findAll", query = "SELECT s FROM Studendinfo s")
    , @NamedQuery(name = "Studendinfo.findByStudentid", query = "SELECT s FROM Studendinfo s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Studendinfo.findByCoursename", query = "SELECT s FROM Studendinfo s WHERE s.coursename = :coursename")
    , @NamedQuery(name = "Studendinfo.findByGrade", query = "SELECT s FROM Studendinfo s WHERE s.grade = :grade")})
public class Studendinfo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENTID")
    private Long studentid;
    @Column(name = "COURSENAME")
    private String coursename;
    @Column(name = "GRADE")
    private Integer grade;

    public Studendinfo() {
    }

    public Studendinfo(Long studentid) {
        this.studentid = studentid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        Long oldStudentid = this.studentid;
        this.studentid = studentid;
        changeSupport.firePropertyChange("studentid", oldStudentid, studentid);
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        String oldCoursename = this.coursename;
        this.coursename = coursename;
        changeSupport.firePropertyChange("coursename", oldCoursename, coursename);
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        Integer oldGrade = this.grade;
        this.grade = grade;
        changeSupport.firePropertyChange("grade", oldGrade, grade);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studendinfo)) {
            return false;
        }
        Studendinfo other = (Studendinfo) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.contacteditor.Studendinfo[ studentid=" + studentid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
