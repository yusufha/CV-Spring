/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.yha.bootcamp14MII.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YusufHA
 */
@Entity
@Table(name = "datadiri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datadiri.findAll", query = "SELECT d FROM Datadiri d")
    , @NamedQuery(name = "Datadiri.findByDatadiriId", query = "SELECT d FROM Datadiri d WHERE d.datadiriId = :datadiriId")
    , @NamedQuery(name = "Datadiri.findByNamaLengkap", query = "SELECT d FROM Datadiri d WHERE d.namaLengkap = :namaLengkap")
    , @NamedQuery(name = "Datadiri.findByUmur", query = "SELECT d FROM Datadiri d WHERE d.umur = :umur")
    , @NamedQuery(name = "Datadiri.findByTempatLahir", query = "SELECT d FROM Datadiri d WHERE d.tempatLahir = :tempatLahir")
    , @NamedQuery(name = "Datadiri.findByTanggalLahir", query = "SELECT d FROM Datadiri d WHERE d.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "Datadiri.findByGender", query = "SELECT d FROM Datadiri d WHERE d.gender = :gender")
    , @NamedQuery(name = "Datadiri.findByAgama", query = "SELECT d FROM Datadiri d WHERE d.agama = :agama")
    , @NamedQuery(name = "Datadiri.findByKewarganegaraan", query = "SELECT d FROM Datadiri d WHERE d.kewarganegaraan = :kewarganegaraan")
    , @NamedQuery(name = "Datadiri.findByStatusPerkawinan", query = "SELECT d FROM Datadiri d WHERE d.statusPerkawinan = :statusPerkawinan")
    , @NamedQuery(name = "Datadiri.findByTinggi", query = "SELECT d FROM Datadiri d WHERE d.tinggi = :tinggi")
    , @NamedQuery(name = "Datadiri.findByBerat", query = "SELECT d FROM Datadiri d WHERE d.berat = :berat")
    , @NamedQuery(name = "Datadiri.findByAlamat", query = "SELECT d FROM Datadiri d WHERE d.alamat = :alamat")
    , @NamedQuery(name = "Datadiri.findByFoto", query = "SELECT d FROM Datadiri d WHERE d.foto = :foto")
    , @NamedQuery(name = "Datadiri.findByProfilSingkat", query = "SELECT d FROM Datadiri d WHERE d.profilSingkat = :profilSingkat")
    , @NamedQuery(name = "Datadiri.findByIsActive", query = "SELECT d FROM Datadiri d WHERE d.isActive = :isActive")})
public class Datadiri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DATADIRI_ID")
    private Integer datadiriId;
    @Size(max = 50)
    @Column(name = "NAMA_LENGKAP")
    private String namaLengkap;
    @Size(max = 45)
    @Column(name = "UMUR")
    private String umur;
    @Size(max = 25)
    @Column(name = "TEMPAT_LAHIR")
    private String tempatLahir;
    @Column(name = "TANGGAL_LAHIR")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Column(name = "GENDER")
    private Character gender;
    @Size(max = 10)
    @Column(name = "AGAMA")
    private String agama;
    @Size(max = 15)
    @Column(name = "KEWARGANEGARAAN")
    private String kewarganegaraan;
    @Size(max = 8)
    @Column(name = "STATUS_PERKAWINAN")
    private String statusPerkawinan;
    @Size(max = 3)
    @Column(name = "TINGGI")
    private String tinggi;
    @Size(max = 3)
    @Column(name = "BERAT")
    private String berat;
    @Size(max = 50)
    @Column(name = "ALAMAT")
    private String alamat;
    @Size(max = 50)
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 150)
    @Column(name = "PROFIL_SINGKAT")
    private String profilSingkat;
    @Column(name = "IS_ACTIVE")
    private Short isActive;
    @OneToMany(mappedBy = "datadiriId", fetch = FetchType.LAZY)
    private List<Pekerjaan> pekerjaanList;
    @OneToMany(mappedBy = "datadiriId", fetch = FetchType.LAZY)
    private List<Pendidikan> pendidikanList;
    @OneToMany(mappedBy = "datadiriId", fetch = FetchType.LAZY)
    private List<Organisasi> organisasiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datadiri", fetch = FetchType.LAZY)
    private List<Skilldiri> skilldiriList;
    @OneToMany(mappedBy = "datadiriId", fetch = FetchType.LAZY)
    private List<Penghargaan> penghargaanList;

    public Datadiri() {
    }

    public Datadiri(Integer datadiriId) {
        this.datadiriId = datadiriId;
    }

    public Integer getDatadiriId() {
        return datadiriId;
    }

    public void setDatadiriId(Integer datadiriId) {
        this.datadiriId = datadiriId;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getProfilSingkat() {
        return profilSingkat;
    }

    public void setProfilSingkat(String profilSingkat) {
        this.profilSingkat = profilSingkat;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Pekerjaan> getPekerjaanList() {
        return pekerjaanList;
    }

    public void setPekerjaanList(List<Pekerjaan> pekerjaanList) {
        this.pekerjaanList = pekerjaanList;
    }

    @XmlTransient
    public List<Pendidikan> getPendidikanList() {
        return pendidikanList;
    }

    public void setPendidikanList(List<Pendidikan> pendidikanList) {
        this.pendidikanList = pendidikanList;
    }

    @XmlTransient
    public List<Organisasi> getOrganisasiList() {
        return organisasiList;
    }

    public void setOrganisasiList(List<Organisasi> organisasiList) {
        this.organisasiList = organisasiList;
    }

    @XmlTransient
    public List<Skilldiri> getSkilldiriList() {
        return skilldiriList;
    }

    public void setSkilldiriList(List<Skilldiri> skilldiriList) {
        this.skilldiriList = skilldiriList;
    }

    @XmlTransient
    public List<Penghargaan> getPenghargaanList() {
        return penghargaanList;
    }

    public void setPenghargaanList(List<Penghargaan> penghargaanList) {
        this.penghargaanList = penghargaanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datadiriId != null ? datadiriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datadiri)) {
            return false;
        }
        Datadiri other = (Datadiri) object;
        if ((this.datadiriId == null && other.datadiriId != null) || (this.datadiriId != null && !this.datadiriId.equals(other.datadiriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Datadiri[ datadiriId=" + datadiriId + " ]";
    }
    
}
