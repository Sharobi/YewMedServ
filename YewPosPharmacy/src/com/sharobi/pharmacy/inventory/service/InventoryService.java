package com.sharobi.pharmacy.inventory.service;

import java.io.InputStream;
import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.model.GenderMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.ReturnReasonTypeDTO;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.SearchCriteraException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.inventory.dao.InventoryDAO;
import com.sharobi.pharmacy.inventory.model.AccountDTO;
import com.sharobi.pharmacy.inventory.model.AccountGroupDTO;
import com.sharobi.pharmacy.inventory.model.AccountMaster;
import com.sharobi.pharmacy.inventory.model.AccountTransTypeDTO;
import com.sharobi.pharmacy.inventory.model.AccountTypeDTO;
import com.sharobi.pharmacy.inventory.model.AreaDTO;
import com.sharobi.pharmacy.inventory.model.BrandDTO;
import com.sharobi.pharmacy.inventory.model.BrandMaster;
import com.sharobi.pharmacy.inventory.model.CategoryMaster;
import com.sharobi.pharmacy.inventory.model.ChartOfAccountDTO;
import com.sharobi.pharmacy.inventory.model.CityDTO;
import com.sharobi.pharmacy.inventory.model.ContentMaster;
import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.inventory.model.CustomerDTO;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.DistributorDTO;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.inventory.model.DoctorMaster;
import com.sharobi.pharmacy.inventory.model.Expiry;
import com.sharobi.pharmacy.inventory.model.ExpiryDTO;
import com.sharobi.pharmacy.inventory.model.ExpiryDetailsDTO;
import com.sharobi.pharmacy.inventory.model.GroupMaster;
import com.sharobi.pharmacy.inventory.model.ItemDTO;
import com.sharobi.pharmacy.inventory.model.ItemHistoryDTO;
import com.sharobi.pharmacy.inventory.model.ItemMaster;
import com.sharobi.pharmacy.inventory.model.ItemSearchByContentDTO;
import com.sharobi.pharmacy.inventory.model.ItemWithSameContentDTO;
import com.sharobi.pharmacy.inventory.model.JournalDTO;
import com.sharobi.pharmacy.inventory.model.JournalListDTO;
import com.sharobi.pharmacy.inventory.model.ManufacturerMaster;
import com.sharobi.pharmacy.inventory.model.OpeningStock;
import com.sharobi.pharmacy.inventory.model.ParaJournalTypeMaster;
import com.sharobi.pharmacy.inventory.model.RackMaster;
import com.sharobi.pharmacy.inventory.model.ScheduleMaster;
import com.sharobi.pharmacy.inventory.model.StateDTO;
import com.sharobi.pharmacy.inventory.model.StockDetailsAdjustmentDTO;
import com.sharobi.pharmacy.inventory.model.SubCategoryMaster;
import com.sharobi.pharmacy.inventory.model.TaxDTO;
import com.sharobi.pharmacy.inventory.model.UnitMaster;
import com.sharobi.pharmacy.inventory.model.ZoneDTO;
import com.sharobi.pharmacy.procurement.model.ItemCurrentStockDTO;
import com.sharobi.pharmacy.procurement.model.TaxMaster;

public class InventoryService {

	private InventoryDAO inventoryDAO;

	public InventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	public InventoryService() {

	}

	public String addBrand(BrandMaster brand) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addBrand(brand);

		} catch (DAOException e) {
			throw new ServiceException("error creating Brand", e);

		}
		return status;
	}

	public String addDistributor(DistributorMaster distributorMaster)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addDistributor(distributorMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating distributor", e);

		}
		return status;
	}

	public String createOrUpdateExpiryInvoice(Expiry expiry)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = inventoryDAO.createOrUpdateExpiryInvoice(expiry);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating expiry invoice", e);

		}
		return stockInId;
	}
	
	public ResponseObj addItem(ItemMaster item) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addItem(item);

		} catch (DAOException e) {
			throw new ServiceException("error creating item", e);

		}
		return responseObj;
	}

	public ResponseObj addSchedule(ScheduleMaster schedule) throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addSchedule(schedule);

		} catch (DAOException e) {
			throw new ServiceException("error creating schedule", e);

		}
		return responseObj;
	}

	public ResponseObj addGroup(GroupMaster groupMaster) throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addGroup(groupMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating Group", e);

		}
		return responseObj;
	}

	public String addRack(RackMaster rackMaster) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addRack(rackMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating rack", e);

		}
		return status;
	}

	public String addDoctor(DoctorMaster doctorMaster) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addDoctor(doctorMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating doctor", e);

		}
		return status;
	}

	public String addCustomer(CustomerMaster customerMaster)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addCustomer(customerMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating customer", e);

		}
		return status;
	}

	public String addSubCategory(SubCategoryMaster subCat)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addSubCategory(subCat);

		} catch (DAOException e) {
			throw new ServiceException("error creating sub category", e);

		}
		return status;
	}

	public ResponseObj addManufacturer(ManufacturerMaster manufacturerMaster)
			throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addManufacturer(manufacturerMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating Manufacturer", e);

		}
		return responseObj;
	}

	public ResponseObj addContent(ContentMaster contentMaster)
			throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addContent(contentMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating Content", e);

		}
		return responseObj;
	}

	public ResponseObj addUnit(UnitMaster unitMaster) throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.addUnit(unitMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating Unit", e);

		}
		return responseObj;
	}

	public String addCategory(CategoryMaster categoryMaster)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.addCategory(categoryMaster);

		} catch (DAOException e) {
			throw new ServiceException("error creating Unit", e);

		}
		return status;
	}

	public String updateBrand(BrandMaster brand) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateBrand(brand);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Brand", e);

		}
		return status;
	}

	public String updateDistributor(DistributorMaster distributorMaster)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateDistributor(distributorMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating distributor", e);

		}
		return status;
	}

	public String updateDoctor(DoctorMaster doc) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateDoctor(doc);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating doctor", e);

		}
		return status;
	}

	public String updateCustomer(CustomerMaster cust) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateCustomer(cust);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating customer", e);

		}
		return status;
	}

	public ResponseObj updateItem(ItemMaster itemMaster) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateItem(itemMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating item", e);

		}
		return responseObj;
	}

	public List<CommonResultSetMapper> searchItem(CommonResultSetMapper mapper)
			throws ServiceException {

		List<CommonResultSetMapper> result = null;
		try {
			result = inventoryDAO.searchItem(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error searching item", e);

		}
		return result;
	}
	
	public List<CommonResultSetMapper> searchTransItem(CommonResultSetMapper mapper)
			throws ServiceException {

		List<CommonResultSetMapper> result = null;
		try {
			result = inventoryDAO.searchTransItem(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error searching trans item", e);

		}
		return result;
	}


	public List<CommonResultSetMapper> searchItemLite(CommonResultSetMapper mapper)
			throws ServiceException {

		List<CommonResultSetMapper> result = null;
		try {
			result = inventoryDAO.searchItemLite(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error searching item lite", e);

		}
		return result;
	}
	
	public ResponseObj updateSchedule(ScheduleMaster scheduleMaster)
			throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateSchedule(scheduleMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating schedule", e);

		}
		return responseObj;
	}

	public ResponseObj updateGroup(GroupMaster groupMaster) throws ServiceException {
		String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateGroup(groupMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Group", e);

		}
		return responseObj;
	}

	public String updateRack(RackMaster rack) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateRack(rack);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating rack", e);

		}
		return status;
	}

	public String updateCategory(CategoryMaster categoryMaster)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateCategory(categoryMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Brand", e);

		}
		return status;
	}

	public String updateSubCategory(SubCategoryMaster subcat)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.updateSubCategory(subcat);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Brand", e);

		}
		return status;
	}

	public ResponseObj updateUnit(UnitMaster unitMaster) throws ServiceException {
		//String status = "";
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateUnit(unitMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Unit", e);

		}
		return responseObj;
	}

	public ResponseObj updateManufacturer(ManufacturerMaster manufacturerMaster)
			throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateManufacturer(manufacturerMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Manufacturer", e);

		}
		return responseObj;
	}

	public ResponseObj updateContent(ContentMaster contentMaster)
			throws ServiceException {
		ResponseObj responseObj = null;
		
		try {
			responseObj = inventoryDAO.updateContent(contentMaster);

		} catch (DAOException e) {
			throw new ServiceException("error uppdating Content", e);

		}
		return responseObj;
	}

	public String deleteBrand(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteBrand(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting Brand", e);

		}
		return status;
	}

	public String deleteDoctor(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteDoctor(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting doctor", e);

		}
		return status;
	}

	public String deleteCustomer(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteCustomer(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting customer", e);

		}
		return status;
	}

	public ResponseObj deleteDistributorByProc(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj=new ResponseObj();
		try {
			responseObj = inventoryDAO.deleteDistributorByProc(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error deleting distributor", e);

		}
		return responseObj;
	}
	
	public ResponseObj deleteCustomer(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj=new ResponseObj();
		try {
			responseObj = inventoryDAO.deleteCustomer(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error deleting customer", e);

		}
		return responseObj;
	}
	
	public String deleteItem(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteItem(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error deleting item", e);

		}
		return status;
	}
	
	public String deleteExpiry(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteExpiry(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error deleting expiry", e);

		}
		return status;
	}
	
	public String postExpiry(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.postExpiry(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error posting expiry", e);

		}
		return status;
	}

	public String deleteDistributor(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteDistributor(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting distributor", e);

		}
		return status;
	}

	public String deleteSchedule(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteSchedule(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting schedule", e);

		}
		return status;
	}

	public String deleteGroup(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteGroup(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting group", e);

		}
		return status;
	}

	public String deleteRack(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteRack(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting Rack", e);

		}
		return status;
	}

	public String deleteCategory(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteCategory(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting category", e);

		}
		return status;
	}

	public String deleteSubCategory(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteSubCategory(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting subcategory", e);

		}
		return status;
	}

	public String deleteUnit(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteUnit(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting unit", e);

		}
		return status;
	}

	public String deleteManufacturer(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteManufacturer(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting manufacturer", e);

		}
		return status;
	}

	public String deleteContent(String id) throws ServiceException {
		String status = "";
		try {
			status = inventoryDAO.deleteContent(id);

		} catch (DAOException e) {
			throw new ServiceException("error deleting Content", e);

		}
		return status;
	}

	public List<BrandMaster> getBrands(String cmpnyId) throws ServiceException {

		List<BrandMaster> brands = null;
		try {

			brands = inventoryDAO.getBrands(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get brands", e);

		}
		return brands;
	}
	
	public List<ItemHistoryDTO> getItemHistory(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemHistoryDTO> contentDTOs = null;
		try {

			contentDTOs = inventoryDAO.getItemHistory(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get item history", e);

		}
		return contentDTOs;
	}
	
	
	public ItemDTO getItemByName(CommonResultSetMapper mapper) throws ServiceException {

		ItemDTO itemDTO = null;
		try {

			itemDTO = inventoryDAO.getItemByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get item by name", e);

		}
		return itemDTO;
	}
	
	public CommonResultSetMapper getItemByBarcode(CommonResultSetMapper mapper) throws ServiceException {

		CommonResultSetMapper commonResultSetMapper = null;
		try {

			commonResultSetMapper = inventoryDAO.getItemByBarcode(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get item by barcode", e);

		}
		return commonResultSetMapper;
	}
	
	public List<ItemWithSameContentDTO> getItemSameContent(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemWithSameContentDTO> contentDTOs = null;
		try {

			contentDTOs = inventoryDAO.getItemSameContent(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get item with same content", e);

		}
		return contentDTOs;
	}

	public List<DoctorMaster> getDoctors(String cmpnyId)
			throws ServiceException {

		List<DoctorMaster> docs = null;
		try {

			docs = inventoryDAO.getDoctors(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get doctrs", e);

		}
		return docs;
	}
	
	public List<DoctorMaster> getDoctorsByName(CommonResultSetMapper mapper)
			throws ServiceException {

		List<DoctorMaster> docs = null;
		try {

			docs = inventoryDAO.getDoctorsByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get doctrs by name", e);

		}
		return docs;
	}

	public List<GenderMaster> getGenders(CommonResultSetMapper mapper)
			throws ServiceException {

		List<GenderMaster> gend = null;
		try {

			gend = inventoryDAO.getGenders(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get genders", e);

		}
		return gend;
	}
	
	public List<CustomerMaster> getCustomers(String cmpnyId)
			throws ServiceException {

		List<CustomerMaster> cust = null;
		try {

			cust = inventoryDAO.getCustomers(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get customers", e);

		}
		return cust;
	}

	public List<DistributorMaster> getDistributors(String cmpnyId)
			throws ServiceException {

		List<DistributorMaster> dists = null;
		try {

			dists = inventoryDAO.getDistributors(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get distributors", e);

		}
		return dists;
	}

	public int checkDuplicateItem(String name, String id)
			throws ServiceException {

		int result = 0;
		try {

			result = inventoryDAO.checkDuplicateItem(name, id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while checking duplicate item", e);

		}
		return result;
	}

	public List<ReturnReasonTypeDTO> getReasonByReturnType(CommonResultSetMapper mapper) throws ServiceException {

		List<ReturnReasonTypeDTO> brands = null;
		try {

			brands = inventoryDAO.getReasonByReturnType(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get return type", e);

		}
		return brands;
	}
	
	public List<BrandDTO> getBrandsProc(String cmpnyId) throws ServiceException {

		List<BrandDTO> brands = null;
		try {

			brands = inventoryDAO.getBrandsProc(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get brands", e);

		}
		return brands;
	}

	public List<ContentMaster> getContents(String cmpnyId)
			throws ServiceException {

		List<ContentMaster> brands = null;
		try {

			brands = inventoryDAO.getContents(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get contents", e);

		}
		return brands;
	}

	public List<ScheduleMaster> getSchedules(String cmpnyId)
			throws ServiceException {

		List<ScheduleMaster> schdls = null;
		try {

			schdls = inventoryDAO.getSchedules(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get schedules", e);

		}
		return schdls;
	}

	public List<GroupMaster> getGroups(String cmpnyId) throws ServiceException {

		List<GroupMaster> grps = null;
		try {

			grps = inventoryDAO.getGroups(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get groups", e);

		}
		return grps;
	}

	public List<RackMaster> getRacks(String cmpnyId) throws ServiceException {

		List<RackMaster> racks = null;
		try {

			racks = inventoryDAO.getRacks(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get brands", e);

		}
		return racks;
	}

	public List<CategoryMaster> getCategories(String cmpnyId)
			throws ServiceException {

		List<CategoryMaster> cats = null;
		try {

			cats = inventoryDAO.getCategories(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get categories", e);

		}
		return cats;
	}

	public List<SubCategoryMaster> getSubCategories(String cmpnyId)
			throws ServiceException {

		List<SubCategoryMaster> subcats = null;
		try {

			subcats = inventoryDAO.getSubCategories(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sub categories", e);

		}
		return subcats;
	}

	public List<ManufacturerMaster> getManufacturers(String cmpnyId)
			throws ServiceException {

		List<ManufacturerMaster> manufcturers = null;
		try {

			manufcturers = inventoryDAO.getManufacturers(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get manufacturers", e);

		}
		return manufcturers;
	}

	public List<UnitMaster> getUnits(String cmpnyId) throws ServiceException {

		List<UnitMaster> units = null;
		try {

			units = inventoryDAO.getUnits(cmpnyId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get units", e);

		}
		return units;
	}

	public BrandMaster getBrand(String id) throws ServiceException {

		BrandMaster brand = null;
		try {

			brand = inventoryDAO.getBrand(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get brand", e);

		}
		return brand;
	}
	
	public List<ItemCurrentStockDTO> getCurrentStockItemBySku(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemCurrentStockDTO> stck = null;
		try {

			stck = inventoryDAO.getCurrentStockItemBySku(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get current stock by sku", e);

		}
		return stck;
	}
	
	public List<CustomerDTO> getCustomersAll(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerDTO> custs = null;
		try {

			custs = inventoryDAO.getCustomersAll(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get customer all", e);

		}
		return custs;
	}
	
	public List<DistributorDTO> getDistributorsAllWithOutstanding(CommonResultSetMapper mapper) throws ServiceException {

		List<DistributorDTO> dist = null;
		try {

			dist = inventoryDAO.getDistributorsAllWithOutstanding(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get distributor all outstanding", e);

		}
		return dist;
	}
	
	public List<DistributorMaster> getDistributorsAll(CommonResultSetMapper mapper) throws ServiceException {

		List<DistributorMaster> dist = null;
		try {

			dist = inventoryDAO.getDistributorsAll(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get distributor all", e);

		}
		return dist;
	}
	
	public DistributorDTO getDistributorById(CommonResultSetMapper mapper) throws ServiceException {

		DistributorDTO dist = null;
		try {

			dist = inventoryDAO.getDistributorById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get distributor by id", e);

		}
		return dist;
	}
	
	public CustomerDTO getCustomerById(CommonResultSetMapper mapper) throws ServiceException {

		CustomerDTO cust = null;
		try {

			cust = inventoryDAO.getCustomerById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get customer by id", e);

		}
		return cust;
	}
	
	public List<ItemCurrentStockDTO> getCurrentStockItem(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemCurrentStockDTO> stck = null;
		try {

			stck = inventoryDAO.getCurrentStockItem(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get current stock", e);

		}
		return stck;
	}
	
	public List<ExpiryDTO> getAllExpiryDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<ExpiryDTO> stck = null;
		try {

			stck = inventoryDAO.getAllExpiryDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all expiry details", e);

		}
		return stck;
	}
	
	public List<ExpiryDetailsDTO> getExpiryDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<ExpiryDetailsDTO> stck = null;
		try {

			stck = inventoryDAO.getExpiryDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get expiry details by id", e);

		}
		return stck;
	}
	
	public List<ItemSearchByContentDTO> getAllItemStockSearchByContent(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemSearchByContentDTO> stck = null;
		try {

			stck = inventoryDAO.getAllItemStockSearchByContent(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all item stock search by content", e);

		}
		return stck;
	}
	
	public List<ItemSearchByContentDTO> getAllItemSearchByContent(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemSearchByContentDTO> stck = null;
		try {

			stck = inventoryDAO.getAllItemSearchByContent(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all item search by content", e);

		}
		return stck;
	}
	
	public List<ExpiryDetailsDTO> getAllPendingExpiryItems(CommonResultSetMapper mapper) throws ServiceException {

		List<ExpiryDetailsDTO> stck = null;
		try {

			stck = inventoryDAO.getAllPendingExpiryItems(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all pending expiry items", e);

		}
		return stck;
	}
	
	public List<ExpiryDetailsDTO> getExpiryForAdjustmentByPurchase(CommonResultSetMapper mapper) throws ServiceException {

		List<ExpiryDetailsDTO> stck = null;
		try {

			stck = inventoryDAO.getExpiryForAdjustmentByPurchase(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get expiry for adjustment by purchase", e);

		}
		return stck;
	}
	
	public List<ExpiryDetailsDTO> getExpiryForAdjustment(CommonResultSetMapper mapper) throws ServiceException {

		List<ExpiryDetailsDTO> stck = null;
		try {

			stck = inventoryDAO.getExpiryForAdjustment(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get expiry for adjustment", e);

		}
		return stck;
	}
	
	
	public ExpiryDTO getExpiryHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		ExpiryDTO exp = null;
		try {

			exp = inventoryDAO.getExpiryHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get expiry header by id", e);

		}
		return exp;
	}
	
	public List<StockDetailsAdjustmentDTO> getStockDetailsForAdjustment(CommonResultSetMapper mapper) throws ServiceException {

		List<StockDetailsAdjustmentDTO> stck = null;
		try {

			stck = inventoryDAO.getStockDetailsForAdjustment(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get stock details for adjustment", e);

		}
		return stck;
	}
	
	public List<ItemCurrentStockDTO> getCurrentStockItemAtSale(CommonResultSetMapper mapper) throws ServiceException {

		List<ItemCurrentStockDTO> stck = null;
		try {

			stck = inventoryDAO.getCurrentStockItemAtSale(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get current stock at sale", e);

		}
		return stck;
	}
	
	public String uploadStockManual(OpeningStock openingStock) throws ServiceException {

		String status = "";
		try {

			status = inventoryDAO.uploadStockManual(openingStock);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to upload stock manually", e);

		}
		return status;
	}
	
	public List<TaxDTO> getAllTaxByName(CommonResultSetMapper mapper) throws ServiceException {

		List<TaxDTO> brands = null;
		try {

			brands = inventoryDAO.getAllTaxByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all tax", e);

		}
		return brands;
	}
	
	public List<TaxDTO> getAllTax(CommonResultSetMapper mapper) throws ServiceException {

		List<TaxDTO> brands = null;
		try {

			brands = inventoryDAO.getAllTax(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all tax", e);

		}
		return brands;
	}
	
	public List<TaxDTO> getTaxDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<TaxDTO> tax = null;
		try {

			tax = inventoryDAO.getTaxDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get tax by id", e);

		}
		return tax;
	}
	
	public TaxDTO getTaxById(CommonResultSetMapper mapper) throws ServiceException {

		TaxDTO tax = null;
		try {

			tax = inventoryDAO.getTaxById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get tax by id", e);

		}
		return tax;
	}
	
	public ResponseObj updateDistributorByProc(DistributorMaster distributorMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.updateDistributorByProc(distributorMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error updating distributor", e);

		}
		return status;
	}
	
	public ResponseObj updateCustomerByProc(CustomerMaster customerMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.updateCustomerByProc(customerMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error updating customer", e);

		}
		return status;
	}
	
	public ResponseObj insertDistributor(DistributorMaster distributorMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.insertDistributor(distributorMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating distributor", e);

		}
		return status;
	}
	
	public ResponseObj insertCustomer(CustomerMaster customerMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.insertCustomer(customerMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating customer", e);

		}
		return status;
	}
	
	public ResponseObj createTax(TaxMaster taxMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.createTax(taxMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating tax", e);

		}
		return status;
	}
	
	public ResponseObj deleteTax(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj status = null;
		try {
			status = inventoryDAO.deleteTax(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error deleting tax", e);

		}
		return status;
	}
	
	public ResponseObj deleteStockAdj(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.deleteStockAdj(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error delteing stock adj", e);

		}
		return status;
	}
	
	public ResponseObj updateStockAdj(StockDetailsAdjustmentDTO mapper)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.updateStockAdj(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error updating stock adj", e);

		}
		return status;
	}
	
	public ResponseObj updateTax(TaxMaster taxMaster)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.updateTax(taxMaster);
			

		} catch (DAOException e) {
			throw new ServiceException("error updating tax", e);

		}
		return status;
	}
	
	public String uploadStock(InputStream fileInputStream,CommonResultSetMapper mapper) throws ServiceException {

		String status= null;
		try {

			status = inventoryDAO.uploadStock(fileInputStream,mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to upload stock", e);

		}
		return status;
	}

	public DoctorMaster getDoctor(String id) throws ServiceException {

		DoctorMaster doc = null;
		try {

			doc = inventoryDAO.getDoctor(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get doctor", e);

		}
		return doc;
	}

	public CustomerMaster getCustomer(String id) throws ServiceException {

		CustomerMaster cust = null;
		try {

			cust = inventoryDAO.getCustomer(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get a customer", e);

		}
		return cust;
	}

	public ItemMaster getItemDetails(String id) throws ServiceException {

		ItemMaster item = null;
		try {

			item = inventoryDAO.getItemDetails(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get item", e);

		}
		return item;
	}

	public DistributorMaster getDistributor(String id) throws ServiceException {

		DistributorMaster dist = null;
		try {

			dist = inventoryDAO.getDistributor(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get distributor", e);

		}
		return dist;
	}

	public ContentMaster getContent(String id) throws ServiceException {

		ContentMaster cntn = null;
		try {

			cntn = inventoryDAO.getContent(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get content", e);

		}
		return cntn;
	}

	public ScheduleMaster getSchedule(String id) throws ServiceException {

		ScheduleMaster schdl = null;
		try {

			schdl = inventoryDAO.getSchedule(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get schedule", e);

		}
		return schdl;
	}

	public GroupMaster getGroup(String id) throws ServiceException {

		GroupMaster grp = null;
		try {

			grp = inventoryDAO.getGroup(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get group", e);

		}
		return grp;
	}

	public RackMaster getRack(String id) throws ServiceException {

		RackMaster rack = null;
		try {

			rack = inventoryDAO.getRack(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get rack", e);

		}
		return rack;
	}

	public UnitMaster getUnit(String id) throws ServiceException {

		UnitMaster unit = null;
		try {

			unit = inventoryDAO.getUnit(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get unit", e);

		}
		return unit;
	}

	public ManufacturerMaster getManufacturer(String id)
			throws ServiceException {

		ManufacturerMaster manufacturerMaster = null;
		try {

			manufacturerMaster = inventoryDAO.getManufacturer(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get manufacturer", e);

		}
		return manufacturerMaster;
	}

	public CategoryMaster getCategory(String id) throws ServiceException {

		CategoryMaster cat = null;
		try {

			cat = inventoryDAO.getCategory(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get catgegory", e);

		}
		return cat;
	}

	public SubCategoryMaster getSubCategory(String id) throws ServiceException {

		SubCategoryMaster subcat = null;
		try {

			subcat = inventoryDAO.getSubCategory(id);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get catgegory", e);

		}
		return subcat;
	}

	public List<BrandMaster> searchBrand(BrandMaster brand)
			throws ServiceException {
		List<BrandMaster> brands = null;
		try {
			brands = inventoryDAO.searchBrand(brand);

		} catch (DAOException e) {
			throw new ServiceException("error searching brand");

		} catch (SearchCriteraException e) {
			throw new ServiceException(e.getMessage());

		}
		return brands;
	}

	public List<UnitMaster> searchUnit(UnitMaster unit) throws ServiceException {
		List<UnitMaster> units = null;
		try {
			units = inventoryDAO.searchUnit(unit);

		} catch (DAOException e) {
			throw new ServiceException("error searching units");

		} catch (SearchCriteraException e) {
			throw new ServiceException(e.getMessage());

		}
		return units;
	}

	public List<CommonResultSetMapper> searchBrandAutoCom(BrandMaster brand)
			throws ServiceException {
		List<CommonResultSetMapper> brands = null;
		try {
			brands = inventoryDAO.searchBrandAutoCom(brand);

		} catch (DAOException e) {
			throw new ServiceException("error searching brand");

		} catch (SearchCriteraException e) {
			throw new ServiceException(e.getMessage());

		}
		return brands;
	}

	public List<CommonResultSetMapper> searchManuAutoCom(ManufacturerMaster manu)
			throws ServiceException {
		List<CommonResultSetMapper> manus = null;
		try {
			manus = inventoryDAO.searchManuAutoCom(manu);

		} catch (DAOException e) {
			throw new ServiceException("error searching manu");

		} catch (SearchCriteraException e) {
			throw new ServiceException(e.getMessage());

		}
		return manus;
	}

	public List<CommonResultSetMapper> searchContentAutoCom(ContentMaster cntnt)
			throws ServiceException {
		List<CommonResultSetMapper> cntnts = null;
		try {
			cntnts = inventoryDAO.searchContentAutoCom(cntnt);

		} catch (DAOException e) {
			throw new ServiceException("error searching content");

		} catch (SearchCriteraException e) {
			throw new ServiceException(e.getMessage());

		}
		return cntnts;
	}

	public List<ContentMaster> searchContent(ContentMaster content)
			throws ServiceException {
		List<ContentMaster> cntnts = null;
		try {
			cntnts = inventoryDAO.searchContent(content);

		} catch (DAOException e) {
			throw new ServiceException("error searching content");

		}

		return cntnts;
	}

	public List<ManufacturerMaster> searchManufacturer(
			ManufacturerMaster manufacturerMaster) throws ServiceException {
		List<ManufacturerMaster> manu = null;
		try {
			manu = inventoryDAO.searchManufacturer(manufacturerMaster);

		} catch (DAOException e) {
			throw new ServiceException("error searching content");

		}

		return manu;
	}

	//15.02.2018
	
	public ResponseObj createAccountGroup(AccountGroupDTO accountGroupDTO) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.createAccountGroup(accountGroupDTO);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error creating Group", e);

		}
		return responseObj;
	}
	
	public ResponseObj updateAccountGroup(AccountGroupDTO accountGroupDTO) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateAccountGroup(accountGroupDTO);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating Group", e);

		}
		return responseObj;
	}
	
	public List<AccountGroupDTO> getAllAccountGroup(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountGroupDTO> typeDTOs = null;
		try {

			typeDTOs = inventoryDAO.getAllAccountGroup(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get account group", e);

		}
		return typeDTOs;
	}
	
	public List<AccountTransTypeDTO> getAccountTransType(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountTransTypeDTO> typeDTOs = null;
		try {

			typeDTOs = inventoryDAO.getAccountTransType(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get AccountTransTypeDTO", e);

		}
		return typeDTOs;
	}
	
	public List<AccountTypeDTO> getAllAccountType(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountTypeDTO> typeDTOs = null;
		try {

			typeDTOs = inventoryDAO.getAllAccountType(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get AccountTypeDTO", e);

		}
		return typeDTOs;
	}
	
	public ResponseObj deleteAccountGroup(CommonResultSetMapper mapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteAccountGroup(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error creating Group", e);

		}
		return responseObj;
	}
	
	//16.02.2018
	public ResponseObj createAccount(AccountMaster master)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = inventoryDAO.createAccount(master);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating account", e);

		}
		return status;
	}
	
	public List<AccountDTO> getAllAccounts(CommonResultSetMapper mapper) throws ServiceException{

		List<AccountDTO> accnts = null;
		try {

			accnts = inventoryDAO.getAllAccounts(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all accounts", e);

		}
		return accnts;
	}
	
	public ResponseObj createArea(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.createArea(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error creating area", e);

		}
		return responseObj;
	}
	
	public ResponseObj updateArea(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateArea(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating area", e);

		}
		return responseObj;
	}
	
	public ResponseObj deleteArea(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteArea(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting area", e);

		}
		return responseObj;
	}
	
	public AreaDTO getAreaById(CommonResultSetMapper mapper) throws ServiceException {

		AreaDTO area = null;
		try {

			area = inventoryDAO.getAreaById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get area", e);

		}
		return area;
	}
	
	public List<AreaDTO> getAreaByNameList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<AreaDTO> area = null;
			try {

				area = inventoryDAO.getAreaByNameList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget areas", e);

			}
			return area;
		
	}
	public List<CountryMaster> getCountryList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<CountryMaster> countryMasters = null;
			try {

				countryMasters = inventoryDAO.getCountryList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get account group", e);

			}
			return countryMasters;
		
	}
	public List<StateDTO> getStateByCountryList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<StateDTO> states = null;
			try {

				states = inventoryDAO.getStateByCountryList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget states", e);

			}
			return states;
		
	}
	public List<CityDTO> getCityByStateList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<CityDTO> city = null;
			try {

				city = inventoryDAO.getCityByStateList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget cities", e);

			}
			return city;
		
	}
	
	public List<CityDTO> getCityByNameList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<CityDTO> city = null;
			try {

				city = inventoryDAO.getCityByNameList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget cities", e);

			}
			return city;
		
	}
	public List<ZoneDTO> getZoneByCityList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<ZoneDTO> city = null;
			try {

				city = inventoryDAO.getZoneByCityList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget zones", e);

			}
			return city;
		
	}
	
	public List<ZoneDTO> getZoneByNameList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<ZoneDTO> city = null;
			try {

				city = inventoryDAO.getZoneByNameList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget zones", e);

			}
			return city;
		
	}
	
	public List<AreaDTO> getAreaByZoneList(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
			List<AreaDTO> city = null;
			try {

				city = inventoryDAO.getAreaByZoneList(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying toget areas", e);

			}
			return city;
		
	}
	
	public ResponseObj createCity(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.createCity(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error creating city", e);

		}
		return responseObj;
	}
	
	public ResponseObj createZone(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.createZone(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error creating zone", e);

		}
		return responseObj;
	}
	
	public ResponseObj updateCity(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateCity(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating city", e);

		}
		return responseObj;
	}
	
	public ResponseObj updateZone(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateZone(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating zone", e);

		}
		return responseObj;
	}
	
	public ResponseObj deleteCity(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteCity(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting city", e);

		}
		return responseObj;
	}
	
	public ResponseObj deleteZone(CommonResultSetMapper commonResultSetMapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteZone(commonResultSetMapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting zone", e);

		}
		return responseObj;
	}

	public List<AccountDTO> getAccountsByName(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountDTO> accnts = null;
		try {
			accnts = inventoryDAO.getAccountsByName(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting zone", e);

		}
		return accnts;
	}
	
	public ResponseObj getDuplicateAccounts(CommonResultSetMapper mapper) throws ServiceException {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.getDuplicateAccount(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error fetching duplicate accounts", e);

		}
		return responseObj;
	}

	public ResponseObj deleteAccounts(CommonResultSetMapper mapper) throws ServiceException {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteAccount(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting accounts", e);

		}
		return responseObj;
	}
	
	public ResponseObj updateAccounts(AccountMaster accountMaster) throws ServiceException {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.updateAccount(accountMaster);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating accounts", e);

		}
		return responseObj;
	}

	public List<AccountDTO> getAccountsAutocomplete(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountDTO> accnts = null;
		try {
			accnts = inventoryDAO.getAccountsAutocomplete(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting accounts", e);

		}
		return accnts;
	}

	public String addJournal(JournalListDTO journallistDTO) throws ServiceException {
		String responseObj="";
		try {
			responseObj = inventoryDAO.addJournal(journallistDTO);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating city", e);

		}
		return responseObj;
	}

	public ResponseObj deleteJournal(CommonResultSetMapper mapper) throws ServiceException {
		ResponseObj responseObj = null;
		try {
			responseObj = inventoryDAO.deleteJournal(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting accounts", e);

		}
		return responseObj;
	}

	public List<ParaJournalTypeMaster> getJournalTypeByQS(CommonResultSetMapper mapper) throws ServiceException {
		List<ParaJournalTypeMaster> pjtms = null;
		try {
			pjtms = inventoryDAO.getJournalTypeByQS(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting ParaJournalTypeMaster", e);

		}
		return pjtms;
	}

	public List<JournalDTO> getAllJournalByType(CommonResultSetMapper mapper) throws ServiceException {
		List<JournalDTO> journals = null;
		try {
			journals = inventoryDAO.getAllJournalByType(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting getAllJournalByType", e);

		}
		return journals;
	}
	
	public List<JournalListDTO> getJournalById(CommonResultSetMapper mapper) throws ServiceException {
		List<JournalListDTO> journals = null;
		try {
			journals = inventoryDAO.getJournalById(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting getJournalById", e);

		}
		return journals;
	}

	public String updateJournal(JournalListDTO journallistDTO) throws ServiceException {
		String responseObj="";
		try {
			responseObj = inventoryDAO.updateJournal(journallistDTO);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error updating journal", e);

		}
		return responseObj;
	}

	public List<AccountDTO> getLedgerDetailsByCode(CommonResultSetMapper mapper) throws ServiceException  {
		List<AccountDTO> ledgerdetails = null;
		try {
			ledgerdetails = inventoryDAO.getLedgerDetailsByCode(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting ledgerdetails", e);

		}
		return ledgerdetails;
	}

	public List<AccountDTO> getAccountsAutocompleteByCashBank(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountDTO> accnts = null;
		try {
			accnts = inventoryDAO.getAccountsAutocompleteByCashBank(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting accounts", e);

		}
		return accnts;
	}

	public List<ChartOfAccountDTO> getChartOfAccount(CommonResultSetMapper mapper) throws ServiceException {
		List<ChartOfAccountDTO> accnts = null;
		try {
			accnts = inventoryDAO.getChartOfAccount(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting chartofaccounts", e);

		}
		return accnts;
	}

	public List<AccountDTO> getAccountsAutocompleteByGroup(CommonResultSetMapper mapper) throws ServiceException {
		List<AccountDTO> accnts = null;
		try {
			accnts = inventoryDAO.getAccountsAutocompleteByGroup(mapper);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error getting accounts", e);

		}
		return accnts;
	}

	public List<CustomerDTO> getCustomersAllByName(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerDTO> custs = null;
		try {

			custs = inventoryDAO.getCustomersAllByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get customer all", e);

		}
		return custs;
	}

	public int opStockTransferforYearEnd(CommonResultSetMapper mapper) throws ServiceException {
		// TODO Auto-generated method stub
		int status = 0;
		try {

			status = inventoryDAO.opStockTransferforYearEnd(mapper);
		} catch (DAOException e) {
			e.printStackTrace();
			status=0;
			throw new ServiceException(
					"problem occured while trying to do opStockTransferforYearEnd", e);
			
		}
		return status;
	}
}
