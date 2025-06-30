package in.sp.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.exception.UserIsNotFoundException;
import in.sp.main.repositories.UserRepository;

@Service
//@Lazy
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserByID(int id) {
		if (userRepository.findById(id).isEmpty())
			throw new UserIsNotFoundException("Requested User Is Not Exist");
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUserData() {
		if (userRepository.findAll().isEmpty())
			throw new UserIsNotFoundException("There is no data in database");
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new UserIsNotFoundException("User Is Not Present in Database");
		}
	}

}
