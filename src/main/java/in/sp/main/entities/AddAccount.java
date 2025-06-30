package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AddAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String accountHolder_Name;
	
	@Column
	private String account_Type;
	
	@Column
	private int IFSC_Code;
	
	@Column
	private String branch_Name;
	
	@Column
	private long balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountHolder_Name() {
		return accountHolder_Name;
	}
	public void setAccountHolder_Name(String accountHolder_Name) {
		this.accountHolder_Name = accountHolder_Name;
	}
	public String getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}
	public int getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(int iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
