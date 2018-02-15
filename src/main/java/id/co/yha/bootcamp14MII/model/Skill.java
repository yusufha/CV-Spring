/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.yha.bootcamp14MII.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YusufHA
 */
@Entity
@Table(name = "skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s")
    , @NamedQuery(name = "Skill.findBySkillId", query = "SELECT s FROM Skill s WHERE s.skillId = :skillId")
    , @NamedQuery(name = "Skill.findBySkill", query = "SELECT s FROM Skill s WHERE s.skill = :skill")
    , @NamedQuery(name = "Skill.findByKeterangan", query = "SELECT s FROM Skill s WHERE s.keterangan = :keterangan")})
public class Skill implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill", fetch = FetchType.LAZY)
    private List<Skilldiri> skilldiriList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SKILL_ID")
    private Integer skillId;
    @Size(max = 50)
    @Column(name = "SKILL")
    private String skill;
    @Size(max = 50)
    @Column(name = "KETERANGAN")
    private String keterangan;
    @JoinTable(name = "skilldiri", joinColumns = {
        @JoinColumn(name = "DATADIRI_ID", referencedColumnName = "SKILL_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SKILL_ID", referencedColumnName = "DATADIRI_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Datadiri> datadiriList;

    public Skill() {
    }

    public Skill(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public List<Datadiri> getDatadiriList() {
        return datadiriList;
    }

    public void setDatadiriList(List<Datadiri> datadiriList) {
        this.datadiriList = datadiriList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Skill[ skillId=" + skillId + " ]";
    }

    @XmlTransient
    public List<Skilldiri> getSkilldiriList() {
        return skilldiriList;
    }

    public void setSkilldiriList(List<Skilldiri> skilldiriList) {
        this.skilldiriList = skilldiriList;
    }
    
}
