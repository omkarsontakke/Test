package in.sp.main.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entities.AddAccount;
import in.sp.main.entities.User;
import in.sp.main.services.AccountService;
import in.sp.main.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class MyCntroller {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;
	
	Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {
		logger.info("Inside User");
		return userService.createUser(user);
	}
	@PostMapping("/test")
	public String userTesting() {
		return "Success";
	}

	@GetMapping("getUserByID/{id}")
	public User getUserByID(@PathVariable int id) {
		return userService.getUserByID(id);
	}

	@GetMapping("/getAllUserDetails")
	public List<User> getMethodName() {
		return userService.getAllUserData();
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserByID(@PathVariable int id) {
		userService.deleteUserById(id);
		
	}

//-------------------------------------------------------------------------------------------

	@PostMapping("/addaccount")
	public AddAccount addUserDetails(@RequestBody AddAccount addAccount) {
		return accountService.createAccount(addAccount);
	}

	@PutMapping("/addaccount/{id}")
	public ResponseEntity<AddAccount> updateUserDetails(@PathVariable int id, @RequestBody AddAccount addAccount) {
		AddAccount accountUpdate = accountService.updateBalance(id, addAccount);

		if (accountUpdate != null) {
			return ResponseEntity.ok(accountUpdate);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/deleteaccounts/{id}")
	public ResponseEntity<Void> deleteUserDetails(@PathVariable int id) {

		accountService.deleteAccount(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getallaccounts")
	public List<AddAccount> getAllDetails() {
		return accountService.getAllAccount();
	}

	// Getting Account Details by ID
	@GetMapping("/getaccount/{id}")
	public AddAccount getAccountByID(@PathVariable int id) {
		return accountService.getAccountByID(id);
	}

	@PutMapping("/withdraAmount/{id}/{amount}")
	public AddAccount withdraAmount(@PathVariable int id, @PathVariable long amount) {
		System.out.println("Run");
		return accountService.withdraAmount(id, amount);
	}

}
