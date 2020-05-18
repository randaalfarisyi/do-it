package com.doit.user.restcontroller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.doit.user.model.AlternativeMobilePhoneModel;
import com.doit.user.model.BankSegmentsModel;
import com.doit.user.model.BorrowerModel;
import com.doit.user.model.EmergencyContactSegmentsModel;
import com.doit.user.model.FamilySegmentsModel;
import com.doit.user.model.HomeAddrRegionModel;
import com.doit.user.model.HomePhoneModel;
import com.doit.user.model.IncomeSegmentsModel;
import com.doit.user.model.MasterDataModel;
import com.doit.user.model.ProductiveSegmentsModel;
import com.doit.user.model.UploadPictureModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.response.BorrowerAllResponse;
import com.doit.user.response.BorrowerResponse;
import com.doit.user.response.UserSegmentsResponse;
import com.doit.user.service.AlternativeMobilePhoneRestService;
import com.doit.user.service.BankSegmentsRestService;
import com.doit.user.service.BorrowerRestService;
import com.doit.user.service.BorrowerService;
import com.doit.user.service.EmergencyContactSegmentsRestService;
import com.doit.user.service.FamilySegmentsRestService;
import com.doit.user.service.HomeAddrRegionRestService;
import com.doit.user.service.HomePhoneRestService;
import com.doit.user.service.IncomeSegmentsRestService;
import com.doit.user.service.MasterDataRestService;
import com.doit.user.service.ProductiveSegmentsRestService;
import com.doit.user.service.UploadPictureRestService;
import com.doit.user.service.UserSegmentsRestService;
import com.doit.user.service.WorkAddrRegionRestService;
import com.doit.user.service.WorkPhoneRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin("*")
@RestController
public class BorrowerRestController {
    @Autowired
    @Qualifier("borrowerRestServiceImpl")
    private BorrowerRestService borrowerService;

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
	@Qualifier("productiveSegmentsRestServiceImpl")
	private ProductiveSegmentsRestService productiveSegmentsRestService;

	@Autowired
	@Qualifier("familySegmentsRestServiceImpl")
	private FamilySegmentsRestService familySegmentsRestService;

	@Autowired
	@Qualifier("bankSegmentsRestServiceImpl")
	private BankSegmentsRestService bankSegmentsRestService;
	
	@Autowired
	@Qualifier("workAddrRegionRestServiceImpl")
	private WorkAddrRegionRestService workAddrRegionRestService;
	
	@Autowired
	@Qualifier("workPhoneRestServiceImpl")
	private WorkPhoneRestService workPhoneRestService;

	@Autowired
	@Qualifier("uploadPictureRestServiceImpl")
	private UploadPictureRestService uploadPictureRestService;
	
	@Autowired
	@Qualifier("emergencyContactSegmentsRestServiceImpl")
	private EmergencyContactSegmentsRestService emergencyContactSegmentsRestService;

	@Autowired
	@Qualifier("masterDataRestServiceImpl")
	private MasterDataRestService masterDataRestService;
	
	//halaman utama
    @GetMapping("/")
    public List<BorrowerResponse> getAllBorrower(){
    	List<BorrowerResponse> brrwrResponse= new ArrayList<BorrowerResponse>(); 
    	
		List<BorrowerModel> listBorrower = borrowerService.getBorrrowerList();
	
		for(BorrowerModel brrwr : listBorrower){
			BorrowerResponse baru = new BorrowerResponse();
			baru.setId(brrwr.getId());
			baru.setEmail(brrwr.getEmail());
			baru.setMobilePhoneNumber(brrwr.getMobilePhoneNumber());
			baru.setUuid(brrwr.getUuid());
			baru.setUpdatedTime(brrwr.getUpdatedTime());
			baru.setDisabled(brrwr.getDisabled());

			if(userSegmentsRestService.getUserSegmentsByUuidBorrower(brrwr.getUuid())!=null){
				String namaPeminjam = userSegmentsRestService.getUserSegmentsByUuidBorrower(brrwr.getUuid()).getFullName();
				baru.setName(namaPeminjam);
			}else{
				baru.setName("*Belum Diinput");
			}
			
			brrwrResponse.add(baru);
		}
		return brrwrResponse;
	}

	//ambil nama doang wkwk
	@GetMapping("/borrower/nama/{uuid}")
    public String getNamabyUuid(@PathVariable String uuid){
		UserSegmentsModel userSeg = userSegmentsRestService.getUserSegmentsByUuidBorrower(uuid);
		String nama = userSeg.getFullName();
		return nama;
	}

	//get borrower
	@GetMapping("/borrower/lihat/{uuid}")
    public BorrowerResponse viewBorrowerByUuid(@PathVariable String uuid){
		BorrowerModel peminjam = borrowerService.getBorrowerByUuid(uuid);
		BorrowerResponse baru = new BorrowerResponse();
		baru.setId(peminjam.getId());
		baru.setEmail(peminjam.getEmail());
		baru.setMobilePhoneNumber(peminjam.getMobilePhoneNumber());
		baru.setUuid(peminjam.getUuid());
		baru.setUpdatedTime(peminjam.getUpdatedTime());
		baru.setDisabled(peminjam.getDisabled());

		if(userSegmentsRestService.getUserSegmentsByUuidBorrower(peminjam.getUuid())!=null){
			String namaPeminjam = userSegmentsRestService.getUserSegmentsByUuidBorrower(peminjam.getUuid()).getFullName();
			baru.setName(namaPeminjam);
		}else{
			baru.setName("*Belum Diinput");
		}
		
        return baru;
	}

	//get user segments
	@GetMapping("/borrower/lihat/usersegments/{uuid}")
	public UserSegmentsResponse viewUserSegmentsByUuid(@PathVariable String uuid){
		UserSegmentsModel userSeg = userSegmentsRestService.getUserSegmentsByUuidBorrower(uuid);
		UserSegmentsResponse userResponse = new UserSegmentsResponse();
		
		userResponse.setId(userSeg.getId());
		userResponse.setUuid(userSeg.getUuid());
		userResponse.setUuidBorrower(uuid);
		userResponse.setFullName(userSeg.getFullName());
		userResponse.setEmail(userSeg.getEmail());
		userResponse.setHomeAddrDetails(userSeg.getHomeAddrDetails());
		userResponse.setBirthCity(userSeg.getBirthCity());

		//cocoklogi dengan masterdata
		MasterDataModel agama = masterDataRestService.getMasterDataByGroupDataAndCode("Religion", userSeg.getReligion());
		userResponse.setReligion(agama.getIdValue());

		MasterDataModel jk = masterDataRestService.getMasterDataByGroupDataAndCode("Gender", userSeg.getGender());
		userResponse.setGender(jk.getIdValue());

		MasterDataModel pkrj = masterDataRestService.getMasterDataByGroupDataAndCode("Education", userSeg.getEducation());
		userResponse.setEducation(pkrj.getIdValue());
		
		List<HomePhoneModel> noRmh = userSeg.getHomePhoneList();
		HomePhoneModel noRmhList = homePhoneRestService.getHomePhoneByUuidBorrower(uuid);
		userResponse.setHomePhoneList(noRmh);

		List<AlternativeMobilePhoneModel> altHpList = userSeg.getAlternativeMobilePhoneList();
		System.out.println(altHpList.size());
		List<String> tipekontak = new ArrayList<String>();
		List<String> nomorHp = new ArrayList<String>();
		List<AlternativeMobilePhoneModel> nomerBaru = new ArrayList<AlternativeMobilePhoneModel>();
		for(AlternativeMobilePhoneModel nomor : altHpList){
			if(nomor.getDisabled()==0){
				System.out.println(nomor.getId());
				MasterDataModel kode = masterDataRestService.getMasterDataByGroupDataAndCode("Relationship", nomor.getContactType());
				System.out.println(kode.getIdValue());
				tipekontak.add(kode.getIdValue());
				nomorHp.add(nomor.getPhoneNumber());
				nomerBaru.add(nomor);
			}
		}
		//harusnya tipe kontak, salah nama
		userResponse.setKodeArea(tipekontak);
		//harusnya nomor HP, salah nama
		userResponse.setNomorRumah(nomorHp);
		userResponse.setAlternativeMobilePhoneList(nomerBaru);

		List<HomeAddrRegionModel> homeAddrRegionList = userSeg.getHomeAddrRegionList();
		for(HomeAddrRegionModel lokasi : homeAddrRegionList){
			if(lokasi.getDisabled()==0){
				HomeAddrRegionModel baruAlamat = new HomeAddrRegionModel();

				if(masterDataRestService.getMasterDataByGroupDataAndCode("Province", lokasi.getProvince())==null){
					baruAlamat.setProvince("Not Defined");
					userResponse.setProvince("Not Defined");
				}else{
					MasterDataModel provinsi = masterDataRestService.getMasterDataByGroupDataAndCode("Province", lokasi.getProvince());
					baruAlamat.setProvince(provinsi.getIdValue());
					userResponse.setProvince(provinsi.getIdValue());

					if(masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("City", lokasi.getCity(), provinsi.getUuid())==null){
						baruAlamat.setCity("Not Defined");
						userResponse.setCity("Not Defined");
					}else{
						MasterDataModel kota = masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("City", lokasi.getCity(), provinsi.getUuid());
						baruAlamat.setCity(kota.getIdValue());
						userResponse.setCity(kota.getIdValue());

						if(masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("District", lokasi.getDistrict(),kota.getUuid())==null){
							baruAlamat.setDistrict("Not Defined");
							userResponse.setDistrict("Not Defined");
						}else{
							MasterDataModel kabupaten = masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("District", lokasi.getDistrict(),kota.getUuid());
							baruAlamat.setDistrict(kabupaten.getIdValue());
							userResponse.setDistrict(kabupaten.getIdValue());

							if(masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("Subdistrict", lokasi.getSubdistrict(),kabupaten.getUuid())==null){
								baruAlamat.setSubdistrict("Not Defined");
								userResponse.setSubdistrict("Not Defined");
							}else{
								MasterDataModel kelurahan = masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("Subdistrict", lokasi.getSubdistrict(),kabupaten.getUuid());
								baruAlamat.setSubdistrict(kelurahan.getIdValue());
								userResponse.setSubdistrict(kelurahan.getIdValue());
								
								if(masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("Village", lokasi.getVillage(),kelurahan.getUuid())==null){
									baruAlamat.setVillage("Not Defined");
									userResponse.setVillage("Not Defined");
								}else{
									MasterDataModel desa = masterDataRestService.getMasterDataByGroupDataAndCodeAndParentUuid("Village", lokasi.getVillage(),kelurahan.getUuid());
									baruAlamat.setVillage(desa.getIdValue());
									userResponse.setVillage(desa.getIdValue());
									
								}
								
							}
							
						}
					}
				}
			}
		}

        return userResponse;
	}
	
    //ubah user
    @GetMapping("/borrower/{uuid}")
    public BorrowerModel updateBorrowerByUuid(@PathVariable String uuid){
        BorrowerModel peminjam = borrowerService.getBorrowerByUuid(uuid);
        return peminjam;
	}

	//post ubah user
	@PutMapping("/borrower/lihat/{uuid}")
	public ResponseEntity<BorrowerModel> updateBorrower(@PathVariable String uuid, @RequestBody BorrowerModel borrowerupdated){
		System.out.println("hai kamu sampai!");
		System.out.println(borrowerupdated.getDisabled());
		System.out.println(borrowerupdated.getEmail());
		System.out.println(borrowerupdated.getMobilePhoneNumber());
		
		BorrowerModel updatedBorrower = borrowerService.changeBorrower(borrowerupdated,uuid);
		
		return new ResponseEntity<BorrowerModel>(updatedBorrower, HttpStatus.OK);
	}

	//mengubah user segments
	@PutMapping("/borrower/lihat/usersegments/{uuid}")
	public ResponseEntity<UserSegmentsResponse> updateUserSegments(@PathVariable String uuid, @RequestBody UserSegmentsResponse userSegRes){
		System.out.println("hai kamu sampai!");
		
		UserSegmentsModel userSeg = userSegmentsRestService.getUserSegmentsByUuidBorrower(uuid);
		userSeg.setFullName(userSegRes.getFullName());
		userSeg.setHomeAddrRegionList(userSegRes.getHomeAddrRegionList());
		
		return new ResponseEntity<UserSegmentsResponse>(userSegRes, HttpStatus.OK);
	}

	//buat user baru
	@PostMapping("borrower/tambah")
	public ResponseEntity<Void> createBorrower(@RequestBody BorrowerAllResponse tempBorrower) {
		
		//class borrower baru
		int length =15;
		final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    	};

		StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

		String newUuid= new String(password);
		
		Date today = new Date();

		List<BorrowerModel> listBorrower = borrowerService.getBorrrowerList();
		BorrowerModel baru = new BorrowerModel();
		// baru.setId(listBorrower.size()+1);
		// baru.setUuid(newUuid);
		baru.setDisabled(0);
		baru.setMobilePhoneNumber(tempBorrower.getMobilePhoneNumber());
		baru.setPin("x");
		baru.setEmail(tempBorrower.getEmail());
		baru.setUpdatedTime(today);
		baru.setCreatedTime(today);

		BorrowerModel createdBorrower = borrowerService.addBorrower(baru);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/borrower/lihat/{uuid}").buildAndExpand(createdBorrower.getUuid()).toUri();

    	return ResponseEntity.created(uri).build();
	}
	
	//get alternative mobile phone
	@GetMapping("borrower/lihat/altmobilephone/{uuid}")
	public List<AlternativeMobilePhoneModel> getAlternativeMobilePhone(@PathVariable String uuid) {
		List<AlternativeMobilePhoneModel> altHp = alternativeMobilePhoneRestService
				.getAlternativeMobilePhoneByUuidBorrower(uuid);
		return altHp;
	}

	//get income segments
	@GetMapping("borrower/lihat/incomesegments/{uuid}")
	public IncomeSegmentsModel getIncomeSegmentsModel(@PathVariable String uuid){
		IncomeSegmentsModel incSegments = incomeSegmentsRestService.getIncomeSegmentsByUuidBorrower(uuid);
		return incSegments;
	}

	//get productive segments
	@GetMapping("borrower/lihat/productivesegments/{uuid}")
	public ProductiveSegmentsModel getProductiveSegmentsModel(@PathVariable String uuid){
		ProductiveSegmentsModel prodSegments = productiveSegmentsRestService.getProductiveSegmentsByUuidBorrower(uuid);
		return prodSegments;
	}

	//get family segments
	@GetMapping("borrower/lihat/familysegments/{uuid}")
	public FamilySegmentsModel getFamilySegmentsModel(@PathVariable String uuid){
		FamilySegmentsModel famSegments = familySegmentsRestService.getFamilySegmentsByUuidBorrower(uuid);
		return famSegments;
	}
	
	//get emergency contact segments
	@GetMapping("borrower/lihat/emergencycontactsegments/{uuid}")
	public List<EmergencyContactSegmentsModel> getEmergencyContactSegmentsModel(@PathVariable String uuid){
		List<EmergencyContactSegmentsModel> emgcSegments = emergencyContactSegmentsRestService.getEmergencyContactSegmentsByUuidBorrower(uuid);
		return emgcSegments;
	}

	//get bank segments
	@GetMapping("borrower/lihat/banksegments/{uuid}")
	public List<BankSegmentsModel> getBankSegmentsModel(@PathVariable String uuid){
		List<BankSegmentsModel> bankSegments = bankSegmentsRestService.getBankSegmentsModelByUuidBorrower(uuid);
		return bankSegments;
	}

	//get upload picture
	@GetMapping("borrower/lihat/uploadpicture/{uuid}")
	public List<UploadPictureModel> getUploadPictureModel(@PathVariable String uuid){
		List<UploadPictureModel> picts = uploadPictureRestService.getUploadPictureModelByUuidBorrower(uuid);
		return picts;
	}

	@GetMapping("cari/{key}")
	public List<BorrowerResponse>findByName(@PathVariable String key){
		List<BorrowerResponse> brrwrResponse= new ArrayList<BorrowerResponse>(); 
    	
		// List<BorrowerModel> listBorrower = borrowerService.get();
	
		// for(BorrowerModel brrwr : listBorrower){
		// 	BorrowerResponse baru = new BorrowerResponse();
		// 	baru.setId(brrwr.getId());
		// 	baru.setEmail(brrwr.getEmail());
		// 	baru.setMobilePhoneNumber(brrwr.getMobilePhoneNumber());
		// 	baru.setUuid(brrwr.getUuid());
		// 	baru.setUpdatedTime(brrwr.getUpdatedTime());
		// 	baru.setDisabled(brrwr.getDisabled());

		// 	if(userSegmentsRestService.getUserSegmentsByUuidBorrower(brrwr.getUuid())!=null){
		// 		String namaPeminjam = userSegmentsRestService.getUserSegmentsByUuidBorrower(brrwr.getUuid()).getFullName();
		// 		baru.setName(namaPeminjam);
		// 	}else{
		// 		baru.setName("*Belum Diinput");
		// 	}
			
		// 	brrwrResponse.add(baru);
		// }
		return brrwrResponse;
	}

	//ubah general information
	// @PutMapping("borrower/ubah/{uuid}")
	// public rE updateBorrower(@PathVariable String uuid,@RequestBody BorrowerModel brrwr){
	// 	BorrowerModel peminjam = borrowerService.getBorrowerByUuid(uuid);
		
	// 	peminjam.setDisabled(brrwr.getDisabled());
	// 	peminjam.set
	// 	return peminjam;
	// }

	//get master data
	// @GetMapping("masterdata/borro")
	// public List<MasterDataModel> getMasterData(){
	// 	List<MasterDataModel> masterdata = masterDataRestService.getMasterData();
	// 	return masterdata;
	// }

}