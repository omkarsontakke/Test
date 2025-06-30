package in.sp.main.services;



import java.util.List;

import org.springframework.http.ResponseEntity;

import in.sp.main.entities.AddAccount;
import in.sp.main.entities.User;

public interface UserService {
	public User createUser(User user);
	public User getUserByID(int id);
	public List<User> getAllUserData();
	public void deleteUserById(int id);
}
