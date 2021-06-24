package com.construction.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.construction.entity.Role;
import com.construction.service.RoleService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleServiceTest {
	static Long testerRoleId;
	static Role testerRole;
	static Role staffRole;
	
	@BeforeAll
	static void setUp() throws Exception {
		testerRole = new Role("TESTER");
		staffRole = new Role("STAFF");
	}
	
	@Autowired
	private RoleService service;
	
	@Test
	@Order(1)
	void testSave() {
		assertNull(testerRole.getId());
		assertNull(staffRole.getId());
		
		service.save(testerRole);
		testerRoleId = testerRole.getId();
		assertNotNull(testerRoleId);
		
		service.save(staffRole);
		assertNotNull(staffRole.getId());
	}
	
	// Only testing for testerRole
	@Test
	@Order(2)
	void testGetById() {
		Role expectedRole = new Role("TESTER");
		expectedRole.setId(testerRoleId);
		assertEquals(expectedRole, service.getById(testerRoleId));
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		// USER and ADMIN will be in database by default using .sql file
		Role userRole = new Role("USER");
		userRole.setId(1L);
		Role adminRole = new Role("ADMIN");
		adminRole.setId(2L);
		
		Role expectedTesterRole = new Role("TESTER");
		expectedTesterRole.setId(testerRoleId);;
		Role expectedStaffRole = new Role("STAFF");
		expectedStaffRole.setId(staffRole.getId());
		List<Role> expectedRoles = 
				Arrays.asList(userRole, adminRole, expectedTesterRole, expectedStaffRole);
		
		for (int i = 0; i < expectedRoles.size(); i++) {
			assertEquals(expectedRoles.get(i), service.getAll().get(i));
		}
		
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		Role expectedRole = new Role("QA Tester");
		expectedRole.setId(testerRoleId);
		service.update(expectedRole);
		
		assertEquals("QA Tester", service.getById(testerRoleId).getName());
	}
	
	// Only testing for testerRole
	@Test
	@Order(5)
	void testDeleteById() {
		service.deleteById(testerRoleId);
		assertThrows(NoSuchElementException.class, 
				() -> service.getById(testerRoleId));
	}
	
	@Test
	@Order(6)
	void testDelete() {
		service.delete(staffRole);
		assertThrows(NoSuchElementException.class, 
				() -> service.getById(staffRole.getId()));
	}

}
