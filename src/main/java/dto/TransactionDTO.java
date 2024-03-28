package dto;

import java.util.Date;

public class TransactionDTO {
	private int transactionID;
	private int sourceAcctID;
    private int targetAcctID;
    private double amount;
    private String transactionType;
    private Date transactionDate;
	

    public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
 
	public TransactionDTO(int sourceAcctID, int targetAcctID, double amount, String transactionType) {
		super();
		this.sourceAcctID = sourceAcctID;
		this.targetAcctID = targetAcctID;
		this.amount = amount;
		this.transactionType = transactionType;
	}

 
	
	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	public int getSourceAcctID() {
		return sourceAcctID;
	}
	public void setSourceAcctID(int sourceAcctID) {
		this.sourceAcctID = sourceAcctID;
	}
	public int getTargetAcctID() {
		return targetAcctID;
	}
	public void setTargetAcctID(int targetAcctID) {
		this.targetAcctID = targetAcctID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
   
    
    
    
   

}
