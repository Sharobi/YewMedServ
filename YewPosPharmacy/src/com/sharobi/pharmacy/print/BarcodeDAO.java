package com.sharobi.pharmacy.print;

import java.sql.Connection;
import com.sharobi.pharmacy.commonutil.BarcodePrintParam;
import com.sharobi.pharmacy.commonutil.BarcodePrintParamList;
import com.sharobi.pharmacy.exceptions.DAOException;



public interface BarcodeDAO {

	public String generateAndPrintBarcode(BarcodePrintParam params, String rootPath, Connection connection) throws DAOException;

	public String generateAndPrintBarcodeAll(BarcodePrintParamList paramsList, String rootPath, Connection connection) throws DAOException;

}
