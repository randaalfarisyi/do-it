package com.doit.user.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doit.user.model.AlternativeMobilePhoneModel;
import com.doit.user.model.BorrowerModel;
import com.doit.user.model.EmergencyContactSegmentsModel;
import com.doit.user.model.HomeAddrRegionModel;
import com.doit.user.model.HomePhoneModel;
import com.doit.user.model.IncomeSegmentsModel;
import com.doit.user.model.MasterDataModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.model.WorkAddrRegionModel;
import com.doit.user.model.WorkPhoneModel;
import com.doit.user.rest.BaseResponse;
import com.doit.user.service.AlternativeMobilePhoneRestService;
import com.doit.user.service.BorrowerRestService;
import com.doit.user.service.EmergencyContactSegmentsRestService;
import com.doit.user.service.HomeAddrRegionRestService;
import com.doit.user.service.HomePhoneRestService;
import com.doit.user.service.IncomeSegmentsRestService;
import com.doit.user.service.MasterDataRestService;
import com.doit.user.service.UserSegmentsRestService;
import com.doit.user.service.WorkAddrRegionRestService;
import com.doit.user.service.WorkPhoneRestService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
	@Autowired
	@Qualifier("borrowerRestServiceImpl")
	private BorrowerRestService borrowerRestService;
	
	@Autowired
	@Qualifier("userSegmentsRestServiceImpl")
	private UserSegmentsRestService userSegmentsRestService;
	
	@Autowired
	@Qualifier("homePhoneRestServiceImpl")
	private HomePhoneRestService homePhoneRestService;
	
	@Autowired
	@Qualifier("alternativeMobilePhoneRestServiceImpl")
	private AlternativeMobilePhoneRestService alternativeMobilePhoneRestService;
	
	@Autowired
	@Qualifier("homeAddrRegionRestServiceImpl")
	private HomeAddrRegionRestService homeAddrRegionRestService;
	
	@Autowired
	@Qualifier("incomeSegmentsRestServiceImpl")
	private IncomeSegmentsRestService incomeSegmentsRestService;
	
	@Autowired
	@Qualifier("workAddrRegionRestServiceImpl")
	private WorkAddrRegionRestService workAddrRegionRestService;
	
	@Autowired
	@Qualifier("workPhoneRestServiceImpl")
	private WorkPhoneRestService workPhoneRestService;
	
	@Autowired
	@Qualifier("emergencyContactSegmentsRestServiceImpl")
	private EmergencyContactSegmentsRestService emergencyContactSegmentsRestService;
	
	@Autowired
	@Qualifier("masterDataRestServiceImpl")
	private MasterDataRestService masterDataRestService;
	
	@GetMapping(value = "/borrower/{uuidBorrower}")
	public BaseResponse<BorrowerModel> retrieveBorrower(@PathVariable("uuidBorrower") String uuidBorrower) {
		BaseResponse<BorrowerModel> response = new BaseResponse<BorrowerModel>();
		BorrowerModel borrower = borrowerRestService.getBorrowerByUuid(uuidBorrower);
		if (borrower == null) {
			response.setStatus(500);
			response.setMessage("Borrower tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(borrower);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/user-detail")
	public BaseResponse<UserSegmentsModel> retrieveUserSegments(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<UserSegmentsModel> response = new BaseResponse<UserSegmentsModel>();
		UserSegmentsModel userSegments = userSegmentsRestService.getUserSegmentsByUuidBorrower(uuidBorrower);
		if (userSegments == null) {
			response.setStatus(500);
			response.setMessage("User Detail tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(userSegments);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/user-detail/home-phone")
	public BaseResponse<HomePhoneModel> retrieveHomePhone(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<HomePhoneModel> response = new BaseResponse<HomePhoneModel>();
		HomePhoneModel homePhone = homePhoneRestService.getHomePhoneByUuidBorrower(uuidBorrower);
		if (homePhone == null) {
			response.setStatus(500);
			response.setMessage("Home Phone tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(homePhone);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/user-detail/alternative-mobile-phone")
	public BaseResponse<List<AlternativeMobilePhoneModel>> retrieveAlternativeMobilePhone(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<List<AlternativeMobilePhoneModel>> response = new BaseResponse<List<AlternativeMobilePhoneModel>>();
		List<AlternativeMobilePhoneModel> alternativeMobilePhone = alternativeMobilePhoneRestService.getAlternativeMobilePhoneByUuidBorrower(uuidBorrower);
		if (alternativeMobilePhone == null) {
			response.setStatus(500);
			response.setMessage("Alternative Mobile Phone tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(alternativeMobilePhone);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/user-detail/home-address-region")
	public BaseResponse<HomeAddrRegionModel> retrieveHomeAddrRegion(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<HomeAddrRegionModel> response = new BaseResponse<HomeAddrRegionModel>();
		HomeAddrRegionModel homeAddrRegion = homeAddrRegionRestService.getHomeAddrRegionByUuidBorrower(uuidBorrower);
		if (homeAddrRegion == null) {
			response.setStatus(500);
			response.setMessage("Home Address Region tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(homeAddrRegion);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/income-detail")
	public BaseResponse<IncomeSegmentsModel> retrieveIncomeSegments(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<IncomeSegmentsModel> response = new BaseResponse<IncomeSegmentsModel>();
		IncomeSegmentsModel incomeSegments = incomeSegmentsRestService.getIncomeSegmentsByUuidBorrower(uuidBorrower);
		if (incomeSegments == null) {
			response.setStatus(500);
			response.setMessage("Income Detail tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(incomeSegments);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/income-detail/work-address-region")
	public BaseResponse<WorkAddrRegionModel> retrieveWorkAddrRegion(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<WorkAddrRegionModel> response = new BaseResponse<WorkAddrRegionModel>();
		WorkAddrRegionModel workAddrRegion = workAddrRegionRestService.getWorkAddrRegionByUuidBorrower(uuidBorrower);
		if (workAddrRegion == null) {
			response.setStatus(500);
			response.setMessage("Work Address Region tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(workAddrRegion);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/income-detail/work-phone")
	public BaseResponse<WorkPhoneModel> retrieveWorkPhone(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<WorkPhoneModel> response = new BaseResponse<WorkPhoneModel>();
		WorkPhoneModel workPhone = workPhoneRestService.getWorkPhoneByUuidBorrower(uuidBorrower);
		if (workPhone == null) {
			response.setStatus(500);
			response.setMessage("Work Phone tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(workPhone);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/{uuidBorrower}/emergency-contact")
	public BaseResponse<List<EmergencyContactSegmentsModel>> retrieveEmergencyContact(@PathVariable("uuidBorrower") String uuidBorrower){
		BaseResponse<List<EmergencyContactSegmentsModel>> response = new BaseResponse<List<EmergencyContactSegmentsModel>>();
		List<EmergencyContactSegmentsModel> emergencyContact = emergencyContactSegmentsRestService.getEmergencyContactSegmentsByUuidBorrower(uuidBorrower);
		if (emergencyContact == null) {
			response.setStatus(500);
			response.setMessage("Emergency Contact tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(emergencyContact);
		}
		return response;
	}
	
	@GetMapping(value = "/master-data/{groupData}/{code}")
	public BaseResponse<MasterDataModel> retrieveMasterData(@PathVariable("groupData") String groupData, @PathVariable("code") String code){
		BaseResponse<MasterDataModel> response = new BaseResponse<MasterDataModel>();
		MasterDataModel masterData = masterDataRestService.getMasterDataByGroupDataAndCode(groupData, code);
		if (masterData == null) {
			response.setStatus(500);
			response.setMessage("Master Data tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(masterData);
		}
		return response;
	}
	
	@GetMapping(value = "/master-data/{groupData}/{code}/{parentUuid}")
	public BaseResponse<MasterDataModel> retrieveMasterDataWithParent(@PathVariable("groupData") String groupData, @PathVariable("code") String code, @PathVariable("parentUuid") String parentUuid){
		BaseResponse<MasterDataModel> response = new BaseResponse<MasterDataModel>();
		MasterDataModel masterData = masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid(groupData, code, parentUuid);
		if (masterData == null) {
			response.setStatus(500);
			response.setMessage("MasterData tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(masterData);
		}
		return response;
	}
	
	@GetMapping(value = "/borrower/all")
	public BaseResponse<List<BorrowerModel>> retrieveAllBorrower(){
		BaseResponse<List<BorrowerModel>> response = new BaseResponse<List<BorrowerModel>>();
		List<BorrowerModel> borrowerList = borrowerRestService.getBorrrowerList();
		if (borrowerList.size() == 0) {
			response.setStatus(500);
			response.setMessage("Daftar Borrower tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(borrowerList);
		}
		return response;
	}

}
