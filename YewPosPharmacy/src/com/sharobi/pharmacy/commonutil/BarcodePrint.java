package com.sharobi.pharmacy.commonutil;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import javawebparts.core.org.apache.commons.lang.WordUtils;

class BarcodePrint implements Printable {

	SimpleDateFormat df = new SimpleDateFormat();
	String receiptDetailLine;
	public static final String pspace = "               ";// 15-spaces
	Object[] printData = null;
	int storeId;
	private BufferedImage image;
	File f = null;
	Font font = null;
	Font mrpfont = null;
	Font storefont = null;
	int space = 10;
	private LabelInfo labelInfo;
	private HttpServletRequest request;
	
	
	public BarcodePrint(LabelInfo labelInfo, HttpServletRequest req) {
		super();
		this.labelInfo = labelInfo;
		this.request=req;
	}


	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		Graphics2D g2d = (Graphics2D) graphics;
		Graphics2D mrp = (Graphics2D) graphics;

		int h = 0;
		int w = 0;
		int y=0;
		font = new Font("SANSSERIF", Font.PLAIN, 6);
		mrpfont = new Font("SANSSERIF", Font.BOLD, 7);
		storefont = new Font("SANSSERIF", Font.BOLD, 6);
		try {
			g2d.translate(0, pageFormat.getImageableY());
//			g2d.translate(10, pageFormat.getImageableY() - 10);
			g2d.setFont(storefont);
			//g2d.drawString("5999", 30, 18);
			//print item id
			if(labelInfo.isPrintStoreName())
				g2d.drawString(labelInfo.getStoreName(), 5, 10);
			//h= h+10;
			g2d.setFont(font);
			if(labelInfo.isPrintItemName()){
				String ad = WordUtils.wrap(labelInfo.getItemName(), 20);
				String split[] = ad.split("\\n");
				
				for (int k = 0; k < split.length; k++) {
					g2d.drawString(split[k], 5, 18+y);
					if(k<split.length-1)
					y = y + 8;
				}
			}
			

			if (pageIndex < 0 || pageIndex >= 1) {
				return Printable.NO_SUCH_PAGE;
			}

			//print bar code with text
			if (labelInfo.isPrintBarcode()) {
				
				//f = new File("D:/barcode20160817/barcodefinal.png"); // image file
				f=new File(this.request.getRealPath("/") + "/images/"
						+ "barcodefinal.png");
				// path
				image = ImageIO.read(f);
				System.out.println("Reading complete.");
				if (image != null) {
					w = image.getWidth();
					h = image.getHeight();
					/*BufferedImage img = new BufferedImage(w, h,
							BufferedImage.TYPE_INT_ARGB); // Graphics2D g2dImage
					img.createGraphics();*/
					//g2d.drawImage(image, 5, 22+y, null);
					if(labelInfo.getBarcode().length()<=13){
					if(labelInfo.getBarcode().matches("[0-9]+")){
						g2d.drawImage(image, 5,22+y,w-25, h, null);
					}else{
						g2d.drawImage(image, 5,22+y,w-100, h, null);
					}
					}
					/*int paperwidth=(int) pageFormat.getWidth();
					if(pageFormat.getWidth()<w)
					{
						//int paperwidth=(int) pageFormat.getWidth();
						g2d.drawImage(image, 0,0,w-(w-paperwidth), h, null);
					}
					else {
						g2d.drawImage(image,0,0, w, h, null);
					}*/
					
				}
				g2d.translate(0, pageFormat.getImageableY());
				//g2d.drawString("1234567890123", 35, h + 30);
				g2d.drawString(labelInfo.getBarcode(), 35, y+h + 28);
			}
			mrp.setFont(mrpfont);
			//mrp.drawString("M.R.P : 2000.00", 5, h + 40);
			//print item mrp
			if(labelInfo.isPrintMrp())
			mrp.drawString("M.R.P : "+""+labelInfo.getMrp(), 5, y+h + 38);
			g2d.setFont(mrpfont);
			if(labelInfo.isPrintSaleRate())
				mrp.drawString("AED : "+""+labelInfo.getSaleRate(), 15, y+h + 36);
			//print item name
			//if(labelInfo.isPrintItemName())
			//g2d.drawString(labelInfo.getItemName(), 5, h + 50);
			g2d.setFont(font);
			//print item dimensions
			 
			if(labelInfo.isPrintBatch() && labelInfo.isPrintExpiry())
			{
				h=h+40;
				if(labelInfo.getExpiryDate()!=null)
					if(labelInfo.getExpiryDate().length()>0 )
				h=h+10;
				g2d.drawString("Batch : "+""+labelInfo.getBatch(), 5, h+y);
				h=h+10;
				g2d.drawString("Exp : "+""+labelInfo.getExpiryDate(), 5, h+y);
			}
			/*//print store name
			if(labelInfo.isPrintStoreName())
			{
				h= h+10;
				g2d.drawString(labelInfo.getStoreName(), 5, h);
			}*/
			// g2d.drawString("Tel : 033 30306675", 5, h+70);
			// g2d.drawString("E-mail : care@yewpos.com", 5, h+80);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Printable.PAGE_EXISTS;

	}

}