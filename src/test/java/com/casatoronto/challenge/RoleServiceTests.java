package com.casatoronto.challenge;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casatoronto.challenge.model.Role;
import com.casatoronto.challenge.model.RoleName;
import com.casatoronto.challenge.service.RoleService;

@SpringBootTest
class RoleServiceTests {

	@Autowired
	private RoleService service;

	@Test
	void testNights01() {
		Role role = service.insert(new Role(RoleName.ROLE_ADMIN)).get();

		assertEquals(RoleName.ROLE_ADMIN, role.getName());
	}

	@Test
	void testNights02() {
		Role role = service.insert(new Role(RoleName.ROLE_USER)).get();

		assertEquals(RoleName.ROLE_USER, role.getName());
	}
}
