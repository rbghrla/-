package MemberCRUD.Controller;

import java.util.HashMap;
import java.util.Map;

import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dao.NotifyDao;
import MemberCRUD.Domain.Dao.NotifyDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;
import MemberCRUD.Domain.Dto.NotifyDto;
import MemberCRUD.Domain.Service.NotifyServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		MemberDaoImpl dao = new MemberDaoImpl();
		
		// Insert
//		dao.Insert(new MemberDto("a1","11111","a1a1","포항시북구",01011111111,"구매자"));
//		dao.Insert(new MemberDto("a2","11112","a2a2","포항시남구",01011112222,"구매자"));
//		dao.Insert(new MemberDto("a3","11113","a3a3","대구광역시서구",01011113333,"판매자"));
//		dao.Insert(new MemberDto("a4","111

		// Delete
//		dao.Delete("a1");
		
		//Select
//		dao.Select("");
		
		

		//SelectAll
//		dao.SelectAll();
		
		//Update
//		MemberDto updateMember = new MemberDto("a5", "11115", "a5a5", "경북경산시", 01011115555, "판매자");
//		dao.Update("a1", updateMember);
		
		
		
		NotifyDao dao = new NotifyDaoImpl();
		
		// Insert
		dao.Insert(new NotifyDto("B1",11111));
		dao.Insert(new NotifyDto("B2",11122));
		dao.Insert(new NotifyDto("B3",11133));
		
		//selectAll
//		dao.SelectAll();
		
		//update
//		NotifyDto updatenotify = new NotifyDto("B4",11122);
//		dao.Update("B2", updatenotify);
		
		
		//delete
//		dao.Delete("B3");
		
		
		
		
		
	}
}
