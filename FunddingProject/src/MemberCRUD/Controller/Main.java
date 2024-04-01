package MemberCRUD.Controller;

import java.util.HashMap;
import java.util.Map;

import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;

public class Main {

	public static void main(String[] args) throws Exception {
		
		MemberDaoImpl dao = new MemberDaoImpl();
		
		// Insert
//		dao.Insert(new MemberDto("a1","11111","a1a1","포항시북구",01011111111,"구매자"));
//		dao.Insert(new MemberDto("a2","11112","a2a2","포항시남구",01011112222,"구매자"));
//		dao.Insert(new MemberDto("a3","11113","a3a3","대구광역시서구",01011113333,"판매자"));
//		dao.Insert(new MemberDto("a4","11114","a4a4","대구광역시중구",01011114444,"판매자"));
		
		// Delete
//		dao.Delete("aaa");
		
		//Select
//		dao.Select("bbb");

		//SelectAll
//		dao.SelectAll();
		
		
		
	}
}
