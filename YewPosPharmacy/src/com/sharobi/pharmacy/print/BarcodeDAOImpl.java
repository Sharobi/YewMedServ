package com.sharobi.pharmacy.print;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import com.sharobi.pharmacy.commonutil.BarcodeGenerate;
import com.sharobi.pharmacy.commonutil.BarcodePrintParam;
import com.sharobi.pharmacy.commonutil.BarcodePrintParamList;
import com.sharobi.pharmacy.commonutil.LabelInfo;
import com.sharobi.pharmacy.exceptions.DAOException;



public class BarcodeDAOImpl implements BarcodeDAO {
	
	@Override
	public String generateAndPrintBarcode(BarcodePrintParam params, String rootPath, Connection connection) throws DAOException {
	
		//ProcurementDAO dao=new ProcurementDAOImpl();
		String status="";
		
		try {
			int noOfCopies = Integer.parseInt(params.getNoOfCopies());
			List<LabelInfo> labelInfos = new ArrayList<>();
			
			for(int i = 0; i < noOfCopies; i++) {
				//populate label info obj
				LabelInfo labelInfo=new LabelInfo();
				labelInfo.setBarcode(params.getSku());
				labelInfo.setPrintBarcode(true);
				labelInfo.setItemId(Integer.parseInt(params.getItemId()));
				labelInfo.setPrintItemId(false);
				labelInfo.setItemName(params.getItemName());
				labelInfo.setPrintItemName(true);
				labelInfo.setMrp(params.getMrp());
				labelInfo.setPrintMrp(true);
				labelInfo.setBatch(params.getBatch());
				labelInfo.setPrintBatch(false);
				labelInfo.setSaleRate(params.getSaleRate());
				labelInfo.setPrintSaleRate(false);
				labelInfo.setExpiryDate(params.getExpiryDate());
				labelInfo.setPrintExpiry(false);
				labelInfo.setStoreName(params.getStoreName());
				labelInfo.setPrintStoreName(true);
				labelInfo.setStoreCurrency(params.getStoreCurrency());
				labelInfo.setItemCategory(params.getItemCategory());
				labelInfo.setPrintItemCategory(true);
				labelInfo.setItemSubCategory(params.getItemSubCategory());
				labelInfo.setGrpName(params.getGrpName());
				labelInfo.setSize(params.getSize());
				labelInfo.setColour(params.getColour());

				labelInfos.add(labelInfo);
			}
		
			BarcodeGenerate barcodeGenerate = new BarcodeGenerate(rootPath, labelInfos);
			barcodeGenerate.printBarcode();
			
			status="success";
			
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
			
		} finally {
			/*if (em != null)
				em.close();*/
		}
		
		return status;
	}

	@Override
	public String generateAndPrintBarcodeAll(BarcodePrintParamList printParamList, String rootPath, Connection connection) throws DAOException {
	
		//ProcurementDAO dao=new ProcurementDAOImpl();
		String status="";
		List<BarcodePrintParam> paramsList = printParamList.getParamList();
		
		try {
			List<LabelInfo> labelInfos = new ArrayList<>(paramsList.size());
			for(int i = 0; i < paramsList.size(); i++) {
				BarcodePrintParam params = paramsList.get(i);
				int noOfCopies = Integer.parseInt(params.getNoOfCopies());
				for(int copy = 0; copy < noOfCopies; copy++) {
					//populate label info obj
					LabelInfo labelInfo = new LabelInfo();
					labelInfo.setBarcode(params.getSku());
					labelInfo.setPrintBarcode(true);
					labelInfo.setItemId(Integer.parseInt(params.getItemId()));
					labelInfo.setPrintItemId(false);
					labelInfo.setItemName(params.getItemName());
					labelInfo.setPrintItemName(true);
					labelInfo.setMrp(params.getMrp());
					labelInfo.setPrintMrp(true);
					labelInfo.setBatch(params.getBatch());
					labelInfo.setPrintBatch(false);
					labelInfo.setSaleRate(params.getSaleRate());
					labelInfo.setPrintSaleRate(false);
					labelInfo.setExpiryDate(params.getExpiryDate());
					labelInfo.setPrintExpiry(false);
					labelInfo.setStoreName(params.getStoreName());
					labelInfo.setPrintStoreName(true);
					labelInfo.setStoreCurrency(params.getStoreCurrency());
					labelInfo.setItemCategory(params.getItemCategory());
					labelInfo.setPrintItemCategory(true);
					labelInfo.setItemSubCategory(params.getItemSubCategory());
					labelInfo.setGrpName(params.getGrpName());
					labelInfo.setSize(params.getSize());
					labelInfo.setColour(params.getColour());
					
					labelInfos.add(labelInfo);
				}
			}
		
			BarcodeGenerate barcodeGenerate = new BarcodeGenerate(rootPath, labelInfos);
			barcodeGenerate.printBarcode();
			
			status="success";
			
		} catch (Exception e) {
			status="failure";
			throw new DAOException("Check data to be inserted", e);
			
		} finally {
			/*if (em != null)
				em.close();*/
		}
		
		return status;
	}
	
}
