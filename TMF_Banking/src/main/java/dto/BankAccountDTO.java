package dto;
public class BankAccountDTO {
	 
	private int accountID;
	private String username;
	private String account_no;
	private String bank_name;
	private String IFSC_code;
	private String account_type;
	private double current_balance;
	
	
	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankAccountDTO(String username, String account_no, String bank_name, String iFSC_code, String account_type,
			double current_balance) {
		super();
		this.username = username;
		this.account_no = account_no;
		this.bank_name = bank_name;
		IFSC_code = iFSC_code;
		this.account_type = account_type;
		this.current_balance = current_balance;
	}









	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}
	
	
	
	
}
