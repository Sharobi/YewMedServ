package com.sharobi.pharmacy.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmailBean implements Serializable{

    private static final long serialVersionUID = 1L;

   
    private String toAddr;
    private String subject;
    private String messageBody;
    private String isAttachment;	// Y/N
    private String transType;
    private int transId;
    private String flag;
    private int storeId;
    private int companyId;
    private int finYrId;
    private String fromAddr;
    private String mailPwd;
    private String mailPort;
    private String mailSmtp;
    private String cc;
    private byte[] attchmntData;
    
     
	public byte[] getAttchmntData() {
		return attchmntData;
	}
	public void setAttchmntData(byte[] attchmntData) {
		this.attchmntData = attchmntData;
	}
	public String getFromAddr() {
		return fromAddr;
	}
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}
	public String getMailPwd() {
		return mailPwd;
	}
	public void setMailPwd(String mailPwd) {
		this.mailPwd = mailPwd;
	}
	public String getMailPort() {
		return mailPort;
	}
	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}
	public String getMailSmtp() {
		return mailSmtp;
	}
	public void setMailSmtp(String mailSmtp) {
		this.mailSmtp = mailSmtp;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getFinYrId() {
		return finYrId;
	}
	public void setFinYrId(int finYrId) {
		this.finYrId = finYrId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getToAddr() {
		return toAddr;
	}
	public void setToAddr(String toAddr) {
		this.toAddr = toAddr;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getIsAttachment() {
		return isAttachment;
	}
	public void setIsAttachment(String isAttachment) {
		this.isAttachment = isAttachment;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
  
    
}

/**
 * rajarshi
 */
