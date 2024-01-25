package dto;

import java.time.LocalDateTime;

public class TransactionDTO {
	private String txnId;
    private LocalDateTime txnDateTime;
    private double txnAmount;
    private String txnType;
    private String txnStatus;
    private String sourceAcctId;
    private String targetAcctId;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
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
	public String getSourceAcctId() {
		return sourceAcctId;
	}
	public void setSourceAcctId(String sourceAcctId) {
		this.sourceAcctId = sourceAcctId;
	}
	public String getTargetAcctId() {
		return targetAcctId;
	}
	public void setTargetAcctId(String targetAcctId) {
		this.targetAcctId = targetAcctId;
	}
    
    
    

}
