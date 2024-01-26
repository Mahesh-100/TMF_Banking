package dto;

import java.time.LocalDateTime;

public class TransactionDTO {
	


	private LocalDateTime txnDateTime;
    private double txnAmount;
    private String txnType;
    private String txnStatus;
    private int sourceAcctId;
    private int targetAcctId;
	
    
    private int txnId;
    public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public int getSourceAcctId() {
		return sourceAcctId;
	}
	public void setSourceAcctId(int sourceAcctId) {
		this.sourceAcctId = sourceAcctId;
	}
	public int getTargetAcctId() {
		return targetAcctId;
	}
	public void setTargetAcctId(int targetAcctId) {
		this.targetAcctId = targetAcctId;
	}
    
    public LocalDateTime getTxnDateTime() {
		return txnDateTime;
	}
	public void setTxnDateTime(LocalDateTime txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	public double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}
	
    
	public String toString() {
        return "Transaction{" +
                "txnId='" + txnId + '\'' +
                ", txnDateTime=" + txnDateTime +
                ", txnAmount=" + txnAmount +
                ", txnType='" + txnType + '\'' +
                ", txnStatus='" + txnStatus + '\'' +
                ", sourceAcctId='" + sourceAcctId + '\'' +
                ", targetAcctId='" + targetAcctId + '\'' +
                '}'; 
	}

}
