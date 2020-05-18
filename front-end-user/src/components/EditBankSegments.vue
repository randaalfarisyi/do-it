<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">{{nama}}</li>
          <li class="breadcrumb-item active" aria-current="page">Edit User Segments</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">{{nama}}</h3>
                <ul class="list-group m-4">
                  <li class="list-group-item">General Information</li>
                  <li class="list-group-item">User Segments</li>
                  <li class="list-group-item">Income Segments</li>
                  <li class="list-group-item">Productive Segments</li>
                  <li class="list-group-item">Family Segments</li>
                  <li class="list-group-item">Emergency Contact Segments</li>
                  <li class="list-group-item active">Bank Segments</li>
                  <li class="list-group-item">Upload Picture</li>
                </ul>
              <button type="button" class="btn btn-outline-info my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-4">
                <h4 class="my-4">Bank Segments</h4>
                    <form class="mx-4">
                        <fieldset class="form-group">
                            <label>Nama Lengkap</label>
                            <input type="text" class="form-control" id="fullName">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" id="email">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tempat Lahir</label>
                            <input type="text" class="form-control" id="birthCity">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tanggal Lahir</label>
                            <input type="date" class="form-control" id="birthDate" >
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Agama</label>
                            <select class="form-control" id="religion">
                                <option>Islam</option>
                                <option>Kristen</option>
                                <option>Protestan</option>
                                <option>Hindu</option>
                                <option>Budha</option>
                            </select>
                        </fieldset>
                        <button class="btn btn-outline-info m-2" type="submit" >Batal</button>
                        <button class="btn btn-info m-2" type="submit" v-on:click="editUserSegments() ">Simpan</button>
                    </form>
            </div>
        </div>
      </div>
    </div>
</div> 
</template>