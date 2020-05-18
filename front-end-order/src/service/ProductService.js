import axios from "axios";

// const INSTRUCTOR = "in28minutes";
// const BASE_API_URL = "http://localhost:8081";
// const BORROWER_API_URL = '${BASE_API_URL}/user';

class ProductService {
  viewProduct(uuid){
    return axios.get(`http://localhost:8081/product/${uuid}`);
  }

  updateProduct(uuid, product) {
    return axios.put(`http://localhost:8081/product/${uuid}`, product);
  }

}

export default new ProductService();