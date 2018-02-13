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
@Table(name = "detaildataskill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detaildataskill.findAll", query = "SELECT d FROM Detaildataskill d")
    , @NamedQuery(name = "Detaildataskill.findByDetId", query = "SELECT d FROM Detaildataskill d WHERE d.detId = :detId")
    , @NamedQuery(name = "Detaildataskill.findByDatadiriId", query = "SELECT d FROM Detaildataskill d WHERE d.datadiriId = :datadiriId")
    , @NamedQuery(name = "Detaildataskill.findBySkillId", query = "SELECT d FROM Detaildataskill d WHERE d.skillId = :skillId")
    , @NamedQuery(name = "Detaildataskill.findByNama", query = "SELECT d FROM Detaildataskill d WHERE d.nama = :nama")})
public class Detaildataskill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DET_ID")
    private Integer detId;
    @Column(name = "DATADIRI_ID")
    private Integer datadiriId;
    @Column(name = "SKILL_ID")
    private Integer skillId;
    @Size(max = 50)
    @Column(name = "NAMA")
    private String nama;

    public Detaildataskill() {
    }

    public Detaildataskill(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
    }

    public Integer getDatadiriId() {
        return datadiriId;
    }

    public void setDatadiriId(Integer datadiriId) {
        this.datadiriId = datadiriId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detId != null ? detId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detaildataskill)) {
            return false;
        }
        Detaildataskill other = (Detaildataskill) object;
        if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.Detaildataskill[ detId=" + detId + " ]";
    }
    
}
