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
@Table(name = "pendidikan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendidikan.findAll", query = "SELECT p FROM Pendidikan p")
    , @NamedQuery(name = "Pendidikan.findByPendidikanId", query = "SELECT p FROM Pendidikan p WHERE p.pendidikanId = :pendidikanId")
    , @NamedQuery(name = "Pendidikan.findByNamaSekolah", query = "SELECT p FROM Pendidikan p WHERE p.namaSekolah = :namaSekolah")
    , @NamedQuery(name = "Pendidikan.findByJurusan", query = "SELECT p FROM Pendidikan p WHERE p.jurusan = :jurusan")
    , @NamedQuery(name = "Pendidikan.findByKota", query = "SELECT p FROM Pendidikan p WHERE p.kota = :kota")
    , @NamedQuery(name = "Pendidikan.findByTahunMulai", query = "SELECT p FROM Pendidikan p WHERE p.tahunMulai = :tahunMulai")
    , @NamedQuery(name = "Pendidikan.findByTahunSelesai", query = "SELECT p FROM Pendidikan p WHERE p.tahunSelesai = :tahunSelesai")
    , @NamedQuery(name = "Pendidikan.findByIpk", query = "SELECT p FROM Pendidikan p WHERE p.ipk = :ipk")
    , @NamedQuery(name = "Pendidikan.findByIsActive", query = "SELECT p FROM Pendidikan p WHERE p.isActive = :isActive")})
public class Pendidikan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PENDIDIKAN_ID")
    private Integer pendidikanId;
    @Size(max = 50)
    @Column(name = "NAMA_SEKOLAH")
    private String namaSekolah;
    @Size(max = 30)
    @Column(name = "JURUSAN")
    private String jurusan;
    @Size(max = 30)
    @Column(name = "KOTA")
    private String kota;
    @Size(max = 4)
    @Column(name = "TAHUN_MULAI")
    private String tahunMulai;
    @Size(max = 4)
    @Column(name = "TAHUN_SELESAI")
    private String tahunSelesai;
    @Size(max = 4)
    @Column(name = "IPK")
    private String ipk;
    @Column(name = "IS_ACTIVE")
    private Integer isActive;
    @JoinColumn(name = "DATADIRI_ID", referencedColumnName = "DATADIRI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Datadiri datadiriId;

    public Pendidikan() {
    }

    public Pendidikan(Integer pendidikanId) {
        this.pendidikanId = pendidikanId;
    }

    public Integer getPendidikanId() {
        return pendidikanId;
    }

    public void setPendidikanId(Integer pendidikanId) {
        this.pendidikanId = pendidikanId;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
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

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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
        hash += (pendidikanId != null ? pendidikanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendidikan)) {
            return false;
        }
        Pendidikan other = (Pendidikan) object;
        if ((this.pendidikanId == null && other.pendidikanId != null) || (this.pendidikanId != null && !this.pendidikanId.equals(other.pendidikanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Pendidikan[ pendidikanId=" + pendidikanId + " ]";
    }
    
}
