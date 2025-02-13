package rentalcar.com.service;

import java.util.List;

import rentalcar.com.entity.Account;
import rentalcar.com.entity.Brand;
import rentalcar.com.entity.Role;
import rentalcar.com.entity.RoleDetail;

public interface AccountService {

	List<Account> findAll();
	
	Account findByUsername(String username);
	
	Account save(Account account);
	
	void deleteByUsername(String username);

	boolean existsById(String username);

	List<Account> findByFullname(String fullname);

	List<Role> findAllRole();

	List<RoleDetail> findAllAuthorities();

	RoleDetail saveRoleDetail(RoleDetail authority);

	void deleteRoleDetail(Long id);

	List<Account> findByUsernameLike(String username);

	Long countCustomer(String role);
	

}
