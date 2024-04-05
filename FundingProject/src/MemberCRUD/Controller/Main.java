package MemberCRUD.Controller;

import java.util.HashMap;
import java.util.Map;

import MemberCRUD.Domain.Dao.MemberDao;
import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dao.NotifyDao;
import MemberCRUD.Domain.Dao.NotifyDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;
import MemberCRUD.Domain.Dto.NotifyDto;
import MemberCRUD.Domain.Service.MemberService;
import MemberCRUD.Domain.Service.MemberServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		MemberDao dao = MemberDaoImpl.getInstance();
		
		// Insert
//		dao.Insert(new MemberDto("a1","11111","a1a1","포항시북구",01011111111,"구매자"));
//		dao.Insert(new MemberDto("a2","11112","a2a2","포항시남구",01011112222,"구매자"));
//		dao.Insert(new MemberDto("a3","11113","a3a3","대구광역시서구",01011113333,"판매자"));
//		dao.Insert(new MemberDto("a4","11114","a4a4","대구광역시중구",01011114444,"판매자"));
		
		//Select
//		dao.Select("a1");
		
		//SelectAll
//		dao.SelectAll();

		//Update
//		MemberDto updateMember = new MemberDto("a5", "11115", "a5a5", "경북경산시", 01011115555, "판매자");
//		dao.Update("a4", updateMember);

		// Delete
//		dao.Delete("a1");
		
		// 회원가입 TEST
//		MemberService service = MemberServiceImpl.getInstance();
//		service.MemberJoin( new MemberDto("a1","11111","a1a1","포항시북구",01011111111,"구매자") );
	
		// 11
//		MemberService service =  MemberServiceImpl.getInstance();
//		 로그인 실패 : 존재하지 않는 계정
//		Map<String,Object> islogin1 = service.login("user5","1234",0);
//		System.out.println("islogin1 : " + islogin1);
		
//		// 로그인 실패 : 계정은 존재하나 패스워드 불일치
//		Map<String,Object> islogin2 = service.login("a1","1235",0);
//		System.out.println("islogin2 : " + islogin2);
//		
//		// 로그인 성공 : 계정도 존재하고 패스워드도 일치	// 이 부분 비교해보기 (강사님꺼랑)!!!!
//		Map<String,Object> islogin3 = service.login("a1","11111",0);
//		System.out.println("islogin3 : " + islogin3);
//		
//		Integer mySessionId = (Integer)islogin3.get("sessionId");
//////		// 로그인 실패 : 기존 로그인된 계정이 존재
//		Map<String,Object> islogin4 = service.login("a1","11111",mySessionId);
//		System.out.println("islogin4 : " + islogin4);
//		
//		//로그아웃
//		Map<String,Object> isLogout01 = service.logout(mySessionId);
////		Map<String,Object> isLogout01 = service.logout(23);
//		System.out.println("isLogout01 : " + isLogout01);
		
		// FrontController로 서비스 실행
//		FrontController controller = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put("memberDto", new MemberDto("a11","1234","hong","대구북구",01022222222,"구매자"));
//		Map<String,Object> result = controller.execute("/member", 1, params);
////		controller.execute("/member", 1, params);
//		Object response = result.get("response");
//		System.out.println(response);
		
		
//		params.put("id", "a1");
//		params.put("pw", "11111");
//		params.put("name", "a1a1");
//		params.put("addr", "포항시북구");
//		params.put("tel", 01011111111);
//		params.put("authority", "구매자");
//		params.put("sessionId", 0);
//		Map<String,Object> response = controller.execute("/member", 6, params);
//		System.out.println(response);
		
//		params.put("sessionId", 9);
//		Map<String,Object> response = controller.execute("/member", 7, params);
//		System.out.println(response);
		
		
		// Notify CRUD TEST
//		NotifyDao dao = NotifyDaoImpl.getInstance();
		
		// Insert
//		dao.Insert(new NotifyDto("B1",11111));
//		dao.Insert(new NotifyDto("B2",11122));
//		dao.Insert(new NotifyDto("B3",11133));
//		
		//selectAll
//		dao.SelectAll();
		
		//update
//		NotifyDto updatenotify = new NotifyDto("B4",11122);
//		dao.Update("B2", updatenotify);
		
		
		//delete
//		dao.Delete("B3");
	
	
	}
	
}
