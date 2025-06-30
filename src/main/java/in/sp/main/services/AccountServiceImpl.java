package in.sp.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import in.sp.main.entities.AddAccount;
import in.sp.main.exception.UserIsNotFoundException;
import in.sp.main.repositories.AccountRepository;


@Service
//@Lazy
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	//Method to create the account of the user
	@Override
	public AddAccount createAccount(AddAccount addAccount) {
		return accountRepository.save(addAccount);		
	}

	//Method for Updating the existing user data
	@Override
	public AddAccount updateBalance(int id, AddAccount updateAccount) {
		AddAccount userData =  accountRepository.findById(id).orElse(null);
		
		if(userData != null) {
			return accountRepository.save(updateAccount);
		}else {
			throw new RuntimeException("User Not Found "+id);
		}
		
	}
	
	//Method for Deleting the Account based on the ID
	@Override
	public void deleteAccount(int id) {
		AddAccount userAccountDelete =  accountRepository.findById(id).orElse(null);
		
		if(userAccountDelete != null) {
			accountRepository.deleteById(id);
		}else {
			throw new RuntimeException("User Not Found "+id);
		}
		
	}

	//Method for getting the all Account Users Data
	@Override
	public List<AddAccount> getAllAccount() {
		return accountRepository.findAll();
	}

	//method for the withadraw money based on the thier id and update the balance 
	@Override
	public AddAccount withdraAmount(int id, long withdrawAmount) {
		AddAccount userData =  accountRepository.findById(id).orElse(null);
		long currentBalance = userData.getBalance();
		if(withdrawAmount < 0 || withdrawAmount==0){
			throw new UserIsNotFoundException("Invalid Amount");
		}
		else if(withdrawAmount > currentBalance) {
				throw new UserIsNotFoundException("Insufficient Balance");
		}
		long newBalance = currentBalance - withdrawAmount;
		userData.setBalance(newBalance);
		return accountRepository.save(userData);
	}
	
	
	//Getting Details of Account based on their ID
	@Override
	public AddAccount getAccountByID(int id) {
		if(accountRepository.findById(id).isEmpty())
			throw new UserIsNotFoundException("Requested Account Is Not Exist");
		return accountRepository.findById(id).get();
	}

}
