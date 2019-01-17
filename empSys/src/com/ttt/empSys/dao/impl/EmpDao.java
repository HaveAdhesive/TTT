package com.ttt.empSys.dao.impl;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.Statement;
import com.ttt.empSys.dao.IEmpDao;
import com.ttt.empSys.domain.Emp;
import com.ttt.empSys.util.C3p0DBUtils;

/**
 * dao接口的实现类
 */
public class EmpDao implements IEmpDao {

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		
		QueryRunner runner = new QueryRunner(C3p0DBUtils.getDataSource());
		
		try {
			return runner.query("select * from emp where name=? and password=?", new BeanHandler<Emp>(Emp.class),name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Emp> findAll() {
		QueryRunner runner = new QueryRunner(C3p0DBUtils.getDataSource());
		
		try {
			return runner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean AddUser(Emp emp) {
		QueryRunner runner = new QueryRunner(C3p0DBUtils.getDataSource());

		try {
			int update = runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)",emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHirdate(),emp.getSalary(),emp.getPassword(),emp.getEmali());
			if(update != 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
