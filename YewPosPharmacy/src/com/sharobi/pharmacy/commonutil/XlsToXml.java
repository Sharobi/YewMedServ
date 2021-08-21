package com.sharobi.pharmacy.commonutil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.Document;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PurchaseInvoiceExcelDTO;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.dao.impl.InventoryDAOImpl;
import com.sharobi.pharmacy.inventory.model.ItemDTO;
import com.sharobi.pharmacy.procurement.model.Purchase;
import com.sharobi.pharmacy.procurement.model.PurchaseDetails;
import com.sharobi.pharmacy.store.dao.impl.StoreDAOImpl;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.StoreMaster;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Font;
import jxl.read.biff.BiffException;

public class XlsToXml {
public String toXml(File excelFile) throws IOException, BiffException {
   try {
       String xmlLine = "";
       String rowText = "";
       String colText = "";
       String isBold = "";
       Font font = null;
       String cellCol = "";
       String cellAddress = "";
       Cell cell = null;
       Workbook workbook = Workbook.getWorkbook(excelFile);
       xmlLine += "<workbook>" + "\n";
       for (int sheet = 0; sheet < workbook.getNumberOfSheets(); sheet++) {
           Sheet s = workbook.getSheet(sheet);
           xmlLine += "  <sheets>" + "\n";
           Cell[] row = null;
           for (int i = 0; i < s.getRows(); i++) {
               row = s.getRow(i);
               for (int j = 0; j < row.length; j++) {
                   if (row[j].getType() != CellType.EMPTY) {
                       cell = row[j];
                       cellCol=columnName(cell.getColumn());
                       cellCol=" colLetter=\""+cellCol+"\"";
                       cellAddress=" address=\""+cellAddress(cell.getRow()+1,cell.getColumn())+"\"";
                       isBold = cell.getCellFormat().getFont().getBoldWeight() == 700 ? "true" : "false";
                       isBold = (isBold == "false" ? "" : " isBold=\"true\"");
                       colText += "      <col"+(j+1)+ ">";
                       colText += cell.getContents();
                       colText += "</col"+(j+1)+">" + "\n";
                       rowText += cell.getContents();
                   }
               }
               if (rowText != "") {
                   xmlLine += "    <row>" + "\n";
                   xmlLine += colText;
                   xmlLine += "    </row>" + "\n";
               }
               colText = "";
               rowText = "";
           }
           xmlLine += "  </sheets>" + "\n";;
       }
       xmlLine += "</workbook>";
       return xmlLine;
   } catch (UnsupportedEncodingException e) {
       System.err.println(e.toString());
   }
   return null;
}

public String toXml(InputStream inputStream) throws IOException, BiffException {

	   try {
		  
	       String xmlLine = "";
	       String rowText = "";
	       String colText = "";
	     
	       String cellCol = "";
	       String cellAddress = "";
	       String cellValue="";
	       //Cell cell = null;
	       org.apache.poi.ss.usermodel.Cell cell = null;
	       DateFormat formatter = new SimpleDateFormat("MM/yy");
	       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	       DocumentBuilder builder = factory.newDocumentBuilder();
	       Document document = builder.newDocument();
	       DecimalFormat format = new DecimalFormat("0.#");
	       
	       org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);
	     
	       xmlLine += "<workbook>" + "\n";
	       int noOfRecords=0;
	       for (int sheet = 0; sheet<1; sheet++) {
	    	  
	    	   org.apache.poi.ss.usermodel.Sheet s = workbook.getSheetAt(sheet);
	           xmlLine += "  <sheets>" + "\n";
	        
	           for (int i = 0; i <= s.getLastRowNum(); i++) {
	        	   boolean chkSpcl=false;
	        	   Row row1 = s.getRow(i);
	        	   int noOfCells= s.getRow(0).getPhysicalNumberOfCells();
	        	  //int noOfCells= row1.getPhysicalNumberOfCells();
	        	   
	        	   if (row1.getCell(1) != null) {
	        		   noOfRecords=i;
	               for (int j = 0; j < noOfCells; j++) {
	            	   boolean isValidData=true;
	            	   if(j==12 || j==13 || j==14 || j==15 ||j==16){
	            		  if(row1.getCell(j)==null){
	            			  cellValue="0";
		                	   
		                	   if(isValidData){
									colText += "      <col" + (j + 1) + ">";
									colText += cellValue;
									colText += "</col" + (j + 1) + ">" + "\n";
									rowText += cellValue;
								}
	            		  }
	            	   }
	            	  
	                   if (row1.getCell(j)!=null) {
						if (row1.getCell(j).getCellType() != org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK) {
							cell = row1.getCell(j);
							cellCol = columnName(cell.getColumnIndex());
							cellCol = " colLetter=\"" + cellCol + "\"";
							cellAddress = " address=\""
									+ cellAddress(cell.getRowIndex() + 1,
											cell.getColumnIndex()) + "\"";
						
							
							if (cell != null) {
								switch (cell.getCellType()) {
								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
									cellValue = cell.getStringCellValue();
									if(j==5){
										chkSpcl=Util.chkSpecialCharacter(cellValue);
										if(chkSpcl){
											break;
										}
									}
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:
									cellValue = cell.getCellFormula();
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
									  if (DateUtil.isCellDateFormatted(cell)) {
									      Date date = cell.getDateCellValue();
										  cellValue=formatter.format(date);
										 // isValidData= Util.validateExpiryDate(cellValue);
									  } else {
										  cellValue = Double.toString(cell
											.getNumericCellValue());
										if(j==5){
											double cellVal=Double.parseDouble(cellValue);
											cellValue=format.format(cellVal);
											chkSpcl=Util.chkSpecialCharacter(cellValue);
											if(chkSpcl){
												break;
											}
										}
									}
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK:
									cellValue = "";
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:
									cellValue = Boolean.toString(cell
											.getBooleanCellValue());
									break;

								}
							}
							if(!chkSpcl){
								if(isValidData){
									colText += "      <col" + (j + 1) + ">";
									colText += cellValue;
									colText += "</col" + (j + 1) + ">" + "\n";
									rowText += cellValue;
								}
							}
							else if(chkSpcl) {
								break;
							}
						}
					}
	                  
	               }
	        	  }
	        	  
	               if (!chkSpcl) {
					if (rowText != "") {
						xmlLine += "    <row>" + "\n";
						xmlLine += colText;
						xmlLine += "    </row>" + "\n";
					}
				}
	               colText = "";
	               rowText = "";
	           }
	           xmlLine += "  </sheets>" + "\n";;
	       }
	       xmlLine += "</workbook>";
	       System.out.println("no of records:: "+noOfRecords);
	       return xmlLine;
	   } catch (UnsupportedEncodingException e) {
	       System.err.println(e.toString());
	   } catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;

}

public Purchase toPurchaseInvXml(InputStream inputStream,PurchaseInvoiceExcelDTO mapper) throws IOException, BiffException {

	   try {
		  
	       String cellCol = "";
	       String cellAddress = "";
	       String cellValue="";
	       DecimalFormat format = new DecimalFormat("0.00");
	       DecimalFormat df = new DecimalFormat("#.####");
	       /*DecimalFormat dfTwo = new DecimalFormat("#.##");*/
	       int startRow=mapper.getExcelUploadStartRow();
	       int endRow=mapper.getExcelUploadEndRow();
	       String itemNamePos= mapper.getExcelUploadItemName();
	       String packPos=mapper.getExcelUploadPack();
	       String batchPos=mapper.getExcelUploadBatch();
	       String mfgPos=mapper.getExcelUploadMfg();
	       String expDatePos=mapper.getExcelUploadExpdate();
	       String mrpPos=mapper.getExcelUploadMrp();
	       String ratePos=mapper.getExcelUploadRate();
	       String qtyPos=mapper.getExcelUploadQty();
	       String freePos=mapper.getExcelUploadFree();
	       String disPerPos=mapper.getExcelUploadDiscPerc();
	       String gstPerPos=mapper.getExcelUploadTaxPerc();
	       String amtPos=mapper.getExcelUploadAmt();
	       Purchase purchase =new Purchase();
	       List<PurchaseDetails> detailsList=new ArrayList<PurchaseDetails>();
	       List<String> itemNotFndList=new ArrayList<>();
	     
	       org.apache.poi.ss.usermodel.Cell cell = null;
/*	       DateFormat formatter = new SimpleDateFormat("MM/yy");*/
	       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	       DocumentBuilder builder = factory.newDocumentBuilder();
	       Document document = builder.newDocument();
	       
	       org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);
	       //FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((org.apache.poi.hssf.usermodel.HSSFWorkbook) workbook);
	       DataFormatter objDefaultFormat = new DataFormatter();
	     
	       purchase.setStoreId(mapper.getStoreId());
	       purchase.setFinyrId(mapper.getFinYrId());
	       purchase.setDistributorId(mapper.getExcelUploadVendorId());
	       purchase.setAdjAmount(0);
	       purchase.setAdvAmount(0);
	       purchase.setBillNo(mapper.getExcelUploadBillNo());
	       purchase.setCompanyId(mapper.getCompanyId());
	       purchase.setCreatedBy(mapper.getCreatedBy());
	       purchase.setCst(0);
	     
	       purchase.setDistDiscPer(0);
	       purchase.setDistributorBillAmount(0);
	       //get due date (current +7)
	       Date nxtDate=com.sharobi.pharmacy.commonutil.DateUtil.getNextDate(7);
	       purchase.setDueDate(nxtDate); 
	       purchase.setEdAmount(0);
	       purchase.setExpiryAdjAmount(0);
	    
	       purchase.setId(0);
	       purchase.setInvDate(new Date());
	       purchase.setInvMode(2);
	       purchase.setIsDeleted(0);
	       purchase.setIsPosted(0);
	       purchase.setLang("English");
	      
	      
	       purchase.setOtherAdjAmount(0);
	       purchase.setPaymentId(0);
	       purchase.setPoOrderId(0);
	       purchase.setPstId(0);
	       purchase.setPurchaseReturnId(0);
	       purchase.setRemarks("");
	      
	       purchase.setSpecDiscAmount(0);
	       purchase.setSpecDiscPer(0);
	     
	      
	       purchase.setUpdatedBy(0);
	       purchase.setVatAmount(0);
	       purchase.setVatDiff(0);
	       //get fin code
	       StoreDAOImpl daoImpl=new StoreDAOImpl();
	       FinYrMaster finYrMaster;
	       StoreMaster store=null;
	       double totalDisc=0;
	       double grossAmt=0;
	       double totLotAdjAmt=0;
	       double totNetAmt=0;
	       double totTaxAmt=0;
	       double totMrp=0;
		try {
			finYrMaster = daoImpl.getFinYrDetailsById(""+mapper.getFinYrId());
			store=daoImpl.getStoreDetails(""+mapper.getStoreId());
			 purchase.setFinyrCode(finYrMaster.getCode());
		} catch (DAOException e1) {
			 purchase.setFinyrCode(null);
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    	
	       for (int sheet = 0; sheet < workbook.getNumberOfSheets(); sheet++) {
	    	  
	    	   org.apache.poi.ss.usermodel.Sheet s = workbook.getSheetAt(sheet);
	        
	           for (int i = (startRow-1); i <= (endRow-1); i++) {		// start each row loop
	        	   PurchaseDetails purchaseDetails=new PurchaseDetails();
	        	   boolean itemFound=false;
	        	   String itemNotFoundName=null;
	        	   Row row = s.getRow(i);
	        	   int noOfCells= s.getRow(startRow-2).getPhysicalNumberOfCells();
	        	   
	        	  if (row.getCell(1) != null) {
	               for (int j = 0; j < noOfCells; j++) {		// start a row's column loop
	            	   if(j==12 || j==13 || j==14 || j==15){
	            		  if(row.getCell(j)==null){
	            			  cellValue="0";
		                	 
	            		  }
	            	   }
	            	  
	                   if (row.getCell(j)!=null) {
						if (row.getCell(j).getCellType() != org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK) {
							cell = row.getCell(j);
							cellCol = columnName(cell.getColumnIndex());
								
							if (cell != null) {
								switch (cell.getCellType()) {
								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
									cellValue = cell.getStringCellValue();
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:
									cellValue = cell.getCellFormula();
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
									
									  if (DateUtil.isCellDateFormatted(cell)) {
									      Date date = cell.getDateCellValue();
									      String date11=null;
										try {
											String date1=new SimpleDateFormat("MM-dd-yyyy").format(date);
											  String[] dateStr=date1.split("-");
											  String yr=dateStr[2];
											  yr = yr.substring(Math.max(yr.length() - 2, 0));
											  date11 = dateStr[0]+"/"+yr;
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									      cellValue=date11;
										
									  } else {
										  cellValue=objDefaultFormat.formatCellValue(cell);
									/*cellValue = Double.toString(cell
											.getNumericCellValue());*/
									}
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK:
									cellValue = "";
									break;

								case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:
									cellValue = Boolean.toString(cell
											.getBooleanCellValue());
									break;

								}
							}
							
							//check for column name and populate dto with data
							if(cellCol.equalsIgnoreCase(itemNamePos)){
								InventoryDAOImpl impl=new InventoryDAOImpl();
								CommonResultSetMapper mapper2=new CommonResultSetMapper();
								mapper2.setCompanyId(mapper.getCompanyId());
								mapper2.setStoreId(mapper.getStoreId());
								mapper2.setItemName(cellValue.trim());
								try {
									//ItemMaster item=impl.getItemByName(cellValue);
									ItemDTO item=impl.getItemByName(mapper2);
									
									if(item!=null){
										mapper2.setTaxId(item.getPurchaseTaxId());
										//TaxDTO taxDTO=impl.getTaxById(mapper2);
										
										//check for item name match using Fuzzy logic
										double value=FuzzyStringMatcher.cosineSimilarity(item.getName(), cellValue);
										if(value>0.5){
											purchaseDetails.setItemName(cellValue);
											purchaseDetails.setConversion(item.getConversion());
											purchaseDetails.setGrpId(item.getGroupId());
											purchaseDetails.setHsnCode(item.getHsnCode());
											purchaseDetails.setId(0);
											purchaseDetails.setItemId(item.getId());	
											purchaseDetails.setManuId(item.getManufacturerId());
											purchaseDetails.setPackUnitId(item.getPackUnitId());
											purchaseDetails.setSchdId(item.getScheduleId());
											purchaseDetails.setSku(item.getSku());
											purchaseDetails.setTaxId(item.getPurchaseTaxId());
											purchaseDetails.setTaxMode(item.getTaxMode());
											purchaseDetails.setIsGroupTax(item.getIsGroup());
											/*if(taxDTO!=null){
												purchaseDetails.setTaxMode(taxDTO.getTaxMode());
												purchaseDetails.setIsGroupTax(taxDTO.getIsGroup());
											}*/
																				
											itemFound=true;
										}
										else {
											itemNotFoundName=cellValue;
										}
									}
									else {
										itemFound=false;
										itemNotFoundName=cellValue;
									}
								} catch (DAOException e) {
									// TODO Auto-generated catch block
									itemFound=false;
									itemNotFoundName=cellValue;
									e.printStackTrace();
								}
								
							}
							else if (cellCol.equalsIgnoreCase(packPos)) {
								purchaseDetails.setPackUnitName(cellValue);
							}
							else if (cellCol.equalsIgnoreCase(batchPos)) {
								purchaseDetails.setBatchNo(cellValue);
							}
							else if (cellCol.equalsIgnoreCase(mfgPos)) {
								purchaseDetails.setManuName(cellValue);
							}
							else if (cellCol.equalsIgnoreCase(expDatePos)) {
								
									purchaseDetails.setExpiryDateFormat(cellValue);
								
							}
							else if(cellCol.equalsIgnoreCase(mrpPos)){
								if(cellValue!=null){
									if(!cellValue.equalsIgnoreCase("")){
										purchaseDetails.setMrp(Double.parseDouble(cellValue));
										//totMrp=totMrp+purchaseDetails.getMrp();
								}
									else{
										purchaseDetails.setMrp(0);
									}
								}
								else{
										purchaseDetails.setMrp(0);
									}
							}
							else if(cellCol.equalsIgnoreCase(ratePos)){
									if(cellValue!=null){
										if(!cellValue.equalsIgnoreCase("")){
											purchaseDetails.setRate(Double.parseDouble(cellValue));
									}
										else{
												purchaseDetails.setRate(0);
											}
									}
									else{
												purchaseDetails.setRate(0);
										}
							}
							else if (cellCol.equalsIgnoreCase(qtyPos)) {
									if(cellValue!=null){
										if(!cellValue.equalsIgnoreCase("")){
											double qtyVal=Double.parseDouble(cellValue);
											String formtdVal=format.format(new Double(qtyVal));
											String toIntQty=formtdVal.replaceAll("\\.00$", "");
											purchaseDetails.setPackQty(Integer.parseInt(toIntQty));
									}
										else{
												purchaseDetails.setPackQty(0);
											}
									}
									else{
												purchaseDetails.setPackQty(0);
										}
							}
							else if (cellCol.equalsIgnoreCase(freePos)) {
								if(cellValue!=null){
									if(!cellValue.equalsIgnoreCase("")){
										double freeVal=Double.parseDouble(cellValue);
										//String formtdVal=format.format(new Double(freeVal));
										//String toIntFree=formtdVal.replaceAll("\\.00$", "");
										purchaseDetails.setFreeQty(freeVal);
								}
									else{
											purchaseDetails.setFreeQty(0);
										}
								}
								else{
											purchaseDetails.setFreeQty(0);
									}
							}
							else if (cellCol.equalsIgnoreCase(disPerPos)) {
								if(cellValue!=null){
									if(!cellValue.equalsIgnoreCase("")){
										purchaseDetails.setDiscPer(Double.parseDouble(cellValue));
								}
									else{
											purchaseDetails.setDiscPer(0);
										}
								}
								else{
											purchaseDetails.setDiscPer(0);
									}
							}
							else if (cellCol.equalsIgnoreCase(gstPerPos)) {
								if(cellValue!=null){
									if(!cellValue.equalsIgnoreCase("")){
										purchaseDetails.setTaxPercentage(Double.parseDouble(cellValue));
								}
									else{
											purchaseDetails.setTaxPercentage(0);
										}
								}
								else{
											purchaseDetails.setTaxPercentage(0);
									}
							}
							else if (cellCol.equalsIgnoreCase(amtPos)) {
								
								//do nothing
								
							}
							
						}
					}
	                  
	               }		// end a row's column loop
	        	  }
	        	 
	        	  if(itemFound==true){
	        		  //set amount
	        		  double amt=purchaseDetails.getRate()*purchaseDetails.getPackQty();
	        		  purchaseDetails.setAmount(amt);
	        		  //calculate gross amount
	        		  grossAmt=grossAmt+amt;
	        		  purchaseDetails.setCompanyId(mapper.getCompanyId());
	        		 
		        	  purchaseDetails.setEd(0);
		        	  purchaseDetails.setEdPer(0);
	        		  purchaseDetails.setFinyrId(mapper.getFinYrId());
		        	  purchaseDetails.setIsTaxOnMrp(0);
		        	  
		        	  //calculate total mrp
		        	  totMrp=totMrp+purchaseDetails.getMrp()*(purchaseDetails.getPackQty()+purchaseDetails.getFreeQty());
		        	 
		        	  //calculate lot adj amount
		        	  	double lotAdjAmt=0;
						double modFree = (purchaseDetails.getFreeQty()) % 1;
						if (modFree>0) {
						double packQtyPerFree = purchaseDetails.getPackQty()
								/ modFree;
						lotAdjAmt = purchaseDetails.getAmount()
								/ packQtyPerFree;
						}
		        	  purchaseDetails.setItemLotAdjAmount(lotAdjAmt);
		        	  //calculate total lot adj amount
		        	  totLotAdjAmt=totLotAdjAmt+lotAdjAmt;
		        	  //calculate disc
		        	  double disc=0;
		        	  if(lotAdjAmt>0){
		        		  disc=(((purchaseDetails.getPackQty())*(purchaseDetails.getRate()))-lotAdjAmt)*(purchaseDetails.getDiscPer()/100);
		        	  }
		        	  else{
		        		  disc=(purchaseDetails.getPackQty())*(purchaseDetails.getRate())*(purchaseDetails.getDiscPer()/100);
		        	  }
		        	  purchaseDetails.setDisc(Double.parseDouble(df.format(disc)));
	        		  totalDisc=totalDisc+disc;
	        		  
		        	  purchaseDetails.setLooseQty(0);
		        	  purchaseDetails.setPurchaseId(0);
		        	  purchaseDetails.setPurchaseOrderId(0);
		        	  //calculate sale rate
		        	  if(store!=null){
		        		  double saleRate=0;
		        		  if(store.getIsExclusive()==1){
		        			  saleRate=(purchaseDetails.getMrp())/(1+(purchaseDetails.getTaxPercentage()/100));
		        			  
		        		  }
		        		  else {
		        			  saleRate=purchaseDetails.getMrp();
						}
		        		  purchaseDetails.setSaleRate(Double.parseDouble(df.format(saleRate)));
		        	  }
		        	  
		        	  purchaseDetails.setStoreId(mapper.getStoreId());
		        	  purchaseDetails.setTax(0);
		        	  //calculate tax amount
		        	  double taxAmt=(purchaseDetails.getAmount()-lotAdjAmt-purchaseDetails.getDisc())*(purchaseDetails.getTaxPercentage()/100);
		        	  purchaseDetails.setTaxAmount(Double.parseDouble(df.format(taxAmt)));
		        	  //calculate total tax amount
		        	  totTaxAmt=totTaxAmt+taxAmt;
		        	  
		        	  purchaseDetails.setTaxPer(0);
		        	  purchaseDetails.setTaxableRate(0);
		        	  purchaseDetails.setTotAmount((purchaseDetails.getPackQty()+purchaseDetails.getFreeQty())*purchaseDetails.getMrp());
		        	  purchaseDetails.setVat(0);
		        	  purchaseDetails.setVatPer(0);
		        	  //calculate purchase net amt
		        	  double purNetAmt=purchaseDetails.getAmount()+purchaseDetails.getTaxAmount()-purchaseDetails.getDisc();
		        	  purNetAmt = Math.round(purNetAmt*100.0)/100.0;
		        	  purchaseDetails.setPurchaseNetAmount(Double.parseDouble(df.format(purNetAmt)));
		        	  //calculate total net amount
		        	  totNetAmt=((grossAmt+totTaxAmt)-totalDisc)-totLotAdjAmt;
		        	  //totNetAmt=totNetAmt+purNetAmt;	
		        	  totNetAmt=Double.parseDouble(df.format(totNetAmt));
		        	  //add to list
	        		  detailsList.add(purchaseDetails);
	        	  }
	        	  else if (itemFound==false) {
	        		  itemNotFndList.add(itemNotFoundName);
					
				}
	             
	           }	// end each row loop
	           purchase.setDiscAmount(Double.parseDouble(df.format(totalDisc)));
	           purchase.setGrossAmount(grossAmt);
	           purchase.setLotAdjAmount(totLotAdjAmt);
	           purchase.setNetAmount(Math.round(totNetAmt));
	           //calculate round off
	           double roundOffNetAmt = new Double(Math.round(totNetAmt));
	           roundOffNetAmt = new Double(Util.roundOffUptoTwoPlacesDouble(roundOffNetAmt, 1)); // round off double
	           roundOffNetAmt=Double.parseDouble(df.format(roundOffNetAmt));
	           double roundOff=roundOffNetAmt-totNetAmt;
	           purchase.setRoundoff(Double.parseDouble(df.format(roundOff)));
	           purchase.setTaxAmount(Double.parseDouble(df.format(totTaxAmt)));
	           purchase.setTotalMrp(totMrp);
	           purchase.setPurchaseDetails(detailsList);
	           //set items not found
	           purchase.setItemNotFndList(itemNotFndList);
	           
	           //sheet complete, break
	           break;
	         
	       }
	      
	       return purchase;
	   } catch (UnsupportedEncodingException e) {
	       System.err.println(e.toString());
	   } catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;

}
private String cellAddress(Integer rowNumber, Integer colNumber){
   //return "$"+columnName(colNumber)+"$"+rowNumber;
   return columnName(colNumber)+rowNumber;
}
private String columnName(Integer colNumber) {
   Base columns = new Base(colNumber,26);
   columns.transform();
   return columns.getResult();
}

class Base {
    String[] colNames = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
    String equalTo;
    int position;
    int number;
    int base;
    int[] digits;
    int[] auxiliar;

    public Base(int n, int b) {
        position = 0;
        equalTo = "";
        base = b;
        number = n;
        digits = new int[1];
    }

    public void transform() {
        if (number < base) {
            digits[position] = number;
            size();
        } else {
            digits[position] = number % base;
            size();
            position++;
            number = number / base;
            transform();
        }
    }

    public String getResult() {
        for (int j = digits.length - 2; j >= 0; j--) {
            equalTo += colNames[j>0?digits[j]-1:digits[j]];
        }
        return equalTo;
    }

    private void size() {
        auxiliar = digits;
        digits = new int[auxiliar.length + 1];
        System.arraycopy(auxiliar, 0, digits, 0, auxiliar.length);
    }
}
}
/**
rajarshi
*/