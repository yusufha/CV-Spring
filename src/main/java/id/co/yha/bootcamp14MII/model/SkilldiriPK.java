/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.yha.bootcamp14MII.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author YusufHA
 */
@Embeddable
public class SkilldiriPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATADIRI_ID")
    private int datadiriId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKILL_ID")
    private int skillId;

    public SkilldiriPK() {
    }

    public SkilldiriPK(int datadiriId, int skillId) {
        this.datadiriId = datadiriId;
        this.skillId = skillId;
    }

    public int getDatadiriId() {
        return datadiriId;
    }

    public void setDatadiriId(int datadiriId) {
        this.datadiriId = datadiriId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) datadiriId;
        hash += (int) skillId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkilldiriPK)) {
            return false;
        }
        SkilldiriPK other = (SkilldiriPK) object;
        if (this.datadiriId != other.datadiriId) {
            return false;
        }
        if (this.skillId != other.skillId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.SkilldiriPK[ datadiriId=" + datadiriId + ", skillId=" + skillId + " ]";
    }
    
}
