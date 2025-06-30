package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.AddAccount;

public interface AccountService {
	public AddAccount createAccount(AddAccount addAccount);

	public List<AddAccount> getAllAccount();

	public AddAccount getAccountByID(int id);

	public AddAccount updateBalance(int id, AddAccount updateAccount);

	public void deleteAccount(int id);

	public AddAccount withdraAmount(int id, long withdrawAmount);

}
