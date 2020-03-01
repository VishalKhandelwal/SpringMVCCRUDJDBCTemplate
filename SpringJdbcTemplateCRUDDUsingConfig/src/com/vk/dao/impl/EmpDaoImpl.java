package com.vk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vk.dao.EmpDao;
import com.vk.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public int save(Emp p) {
		String sql = "insert into emp99(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";
		System.err.println(sql);
		return template.update(sql);
	}

	@Override
	public int update(Emp p) {
		String sql = "update emp99 set name='"+p.getName()+"',salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";
		System.err.println(sql);
		return template.update(sql);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from emp99 where id = "+id+"";
		System.err.println(sql);
		return template.update(sql);
	}

	@Override
	public Emp getEmpById(int id) {
		String sql = "select * from emp99 where id=?";
		System.err.println(sql);
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Emp.class));
	}

	@Override
	public List<Emp> getEmployees() {
		return template.query("select * from emp99", new RowMapper<Emp>() {
			@Override
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

}
