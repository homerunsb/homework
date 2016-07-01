package org.tacademy.webdata.test;

import org.tacademy.webdata.dao.AnMemberDAO;
import org.tacademy.webdata.vo.AnMemberVO;

public class AnMemberTest {

	public AnMemberTest() {
		AnMemberDAO dao = new AnMemberDAO();
		AnMemberVO vo = new AnMemberVO();
		vo.setId("abc2");
		//vo.setPw("1234");
		
		if(dao.doCheck(vo)){
			System.out.println("ID 있음");
		}else{
			System.out.println("ID 없음");
		}
	}

	public static void main(String[] args) {
		new AnMemberTest();
	}
}
