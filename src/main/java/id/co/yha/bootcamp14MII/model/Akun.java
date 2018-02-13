/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.yha.bootcamp14MII.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YusufHA
 */
@Entity
@Table(name = "akun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Akun.findAll", query = "SELECT a FROM Akun a")
    , @NamedQuery(name = "Akun.findByAkunId", query = "SELECT a FROM Akun a WHERE a.akunId = :akunId")
    , @NamedQuery(name = "Akun.findByDatadiriId", query = "SELECT a FROM Akun a WHERE a.datadiriId = :datadiriId")
    , @NamedQuery(name = "Akun.findByUsername", query = "SELECT a FROM Akun a WHERE a.username = :username")
    , @NamedQuery(name = "Akun.findByEmail", query = "SELECT a FROM Akun a WHERE a.email = :email")
    , @NamedQuery(name = "Akun.findByPw", query = "SELECT a FROM Akun a WHERE a.pw = :pw")})
public class Akun implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "akun_id")
    private Integer akunId;
    @Column(name = "datadiri_id")
    private Integer datadiriId;
    @Size(max = 25)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "pw")
    private String pw;

    public Akun() {
    }

    public Akun(Integer akunId) {
        this.akunId = akunId;
    }

    public Integer getAkunId() {
        return akunId;
    }

    public void setAkunId(Integer akunId) {
        this.akunId = akunId;
    }

    public Integer getDatadiriId() {
        return datadiriId;
    }

    public void setDatadiriId(Integer datadiriId) {
        this.datadiriId = datadiriId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (akunId != null ? akunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.akunId == null && other.akunId != null) || (this.akunId != null && !this.akunId.equals(other.akunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.Akun[ akunId=" + akunId + " ]";
    }
    
}
