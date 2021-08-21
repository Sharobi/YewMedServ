package com.sharobi.pharmacy.commonutil;


/**
 * rajarshi
 */
public class StoredProcedures {

	public static final String PROC_LOGIN_INFO_BY_USER = "{call get_LoginInformation_by_User(?,?,?)}";
	public static final String PROC_MENU_BY_USER = "{call get_menuDetails_userID(?,?,?,?)}"; //old menu
	//public static final String PROC_MENU_BY_USER = "{call get_menu_by_userID(?,?,?,?)}"; //new menu
	public static final String PROC_MENU_DETAILS_BY_USER = "{call get_menu_by_userID(?,?,?,?,?)}";
	public static final String PROC_GET_ALL_BRANDS = "{call get_allBrand_List(?,?,?,?)}";
	public static final String PROC_GET_ALL_REASON_BY_RETURN_TYPE = "{call get_reason_byReturnType(?)}";
	public static final String PROC_CHK_DUPLICATE_ITEM = "{call Get_Duplicate_Item(?,?,?)}";
	public static final String PROC_CREATE_ITEM = "{call In_Create_Item(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_ITEM = "{call In_Update_Item(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_SEARCH_BRAND_AUTO_COMPLETE = "{call get_autoBrand_List(?,?,?)}";
	public static final String PROC_SEARCH_MANU_AUTO_COMPLETE = "{call get_autoManufacturer_List(?,?,?)}";
	public static final String PROC_SEARCH_ITEM = "{call get_allItem_Search(?,?,?,?,?,?,?,?)}";
	public static final String PROC_SEARCH_TRANS_ITEM = "{call get_all_trans_Item_Search(?,?)}";
	public static final String PROC_SEARCH_ITEM_LITE = "{call get_allItem_SearchLite(?,?,?,?,?,?)}";
	public static final String PROC_SEARCH_CONTENT_AUTO_COMPLETE = "{call get_autoContent_List(?,?,?)}";
	public static final String PROC_DELETE_ITEM = "{call In_Delete_item(?,?,?,?)}";
	public static final String PROC_DELETE_CUSTOMER = "{call delete_customer(?,?,?,?)}";
	public static final String PROC_DELETE_DISTRIBUTOR = "{call delete_distributor(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_HEADER = "{call get_Purchase_Header_byID(?)}";
	
	
	public static final String PROC_GET_PURCHASE_RETURN_HEADER_BY_ID = "{call get_PurchaseReturn_Header_byID(?)}";
	public static final String PROC_GET_PURCHASE_PAYMENT_HEADER_BY_ID = "{call get_Payment_Header_byID(?)}";
	public static final String PROC_GET_PURCHASE_ORDER_QTY = "{call get_calculated_purchase_order_qty(?,?,?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_RETURN_DETAILS_BY_ID = "{call get_PurchaseReturn_Details_byID(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_RETURN_HEADER_ALL = "{call get_allPurchaseReturn_Details(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_ALL_PURCHASE_ORDER_DETAILS = "{call get_allPurchaseOrder_Details(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_ORDER_HEADER_BY_ID = "{call get_PurchaseOrder_Header_byID(?)}";
	public static final String PROC_GET_PURCHASE_ORDER_DETAILS_BY_ID = "{call get_PurchaseOrder_Details_byID(?)}";
	public static final String PROC_GET_PENDING_PURCHASE_ORDER_DETAILS_BY_INV_NO = "{call get_Pending_PurchaseOrder_Details_byInvNo(?,?,?,?,?)}";
	public static final String PROC_GENERATE_PURCHASE_ORDER_BY_TYPE = "{call generate_PurchaseOrder_byType(?,?,?,?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_PAYMENT_DETAILS_ALL = "{call get_allPayment_Details(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_PAYMENT_DETAILS_BY_ID = "{call get_Payment_Details_byID(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_PAYMENT_PENDING_BY_DISTRIBUTOR = "{call get_PendingPayment_byDistributor(?,?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_DETAILS_RETURN_INV_NO = "{call get_PurchaseDetails_byInvNo_forReturn(?,?,?)}";
	public static final String PROC_GET_PURCHASE_DETAILS_RETURN_ITEM = "{call get_PurchaseDetails_byItem_forReturn(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_DETAILS_RETURN_SKU = "{call get_PurchaseDetails_bySKU_forReturn(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_HISTORY = "{call get_latestPurchase_byItem(?,?,?,?)}";
	public static final String PROC_PURCHASE_ALL = "{call get_allPurchase_Details(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_PURCHASE_DETAILS_BY_ID = "{call get_Purchase_Details_byID(?)}";
	public static final String PROC_CREATE_PURCHASE_INVOICE = "{call insert_purchase(?,?,?,?)}";
	public static final String PROC_CREATE_PURCHASE_ORDER = "{call insert_purchase_order(?,?,?,?)}";
	public static final String PROC_CREATE_DISTRIBUTOR_PAYMENT = "{call insert_distributor_payment(?,?,?,?)}";
	public static final String PROC_CREATE_PURCHASE_RETURN = "{call insert_purchase_return(?,?,?,?)}";
	public static final String PROC_PURCHASE_DETAILS_BY_ITEM_ID = "{call get_Purchase_Info_byItemID(?,?)}";
	public static final String PROC_PURCHASE_DETAILS_BY_ITEM_SKU = "{call get_Purchase_Info_byItemSKU(?,?,?,?)}";
	public static final String PROC_DELETE_PURCHASE_INVOICE = "{call Delete_Purchase(?,?,?,?,?)}";
	public static final String PROC_DELETE_PURCHASE_ORDER = "{call delete_purchase_order(?,?,?,?,?)}";
	public static final String PROC_DELETE_PURCHASE_RETURN = "{call Delete_PurchaseReturn(?,?,?,?,?)}";
	public static final String PROC_DELETE_DISTRIBUTOR_PAYMENT = "{call Delete_Distributor_Payment(?,?,?,?,?,?)}";
	public static final String PROC_LAST_PURCHASE_DETAILS_BY_DIST_ID = "{call get_Last_Purchase_Info_byDistributerID(?)}";
	public static final String PROC_POST_PURCHASE_INVOICE = "{call Posted_Purchase(?,?,?,?)}";
	public static final String PROC_GET_DUPLICATE_BILL = "{call Get_Duplicate_Bill(?,?,?,?,?,?)}";
	public static final String PROC_POST_PURCHASE_ORDER = "{call posted_purchase_order(?,?,?,?)}";
	public static final String PROC_CLOSE_PURCHASE_ORDER = "{call closed_purchase_order(?,?,?,?,?)}";
	public static final String PROC_ASSIGN_TAX_ITEM = "{call in_assign_tax_to_item(?,?,?,?,?)}";
	public static final String PROC_INSERT_TEMP_PUR_FRM_SALE = "{call insert_tmp_purchase_from_sale(?,?,?,?,?,?)}";
	public static final String PROC_POST_DISTRIBUTOR_PAYMENT = "{call Posted_DistributorPayment(?,?,?,?)}";
	public static final String PROC_POST_PURCHASE_RETURN = "{call Posted_PurchaseReturn(?,?,?,?)}";
	public static final String PROC_GET_CURRENT_STOCK_ITEM = "{call get_Stock_Status_byItemID(?,?,?,?,?,?)}";
	public static final String PROC_GET_CUSTOMER_BY_ID = "{call get_Customer_byID(?,?,?,?)}";
	public static final String PROC_GET_DISTRIBUTOR_BY_ID = "{call get_distributor_byID(?,?,?,?)}";
	public static final String PROC_GET_CURRENT_STOCK_ITEM_BY_SKU = "{call get_Stock_Status_byItemSKU(?,?,?,?,?,?)}";
	
	public static final String PROC_GET_DISTRIBUTORS_ALL = "{call get_allDistributors(?,?,?,?)}";
	public static final String PROC_GET_CUSTOMERS_ALL = "{call get_allCustomers(?,?,?,?)}";
	public static final String PROC_GET_DISTRIBUTORS_ALL_WITH_OUTSTANDING = "{call get_allDistributors_withOutstanding(?,?,?,?)}";
	public static final String PROC_GET_SALE_HEADER = "{call get_Sale_Header_byID(?)}";
	public static final String PROC_GET_SALE_HEADER_FOR_BILL = "{call get_Sale_Header_byID_forBill(?,?,?)}";
	public static final String PROC_GET_CUST_PAYMENT_HEADER = "{call get_CustomerPayment_Header_byID(?)}";
	public static final String PROC_GET_CUST_CREDIT_LIMIT_BY_NAME = "{call get_CustomerWithCreditLimit_byName(?,?,?,?,?,?,?)}";
	public static final String PROC_GET_SALE_HEADER_BY_INV_NO = "{call get_Sale_Header_byInvNo(?)}";
	public static final String PROC_GET_SALE_ITEM_DETAILS_BY_ITEM_ID = "{call get_saleItemDetails_byItemID(?,?,?,?)}";
	public static final String PROC_GET_SALE_DETAILS = "{call get_Sale_Details_byID(?)}";
	public static final String PROC_GET_AUTO_REMARKS = "{call get_autoRemarks_List(?,?,?)}";
	public static final String PROC_GET_TAX_DETAILS_SALE_BILL = "{call get_Sale_TaxDetails_byID_forBill(?,?,?)}";
	public static final String PROC_GET_SALE_DETAILS_FOR_BILL = "{call get_Sale_Details_byID_forBill(?,?,?)}";
	public static final String PROC_GET_SALE_DETAILS_BY_INV_NO = "{call get_Sale_Details_byInvNo(?,?,?)}";
	
	public static final String PROC_GET_SALE_RETURN_DETAILS = "{call get_allSaleReturn_Details(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_SALE_RETURN_HEADER = "{call get_SaleReturn_Header_byID(?)}";
	public static final String PROC_GET_SALE_RETURN_DETAILS_BY_ID = "{call get_SaleReturn_Details_byID(?)}";
	public static final String PROC_GET_SALE_DETAILS_FOR_RETURN_BY_ITEM = "{call get_SalesDetails_byItem_forReturn(?,?,?,?,?)}";
	public static final String PROC_GET_SALE_DETAILS_FOR_RETURN_INV_NO = "{call get_SalesDetails_byInvNo_forReturn(?,?,?)}";
	public static final String PROC_GET_SALE_RETURN_ADJ_INV_NO = "{call get_SaleReturn_forAdjustment(?,?,?,?,?)}";
	public static final String PROC_GET_SALE_RETURN_ADJ_SALEID = "{call get_SaleReturn_forAdjustment_bySaleID(?,?,?)}";
	public static final String PROC_CREATE_SALES_INVOICE = "{call insert_sale(?,?,?,?)}";
	public static final String PROC_POST_ALL_SALES_INVOICE = "{call post_all_sale(?,?,?,?)}";
	public static final String PROC_POST_ALL_PURCHASE = "{call post_all_purchase(?,?,?,?)}";
	public static final String PROC_POST_ALL_PURCHASE_RETURN = "{call post_all_purchase_return(?,?,?,?)}";
	public static final String PROC_CREATE_CUST_PAYMENT = "{call insert_customer_payment(?,?,?,?)}";
	public static final String PROC_CREATE_EXPIRY_INVOICE = "{call insert_expiry(?,?,?,?)}";
	public static final String PROC_CREATE_SALES_RETURN = "{call insert_sale_return(?,?,?,?)}";
	public static final String PROC_GET_CUSTOMER_PHONE_OR_NAME = "{call get_Customer_byName(?,?,?,?)}";
	public static final String PROC_GET_SALE_DETAILS_ALL = "{call get_allSale_Details(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_CUST_PAYMENT_DETAILS_ALL = "{call get_allCustomerPayment_Details(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_CUST_PAYMENT_DETAILS_BY_ID = "{call get_CustomerPayment_Details_byID(?,?,?,?)}";
	public static final String PROC_GET_CUST_PAYMENT_PENDING = "{call get_PendingPayment_byCustomer(?,?,?,?,?)}";
	public static final String PROC_POST_SALES_INVOICE = "{call Posted_Sale(?,?,?,?)}";
	public static final String PROC_POST_CUST_PAYMENT = "{call Posted_CustomerPayment(?,?,?,?)}";
	public static final String PROC_POST_SALES_RETURN = "{call Posted_SaleReturn(?,?,?,?)}";
	public static final String PROC_POST_ALL_SALES_RETURN_INVOICE = "{call post_all_sale_return(?,?,?,?)}";
	public static final String PROC_GET_ITEMS_WITH_SAME_CONTENT = "{call get_SameContentItemList_byItem(?,?,?,?,?)}";
	public static final String PROC_GET_ITEM_HISTORY = "{call get_item_history(?,?,?,?,?,?)}";
	public static final String PROC_GET_ITEM_BY_BARCODE = "{call get_item_bySKU(?,?,?)}";
	public static final String PROC_GET_ITEM_BY_NAME = "{call get_item_byName(?,?,?)}";
	public static final String PROC_GET_ALL_DOCS_BY_NAME = "{call get_Doctor_byName(?,?,?,?)}";
	public static final String PROC_DELETE_SALES_INVOICE = "{call Delete_Sale(?,?,?,?,?)}";
	public static final String PROC_DELETE_CUST_PAYMENT = "{call Delete_Customer_Payment(?,?,?,?,?,?)}";
	public static final String PROC_DELETE_SALES_RETURN = "{call Delete_SaleReturn(?,?,?,?,?)}";
	public static final String PROC_GET_LAST_SALE_BY_CUSTOMER = "{call get_Last_Sales_byCustomer(?,?,?,?)}";
	
	public static final String PROC_UPLOAD_STOCK_AUTO = "{call import_Stock(?,?,?,?,?,?,?)}";
	
	public static final String PROC_UPLOAD_STOCK_MANUAL = "{call import_Stock_Manual(?,?,?)}";
	public static final String PROC_GET_CURRENT_STOCK_ITEM_AT_SALE = "{call get_Stock_Status_byItemBatch(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_STOCK_DETAILS_FOR_ADJUSTMENT = "{call get_stock_details_for_adjustment(?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_VALID_USER = "{call get_Valid_by_User(?,?)}";
	public static final String PROC_GET_PURCHASE_RETURN_ADJ_INV_NO = "{call get_PurchaseReturn_forAdjustment(?,?,?,?)}";
	public static final String PROC_GET_PURCHASE_RETURN_ADJ_PURCHASE_ID = "{call get_PurchaseReturn_forAdjustment_byPurchaseID(?,?,?)}";
	public static final String PROC_GET_EXPIRY_DETAILS_ALL = "{call get_allExpiry_Details(?,?,?,?,?,?)}";
	public static final String PROC_GET_EXPIRY_HEADER_BY_ID = "{call get_Expiry_Header_byID(?)}";
	
	public static final String PROC_GET_EXPIRY_DETAILS_BY_ID = "{call get_Expiry_Details_byID(?)}";
	public static final String PROC_GET_ALL_PENDING_EXPIRY_LIST = "{call get_allPendingExpiryList(?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_ALL_ITEM_SEARCH_BY_CONTENT = "{call get_allItem_SearchByContent(?)}";
	public static final String PROC_GET_ALL_ITEM__STOCK_SEARCH_BY_CONTENT = "{call get_allItemStock_SearchByContent(?,?,?,?,?)}";
	public static final String PROC_GET_EXPIRY_FOR_ADJ = "{call get_Expiry_forAdjustment(?,?,?,?)}";
	public static final String PROC_GET_EXPIRY_FOR_ADJ_BY_PUR = "{call get_Expiry_forAdjustment_byPurchaseID(?,?,?)}";
	public static final String PROC_DELETE_EXPIRY = "{call Delete_Expiry(?,?,?,?,?)}";
	public static final String PROC_POST_EXPIRY = "{call Posted_Expiry(?,?,?,?)}";
	public static final String PROC_GET_TAX_BY_NAME = "{call get_allTax_byName(?,?,?)}";
	public static final String PROC_GET_ALL_TAX = "{call get_allTax_List(?,?,?,?)}";
	public static final String PROC_GET_TAX_DETAILS_BY_ID = "{call get_TaxDetails_byID(?,?,?)}";
	public static final String PROC_GET_TAX_BY_ID = "{call get_Tax_byID(?,?,?)}";
	public static final String PROC_CREATE_TAX = "{call In_Create_Tax(?,?,?,?)}";
	public static final String PROC_INSERT_CUST = "{call insert_customer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_INSERT_DIST = "{call insert_distributor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_CUST = "{call update_customer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_DIST = "{call update_distributor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_DELETE_TAX = "{call In_Delete_Tax(?,?,?,?)}";
	public static final String PROC_DELETE_STCK_ADJ = "{call delete_stock_adjustment(?,?,?,?)}";
	public static final String PROC_UPDATE_STOCK_ADJ = "{call update_stock_adjusment(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_TAX = "{call In_Update_Tax(?,?,?,?)}";

	
	//15.02.2018
	public static final String PROC_CREATE_ACCOUNT_GROUP = "{call create_acount_group(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_ACCOUNT_GROUP = "{call update_acount_group(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_ALL_ACCOUNT_GRP = "{call get_all_account_group(?,?,?)}";
	public static final String PROC_GET_ALL_ACCOUNT_TYPE = "{call get_allAccount_Type(?,?)}";
	public static final String PROC_DELETE_ACCOUNT_GROUP = "{call delete_account_group_byID(?,?,?,?)}";
	
	public static final String PROC_GET_ALL_TRANS_ACCOUNT_TYPE = "{call get_account_trans_type(?,?)}";
	//15.02.2018
	
	//16.02.2018
	public static final String PROC_CREATE_ACCOUNT = "{call insert_account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_ALL_ACCOUNTS = "{call get_allAccounts(?,?,?,?,?,?)}";
	public static final String PROC_CREATE_AREAS = "{call create_areas(?,?,?,?,?)}";
	public static final String PROC_UPDATE_AREAS = "{call update_areas(?,?,?,?,?,?)}";
	public static final String PROC_DELETE_AREAS = "{call delete_areas(?,?)}";
	public static final String PROC_GET_AREA_BY_ID = "{call get_area_byID(?,?,?)}";
	public static final String PROC_GET_ALL_AREAS_BY_NAME = "{call get_allAreas_byName(?,?,?,?)}";
	public static final String PROC_GET_ALL_STATES_BY_COUNTRY = "{call get_allStates(?,?,?)}";
	public static final String PROC_GET_ALL_CITIES_BY_STATE = "{call get_allCities(?,?,?)}";
	public static final String PROC_GET_ALL_CITIES_BY_NAME = "{call get_allCities_byName(?,?,?,?)}";
	public static final String PROC_GET_ALL_ZONES_BY_CITY = "{call get_allZones(?,?,?)}";
	public static final String PROC_GET_ALL_ZONES_BY_NAME = "{call get_allZones_byName(?,?,?,?)}";
	public static final String PROC_GET_ALL_AREAS_BY_ZONE = "{call get_allAreas(?,?,?)}";
	public static final String PROC_CREATE_ZONES = "{call create_zones(?,?,?,?,?,?)}";
	public static final String PROC_UPDATE_CITIES = "{call update_cities(?,?,?,?)}";
	public static final String PROC_UPDATE_ZONES = "{call update_zones(?,?,?,?,?,?,?)}";
	public static final String PROC_DELETE_CITIES = "{call delete_cities(?,?,?)}";
	public static final String PROC_DELETE_ZONES = "{call delete_zones(?,?)}";
	public static final String PROC_CREATE_CITIES = "{call create_cities(?,?,?)}";
	//16.02.2018
	
	//19.02.2018
	public static final String PROC_DELETE_ACCOUNT = "{call delete_account(?,?,?,?)}";
	
	public static final String GET_DUPLICATE_ACCOUNT = "{call Get_Duplicate_Account(?,?,?,?,?)}";
	public static final String PROC_UPDATE_ACCOUNT = "{call update_account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_GET_ACCOUNTS_AUTOCOMPLETE = "{call get_accounts_autocomplete(?,?,?)}";
	//19.02.2018
	public static final String PROC_DELETE_JOURNAL = "{call delete_journal(?,?,?,?)}";
	public static final String PROC_GET_JOURNALTYPE_BYQS = "{call get_journalType_byQS(?,?,?)}";
	public static final String PROC_GET_ALLJOURNAL_BYTYPE = "{CALL get_allJournal_byType(?,?,?,?,?)}";
	public static final String PROC_INSERT_JOURNAL = "{CALL insert_journal(?,?,?,?)}";
	public static final String PROC_GET_JOURNALDETAILS_BYID = "{CALL get_journalDetails_byID(?,?,?,?)}";
	
	public static final String PROC_GET_JOURNALHEADER_BYID = "{CALL get_journalHeader_byID(?,?,?,?)}";
	public static final String PROC_GET_LEDGERDETAILS_BYCODE = "{CALL get_ledgerDetails_byCode(?,?,?,?,?)}";
	public static final String PROC_GET_ACCOUNTS_AUTOCOMPLETE_BYCASHBANK = "{CALL get_accounts_autocomplete_byCashBank(?,?,?,?)}";
//	public static final String PROC_CHART_OF_ACCOUNT = "{CALL chart_of_account(?,?)}";
	public static final String PROC_CHART_OF_ACCOUNT = "{CALL get_ChartOfAccounts(?,?,?,?,?,?)}";
	public static final String PROC_GET_ACCOUNTS_AUTOCOMPLETEBYGROUP = "{CALL get_accounts_autocompleteByGroupID(?,?,?,?)}";//get_accounts_autocompleteByGroup(?,?,?,?) 19.03.2018
	public static final String PROC_GET_CUSTOMERS_ALL_BYNAME = "{call get_allCustomers_byName(?,?,?,?,?,?)}";
	public static final String PROC_OP_STOCK_TRANSFER_FOR_YEAREND = "{call op_Stock_Transfer_for_YearEnd(?,?,?,?,?,?,?)}";
	
	//added on 15.07.2019
	public static final String PROC_GEN_CREATE_USER = "{call Gen_Create_User(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; 
	public static final String PROC_GEN_CREATE_ROLE = "{call Gen_Create_Role(?,?)}";
	public static final String PROC_GEN_DELETE_ROLE = "{call Gen_Delete_Role(?,?,?)}";
	public static final String PROC_GEN_USER_ROLE_MAPPING = "{call Gen_User_Role_Mapping(?,?,?,?)}";
	public static final String PROC_GET_USER_ROLE = "{call get_user_role(?)}";
	
	//added on 25.07.2019
	public static final String PROC_GET_ALL_COUNT = "{call get_All_Count(?,?,?,?,?)}";
	public static final String PROC_GET_All_TRANS_MONTHWISE = "{call get_AllTrans_monthWise(?,?,?,?,?)}";
	public static final String PROC_GET_All_COUNT_MONTHWISE = "{call get_AllCount_monthWise(?,?,?,?,?)}";
	public static final String PROC_GET_ALL_STORE= "{call get_All_Store()}";
	public static final String PROC_GET_ALL_STORE_BY_COMPANYID= "{call get_All_Store_by_CompanyId(?)}";
}


