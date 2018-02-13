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
@Table(name = "organisasi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisasi.findAll", query = "SELECT o FROM Organisasi o")
    , @NamedQuery(name = "Organisasi.findByOrganisasiId", query = "SELECT o FROM Organisasi o WHERE o.organisasiId = :organisasiId")
    , @NamedQuery(name = "Organisasi.findByNamaOrganisasi", query = "SELECT o FROM Organisasi o WHERE o.namaOrganisasi = :namaOrganisasi")
    , @NamedQuery(name = "Organisasi.findByJabatan", query = "SELECT o FROM Organisasi o WHERE o.jabatan = :jabatan")
    , @NamedQuery(name = "Organisasi.findByKota", query = "SELECT o FROM Organisasi o WHERE o.kota = :kota")
    , @NamedQuery(name = "Organisasi.findByTahunMulai", query = "SELECT o FROM Organisasi o WHERE o.tahunMulai = :tahunMulai")
    , @NamedQuery(name = "Organisasi.findByTahunSelesai", query = "SELECT o FROM Organisasi o WHERE o.tahunSelesai = :tahunSelesai")
    , @NamedQuery(name = "Organisasi.findByKeterangan", query = "SELECT o FROM Organisasi o WHERE o.keterangan = :keterangan")})
public class Organisasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORGANISASI_ID")
    private Integer organisasiId;
    @Size(max = 45)
    @Column(name = "NAMA_ORGANISASI")
    private String namaOrganisasi;
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

    public Organisasi() {
    }

    public Organisasi(Integer organisasiId) {
        this.organisasiId = organisasiId;
    }

    public Integer getOrganisasiId() {
        return organisasiId;
    }

    public void setOrganisasiId(Integer organisasiId) {
        this.organisasiId = organisasiId;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
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
        hash += (organisasiId != null ? organisasiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisasi)) {
            return false;
        }
        Organisasi other = (Organisasi) object;
        if ((this.organisasiId == null && other.organisasiId != null) || (this.organisasiId != null && !this.organisasiId.equals(other.organisasiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.yha.bootcamp14MII.model.Organisasi[ organisasiId=" + organisasiId + " ]";
    }
    
}
