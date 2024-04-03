package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dao.BookDaoImpl;
import Ch36.Domain.Dao.UserDaoImpl;
import Ch36.Domain.Dto.BookDto;
import Ch36.Domain.Dto.UserDto;
import Ch36.Domain.Service.UserServiceImpl;

public class Application {

	public static void main(String[] args) throws Exception {
		
		// 01 Controller Test
//		FrontController frontController = new FrontController();		// frontController 객체 생성(생성자 호출(init 메소드 실행))
//		Map<String ,Object> params = new HashMap();
//		params.put("bookDto", new BookDto(1111,"JAVA의 정석","EASY","111-111"));
//		frontController.execute("/book", 1, params);		// 생성된 frontController의 execute 메소드 실행
//															// uri 값만 넣어줌
//		System.out.println("----------------");
//		frontController.execute("/member", 0, null);
		
		// 02 Insert
//		BookDaoImpl dao = new BookDaoImpl();
//		dao.Insert( new BookDto(1111,"JAVA의 정석","EASY","111-111") );
//		dao.Insert( new BookDto(1112,"JAVA의 정석","EASY","111-111") );
//		dao.Insert( new BookDto(1113,"Physon의 정석","EASY","111-111") );
//		dao.Insert( new BookDto(1114,"C++의 정석","EASY","111-111") );
		
		// 03 SelectAll
//		List<BookDto> list = dao.SelectAll();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
		
		// 04 Select
//		BookDto dto = dao.Select(1112);
//		System.out.println(dto);
		
		// 05 북서비스구현을 이용해 selectAll
//		BookServiceImpl service = new BookServiceImpl();
//		List<BookDto> list = service.getAllBooks();
//		list.forEach(dto->{
//			System.out.println(dto);
//		});
		
		// 06 Update
//		dao.Update("홍재성의 정석",1112);
//		BookDto dto = dao.Select(1112);
//		System.out.println(dto);
		
		// 07
//		FrontController controller = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put("bookDto", new BookDto(2222,"이것이","EASY","222-2222"));
//		Map<String,Object> result = controller.execute("/book", 1, params);		// "response", isRegistered
//		Object response = result.get("response");
		
		// 08 회원가입
//		UserDaoImpl dao = new UserDaoImpl();
//		dao.Insert( new UserDto("user1","1234","ROLE_USER",false) );
		
		// 09 회원가입
//		UserServiceImpl service = new UserServiceImpl();
//		service.UserJoin( new UserDto("user1","1234","ROLE_USER",false) );
		
		// 10
//		FrontController controller = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put( "userDto", new UserDto("user3","1234","ROLE_USER",false) );
//		
//		controller.execute("/user", 1, params);
		
		// 11
		UserServiceImpl service = new UserServiceImpl();
		// 로그인 실패 : 존재하지 않는 계정
//		Map<String,Object> islogin1 = service.login("user5","1234",0);
//		System.out.println("islogin1 : " + islogin1);
//		
//		// 로그인 실패 : 계정은 존재하나 패스워드 불일치
//		Map<String,Object> islogin2 = service.login("user2","1235",0);
//		System.out.println("islogin2 : " + islogin2);
//		
//		// 로그인 성공 : 계정도 존재하고 패스워드도 일치	// 이 부분 비교해보기 (강사님꺼랑)!!!!
//		Map<String,Object> islogin3 = service.login("user3","1234",0);
//		System.out.println("islogin3 : " + islogin3);
//		Integer mySessionId = (Integer)islogin3.get("sessionId");
//		
//		// 로그인 실패 : 기존 로그인된 계정이 존재
//		Map<String,Object> islogin4 = service.login("user2","1234",mySessionId);
//		System.out.println("islogin4 : " + islogin3);
		
		// 12
		// 로그아웃
//		Map<String,Object> isLogout01 = service.logout(mySessionId);
//		Map<String,Object> isLogout01 = service.logout(23);
//		System.out.println("isLogout01 : " + isLogout01);
		
		// 13
		FrontController controller = new FrontController();
		Map<String,Object> params = new HashMap();
		params.put("username", "user3");
		params.put("password", "1234");
		params.put("sessionId", 0);
		Map<String,Object> response = controller.execute("/user", 6, params);
		System.out.println(response);
		
//		params.put("sessionId", 32);
//		Map<String,Object> response = controller.execute("/user", 7, params);
//		System.out.println(response);
		
	}

}
