package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dao.BookDaoImpl;
import Ch36.Domain.Dto.BookDto;

public class Main {

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
		BookDaoImpl dao = new BookDaoImpl();
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
		FrontController controller = new FrontController();
		Map<String,Object> params = new HashMap();
//		params.put("bookDto", new BookDto(2222,"이것이","EASY","222-2222"));
		Map<String,Object> result = controller.execute("/book", 1, params);		// "response", isRegistered
		Object response = result.get("response");
		
		
		
		
	}

}
