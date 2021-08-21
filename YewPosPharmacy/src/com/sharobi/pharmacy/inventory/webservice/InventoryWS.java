package com.sharobi.pharmacy.inventory.webservice;

import javax.ws.rs.QueryParam;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.inventory.model.AccountGroupDTO;
import com.sharobi.pharmacy.inventory.model.BrandMaster;
import com.sharobi.pharmacy.inventory.model.CategoryMaster;
import com.sharobi.pharmacy.inventory.model.ContentMaster;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.inventory.model.DoctorMaster;
import com.sharobi.pharmacy.inventory.model.Expiry;
import com.sharobi.pharmacy.inventory.model.GroupMaster;
import com.sharobi.pharmacy.inventory.model.ItemMaster;
import com.sharobi.pharmacy.inventory.model.ManufacturerMaster;
import com.sharobi.pharmacy.inventory.model.OpeningStock;
import com.sharobi.pharmacy.inventory.model.RackMaster;
import com.sharobi.pharmacy.inventory.model.ScheduleMaster;
import com.sharobi.pharmacy.inventory.model.SubCategoryMaster;
import com.sharobi.pharmacy.inventory.model.UnitMaster;
import com.sharobi.pharmacy.procurement.model.TaxMaster;

/**
 * rajarshi
 */
public interface InventoryWS {

	public String addBrand(BrandMaster brand);

	public String updateBrand(BrandMaster brand);

	public String deleteBrand(@QueryParam(value = "id") String id);

	public String addContent(ContentMaster contentMaster);

	public String updateContent(ContentMaster contentMaster);

	public String deleteContent(@QueryParam(value = "id") String id);

	public String getBrands(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getBrand(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addManufacturer(ManufacturerMaster manufacturerMaster);

	public String updateManufacturer(ManufacturerMaster brand);

	public String deleteManufacturer(@QueryParam(value = "id") String id);

	public String getManufacturers(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getManufacturer(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addUnit(UnitMaster unitMaster);

	public String updateUnit(UnitMaster unitMaster);

	public String deleteUnit(@QueryParam(value = "id") String id);

	public String getUnit(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String getUnits(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String addCategory(CategoryMaster categoryMaster);

	public String updateCategory(CategoryMaster categoryMaster);

	public String deleteCategory(@QueryParam(value = "id") String id);

	public String getCategories(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getCategory(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addSubCategory(SubCategoryMaster subCat);

	public String updateSubCategory(SubCategoryMaster subcat);

	public String deleteSubCategory(@QueryParam(value = "id") String id);

	public String getSubCategories(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getSubCategory(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addRack(RackMaster rackMaster);

	public String updateRack(RackMaster rack);

	public String deleteRack(@QueryParam(value = "id") String id);

	public String getRacks(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getRack(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addGroup(GroupMaster groupMaster);

	public String updateGroup(GroupMaster groupMaster);

	public String deleteGroup(@QueryParam(value = "id") String id);

	public String getGroups(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getGroup(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String addSchedule(ScheduleMaster brand);

	public String updateSchedule(ScheduleMaster scheduleMaster);

	public String deleteSchedule(@QueryParam(value = "id") String id);

	public String getSchedules(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getSchedule(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String getContents(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getContent(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String searchBrand(BrandMaster brand);

	public String searchContent(ContentMaster content);

	public String getBrandsProc(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String searchManufacturer(ManufacturerMaster manufacturerMaster);

	public String checkDuplicateItem(@QueryParam(value = "name") String name,
			@QueryParam(value = "id") String id);

	public String addItem(ItemMaster item);

	public String searchBrandAutoCom(BrandMaster brand);

	public String searchManuAutoCom(ManufacturerMaster brand);

	public String searchContentAutoCom(ContentMaster cntnt);

	public String addDistributor(DistributorMaster distributorMaster);

	public String updateDistributor(DistributorMaster distributorMaster);

	public String getDistributors(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);

	public String getDistributor(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String deleteDistributor(@QueryParam(value = "id") String id);

	public String searchUnit(UnitMaster unit);

	public String getItemDetails(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);

	public String updateItem(ItemMaster itemMaster);

	public String searchItem(CommonResultSetMapper mapper);
	//added on 23.08.2019
	public String searchTransItem(CommonResultSetMapper mapper);

	public String deleteItem(CommonResultSetMapper mapper);
	public String addDoctor(DoctorMaster doctorMaster);
	public String updateDoctor(DoctorMaster doc);
	public String deleteDoctor(@QueryParam(value = "id") String id);
	public String getDoctors(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);
	
	public String getDoctor(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);
	public String addCustomer(CustomerMaster customerMaster);
	public String updateCustomer(CustomerMaster cust);
	public String deleteCustomer(@QueryParam(value = "id") String id);
	public String getCustomers(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang);
	public String getCustomer(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang);
	public String getCurrentStockItem(CommonResultSetMapper mapper);
	public String getItemSameContent(CommonResultSetMapper mapper);
	public String getDoctorsByName(CommonResultSetMapper mapper);
	public String uploadStockManual(OpeningStock openingStock);
	public String getCurrentStockItemAtSale(CommonResultSetMapper mapper);
	public String getAllExpiryDetails(CommonResultSetMapper mapper);
	public String getExpiryHeaderById(CommonResultSetMapper mapper);
	public String getExpiryDetailsById(CommonResultSetMapper mapper);
	public String getAllPendingExpiryItems(CommonResultSetMapper mapper);

	public String createOrUpdateExpiryInvoice(Expiry expiry);
	public String deleteExpiry(CommonResultSetMapper mapper);
	public String postExpiry(CommonResultSetMapper mapper);
	public String getExpiryForAdjustment(CommonResultSetMapper mapper);
	public String getExpiryForAdjustmentByPurchase(CommonResultSetMapper mapper);
	public String getAllItemSearchByContent(CommonResultSetMapper mapper);
	public String getAllItemStockSearchByContent(CommonResultSetMapper mapper);
	public String getAllTaxByName(CommonResultSetMapper mapper);
	public String getAllTax(CommonResultSetMapper mapper);
	public String getTaxDetailsById(CommonResultSetMapper mapper);
	public String createTax(TaxMaster taxMaster);
	public String updateTax(TaxMaster taxMaster);
	public String getItemHistory(CommonResultSetMapper mapper);
	public String getItemByBarcode(CommonResultSetMapper mapper);

	//15.02.2018
	String createAccountGroup(AccountGroupDTO accountGroupDTO);

	String getCountryList(CommonResultSetMapper mapper);
	
}
