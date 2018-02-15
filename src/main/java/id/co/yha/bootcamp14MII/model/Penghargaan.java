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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "penghargaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penghargaan.findAll", query = "SELECT p FROM Penghargaan p")
    , @NamedQuery(name = "Penghargaan.findByPenghargaanId", query = "SELECT p FROM Penghargaan p WHERE p.penghargaanId = :penghargaanId")
    , @NamedQuery(name = "Penghargaan.findByPenghargaan", query = "SELECT p FROM Penghargaan p WHERE p.penghargaan = :penghargaan")
    , @NamedQuery(name = "Penghargaan.findByKeterangan", query = "SELECT p FROM Penghargaan p WHERE p.keterangan = :keterangan")
    , @NamedQuery(name = "Penghargaan.findByGambar", query = "SELECT p FROM Penghargaan p WHERE p.gambar = :gambar")})
public class Penghargaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PENGHARGAAN_ID")
    private Integer penghargaanId;
    @Size(max = 30)
    @Column(name = "PENGHARGAAN")
    private String penghargaan;
    @Size(max = 50)
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Size(max = 50)
    @Column(name = "GAMBAR")
    private String gambar;
    @JoinColumn(name = "DATADIRI_ID", referencedColumnName = "DATADIRI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Datadiri datadiriId;

    public Penghargaan() {
    }

    public Penghargaan(Integer penghargaanId) {
        this.penghargaanId = penghargaanId;
    }

    public Integer getPenghargaanId() {
        return penghargaanId;
    }

    public void setPenghargaanId(Integer penghargaanId) {
        this.penghargaanId = penghargaanId;
    }

    public String getPenghargaan() {
        return penghargaan;
    }

    public void setPenghargaan(String penghargaan) {
        this.penghargaan = penghargaan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Datadiri getDatadiriId() {
        return datadiriId;
    }

    public void setDatadiriId(Datadiri datadiriId) {
        this.datadiriId = datadiriId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (penghargaanId != null ? penghargaanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penghargaan)) {
            return false;
        }
        Penghargaan other = (Penghargaan) object;
        if ((this.penghargaanId == null && other.penghargaanId != null) || (this.penghargaanId != null && !this.penghargaanId.equals(other.penghargaanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Penghargaan[ penghargaanId=" + penghargaanId + " ]";
    }
    
}
