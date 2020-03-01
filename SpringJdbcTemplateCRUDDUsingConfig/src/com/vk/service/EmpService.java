package com.vk.service;

import java.util.List;

import com.vk.model.Emp;

public interface EmpService {

	public int save(Emp p);
	public int update(Emp p);
	public int delete(int id);
	public Emp getEmpById(int id);
	public List<Emp> getEmployees();
}
