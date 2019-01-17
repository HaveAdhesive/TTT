package com.ttt.empSys.service.impl;

import java.sql.Date;
import java.util.List;

import com.ttt.empSys.dao.IEmpDao;
import com.ttt.empSys.dao.impl.EmpDao;
import com.ttt.empSys.domain.Emp;
import com.ttt.empSys.service.IEmpSysService;

/**
 * 服务接口的实现类
 */
public class EmpSysService implements IEmpSysService {

	IEmpDao dao = new EmpDao();
	
	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		return dao.findEmpByNameAndPassword(name, password);
	}

	@Override
	public List<Emp> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean AddUser(Emp emp) {
		
		return dao.AddUser(emp);
	}

}
