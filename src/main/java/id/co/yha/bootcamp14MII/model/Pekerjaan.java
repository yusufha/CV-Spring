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
@Table(name = "pekerjaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pekerjaan.findAll", query = "SELECT p FROM Pekerjaan p")
    , @NamedQuery(name = "Pekerjaan.findByPekerjaanId", query = "SELECT p FROM Pekerjaan p WHERE p.pekerjaanId = :pekerjaanId")
    , @NamedQuery(name = "Pekerjaan.findByNamaPerusahaan", query = "SELECT p FROM Pekerjaan p WHERE p.namaPerusahaan = :namaPerusahaan")
    , @NamedQuery(name = "Pekerjaan.findByJabatan", query = "SELECT p FROM Pekerjaan p WHERE p.jabatan = :jabatan")
    , @NamedQuery(name = "Pekerjaan.findByKota", query = "SELECT p FROM Pekerjaan p WHERE p.kota = :kota")
    , @NamedQuery(name = "Pekerjaan.findByTahunMulai", query = "SELECT p FROM Pekerjaan p WHERE p.tahunMulai = :tahunMulai")
    , @NamedQuery(name = "Pekerjaan.findByTahunSelesai", query = "SELECT p FROM Pekerjaan p WHERE p.tahunSelesai = :tahunSelesai")
    , @NamedQuery(name = "Pekerjaan.findByKeterangan", query = "SELECT p FROM Pekerjaan p WHERE p.keterangan = :keterangan")})
public class Pekerjaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEKERJAAN_ID")
    private Integer pekerjaanId;
    @Size(max = 45)
    @Column(name = "NAMA_PERUSAHAAN")
    private String namaPerusahaan;
    @Size(max = 30)
    @Column(name = "JABATAN")
    private String jabatan;
    @Size(max = 30)
    @Column(name = "KOTA")
    private String kota;
    @Size(max = 4)
    @Column(name = "TAHUN_MULAI")
    private String tahunMulai;
    @Size(max = 4)
    @Column(name = "TAHUN_SELESAI")
    private String tahunSelesai;
    @Size(max = 100)
    @Column(name = "KETERANGAN")
    private String keterangan;
    @JoinColumn(name = "DATADIRI_ID", referencedColumnName = "DATADIRI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Datadiri datadiriId;

    public Pekerjaan() {
    }

    public Pekerjaan(Integer pekerjaanId) {
        this.pekerjaanId = pekerjaanId;
    }

    public Integer getPekerjaanId() {
        return pekerjaanId;
    }

    public void setPekerjaanId(Integer pekerjaanId) {
        this.pekerjaanId = pekerjaanId;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTahunMulai() {
        return tahunMulai;
    }

    public void setTahunMulai(String tahunMulai) {
        this.tahunMulai = tahunMulai;
    }

    public String getTahunSelesai() {
        return tahunSelesai;
    }

    public void setTahunSelesai(String tahunSelesai) {
        this.tahunSelesai = tahunSelesai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
        hash += (pekerjaanId != null ? pekerjaanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pekerjaan)) {
            return false;
        }
        Pekerjaan other = (Pekerjaan) object;
        if ((this.pekerjaanId == null && other.pekerjaanId != null) || (this.pekerjaanId != null && !this.pekerjaanId.equals(other.pekerjaanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Pekerjaan[ pekerjaanId=" + pekerjaanId + " ]";
    }
    
}
