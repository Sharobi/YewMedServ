package com.sharobi.pharmacy.dashboard.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class Dashboard {
	
	@Expose
	@MapToData(columnAliases={"total_customer"})
	 private int totalCustomer;
	
	@Expose
	@MapToData(columnAliases={"total_product"})
	 private int totalProduct;
	
	@Expose
	@MapToData(columnAliases={"total_vendor"})
	 private int totalVendor;
	
	@Expose 
	@MapToData(columnAliases={"sale_total_amount"})
	private double saleTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"purchase_total_amount"})
	private double purchaseTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"sale_return_total_amount"})
	private double saleReturnTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"purchase_return_total_amount"})
	private double purchaseReturnTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"valuation"})
	private double valuation;
	
	@Expose 
	@MapToData(columnAliases={"stockqty"})
	private String stockqty;
	
	@Expose 
	@MapToData(columnAliases={"cash_in_hand_cr"})
	private double cashInHandCr;
	
	@Expose 
	@MapToData(columnAliases={"cash_in_hand_dr"})
	private double cashInHandDr;
	
	@Expose 
	@MapToData(columnAliases={"cash_in_bank_cr"})
	private double BankAmtCr;
	
	@Expose 
	@MapToData(columnAliases={"cash_in_bank_dr"})
	private double BankAmtDr;
	
	@Expose 
	@MapToData(columnAliases={"total_sale_cash_amount"})
	private double totalSaleCashAmount;
	
	@Expose 
	@MapToData(columnAliases={"total_sale_card_amount"})
	private double totalSaleCardAmount;
	
	@Expose 
	@MapToData(columnAliases={"total_sale_credit_amount"})
	private double totalSaleCreditAmount;
	
	@Expose 
	@MapToData(columnAliases={"purchase_order_total_amount"})
	private double purchaseOrderTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"purchase_inv_total_amount"})
	private double purchaseInvTotalAmount;
	
	@Expose 
	@MapToData(columnAliases={"total_purchase"})
	private int totalPurchase;
	
	@Expose 
	@MapToData(columnAliases={"total_sale"})
	private int totalSale;
	
	@Expose 
	@MapToData(columnAliases={"total_purchase_return"})
	private int totalPurchaseReturn;
	
	@Expose 
	@MapToData(columnAliases={"total_sale_return"})
	private int totalSaleReturn;
	
	@Expose 
	@MapToData(columnAliases={"total_purchase_inv"})
	private int totalPurchaseInv;
	
	@Expose 
	@MapToData(columnAliases={"total_purchase_order"})
	private int totalPurchaseOrder;
	
	@Expose 
	@MapToData(columnAliases={"duties_and_taxes_cr"})
	private double taxAndDutiesCr;
	
	@Expose 
	@MapToData(columnAliases={"duties_and_taxes_dr"})
	private double taxAndDutiesDr;
	
	@Expose 
	@MapToData(columnAliases={"profit_n_loss"})
	private double profitAndLoss;
	
	public Dashboard() { }
	
	public int getTotalCustomer() {
		return totalCustomer;
	}

	public void setTotalCustomer(int totalCustomer) {
		this.totalCustomer = totalCustomer;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	public int getTotalVendor() {
		return totalVendor;
	}

	public void setTotalVendor(int totalVendor) {
		this.totalVendor = totalVendor;
	}

	public double getSaleTotalAmount() {
		return saleTotalAmount;
	}

	public void setSaleTotalAmount(double saleTotalAmount) {
		this.saleTotalAmount = saleTotalAmount;
	}

	public double getPurchaseTotalAmount() {
		return purchaseTotalAmount;
	}

	public void setPurchaseTotalAmount(double purchaseTotalAmount) {
		this.purchaseTotalAmount = purchaseTotalAmount;
	}

	public double getSaleReturnTotalAmount() {
		return saleReturnTotalAmount;
	}

	public void setSaleReturnTotalAmount(double saleReturnTotalAmount) {
		this.saleReturnTotalAmount = saleReturnTotalAmount;
	}

	public double getPurchaseReturnTotalAmount() {
		return purchaseReturnTotalAmount;
	}

	public void setPurchaseReturnTotalAmount(double purchaseReturnTotalAmount) {
		this.purchaseReturnTotalAmount = purchaseReturnTotalAmount;
	}

	public double getValuation() {
		return valuation;
	}

	public void setValuation(double valuation) {
		this.valuation = valuation;
	}


	public String getStockqty() {
		return stockqty;
	}

	public void setStockqty(String stockqty) {
		this.stockqty = stockqty;
	}

	public double getCashInHandCr() {
		return cashInHandCr;
	}

	public void setCashInHandCr(double cashInHandCr) {
		this.cashInHandCr = cashInHandCr;
	}

	public double getCashInHandDr() {
		return cashInHandDr;
	}

	public void setCashInHandDr(double cashInHandDr) {
		this.cashInHandDr = cashInHandDr;
	}

	public double getBankAmtCr() {
		return BankAmtCr;
	}

	public void setBankAmtCr(double bankAmtCr) {
		BankAmtCr = bankAmtCr;
	}

	public double getBankAmtDr() {
		return BankAmtDr;
	}

	public void setBankAmtDr(double bankAmtDr) {
		BankAmtDr = bankAmtDr;
	}

	public double getTotalSaleCashAmount() {
		return totalSaleCashAmount;
	}

	public void setTotalSaleCashAmount(double totalSaleCashAmount) {
		this.totalSaleCashAmount = totalSaleCashAmount;
	}

	public double getTotalSaleCardAmount() {
		return totalSaleCardAmount;
	}

	public void setTotalSaleCardAmount(double totalSaleCardAmount) {
		this.totalSaleCardAmount = totalSaleCardAmount;
	}

	public double getTotalSaleCreditAmount() {
		return totalSaleCreditAmount;
	}

	public void setTotalSaleCreditAmount(double totalSaleCreditAmount) {
		this.totalSaleCreditAmount = totalSaleCreditAmount;
	}

	public double getPurchaseOrderTotalAmount() {
		return purchaseOrderTotalAmount;
	}

	public void setPurchaseOrderTotalAmount(double purchaseOrderTotalAmount) {
		this.purchaseOrderTotalAmount = purchaseOrderTotalAmount;
	}

	public double getPurchaseInvTotalAmount() {
		return purchaseInvTotalAmount;
	}

	public void setPurchaseInvTotalAmount(double purchaseInvTotalAmount) {
		this.purchaseInvTotalAmount = purchaseInvTotalAmount;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}

	public int getTotalPurchaseReturn() {
		return totalPurchaseReturn;
	}

	public void setTotalPurchaseReturn(int totalPurchaseReturn) {
		this.totalPurchaseReturn = totalPurchaseReturn;
	}

	public int getTotalSaleReturn() {
		return totalSaleReturn;
	}

	public void setTotalSaleReturn(int totalSaleReturn) {
		this.totalSaleReturn = totalSaleReturn;
	}

	public int getTotalPurchaseInv() {
		return totalPurchaseInv;
	}

	public void setTotalPurchaseInv(int totalPurchaseInv) {
		this.totalPurchaseInv = totalPurchaseInv;
	}

	public int getTotalPurchaseOrder() {
		return totalPurchaseOrder;
	}

	public void setTotalPurchaseOrder(int totalPurchaseOrder) {
		this.totalPurchaseOrder = totalPurchaseOrder;
	}

	public double getTaxAndDutiesCr() {
		return taxAndDutiesCr;
	}

	public void setTaxAndDutiesCr(double taxAndDutiesCr) {
		this.taxAndDutiesCr = taxAndDutiesCr;
	}

	public double getTaxAndDutiesDr() {
		return taxAndDutiesDr;
	}

	public void setTaxAndDutiesDr(double taxAndDutiesDr) {
		this.taxAndDutiesDr = taxAndDutiesDr;
	}

	public double getProfitAndLoss() {
		return profitAndLoss;
	}

	public void setProfitAndLoss(double profitAndLoss) {
		this.profitAndLoss = profitAndLoss;
	}

	@Override
	public String toString() {
		return "Dashboard [totalCustomer=" + totalCustomer + ", totalProduct=" + totalProduct + ", totalVendor="
				+ totalVendor + ", saleTotalAmount=" + saleTotalAmount + ", purchaseTotalAmount=" + purchaseTotalAmount
				+ ", saleReturnTotalAmount=" + saleReturnTotalAmount + ", purchaseReturnTotalAmount="
				+ purchaseReturnTotalAmount + ", valuation=" + valuation + ", stockqty=" + stockqty + ", cashInHandCr="
				+ cashInHandCr + ", cashInHandDr=" + cashInHandDr + ", BankAmtCr=" + BankAmtCr + ", BankAmtDr="
				+ BankAmtDr + ", totalSaleCashAmount=" + totalSaleCashAmount + ", totalSaleCardAmount="
				+ totalSaleCardAmount + ", totalSaleCreditAmount=" + totalSaleCreditAmount
				+ ", purchaseOrderTotalAmount=" + purchaseOrderTotalAmount + ", purchaseInvTotalAmount="
				+ purchaseInvTotalAmount + ", totalPurchase=" + totalPurchase + ", totalSale=" + totalSale
				+ ", totalPurchaseReturn=" + totalPurchaseReturn + ", totalSaleReturn=" + totalSaleReturn
				+ ", totalPurchaseInv=" + totalPurchaseInv + ", totalPurchaseOrder=" + totalPurchaseOrder
				+ ", taxAndDutiesCr=" + taxAndDutiesCr + ", taxAndDutiesDr=" + taxAndDutiesDr + ", profitAndLoss="
				+ profitAndLoss + "]";
	}

}
