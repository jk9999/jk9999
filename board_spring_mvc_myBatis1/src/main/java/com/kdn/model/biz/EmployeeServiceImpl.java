package com.kdn.model.biz;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kdn.model.biz.EmployeeDao;
import com.kdn.model.dao.EmployeeDaoImpl;
import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.UpdateException;
import com.kdn.util.DBUtil;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao dao;

	@Override
	public void add(Employee emp) {
		try {
			String empno = emp.getEmpno();
			Employee find = dao.search(emp.getEmpno());
			if (find != null) {
				String msg = String.format("사원 번호 %s번은 등록되어있는 사원번호입니다.", empno);
				throw new UpdateException(msg);
			}
			dao.add(emp);
		} catch (Exception e) {
			throw new UpdateException("사원정보 등록 중 오류 발생");
		}
	}

	@Override
	public void update(Employee emp) {
		try {
			//			System.out.println("employee<<<"+emp);
			//			String empno = emp.getEmpno();
			//			System.out.println("empno<<<"+empno);
			//			Employee find = dao.search(empno);
			Employee find = dao.search(emp.getEmpno());
			System.out.println("empno<<<" + find);
			if (find == null) {
				//				String msg = String.format("사원 번호 %s번은 등록되어있지 않은 사원번호입니다.", empno);
				//				throw new UpdateException("msg");
				throw new UpdateException("아이디에 해당하는 사원이 없어 수정할 수 없습니다.");
			}
			System.out.println("employee<<<" + emp);
			dao.update(emp);
		} catch (Exception e) {
			throw new UpdateException("사원정보 갱신 중 오류 발생");
		}
	}

	@Override
	public void remove(String empno) {
		try {
			Employee find = dao.search(empno);
			if (find == null) {
				String msg = String.format("사원 번호 %s번은 등록되어있지 않은 사원번호입니다..",
						empno);
				throw new UpdateException(msg);
			}
			dao.remove(empno);
		} catch (Exception e) {
			throw new UpdateException("사원정보 삭제 중 오류 발생");
		}
	}

	@Override
	public Employee search(String empno) {
		try {
			Employee find = dao.search(empno);
			if (find == null) {
				String msg = String.format("사원 번호 %s번은 등록되어있지 않은 사원번호입니다.",
						empno);
				throw new UpdateException(msg);
			}
			return find;
		} catch (Exception e) {
			throw new UpdateException("사원정보 검색 중 오류 발생");
		}
	}

	@Override
	public List<Employee> searchAll(PageBean bean) {
		try {
			int total = dao.getCount(bean);
			System.out.println(total);
			return dao.searchAll(bean);
		} catch (Exception e) {
			throw new UpdateException("사원정보 검색 중 오류 발생");
		}
	}

	public boolean login(String empno) {
		Employee employee = null;
		try {
			employee = dao.search(empno);
		} catch (Exception s) {
			throw new UpdateException("DB 서버 오류");
		}
		if (employee == null) {
			throw new UpdateException("해당하는 아이디는 존재하지 않습니다.");
		}
		//		if(empno ==null || !passwrod.equals(empno.getPassword())){
		//			throw new UpdateException("비밀번호가 맞지 않습니다.");
		//		}
		//		if(empno.getWithdraw().equals("Y")){
		//			throw new UpdateException("탈퇴한 회원 아이디입니다.");
		//		}
		return true;
	}
}
