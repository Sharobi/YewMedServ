package com.sharobi.pharmacy.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;

@XmlRootElement
public class WriteToExcelDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String firstData;
    private String secondData;
    private String thirdData;
    private String fourthData;
    private List<String> headerList;
    private List<PurchaseOrderDetailsDTO> valueList;
    private String classType=null;
    
    
    
	public String getFourthData() {
		return fourthData;
	}
	public void setFourthData(String fourthData) {
		this.fourthData = fourthData;
	}
	public String getFirstData() {
		return firstData;
	}
	public void setFirstData(String firstData) {
		this.firstData = firstData;
	}
	public String getSecondData() {
		return secondData;
	}
	public void setSecondData(String secondData) {
		this.secondData = secondData;
	}
	public String getThirdData() {
		return thirdData;
	}
	public void setThirdData(String thirdData) {
		this.thirdData = thirdData;
	}
	
	public List<PurchaseOrderDetailsDTO> getValueList() {
		return valueList;
	}
	public void setValueList(List<PurchaseOrderDetailsDTO> valueList) {
		this.valueList = valueList;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public List<String> getHeaderList() {
		return headerList;
	}
	public void setHeaderList(List<String> headerList) {
		this.headerList = headerList;
	}
	  
	public String writeToExcel() throws Exception{
		 //String FILE_NAME = "D:\\2017-07-21\\purchase_order.xlsx";
		byte[] xls=new byte[1024];
		try{
		 XSSFWorkbook workbook = new XSSFWorkbook();
	     XSSFSheet sheet = workbook.createSheet("sheet1");
	     
	     
	     int rowNum = 0;
	     int colNum = 3;
	        
	        Row row = sheet.createRow(rowNum++);
	        Cell cell = row.createCell(colNum--);
	        cell.setCellValue(getFirstData());
	        
	        Row row1 = sheet.createRow(rowNum++);
	        Cell cell1 = row1.createCell(colNum--);
	        cell1.setCellValue(getSecondData());
	        
	        Row row2 = sheet.createRow(rowNum++);
	        Cell cell2 = row2.createCell(colNum);
	        cell2.setCellValue(getThirdData());
	        
	        Row row3 = sheet.createRow(rowNum++);
	        Cell cell3 = row3.createCell(colNum);
	        cell3.setCellValue(getFourthData());
	        
	        rowNum++;
	        Row headerRow = sheet.createRow(rowNum++);
	        int headerColNum = 0;
	        for (String header : headerList) {
            Cell headerCell = headerRow.createCell(headerColNum++);
           	headerCell.setCellValue(header);
            
	       }
	        int serialNum=1;
	        for (PurchaseOrderDetailsDTO valueDTO : valueList) {
            Row valRow = sheet.createRow(rowNum++);
            int valColNum = 0;
            
            Cell valCell0 = valRow.createCell(valColNum++);
            valCell0.setCellValue(serialNum++);
            
            Cell valCell1 = valRow.createCell(valColNum++);
			if (valueDTO.getItemName() instanceof String) {
				valCell1.setCellValue((String) valueDTO.getItemName());
			}
			 Cell valCell2 = valRow.createCell(valColNum++);
			if ((Integer)valueDTO.getConversion() instanceof Integer) {
				valCell2.setCellValue((Integer) valueDTO.getConversion());
			}
			 Cell valCell3 = valRow.createCell(valColNum++);
			if (valueDTO.getManufacturerName() instanceof String) {
				valCell3.setCellValue((String) valueDTO.getManufacturerName());
			}
			 Cell valCell4 = valRow.createCell(valColNum++);
			if ((Double)valueDTO.getMrp() instanceof Double) {
				valCell4.setCellValue((Double) valueDTO.getMrp());
			}
			Cell valCell5 = valRow.createCell(valColNum++);
			if ((Double)valueDTO.getRate() instanceof Double) {
				valCell5.setCellValue((Double) valueDTO.getRate());
			}
			Cell valCell6 = valRow.createCell(valColNum++);
			if ((Integer)valueDTO.getPackQty() instanceof Integer) {
				valCell6.setCellValue((Integer) valueDTO.getPackQty());
			}
			Cell valCell7 = valRow.createCell(valColNum++);
			if ((Double)valueDTO.getDiscPer() instanceof Double) {
				valCell7.setCellValue((Double) valueDTO.getDiscPer());
			}
			Cell valCell8 = valRow.createCell(valColNum++);
			if ((Double)valueDTO.getTaxPercentage() instanceof Double) {
				valCell8.setCellValue((Double) valueDTO.getTaxPercentage());
			}
			Cell valCell9 = valRow.createCell(valColNum++);
			valCell9.setCellValue((Double) (valueDTO.getPackQty()*valueDTO.getRate()));
		     
        }
	        	
	        	File dir = new File("/home/ubuntu/temp_data");
	        	//File dir = new File("c:\\temp_data");
	        	String ops = System.getProperty("os.name").toLowerCase();
				if (ops.startsWith("windows")) {
					dir = new File("c:\\temp_data");
				}
	            boolean successful = dir.mkdir();
	            String absPath=dir.getAbsolutePath();
	           
	            if (successful)
	            {
	            	//FileOutputStream outputStream = new FileOutputStream(absPath+"\\"+"purchase_order.xlsx");
	            	FileOutputStream outputStream;
	            	if (ops.startsWith("windows")) {
	            		outputStream = new FileOutputStream(absPath+"\\"+"purchase_order.xlsx");
	            	}
	            	else 
	            	{
	            		outputStream = new FileOutputStream(absPath+"/"+"purchase_order.xlsx");
	            	}
		            workbook.write(outputStream);
		            outputStream.close();
		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            workbook.write(baos);
		            xls = baos.toByteArray();
	            }
	            else
	            {
	              // creating the directory failed
	              System.out.println("failed trying to create the directory");
	              FileOutputStream outputStream;
	            	if (ops.startsWith("windows")) {
	            		outputStream = new FileOutputStream(absPath+"\\"+"purchase_order.xlsx");
	            	}
	            	else 
	            	{
	            		outputStream = new FileOutputStream(absPath+"/"+"purchase_order.xlsx");
	            	}
	            	//FileOutputStream outputStream = new FileOutputStream(absPath+"\\"+"purchase_order.xlsx");
		            workbook.write(outputStream);
		            outputStream.close();
		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            workbook.write(baos);
		            xls = baos.toByteArray();
	            }
	        	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new Exception();
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new Exception();
	        }

	       // System.out.println("Done");
	        return "";
	    }
	 
	}
    


/**
 * rajarshi
 */
