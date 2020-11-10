/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorul
 */
@Entity
@Table(name = "STUDENTX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentx.findAll", query = "SELECT s FROM Studentx s")
    , @NamedQuery(name = "Studentx.findByStudentxid", query = "SELECT s FROM Studentx s WHERE s.studentxid = :studentxid")
    , @NamedQuery(name = "Studentx.findByStudentxlastname", query = "SELECT s FROM Studentx s WHERE s.studentxlastname = :studentxlastname")
    , @NamedQuery(name = "Studentx.findByStudentxfirstname", query = "SELECT s FROM Studentx s WHERE s.studentxfirstname = :studentxfirstname")
    , @NamedQuery(name = "Studentx.findByStudentxemail", query = "SELECT s FROM Studentx s WHERE s.studentxemail = :studentxemail")})
public class Studentx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENTXID")
    private Integer studentxid;
    @Column(name = "STUDENTXLASTNAME")
    private String studentxlastname;
    @Column(name = "STUDENTXFIRSTNAME")
    private String studentxfirstname;
    @Column(name = "STUDENTXEMAIL")
    private String studentxemail;

    public Studentx() {
    }

    public Studentx(Integer studentxid) {
        this.studentxid = studentxid;
    }

    public Integer getStudentxid() {
        return studentxid;
    }

    public void setStudentxid(Integer studentxid) {
        this.studentxid = studentxid;
    }

    public String getStudentxlastname() {
        return studentxlastname;
    }

    public void setStudentxlastname(String studentxlastname) {
        this.studentxlastname = studentxlastname;
    }

    public String getStudentxfirstname() {
        return studentxfirstname;
    }

    public void setStudentxfirstname(String studentxfirstname) {
        this.studentxfirstname = studentxfirstname;
    }

    public String getStudentxemail() {
        return studentxemail;
    }

    public void setStudentxemail(String studentxemail) {
        this.studentxemail = studentxemail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentxid != null ? studentxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentx)) {
            return false;
        }
        Studentx other = (Studentx) object;
        if ((this.studentxid == null && other.studentxid != null) || (this.studentxid != null && !this.studentxid.equals(other.studentxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Studentx[ studentxid=" + studentxid + " ]";
    }
    
}
