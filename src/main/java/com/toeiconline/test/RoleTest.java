package com.toeiconline.test;

import java.util.ArrayList;
import java.util.List;

import com.toeiconline.dao.RoleDao;
import com.toeiconline.daoimpl.RoleDaoImpl;
import com.toeiconline.persistencedata.RoleEntity;



public class RoleTest {
	
	public void checkFindAll() {
		RoleDao role = new RoleDaoImpl();
		List<RoleEntity> list= role.findAll();
		System.out.println("xong");
	}
	
	public static void main(String[] args) {
		RoleDao role = new RoleDaoImpl();
	List<Integer> arr= new ArrayList<Integer>() ;
	arr.add(2);
	arr.add(3);
		Integer count = role.delete2(3);
		System.out.println("thanh cong");
//		Object object = role.findByProperty("name", "ADMIN", null, null);
//		System.out.println("thanh cong");
	}
}
