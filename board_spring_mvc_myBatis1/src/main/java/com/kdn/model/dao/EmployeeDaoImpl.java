package com.kdn.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdn.model.biz.EmployeeDao;
import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	public SqlSessionTemplate session;

	@Override
	public void add(Employee emp) {
		session.insert("employee.insert", emp);
	}

	@Override
	public void update(Employee emp) {
		session.update("employee.update", emp);
	}

	@Override
	public void remove(String empno) {
		session.delete("employee.delete", empno);
	}

	@Override
	public Employee search(String empno) {
		return session.selectOne("employee.search", empno);
	}

	@Override
	public List<Employee> searchAll(PageBean bean) {
		RowBounds rows = new RowBounds(bean.getStart() - 1, bean.getInterval());
		return session.selectList("employee.searchAll", bean, rows);
	}

	@Override
	public int getCount(PageBean bean) {
		return session.selectOne("board.getCount", bean);
	}
}