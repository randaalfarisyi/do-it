<template>
<div class="landing">
    <div class="row">
      <div class="col-md-12">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb mt-4 mx-4">
              <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Tambah User</li>
            </ol>
        </nav>
      </div>
    </div>

    <div class="col-md-12">
      <div class="list row">
          <div class="col-md-12">
            <div class="card mx-4">
              <div class="card-body">
                <h1 class="m-5">Tambah User</h1>
                <form class="mt-5 mx-5">
                    <fieldset class="form-group">
                        <label>Nama Lengkap</label>
                        <input type="text" class="form-control" id="fullName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Nomor HP</label>
                        <input type="text" class="form-control" v-model="mobilePhoneNumber">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Email</label>
                        <input type="email" v-model="email" class="form-control">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Tempat Lahir</label>
                        <input type="text" class="form-control" id="birthCity">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Tanggal Lahir</label>
                        <input type="date" class="form-control" id="birthDate">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Agama</label>
                        <select id="religion" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option selected>Islam</option>
                            <option>Kristen</option>
                            <option>Budha</option>
                            <option>Hindu</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Jenis Kelamin</label>
                        <select id="gender" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Laki-laki</option>
                            <option>Perempuan</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Pendidikan Terakhir</label>
                        <select id="education" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Doktor</option>
                            <option>Sarjana</option>
                            <option>SMA</option>
                            <option>SMP</option>
                            <option>SD</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Detail Alamat Rumah</label>
                        <input type="textarea" class="form-control">
                    </fieldset>

                    <h5 class="mt-4">Nomor Telepon</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Telepon Rumah</label>
                         <div class="form-row">
                            <div class="col">
                            <input type="text" id="codeArea" class="form-control" placeholder="Kode Area">
                            </div>
                            <div class="col">
                            <input type="text" id="homePhoneNumber" class="form-control" placeholder="Nomor Telepon">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Telepon Alternatif</label>
                         <div class="form-row">
                            <div class="col">
                            <input type="text" id="contactType" class="form-control" placeholder="Tipe Kontak">
                            </div>
                            <div class="col">
                            <input type="text" id="alternativePhoneNumber" class="form-control" placeholder="Nomor Telepon">
                            </div>
                        </div>
                    </fieldset>

                    <h5 class="mt-4">Alamat Rumah</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Provinsi</label>
                        <select id="province" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jabar</option>
                            <option>Jatim</option>
                            <option>Jateng</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kota</label>
                        <select id="city" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jabar</option>
                            <option>Jatim</option>
                            <option>Jateng</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kabupaten</label>
                        <select id="district" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jabar</option>
                            <option>Jatim</option>
                            <option>Jateng</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kecamatan</label>
                        <select id="subdistrict" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jabar</option>
                            <option>Jatim</option>
                            <option>Jateng</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Desa</label>
                        <select id="village" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jabar</option>
                            <option>Jatim</option>
                            <option>Jateng</option>
                        </select>
                    </fieldset>

                    <h5 class="mt-4">Income Segments</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Nama Perusahaan</label>
                        <input type="text" class="form-control" id="companyName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Bidang Industri</label>
                        <select id="industry" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Ritel</option>
                            <option>Kesehatan</option>
                            <option>IT</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Posisi</label>
                        <select id="position" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Sekretaris</option>
                            <option>Akuntan</option>
                            <option>IT</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Pendapatan Bulanan</label>
                        <input type="number" class="form-control" id="monthlyIncome">
                    </fieldset>

                    <h5 class="mt-4">Detail Alamat Kantor</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Alamat Kerja</label>
                        <textarea class="form-control" id="workAddr" rows="3"></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Provinsi</label>
                        <select id="workProvince" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Jawa Barat</option>
                            <option>Jawa Timur</option>
                            <option>DKI Jakarta</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kota</label>
                        <select id="workCity" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>Bogor</option>
                            <option>Jawa Timur</option>
                            <option>DKI Jakarta</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kecamatan</label>
                        <select id="workDistrict" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Kelurahan</label>
                        <select id="workSubdistrict" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Desa</label>
                        <select id="workVillage" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Telepon Kantor</label>
                        <div class="form-row">
                            <div class="col">
                            <input type="text" id="codeAreaOffice" class="form-control" placeholder="Kode Area">
                            </div>
                            <div class="col">
                            <input type="text" id="officePhoneNumber" class="form-control" placeholder="Nomor Telepon">
                            </div>
                        </div>
                    </fieldset>

                    <h5 class="mt-4">Productive Segments</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Application Name</label>
                        <input type="text" class="form-control" id="applicationName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Jangka Waktu (Hari)</label>
                        <input type="text" class="form-control" id="howLong">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Mutasi Bank</label>
                        <input type="file" class="form-control-file" id="bankMutation">
                    </fieldset>

                    <h5 class="mt-4">Family Segments</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>Nama Ibu</label>
                        <input type="text" class="form-control" id="motherName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Status</label>
                        <input type="text" class="form-control" id="status">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Hubungan</label>
                        <input type="text" class="form-control" id="relationshipFam">
                    </fieldset>

                    <h5 class="mt-4">Emergency Contact Segments</h5>
                    <hr/>
                     <fieldset class="form-group">
                        <label>Hubungan</label>
                        <select id="relationshipEmergency" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Nama</label>
                        <input type="text" class="form-control" id="nameEmergency">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Jenis Kelamin</label>
                        <select id="genderEmergency" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Tipe Kontak</label>
                        <select id="contactTypeEmergency" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Nomor Telepon</label>
                        <input type="text" class="form-control" id="emergencyPhoneNum">
                    </fieldset>

                    <h5 class="mt-4">Bank Segments</h5>
                    <hr/>
                     <fieldset class="form-group">
                        <label>Kode Bank</label>
                        <select id="code" class="form-control">
                            <option disabled selected value="">- Pilih -</option>
                            <option>A</option>
                            <option>B</option>
                            <option>C</option>
                        </select>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Nama Pemilik Rekening</label>
                        <input type="text" class="form-control" id="accountHolderName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Nomor Rekening</label>
                        <input type="number" class="form-control" id="accountNumber">
                    </fieldset>

                    <h5 class="mt-4">Upload Picture</h5>
                    <hr/>
                    <fieldset class="form-group">
                        <label>KTP</label>
                        <input type="file" class="form-control-file" id="idCard">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Foto Diri</label>
                        <input type="file" class="form-control-file" id="selfie">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Foto Diri dengan KTP</label>
                        <input type="file" class="form-control-file" id="selfieIdCard">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>NPWP</label>
                        <input type="file" class="form-control-file" id="taxCard">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Slip Gaji</label>
                        <input type="file" class="form-control-file" id="paySlip">
                    </fieldset>

                    <button class="btn btn-outline-info m-2" type="submit">Batal</button>
                    <button class="btn btn-info m-2" type="submit" v-on:click="addBorrower()">Simpan</button>
                </form>
              </div>
            </div>
          </div>
      </div>
    </div>
</div>
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';
export default {
  name: "addBorrower",
   data(){
    return{
        fullName:"",
        email:"",
        mobilePhoneNumber:"",
        errors:[],
        message: null
    };
  },
  methods: {
    addBorrower() {
        BorrowerDataService.addBorrower({
        fullName:this.fullName,
        email:this.email,
        mobilePhoneNumber : this.mobilePhoneNumber
      })
      .then(() => {
        this.$router.push(`/`);
      })
      .catch(e => {
        console.log(e);
      });
    }
  }
};
</script>

<style scoped>
.landing{
  background-color : #F4F5F5;
}

table{
  width:100%;
  border-style : none;
}

.breadcrumb{
  background-color : #FFFFFF;
}

.breadcrumb-item{
  color : #03D0B6;
}
</style>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)
</style>