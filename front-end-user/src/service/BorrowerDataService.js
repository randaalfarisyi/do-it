import axios from "axios";

// const INSTRUCTOR = "in28minutes";
// const BASE_API_URL = "http://localhost:8081";
// const BORROWER_API_URL = '${BASE_API_URL}/user';

class BorrowerDataService {
  retrieveAllBorrower() {
    return axios.get(`http://localhost:8081/`);
  }

  viewBorrower(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/${uuid}`);
  }

  viewUserSegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/usersegments/${uuid}`);
  }

  viewIncomeSegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/incomesegments/${uuid}`);
  }

  viewProductiveSegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/productivesegments/${uuid}`);
  }

  viewFamilySegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/familysegments/${uuid}`);
  }

  viewEmergencyContactSegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/emergencycontactsegments/${uuid}`);
  }
  
  viewBankSegments(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/banksegments/${uuid}`);
  }

  viewUploadPicture(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/uploadpicture/${uuid}`);
  }

  getNama(uuid){
    return axios.get(`http://localhost:8081//borrower/nama/${uuid}`);
  }

  retrieveBorrowerByUuid(uuid){
    return axios.get(`http://localhost:8081/borrower/lihat/${uuid}`);
  }

  updateBorrower(uuid,borrower){
    return axios.put(`http://localhost:8081/borrower/lihat/${uuid}`,borrower);
  }

  updateUserSegments(uuid,userSegments){
    return axios.put(`http://localhost:8081/borrower/ubah/${uuid}`,userSegments);
  }

  addBorrower(borrower){
    return axios.post(`http://localhost:8081/borrower/tambah/`,borrower);
  }

}

export default new BorrowerDataService();