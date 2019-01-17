package com.ttt.empSys.dao;

import java.sql.Date;
import java.util.List;

import com.ttt.empSys.domain.Emp;

/**
 * Emp对象的dao接口
 */
public interface IEmpDao {

	/**
	 * 登录验证，通过姓名和密码来查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name,String password);

	/**
	 * 获取所有员工信息
	 * @return
	 */
	List<Emp> findAll();
	
	/**
	 * 获取注册信息，存入数据库
	 * @return
	 */
	boolean AddUser(Emp emp);
}
