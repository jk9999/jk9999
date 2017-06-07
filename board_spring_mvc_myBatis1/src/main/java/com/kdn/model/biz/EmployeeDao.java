package com.kdn.model.biz;
import java.util.List;
import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;
import java.sql.Connection;
import java.sql.SQLException;
public interface EmployeeDao {
	public void add(Employee emp);
	public void update(Employee emp);
	public void remove(String empno);
	public Employee search(String empno);
	public List<Employee> searchAll(PageBean bean);
	public int getCount(PageBean bean);
}
