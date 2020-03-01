package com.vk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dao.EmpDao;
import com.vk.model.Emp;
import com.vk.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empdao;
	
	
	@Override
	public int save(Emp p) {
		// TODO Auto-generated method stub
		return empdao.save(p);
	}

	@Override
	public int update(Emp p) {
		// TODO Auto-generated method stub
		return empdao.update(p);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return empdao.delete(id);
	}

	@Override
	public Emp getEmpById(int id) {
		// TODO Auto-generated method stub
		return empdao.getEmpById(id);
	}

	@Override
	public List<Emp> getEmployees() {
		// TODO Auto-generated method stub
		return empdao.getEmployees();
	}

}
