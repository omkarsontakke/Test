package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.main.entities.AddAccount;

public interface AccountRepository extends JpaRepository<AddAccount, Integer>{

}
