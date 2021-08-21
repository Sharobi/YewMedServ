package com.sharobi.pharmacy.inventory.webservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.GenderMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.ReturnReasonTypeDTO;
import com.sharobi.pharmacy.commonutil.BarcodePrintParam;
import com.sharobi.pharmacy.commonutil.BarcodePrintParamList;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
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
import com.sharobi.pharmacy.inventory.service.InventoryService;
import com.sharobi.pharmacy.inventory.webservice.InventoryWS;
import com.sharobi.pharmacy.print.BarcodeDAO;
import com.sharobi.pharmacy.print.BarcodeDAOImpl;
import com.sharobi.pharmacy.procurement.model.ItemCurrentStockDTO;
import com.sharobi.pharmacy.procurement.model.TaxMaster;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.dao.impl.StoreDAOImpl;
import com.sharobi.pharmacy.store.model.StoreMaster;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * rajarshi
 */
@Path(value = "/inventory")
public class InventoryWSImpl implements InventoryWS {

	private InventoryService inventoryService;
	private BarcodeDAO barcodeDAO=new BarcodeDAOImpl();
	
  private EntityManagerFactory entityManagerFactory = PersistenceListener.getEntityManager();;


	public InventoryWSImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@Override
	@Path(value = "/addBrand")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addBrand(BrandMaster brand) {
		String status = "";
		try {
			status = inventoryService.addBrand(brand);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addDistributor")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addDistributor(DistributorMaster distributorMaster) {
		String status = "";
		//System.out.println("addDistributor distributorMaster = "+distributorMaster);
		try {
			status = inventoryService.addDistributor(distributorMaster);

		} catch (Exception x) {
			//status = ReturnConstant.FAILURE;
			status=""+0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addItem(ItemMaster item) {
		//System.out.println("Add Item = "+item);
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addItem(item);

		} catch (Exception x) {
			x.printStackTrace();
			ItemMaster itemMaster=new ItemMaster();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setItem(itemMaster);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		
		//System.out.println("add item return "+ json);
		return json;
	}

	@Override
	@Path(value = "/addSchedule")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addSchedule(ScheduleMaster scheduleMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addSchedule(scheduleMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/addGroup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addGroup(GroupMaster groupMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addGroup(groupMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/addRack")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addRack(RackMaster rackMaster) {
		String status = "";
		try {
			status = inventoryService.addRack(rackMaster);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addDoctor")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addDoctor(DoctorMaster doctorMaster) {
		String status = "";
		try {
			status = inventoryService.addDoctor(doctorMaster);

		} catch (Exception x) {
			//status = ReturnConstant.FAILURE;
			status=""+0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addCustomer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addCustomer(CustomerMaster customerMaster) {
		System.out.println("customerMaster: "+customerMaster);
		String status = "";
		try {
			status = inventoryService.addCustomer(customerMaster);

		} catch (Exception x) {
			//status = ReturnConstant.FAILURE;
			status=""+0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addSubCategory")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addSubCategory(SubCategoryMaster subCat) {
		String status = "";
		try {
			status = inventoryService.addSubCategory(subCat);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/addManufacturer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addManufacturer(ManufacturerMaster manufacturerMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addManufacturer(manufacturerMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/addContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addContent(ContentMaster contentMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addContent(contentMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/addUnit")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addUnit(UnitMaster unitMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.addUnit(unitMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/addCategory")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addCategory(CategoryMaster categoryMaster) {
		String status = "";
		try {
			status = inventoryService.addCategory(categoryMaster);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateBrand")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateBrand(BrandMaster brand) {
		String status = "";
		try {
			status = inventoryService.updateBrand(brand);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateDistributor")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDistributor(DistributorMaster distributorMaster) {
		String status = "";
		try {
			status = inventoryService.updateDistributor(distributorMaster);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateDoctor")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDoctor(DoctorMaster doc) {
		String status = "";
		try {
			status = inventoryService.updateDoctor(doc);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateCustomer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateCustomer(CustomerMaster cust) {
		String status = "";
		try {
			status = inventoryService.updateCustomer(cust);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateItem(ItemMaster itemMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateItem(itemMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/searchItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchItem(CommonResultSetMapper mapper) {
		String status = "";
		List<CommonResultSetMapper> data = null;
		String result = "";
		try {
			data = inventoryService.searchItem(mapper);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(data, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}
	//added on 23.08.2019
	@Override
	@Path(value = "/searchTransItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchTransItem(CommonResultSetMapper mapper) {
		List<CommonResultSetMapper> data = null;
		long st=System.currentTimeMillis();
		String result = "";
		try {
			data = inventoryService.searchTransItem(mapper);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(data, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}
		long et=System.currentTimeMillis();
		System.out.println("time diff in searchTransItem:"+(et-st));
		return result;
	}
	
	@Path(value = "/searchItemLite")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchItemLite(CommonResultSetMapper mapper) {
		String status = "";
		List<CommonResultSetMapper> data = null;
		String result = "";
		try {
			data = inventoryService.searchItemLite(mapper);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(data, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/updateSchedule")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateSchedule(ScheduleMaster scheduleMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateSchedule(scheduleMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/updateGroup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateGroup(GroupMaster groupMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateGroup(groupMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/updateRack")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateRack(RackMaster rack) {
		String status = "";
		try {
			status = inventoryService.updateRack(rack);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateCategory")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateCategory(CategoryMaster categoryMaster) {
		String status = "";
		try {
			status = inventoryService.updateCategory(categoryMaster);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateSubCategory")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateSubCategory(SubCategoryMaster subcat) {
		String status = "";
		try {
			status = inventoryService.updateSubCategory(subcat);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/updateUnit")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateUnit(UnitMaster unitMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateUnit(unitMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/updateManufacturer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateManufacturer(ManufacturerMaster manufacturerMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateManufacturer(manufacturerMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/updateContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateContent(ContentMaster contentMaster) {
		//String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateContent(contentMaster);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/deleteBrand")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteBrand(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteBrand(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteDoctor")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteDoctor(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteDoctor(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteCustomer")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteCustomer(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteCustomer(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteItem")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteItem(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = inventoryService.deleteItem(mapper);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}
	
	
	@Path(value = "/deleteCustomer")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteCustomer(CommonResultSetMapper mapper) {
		ResponseObj responseObj=new ResponseObj();
		try {
			responseObj = inventoryService.deleteCustomer(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("customer not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/deleteDistributorByProc")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteDistributorByProc(CommonResultSetMapper mapper) {
		ResponseObj responseObj=new ResponseObj();
		try {
			responseObj = inventoryService.deleteDistributorByProc(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("distributor not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/deleteDistributor")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteDistributor(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteDistributor(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteSchedule")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSchedule(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteSchedule(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteGroup")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteGroup(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteGroup(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteRack")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteRack(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteRack(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteCategory")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteCategory(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteCategory(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteSubCategory")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSubCategory(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteSubCategory(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteUnit")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteUnit(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteUnit(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteManufacturer")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteManufacturer(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteManufacturer(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteContent")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteContent(@QueryParam(value = "id") String id) {
		String status = "";
		try {
			status = inventoryService.deleteContent(id);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/getBrands")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getBrands(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<BrandMaster> brands = null;
		long startTime = System.currentTimeMillis();
		try {

			brands = inventoryService.getBrands(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<BrandMaster>>() {
		}.getType();
		String json = gson.toJson(brands, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}

	@Override
	@Path(value = "/getItemSameContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getItemSameContent(CommonResultSetMapper mapper) {
		List<ItemWithSameContentDTO> contentDTOs = null;
		long startTime = System.currentTimeMillis();
		try {

			contentDTOs = inventoryService.getItemSameContent(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemWithSameContentDTO>>() {
		}.getType();
		String json = gson.toJson(contentDTOs, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}

	@Override
	@Path(value = "/getDoctors")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getDoctors(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<DoctorMaster> docs = null;

		try {

			docs = inventoryService.getDoctors(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DoctorMaster>>() {
		}.getType();
		String json = gson.toJson(docs, type);

		return json;
	}
	
	
	@Path(value = "/generateAndPrintBarcode")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String generateAndPrintBarcode(BarcodePrintParam params,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		String status = null;
		System.out.println("BarcodePrintParam = "+params);
		EntityManager em = null;
		Connection connection = null;
		try {

			em = PersistenceListener.getEntityManager().createEntityManager();
			// get connection object from entity manager
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ((Session) em.getDelegate())
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			status = barcodeDAO.generateAndPrintBarcode(params,request.getRealPath("/"), connection);

		} catch (Exception x) {
			x.printStackTrace();

		}
		finally {
			try {
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(em != null) em.close();
			
		}

		return status;
	}

	@Path(value = "/generateAndPrintBarcodeAll")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String generateAndPrintBarcodeAll(BarcodePrintParamList barcodePrintParamList,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		String status = null;

		EntityManager em = null;
		Connection connection = null;
		try {
			em = PersistenceListener.getEntityManager().createEntityManager();
			// get connection object from entity manager
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ((Session) em.getDelegate())
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			status = barcodeDAO.generateAndPrintBarcodeAll(barcodePrintParamList, request.getRealPath("/"), connection);

		} catch (Exception x) {
			x.printStackTrace();
		}
		finally {
			try {
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(em != null) em.close();
			
		}
	
		return status;
	}

	@Override
	@Path(value = "/getDoctorsByName")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getDoctorsByName(CommonResultSetMapper mapper) {
		List<DoctorMaster> docs = null;

		try {

			docs = inventoryService.getDoctorsByName(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DoctorMaster>>() {
		}.getType();
		String json = gson.toJson(docs, type);

		return json;
	}

	@Override
	@Path(value = "/getCustomers")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustomers(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<CustomerMaster> cust = null;

		try {

			cust = inventoryService.getCustomers(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CustomerMaster>>() {
		}.getType();
		String json = gson.toJson(cust, type);

		return json;
	}
	
	
	@Path(value = "/getGenders")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getGenders(CommonResultSetMapper mapper) {
		List<GenderMaster> list = null;

		try {

			list = inventoryService.getGenders(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<GenderMaster>>() {
		}.getType();
		String json = gson.toJson(list, type);

		return json;
	}

	@Override
	@Path(value = "/getDistributors")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getDistributors(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<DistributorMaster> dists = null;
		long startTime = System.currentTimeMillis();
		try {

			dists = inventoryService.getDistributors(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DistributorMaster>>() {
		}.getType();
		String json = gson.toJson(dists, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}

	@Override
	@Path(value = "/checkDuplicateItem")
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String checkDuplicateItem(@QueryParam(value = "name") String name,
			@QueryParam(value = "id") String id) {
		int result = 0;
		String result1 = "";
		try {

			result = inventoryService.checkDuplicateItem(name, id);

		} catch (Exception x) {
			result = 1;
			x.printStackTrace();

		}
		/*
		 * if(result==0){ result1="success"; } else if (result==1) {
		 * result1="failure"; }
		 */

		return "" + result;
	}

	@Override
	@Path(value = "/getBrandsProc")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getBrandsProc(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<BrandDTO> brands = null;
		long startTime = System.currentTimeMillis();
		try {

			brands = inventoryService.getBrandsProc(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<BrandMaster>>() {
		}.getType();
		String json = gson.toJson(brands, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS with Proc:: "+ (endTime - startTime));
		return json;
	}

	@Override
	@Path(value = "/getContents")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getContents(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<ContentMaster> contnts = null;

		try {

			contnts = inventoryService.getContents(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ContentMaster>>() {
		}.getType();
		String json = gson.toJson(contnts, type);

		return json;
	}

	@Override
	@Path(value = "/getSchedules")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getSchedules(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<ScheduleMaster> schdls = null;

		try {

			schdls = inventoryService.getSchedules(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ScheduleMaster>>() {
		}.getType();
		String json = gson.toJson(schdls, type);

		return json;
	}

	@Override
	@Path(value = "/getGroups")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getGroups(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<GroupMaster> grps = null;

		try {

			grps = inventoryService.getGroups(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<GroupMaster>>() {
		}.getType();
		String json = gson.toJson(grps, type);

		return json;
	}

	@Override
	@Path(value = "/getRacks")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getRacks(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<RackMaster> racks = null;

		try {

			racks = inventoryService.getRacks(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<RackMaster>>() {
		}.getType();
		String json = gson.toJson(racks, type);

		return json;
	}

	@Override
	@Path(value = "/getCategories")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getCategories(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<CategoryMaster> cats = null;

		try {

			cats = inventoryService.getCategories(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CategoryMaster>>() {
		}.getType();
		String json = gson.toJson(cats, type);

		return json;
	}

	@Override
	@Path(value = "/getSubCategories")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getSubCategories(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<SubCategoryMaster> subcats = null;

		try {

			subcats = inventoryService.getSubCategories(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<SubCategoryMaster>>() {
		}.getType();
		String json = gson.toJson(subcats, type);

		return json;
	}

	@Override
	@Path(value = "/getManufacturers")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getManufacturers(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<ManufacturerMaster> manufcturers = null;

		try {

			manufcturers = inventoryService.getManufacturers(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ManufacturerMaster>>() {
		}.getType();
		String json = gson.toJson(manufcturers, type);

		return json;
	}

	@Override
	@Path(value = "/getUnits")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getUnits(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "lang") String lang) {
		List<UnitMaster> units = null;

		try {

			units = inventoryService.getUnits(cmpnyId);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<UnitMaster>>() {
		}.getType();
		String json = gson.toJson(units, type);

		return json;
	}

	@Override
	@Path(value = "/getBrand")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getBrand(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		BrandMaster brand = null;

		try {

			brand = inventoryService.getBrand(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(brand, BrandMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getDoctor")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getDoctor(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		DoctorMaster doc = null;

		try {

			doc = inventoryService.getDoctor(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(doc, DoctorMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getCustomer")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustomer(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		CustomerMaster cust = null;

		try {

			cust = inventoryService.getCustomer(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(cust, CustomerMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getItemDetails")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getItemDetails(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		ItemMaster item = null;

		try {

			item = inventoryService.getItemDetails(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(item, ItemMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getDistributor")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getDistributor(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		DistributorMaster dist = null;

		try {

			dist = inventoryService.getDistributor(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(dist, DistributorMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getContent")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getContent(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		ContentMaster cntnt = null;

		try {

			cntnt = inventoryService.getContent(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(cntnt, BrandMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getSchedule")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getSchedule(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		ScheduleMaster schdl = null;

		try {

			schdl = inventoryService.getSchedule(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(schdl, ScheduleMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getGroup")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getGroup(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		GroupMaster grp = null;

		try {

			grp = inventoryService.getGroup(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(grp, GroupMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getRack")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getRack(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		RackMaster rack = null;

		try {

			rack = inventoryService.getRack(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(rack, RackMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getUnit")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getUnit(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		UnitMaster unit = null;

		try {

			unit = inventoryService.getUnit(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(unit, UnitMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getManufacturer")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getManufacturer(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		ManufacturerMaster manufacturerMaster = null;

		try {

			manufacturerMaster = inventoryService.getManufacturer(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(manufacturerMaster, ManufacturerMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getCategory")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getCategory(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		CategoryMaster cat = null;

		try {

			cat = inventoryService.getCategory(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(cat, CategoryMaster.class);

		return json;
	}

	@Override
	@Path(value = "/getSubCategory")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String getSubCategory(@QueryParam(value = "id") String id,
			@QueryParam(value = "lang") String lang) {
		SubCategoryMaster sub = null;

		try {

			/*
			  OpeningStock openingStock=new OpeningStock();
			 List<OpeningStockDetails> openingStockDetails =new  ArrayList<OpeningStockDetails>(); OpeningStockDetails details=new
			  OpeningStockDetails(); details.setId(1);
			 details.setBatchNo("AHXP"); details.setFinyrId(27);
			 details.setMrp(200.00); 
			 details.setExpiryDate(new Date());
			 openingStockDetails.add(details);
			 openingStock.setOpeningStockDetails(openingStockDetails);
		 
			 Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() .create();
			String jsonStock = gson.toJson(openingStock, OpeningStock.class);*/
			 

			sub = inventoryService.getSubCategory(id);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(sub, SubCategoryMaster.class);

		return json;
	}

	@Override
	@Path(value = "/searchBrand")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchBrand(BrandMaster brand) {

		List<BrandMaster> brands = null;
		String result = "";
		try {
			brands = inventoryService.searchBrand(brand);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<BrandMaster>>() {
			}.getType();
			result = gson.toJson(brands, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchUnit")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchUnit(UnitMaster unit) {

		List<UnitMaster> units = null;
		String result = "";
		try {
			units = inventoryService.searchUnit(unit);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<UnitMaster>>() {
			}.getType();
			result = gson.toJson(units, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchBrandAutoCom")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchBrandAutoCom(BrandMaster brand) {

		List<CommonResultSetMapper> brands = null;
		String result = "";
		try {
			brands = inventoryService.searchBrandAutoCom(brand);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(brands, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchManuAutoCom")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchManuAutoCom(ManufacturerMaster manu) {

		List<CommonResultSetMapper> manus = null;
		String result = "";
		try {
			manus = inventoryService.searchManuAutoCom(manu);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(manus, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchContentAutoCom")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchContentAutoCom(ContentMaster cntnt) {

		List<CommonResultSetMapper> cntnts = null;
		String result = "";
		try {
			cntnts = inventoryService.searchContentAutoCom(cntnt);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
			}.getType();
			result = gson.toJson(cntnts, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchContent(ContentMaster content) {

		List<ContentMaster> cntnts = null;
		String result = "";
		try {
			cntnts = inventoryService.searchContent(content);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<BrandMaster>>() {
			}.getType();
			result = gson.toJson(cntnts, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/searchManufacturer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String searchManufacturer(ManufacturerMaster manufacturerMaster) {

		List<ManufacturerMaster> manu = null;
		String result = "";
		try {
			manu = inventoryService.searchManufacturer(manufacturerMaster);
			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<ManufacturerMaster>>() {
			}.getType();
			result = gson.toJson(manu, type);

		} catch (ServiceException x) {
			result = x.getMessage();
		}

		return result;
	}

	@Override
	@Path(value = "/getCurrentStockItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCurrentStockItem(CommonResultSetMapper mapper) {
		List<ItemCurrentStockDTO> stock = null;
		String result = "";
		try {

			stock = inventoryService.getCurrentStockItem(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemCurrentStockDTO>>() {
		}.getType();
		result = gson.toJson(stock, type);

		return result;
	}
	
	
	@Path(value = "/getCustomerById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustomerById(CommonResultSetMapper mapper) {
		CustomerDTO cust = null;
		
		try {

			cust = inventoryService.getCustomerById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(cust, CustomerDTO.class);

		return json;
	}
	
	@Path(value = "/getDistributorById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getDistributorById(CommonResultSetMapper mapper) {
		DistributorDTO dist = null;
		
		try {

			dist = inventoryService.getDistributorById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(dist, DistributorDTO.class);

		return json;
	}
	
	@Path(value = "/getDistributorsAll")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getDistributorsAll(CommonResultSetMapper mapper) {
		List<DistributorMaster> dist = null;
		long st=System.currentTimeMillis();
		String result = "";
		try {

			dist = inventoryService.getDistributorsAll(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DistributorMaster>>() {
		}.getType();
		result = gson.toJson(dist, type);
		long et=System.currentTimeMillis();
		System.out.println("time diff in getDistributorsAll:"+(et-st));
		return result;
	}
	
	@Path(value = "/getDistributorsAllWithOutstanding")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getDistributorsAllWithOutstanding(CommonResultSetMapper mapper) {
		List<DistributorDTO> dist = null;
		String result = "";
		try {

			dist = inventoryService.getDistributorsAllWithOutstanding(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<DistributorDTO>>() {
		}.getType();
		result = gson.toJson(dist, type);

		return result;
	}
	
	@Path(value = "/getCustomersAll_old") //this was /getCustomersAll 
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustomersAll(CommonResultSetMapper mapper) {
		List<CustomerDTO> custs = null;
		String result = "";
		try {

			custs = inventoryService.getCustomersAll(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CustomerDTO>>() {
		}.getType();
		result = gson.toJson(custs, type);

		return result;
	}
	
	
	@Path(value = "/getCurrentStockItemBySku")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCurrentStockItemBySku(CommonResultSetMapper mapper) {
		List<ItemCurrentStockDTO> stock = null;
		String result = "";
		try {

			stock = inventoryService.getCurrentStockItemBySku(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemCurrentStockDTO>>() {
		}.getType();
		result = gson.toJson(stock, type);

		return result;
	}
	
	@Override
	@Path(value = "/getCurrentStockItemAtSale")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCurrentStockItemAtSale(CommonResultSetMapper mapper) {
		List<ItemCurrentStockDTO> stock = null;
		String result = "";
		try {

			stock = inventoryService.getCurrentStockItemAtSale(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemCurrentStockDTO>>() {
		}.getType();
		result = gson.toJson(stock, type);

		return result;
	}
	
	
	@Path(value = "/getStockDetailsForAdjustment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getStockDetailsForAdjustment(CommonResultSetMapper mapper) {
		List<StockDetailsAdjustmentDTO> stock = null;
		String result = "";
		try {

			stock = inventoryService.getStockDetailsForAdjustment(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<StockDetailsAdjustmentDTO>>() {
		}.getType();
		result = gson.toJson(stock, type);

		return result;
	}
	
	@Override
	@Path(value = "/getAllExpiryDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllExpiryDetails(CommonResultSetMapper mapper) {
		List<ExpiryDTO> expDetails = null;
		//System.out.println("getAllExpiryDetails mapper = "+mapper);
		String result = "";
		try {

			expDetails = inventoryService.getAllExpiryDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ExpiryDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/getExpiryHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getExpiryHeaderById(CommonResultSetMapper mapper) {
		ExpiryDTO expHeader = null;
		
		try {

			expHeader = inventoryService.getExpiryHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(expHeader, ExpiryDTO.class);

		return json;
	}
	
	@Override
	@Path(value = "/getExpiryDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getExpiryDetailsById(CommonResultSetMapper mapper) {
		List<ExpiryDetailsDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getExpiryDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ExpiryDetailsDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/getAllPendingExpiryItems")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllPendingExpiryItems(CommonResultSetMapper mapper) {
		List<ExpiryDetailsDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getAllPendingExpiryItems(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ExpiryDetailsDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/getExpiryForAdjustment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getExpiryForAdjustment(CommonResultSetMapper mapper) {
		List<ExpiryDetailsDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getExpiryForAdjustment(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ExpiryDetailsDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/getExpiryForAdjustmentByPurchase")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getExpiryForAdjustmentByPurchase(CommonResultSetMapper mapper) {
		List<ExpiryDetailsDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getExpiryForAdjustmentByPurchase(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ExpiryDetailsDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/createOrUpdateExpiryInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateExpiryInvoice(Expiry expiry) {
		System.out.println("createOrUpdateExpiryInvoice expiry = "+expiry);
		String status = "";
		try {
			status = inventoryService.createOrUpdateExpiryInvoice(expiry);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/deleteExpiry")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteExpiry(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = inventoryService.deleteExpiry(mapper);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/postExpiry")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String postExpiry(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = inventoryService.postExpiry(mapper);

		} catch (Exception x) {
			status = ReturnConstant.FAILURE;
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/getAllItemSearchByContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllItemSearchByContent(CommonResultSetMapper mapper) {
		List<ItemSearchByContentDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getAllItemSearchByContent(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemSearchByContentDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}
	
	@Override
	@Path(value = "/getAllItemStockSearchByContent")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllItemStockSearchByContent(CommonResultSetMapper mapper) {
		List<ItemSearchByContentDTO> expDetails = null;
		String result = "";
		try {

			expDetails = inventoryService.getAllItemStockSearchByContent(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemSearchByContentDTO>>() {
		}.getType();
		result = gson.toJson(expDetails, type);

		return result;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "/uploadStock")
	public String uploadStock(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition cdh,
			@FormDataParam("commonResultSetMapper") CommonResultSetMapper commonResultSetMapper) {

		String status = "";
		try {
			status=inventoryService.uploadStock(fileInputStream,commonResultSetMapper);

		} catch (Exception ex) {
			status = "0";
		}
		return status;
	}

	@Override
	@Path(value = "/uploadStockManual")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String uploadStockManual(OpeningStock openingStock) {
		String status = "";
		try {
			status = inventoryService.uploadStockManual(openingStock);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/getAllTaxByName")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllTaxByName(CommonResultSetMapper mapper) {
		List<TaxDTO> tax = null;

		try {

			tax = inventoryService.getAllTaxByName(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<TaxDTO>>() {
		}.getType();
		String json = gson.toJson(tax, type);

		return json;
	}
	
	@Override
	@Path(value = "/getAllTax")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllTax(CommonResultSetMapper mapper) {
		List<TaxDTO> tax = null;

		try {

			tax = inventoryService.getAllTax(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<TaxDTO>>() {
		}.getType();
		String json = gson.toJson(tax, type);

		return json;
	}
	
	@Override
	@Path(value = "/getTaxDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getTaxDetailsById(CommonResultSetMapper mapper) {
		List<TaxDTO> taxes = null;
		String result="";
		try {

			taxes = inventoryService.getTaxDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<TaxDTO>>() {
		}.getType();
		result = gson.toJson(taxes, type);
		return result;
	}
	
	
	@Path(value = "/getTaxById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getTaxById(CommonResultSetMapper mapper) {
		TaxDTO tax = null;

		try {

			tax = inventoryService.getTaxById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(tax, TaxDTO.class);

		return json;
	}
	
	@Override
	@Path(value = "/createTax")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createTax(TaxMaster taxMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createTax(taxMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	
	@Path(value = "/insertCustomer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String insertCustomer(CustomerMaster customerMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.insertCustomer(customerMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/insertDistributor")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String insertDistributor(DistributorMaster distributorMaster) {
		ResponseObj responseObj = new ResponseObj();
		//System.out.println("insertDistributor distributorMaster = "+distributorMaster);
		try {
			responseObj = inventoryService.insertDistributor(distributorMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/updateCustomerByProc")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateCustomerByProc(CustomerMaster customerMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateCustomerByProc(customerMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not updated successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/updateDistributorByProc")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateDistributorByProc(DistributorMaster distributorMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateDistributorByProc(distributorMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not updated successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/deleteTax")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteTax(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();;
		try {
			responseObj = inventoryService.deleteTax(mapper);

		} catch (Exception x) {
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
			x.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	@Override
	@Path(value = "/updateTax")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateTax(TaxMaster taxMaster) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateTax(taxMaster);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	
	@Path(value = "/updateStockAdj")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateStockAdj(StockDetailsAdjustmentDTO mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateStockAdj(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/deleteStockAdj")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteStockAdj(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.deleteStockAdj(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/getItemHistory")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getItemHistory(CommonResultSetMapper mapper) {
		List<ItemHistoryDTO> hist = null;
		long startTime = System.currentTimeMillis();
		try {

			hist = inventoryService.getItemHistory(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ItemHistoryDTO>>() {
		}.getType();
		String json = gson.toJson(hist, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}
	
	
	@Override
	@Path(value = "/getItemByBarcode")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getItemByBarcode(CommonResultSetMapper mapper) {
		CommonResultSetMapper commonResultSetMapper = null;
		long startTime = System.currentTimeMillis();
		try {

			commonResultSetMapper = inventoryService.getItemByBarcode(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(commonResultSetMapper, CommonResultSetMapper.class);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}
	
	
	@Path(value = "/getItemByName")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getItemByName(CommonResultSetMapper mapper) {
		ItemDTO itemDTO = null;
		long startTime = System.currentTimeMillis();
		try {

			itemDTO = inventoryService.getItemByName(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(itemDTO, ItemDTO.class);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return json;
	}
	
	@Path(value = "/getReasonByReturnType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getReasonByReturnType(CommonResultSetMapper mapper) {
		List<ReturnReasonTypeDTO> types = null;
		
		try {

			types = inventoryService.getReasonByReturnType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ReturnReasonTypeDTO>>() {
		}.getType();
		String json = gson.toJson(types, type);
	
		return json;
	}
	
	@Path(value = "/report/inventory/stock")
	@GET
	public void getStockReportByDate(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "manuId") String manuId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "schId") String schId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "asOnDate") String asOnDate,
			@QueryParam(value = "noOfExpiryMonth") String noOfExpiryMonth,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateason=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date asOnDate1= DateUtil.convertStringDateToSqlDate(convertdDateason, DATE_FORMAT_NEEDED);
			 
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_manufacturerID", Integer.parseInt(manuId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_scheduleID", Integer.parseInt(schId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_asOnDate", asOnDate1);
			parameters.put("W_noOfExpiryMonth", Integer.parseInt(noOfExpiryMonth));
			fileName = "pharmacy_stock.pdf";
			jasperFile = "pharmacy_stock.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/inventory/stockOnValue")
	@GET
	public void getStockOnValueReportByDate(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "manuId") String manuId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "asOnDate") String asOnDate,
			@QueryParam(value = "noOfExpiryMonth") String noOfExpiryMonth,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateason=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date asOnDate1= DateUtil.convertStringDateToSqlDate(convertdDateason, DATE_FORMAT_NEEDED);
			
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_manufacturerID", Integer.parseInt(manuId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_asOnDate", asOnDate1);
			parameters.put("W_noOfExpiryMonth", Integer.parseInt(noOfExpiryMonth));
			fileName = "pharmacy_stock_on_value_details.pdf";
			jasperFile = "pharmacy_stock_on_value_details.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/inventory/stockOnValueGrp")
	@GET
	public void getStockOnValueGrpReportByDate(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "manuId") String manuId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "asOnDate") String asOnDate,
			@QueryParam(value = "noOfExpiryMonth") String noOfExpiryMonth,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateason=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager ///
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date asOnDate1= DateUtil.convertStringDateToSqlDate(convertdDateason, DATE_FORMAT_NEEDED);
			 
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_manufacturerID", Integer.parseInt(manuId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_asOnDate", asOnDate1);
			parameters.put("W_noOfExpiryMonth", Integer.parseInt(noOfExpiryMonth));
			fileName = "pharmacy_stock_on_value_group.pdf";
			jasperFile = "pharmacy_stock_on_value_group.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/item/dormant")
	@GET
	public void getDormantItemReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "asOnDate") String asOnDate,
			@QueryParam(value = "noOfMonth") String noOfMonth,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateason=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			java.sql.Date asOnDate1= DateUtil.convertStringDateToSqlDate(convertdDateason, DATE_FORMAT_NEEDED);
			 
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_asOnDate", asOnDate1);
			parameters.put("W_noOfMonth", Integer.parseInt(noOfMonth));
			fileName = "item_not_sale_report.pdf";
			jasperFile = "item_not_sale_report.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/expiry")
	@GET
	public void getExpiryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "asOnDate") String asOnDate,
			@QueryParam(value = "noOfExpiryMonth") String noOfExpiryMonth,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "rackId") String rackId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			if(!asOnDate.equalsIgnoreCase("null")){
			String convertdDateason=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
			java.sql.Date asOnDate1= DateUtil.convertStringDateToSqlDate(convertdDateason, DATE_FORMAT_NEEDED);
			parameters.put("W_asOnDate", asOnDate1);
			}
			else {
				
				parameters.put("W_asOnDate", null);
			}
			parameters.put("W_noOfExpiryMonth", Integer.parseInt(noOfExpiryMonth));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_rackID", Integer.parseInt(rackId));
			fileName = "pharmacy_expiry.pdf";
			jasperFile = "pharmacy_expiry.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/expiryissue/distributor")
	@GET
	public void getExpiryIssueDistributorWiseReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distId") String distId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_distributorID", Integer.parseInt(distId));
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			
			fileName = "distributor_wise_expiry_issue.pdf";
			jasperFile = "distributor_wise_expiry_issue.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/ledger/distributor")
	@GET
	public void getDistributorLedgerReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distId") String distId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "status") String status,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distId));
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			parameters.put("W_status", status);
			fileName = "distributor_ledger_report.pdf";
			jasperFile = "distributor_ledger_report.jrxml";

			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Path(value = "/report/taxwise/summary")
	@GET
	public void getTaxWiseSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			
			fileName = "tax_wise_summary_report";
			jasperFile = "tax_wise_summary_report.jrxml";

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/taxslabwise/summary")
	@GET
	public void getTaxSlabWiseSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		StoreDAO sDao = new StoreDAOImpl();
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		try {
			StoreMaster sMaster = sDao.getStoreDetails(storeId);
			
			
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			
			if(sMaster.getIsExclusive()==1)
			{
				System.out.println("tax slab report");
				fileName = "tax_slab_wise_summary_report";
				jasperFile = "tax_slab_wise_summary_report.jrxml";
			}
			else if(sMaster.getIsExclusive()==0)
			{
				System.out.println("tax slab report composite");
				fileName = "tax_slab_wise_summary_composite_report";
				jasperFile = "tax_slab_wise_summary_composite_report.jrxml";
			}
			

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/vendorwisestock")
	@GET
	public void getVendorwisestockReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "distributorId") String distributorId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		System.out.println("/report/vendorwisestock");
//		StoreDAO sDao = new StoreDAOImpl();
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		ServletOutputStream os = null;
		try {
//			StoreMaster sMaster = sDao.getStoreDetails(storeId);
			
			
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			
			fileName = "distributor_wise_stock.pdf";
			jasperFile = "distributor_wise_stock.jrxml";
			
			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			os = response.getOutputStream();
			os.write(array);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//26.12.2019
	@Path(value = "/report/manufacturerwisestock")
	@GET
	public void getManufacturerwisestockReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "manufacturerId") String manufacturerId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
//		StoreDAO sDao = new StoreDAOImpl();
		
		String fileName = null;
		Connection connection = null;
		
		EntityManager em = null;
		String jasperFile = null;
		ServletOutputStream os = null;
		try {
//			StoreMaster sMaster = sDao.getStoreDetails(storeId);
			
			
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			
			//entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_manufacturerID", Integer.parseInt(manufacturerId));
			
			if(!startDate.equalsIgnoreCase("null")){
			String convertdDateStart=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			java.sql.Date startDate1= DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
			parameters.put("W_startDate", startDate1);
			}
			else {
				
				parameters.put("W_startDate", null);
			}
			
			if(!endDate.equalsIgnoreCase("null")){
				String convertdDateend=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				java.sql.Date endDate1= DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
				}
				else {
					
					parameters.put("W_endDate", null);
				}
			
			fileName = "manufacturer_wise_stock.pdf";
			jasperFile = "manufacturer_wise_stock.jrxml";
			
			// call method to generate pdf
			generatePDF(request, response, fileName, parameters,
					connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/inventory/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			os = response.getOutputStream();
			os.write(array);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//15.02.2018
	@Override
	@Path(value = "/createAccountGroup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createAccountGroup(AccountGroupDTO accountGroupDTO) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createAccountGroup(accountGroupDTO);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		//System.out.println("createAccountGroup = "+json);
		return json;
	}
	
	@Path(value = "/updateAccountGroup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateAccountGroup(AccountGroupDTO accountGroupDTO) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateAccountGroup(accountGroupDTO);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/getAllAccountGroup")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllAccountGroup(CommonResultSetMapper mapper) {
		System.out.println("Mapper = "+mapper);
		List<AccountGroupDTO> list = null;
		
		try {

			list = inventoryService.getAllAccountGroup(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountGroupDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);

		return json;
	}
	
	@Path(value = "/getAllAccountType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllAccountType(CommonResultSetMapper mapper) {
		List<AccountTypeDTO> list = null;

		try {

			list = inventoryService.getAllAccountType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountTypeDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);

		return json;
	}
	
	@Path(value = "/getAccountTransType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAccountTransType(CommonResultSetMapper mapper) {
		List<AccountTransTypeDTO> list = null;

		try {

			list = inventoryService.getAccountTransType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountTransTypeDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);

		return json;
	}
	
	@Path(value = "/deleteAccountGroup")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteAccountGroup(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.deleteAccountGroup(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj
					.setReason("deleteAccountGroup not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	//15.02.2018
	
	//16.02.2018
	@Path(value = "/createAccount")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createAccount(AccountMaster master) {
		System.out.println("Create acc master = "+ master);
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createAccount(master);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		//System.out.println("return Create acc master = "+json);
		return json;
	}
	
	@Path(value = "/getAllAccounts")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllAccounts(CommonResultSetMapper mapper) {
		List<AccountDTO> accnts = null;
		System.out.println("getAllAccounts mapper = "+mapper);
		try {

			accnts = inventoryService.getAllAccounts(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
		}.getType();
		String json = gson.toJson(accnts, type);

		return json;
	}
	
	@Path(value = "/createArea")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createArea(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createArea(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/updateArea")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateArea(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateArea(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/deleteArea")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteArea(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.deleteArea(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/getAreaById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAreaById(CommonResultSetMapper mapper) {
		AreaDTO area = null;

		try {

			area = inventoryService.getAreaById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(area, AreaDTO.class);

		return json;
	}
	
	@Path(value = "/getAreaByNameList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAreaByNameList(CommonResultSetMapper mapper) {
		List<AreaDTO> area = null;
		String result = "";
		try {

			area = inventoryService.getAreaByNameList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AreaDTO>>() {
		}.getType();
		result = gson.toJson(area, type);

		return result;
	}
	
	
	@Path(value = "/tset")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String testing() {
		AccountGroupDTO aGroupDTO = new AccountGroupDTO();
		aGroupDTO.setId(12);
		aGroupDTO.setName("Test");
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(aGroupDTO, AccountGroupDTO.class);
		
		//System.out.println("test :: hit");

		return json;
	}
	
	@Override
	@Path(value = "/getCountryList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCountryList(CommonResultSetMapper mapper) {
		List<CountryMaster> countryMasters = null;
		String result = "";
		long startTime = System.currentTimeMillis();
		try {

			countryMasters = inventoryService.getCountryList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CountryMaster>>() {
		}.getType();
		result = gson.toJson(countryMasters, type);
		long endTime = System.currentTimeMillis();
		//System.out.println("time diff in WS:: " + (endTime - startTime));
		return result;
	}
	
	@Path(value = "/getStateByCountryList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getStateByCountryList(CommonResultSetMapper mapper) {
		System.out.println("COntroller /getStateByCountryList mapper = "+mapper);
		List<StateDTO> states = null;
		String result = "";
		try {

			states = inventoryService.getStateByCountryList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<StateDTO>>() {
		}.getType();
		result = gson.toJson(states, type);

		return result;
	}
	
	@Path(value = "/getCityByStateList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCityByStateList(CommonResultSetMapper mapper) {
		List<CityDTO> cities = null;
		String result = "";
		try {

			cities = inventoryService.getCityByStateList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CityDTO>>() {
		}.getType();
		result = gson.toJson(cities, type);

		return result;
	}

	@Path(value = "/getCityByNameList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCityByNameList(CommonResultSetMapper mapper) {
		List<CityDTO> cities = null;
		String result = "";
		try {

			cities = inventoryService.getCityByNameList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<CityDTO>>() {
		}.getType();
		result = gson.toJson(cities, type);

		return result;
	}

	@Path(value = "/getZoneByCityList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getZoneByCityList(CommonResultSetMapper mapper) {
		List<ZoneDTO> zone = null;
		String result = "";
		try {

			zone = inventoryService.getZoneByCityList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ZoneDTO>>() {
		}.getType();
		result = gson.toJson(zone, type);

		return result;
	}

	@Path(value = "/getZoneByNameList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getZoneByNameList(CommonResultSetMapper mapper) {
		List<ZoneDTO> zone = null;
		String result = "";
		try {

			zone = inventoryService.getZoneByNameList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ZoneDTO>>() {
		}.getType();
		result = gson.toJson(zone, type);

		return result;
	}

	@Path(value = "/getAreaByZoneList")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAreaByZoneList(CommonResultSetMapper mapper) {
		List<AreaDTO> area = null;
		String result = "";
		try {

			area = inventoryService.getAreaByZoneList(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AreaDTO>>() {
		}.getType();
		result = gson.toJson(area, type);

		return result;
	}

	@Path(value = "/createCity")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createCity(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createCity(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/createZone")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createZone(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.createZone(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/updateCity")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateCity(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateCity(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/updateZone")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateZone(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.updateZone(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/deleteCity")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteCity(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.deleteCity(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/deleteZone")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String deleteZone(CommonResultSetMapper commonResultSetMapper) {
		// String status = "";
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = inventoryService.deleteZone(commonResultSetMapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	
	
	//16.02.2018
	
	
	//19.02.2018
	@Path(value = "/getAccountsByName")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody String getAccountsByName(@RequestBody CommonResultSetMapper mapper) {
		List<AccountDTO> accnts = null;
		System.out.println("getAccountsByName mapper = "+mapper);
		try {

			accnts = inventoryService.getAccountsByName(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
		}.getType();
		String json = gson.toJson(accnts, type);

		return json;
	}
	
	@Path(value = "/getDuplicateAccounts")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody String getDuplicateAccounts(@RequestBody CommonResultSetMapper mapper) {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		//System.out.println("getDuplicateAccounts mapper = "+mapper);
		try {

			responseObj = inventoryService.getDuplicateAccounts(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		/*java.lang.reflect.Type type = new TypeToken<List<ResponseObj>>() {
		}.getType();*/
		String json = gson.toJson(responseObj, ResponseObj.class);

		return json;
	}
	
	@Path(value = "/deleteAccounts")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody String deleteAccounts(@RequestBody CommonResultSetMapper mapper) {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		//System.out.println("delete accounts mapper = "+mapper);
		try {

			responseObj = inventoryService.deleteAccounts(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		/*java.lang.reflect.Type type = new TypeToken<List<ResponseObj>>() {
		}.getType();*/
		String json = gson.toJson(responseObj, ResponseObj.class);

		return json;
	}
	
	@Path(value = "/updateAccounts")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody String updateAccounts(@RequestBody AccountMaster accountMaster) {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		//System.out.println("update accounts mapper = "+accountMaster);
		try {

			responseObj = inventoryService.updateAccounts(accountMaster);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		/*java.lang.reflect.Type type = new TypeToken<List<ResponseObj>>() {
		}.getType();*/
		String json = gson.toJson(responseObj, ResponseObj.class);
		//System.out.println("returning status");
		return json;
	}
	
	//19.02.2018
	
	//21.02.2018
	@Path(value = "/getAccountsAutocomplete")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public @ResponseBody String getAccountsAutocomplete(@RequestBody CommonResultSetMapper mapper) {
		List<AccountDTO> accnts = null;
		//ResponseObj responseObj = null;
		//System.out.println("getAccountsAutocomplete mapper = "+mapper);
		try {

			accnts = inventoryService.getAccountsAutocomplete(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
		}.getType();
		String json = gson.toJson(accnts, type);
		//System.out.println("returning status");
		return json;
	}
	
	//21.02.2018
	
	//22.02.2018
	@Path(value = "/addJournal")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addJournal(JournalListDTO journallistDTO) {
		// String status = "";
		//System.out.println("add journal = "+journallistDTO);
		ResponseObj responseObj = new ResponseObj();
//		String responseObj="";
		String stat = "";
		try {
			stat = inventoryService.addJournal(journallistDTO);
			if(!stat.equals("0"))
			{
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(Integer.parseInt(stat));
				responseObj.setReason("Journal added successfully");
			}

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not added successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
		
		//return responseObj;
	}
	
	
	@Path(value = "/deleteJournal")
	@POST
	/*@Consumes("application/json")
	@Produces("application/json")*/
	public @ResponseBody String deleteJournal(@RequestBody CommonResultSetMapper mapper) {
		//List<AccountDTO> accnts = null;
		ResponseObj responseObj = null;
		//System.out.println("delete journal mapper = "+mapper);
		try {

			responseObj = inventoryService.deleteJournal(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		/*java.lang.reflect.Type type = new TypeToken<List<ResponseObj>>() {
		}.getType();*/
		String json = gson.toJson(responseObj, ResponseObj.class);

		return json;
	}
	
	//22.02.2018
	@Path(value = "/getJournalTypeByQS")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public @ResponseBody String getJournalTypeByQS(@RequestBody CommonResultSetMapper mapper) {
		List<ParaJournalTypeMaster> pjtms = null;
		//ResponseObj responseObj = null;
		//System.out.println("getJournalTypeByQS mapper = "+mapper);
		try {

			pjtms = inventoryService.getJournalTypeByQS(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<ParaJournalTypeMaster>>() {
		}.getType();
		String json = gson.toJson(pjtms, type);
		//System.out.println("returning status");
		return json;
	}
	
	@Path(value = "/getAllJournalByType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public @ResponseBody String getAllJournalByType(@RequestBody CommonResultSetMapper mapper) {
		List<JournalDTO> journals = null;
		//ResponseObj responseObj = null;
		//System.out.println("getAllJournalByType mapper = "+mapper);
		try {

			journals = inventoryService.getAllJournalByType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<JournalDTO>>() {
		}.getType();
		String json = gson.toJson(journals, type);
		//System.out.println("returning status");
		return json;
	}
	//22.02.2018
	
	//26.02.2018
	@Path(value = "/getJournalById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public @ResponseBody String getJournalById(@RequestBody CommonResultSetMapper mapper) {
		List<JournalListDTO> journals = null;
		//ResponseObj responseObj = null;
		//System.out.println("getJournalById mapper = "+mapper);
		try {

			journals = inventoryService.getJournalById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		/*java.lang.reflect.Type type = new TypeToken<List<JournalListDTO>>() {
		}.getType();*/
		String json = gson.toJson(journals.get(0), JournalListDTO.class);
		//System.out.println("returning status");
		return json;
	}
	
	@Path(value = "/updateJournal")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateJournal(JournalListDTO journallistDTO) {
		// String status = "";
		//System.out.println("update journal = "+journallistDTO);
		ResponseObj responseObj = new ResponseObj();
		//String responseObj="";
		//ResponseObj responseObj = new ResponseObj();
		String stat = "";
		try {
			stat = inventoryService.addJournal(journallistDTO);
			if(!stat.equals("0"))
			{
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(Integer.parseInt(stat));
				responseObj.setReason("Journal updated successfully");
			}

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not updated successfully.");
		}
		//System.out.println("update journal status = "+responseObj);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
		
//		return responseObj;
	}
	//26.02.2018
	
	@Path(value = "/getLedgerDetailsByCode")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getLedgerDetailsByCode(CommonResultSetMapper mapper) {
		//System.out.println("getLedgerDetailsByCode Mapper = "+mapper);
		List<AccountDTO> list = null;
		
		try {

			list = inventoryService.getLedgerDetailsByCode(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	//13.03.2018
		@Path(value = "/getAccountsAutocompleteByCashBank")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public @ResponseBody String getAccountsAutocompleteByCashBank(@RequestBody CommonResultSetMapper mapper) {
			List<AccountDTO> accnts = null;
			//ResponseObj responseObj = null;
			//System.out.println("getAccountsAutocompleteByCashBank mapper = "+mapper);
			try {

				accnts = inventoryService.getAccountsAutocompleteByCashBank(mapper);

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
			}.getType();
			String json = gson.toJson(accnts, type);
			//System.out.println("returning status");
			return json;
		}
		
		//14.03.2018
		@Path(value = "/getChartOfAccount")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public @ResponseBody String getChartOfAccount(@RequestBody CommonResultSetMapper mapper) {
			List<ChartOfAccountDTO> accnts = null;
			//ResponseObj responseObj = null;
			//CommonResultSetMapper mapper = new CommonResultSetMapper(); 
			//System.out.println("getChartOfAccount mapper = "+mapper);
			try {

				accnts = inventoryService.getChartOfAccount(mapper);

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			java.lang.reflect.Type type = new TypeToken<List<ChartOfAccountDTO>>() {
			}.getType();
			String json = gson.toJson(accnts, type);
			//System.out.println("returning status");
			return json;
		}
		
		//16.03.2018
		@Path(value = "/getAccountsAutocompleteByGroup")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public @ResponseBody String getAccountsAutocompleteByGroup(@RequestBody CommonResultSetMapper mapper) {
			List<AccountDTO> accnts = null;
			//ResponseObj responseObj = null;
			//System.out.println("getAccountsAutocompleteByGroup mapper = "+mapper);
			try {

				accnts = inventoryService.getAccountsAutocompleteByGroup(mapper);

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
			}.getType();
			String json = gson.toJson(accnts, type);
			//System.out.println("returning status");
			return json;
		}
		
		//23.03.2018
		@Path(value = "/getCustomersAll")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public String getCustomersAllByName(CommonResultSetMapper mapper) {
			//System.out.println("getCustomersAll mapper = "+mapper);
			List<CustomerDTO> custs = null;
			String result = "";
			try {

				custs = inventoryService.getCustomersAllByName(mapper); //for new war
				
				//custs = inventoryService.getCustomersAll(mapper); //for old war

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			java.lang.reflect.Type type = new TypeToken<List<CustomerDTO>>() {
			}.getType();
			result = gson.toJson(custs, type);

			return result;
		}
		
		
		
		@Path(value = "/opStockTransferforYearEnd")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public String opStockTransferforYearEnd(CommonResultSetMapper mapper) {
			// String status = "";
			System.out.println("opStockTransferforYearEnd mapper = "+mapper);
			ResponseObj responseObj = new ResponseObj();
			//String responseObj="";
			//ResponseObj responseObj = new ResponseObj();
			int stat = 0;
			try {
				stat = inventoryService.opStockTransferforYearEnd(mapper);
				if(stat!=0)
				{
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(stat);
					responseObj.setReason("opStockTransferforYearEnd done successfully");
				}
				else
				{
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(stat);
					responseObj.setReason("opStockTransferforYearEnd not done successfully");
				}

			} catch (Exception x) {
				x.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("opStockTransferforYearEnd not done successfully.");
			}
			System.out.println("opStockTransferforYearEnd status = "+responseObj);

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			String json = gson.toJson(responseObj, ResponseObj.class);
			return json;
			
//			return responseObj;
		}
		
		
		/*//19.03.2018
		@Path(value = "/getAccountsAutocompleteByGroup")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public @ResponseBody String getAccountsAutocompleteByGroup(@RequestBody CommonResultSetMapper mapper) {
			List<AccountDTO> accnts = null;
			//ResponseObj responseObj = null;
			System.out.println("getAccountsAutocompleteByGroup mapper = "+mapper);
			try {

				accnts = inventoryService.getAccountsAutocompleteByGroup(mapper);

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			java.lang.reflect.Type type = new TypeToken<List<AccountDTO>>() {
			}.getType();
			String json = gson.toJson(accnts, type);
			//System.out.println("returning status");
			return json;
		}*/
	
	// method to generate pdf
		public void generatePDF(HttpServletRequest request,
				HttpServletResponse response, String fileName,
				Map<String, Object> parameters, Connection connection,
				String jasperFile) throws FileNotFoundException, IOException {
			

			try {

				File file = new File(request.getRealPath("/") + "/jasper/inventory/"
						+ fileName);

				JasperReport report;

				report = JasperCompileManager.compileReport(request
						.getRealPath("/jasper") + "/inventory/" + jasperFile);
				JasperPrint print = JasperFillManager.fillReport(report,
						parameters, connection);
				//JasperExportManager.exportreportto
				JasperExportManager.exportReportToPdfFile(print,
						request.getRealPath("/") + "/jasper/inventory/" + fileName);

			}

			catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

			// Inform JSF that it doesn't need to handle response.
			// This is very important, otherwise you will get the following
			// exception in the logs:
			// java.lang.IllegalStateException: Cannot forward after response has
			// been committed.
			// context.responseComplete();
		}
		
		 public void generateXLSX(HttpServletRequest request,
			      HttpServletResponse response, String fileName,
			      Map<String, Object> parameters, Connection connection,
			      String jasperFile) throws FileNotFoundException, IOException {

			    
			    try {
			      JasperReport report = JasperCompileManager.compileReport(request.getSession().getServletContext().getRealPath("/jasper"+ "/inventory/" + jasperFile));
			      JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);
			      
			      File xlsxFile = new File(request.getSession().getServletContext().getRealPath("/" + "/jasper/inventory/" + fileName));
			      JRXlsxExporter xlsxExporter = new JRXlsxExporter();
			      
			      xlsxExporter.setExporterInput(new SimpleExporterInput(print));
			      xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxFile));
			      
			      SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration(); 
			      configuration.setDetectCellType(true);
			      configuration.setCollapseRowSpan(false);
			      xlsxExporter.setConfiguration(configuration);
			      
			      /*xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
			      xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE, xlsxFile);
			      xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);*/
			      
			      xlsxExporter.exportReport(); //File is generated Correctly
			    }
			    catch (JRException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    } finally {

			    }
			  }


}
