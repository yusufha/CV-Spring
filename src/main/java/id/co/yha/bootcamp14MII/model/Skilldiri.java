/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.yha.bootcamp14MII.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "skilldiri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skilldiri.findAll", query = "SELECT s FROM Skilldiri s")
    , @NamedQuery(name = "Skilldiri.findByDatadiriId", query = "SELECT s FROM Skilldiri s WHERE s.skilldiriPK.datadiriId = :datadiriId")
    , @NamedQuery(name = "Skilldiri.findBySkillId", query = "SELECT s FROM Skilldiri s WHERE s.skilldiriPK.skillId = :skillId")
    , @NamedQuery(name = "Skilldiri.findByNama", query = "SELECT s FROM Skilldiri s WHERE s.nama = :nama")
    , @NamedQuery(name = "Skilldiri.findByIsActive", query = "SELECT s FROM Skilldiri s WHERE s.isActive = :isActive")})
public class Skilldiri implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkilldiriPK skilldiriPK;
    @Size(max = 45)
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @JoinColumn(name = "DATADIRI_ID", referencedColumnName = "SKILL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Skill skill;
    @JoinColumn(name = "SKILL_ID", referencedColumnName = "DATADIRI_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Datadiri datadiri;

    public Skilldiri() {
    }

    public Skilldiri(SkilldiriPK skilldiriPK) {
        this.skilldiriPK = skilldiriPK;
    }

    public Skilldiri(int datadiriId, int skillId) {
        this.skilldiriPK = new SkilldiriPK(datadiriId, skillId);
    }

    public SkilldiriPK getSkilldiriPK() {
        return skilldiriPK;
    }

    public void setSkilldiriPK(SkilldiriPK skilldiriPK) {
        this.skilldiriPK = skilldiriPK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Datadiri getDatadiri() {
        return datadiri;
    }

    public void setDatadiri(Datadiri datadiri) {
        this.datadiri = datadiri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skilldiriPK != null ? skilldiriPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skilldiri)) {
            return false;
        }
        Skilldiri other = (Skilldiri) object;
        if ((this.skilldiriPK == null && other.skilldiriPK != null) || (this.skilldiriPK != null && !this.skilldiriPK.equals(other.skilldiriPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Skilldiri[ skilldiriPK=" + skilldiriPK + " ]";
    }
    
}
