package com.sharobi.pharmacy.commonutil;


import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;


public class BarcodeGenerate {

private List<LabelInfo> labelInfos;
	
	private JasperReport report;

	public BarcodeGenerate(String path, List<LabelInfo> labelInfos) {
		super();
		this.labelInfos = labelInfos;

		// Barcode Jasper report
        try {
			//report = (JasperReport) JRLoader.loadObject(new File(path + "/" + "jasper" + "/" + "procurement" + "/" + "barcodeds.jasper"));
			
			//old script
			//report = JasperCompileManager.compileReport(path + "/" + "jasper" + "/" + "procurement" + "/" + "barcode3cols.jrxml");
			report = JasperCompileManager.compileReport(
					path + "/" + "jasper" + "/" + "procurement" + "/" + "barcodeds.jrxml");

		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public void printBarcode() {
		
		Map<String, Object> parameters = new HashMap<String,Object>();
		//parameters.put("w_purchaseId", "346");
		parameters.put("itemList", labelInfos);
		
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            //PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService selectedService = PrintServiceLookup.lookupDefaultPrintService();

            if(selectedService != null)  {

                PrinterJob.getPrinterJob().setPrintService(selectedService);
                
                // Actual print
                JRPrintServiceExporter exporter = new JRPrintServiceExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                 //We set the selected service and pass it as a paramenter 
                
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, selectedService);
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, selectedService.getAttributes());
                
                exporter.exportReport();

                System.out.println(">>>>>>>>>>>>>>>> Printing results: " + "printStatus");
            }
            
		} catch (JRException e) {
			e.printStackTrace();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
	}

	

}