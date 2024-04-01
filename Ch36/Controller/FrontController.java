package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {		// FrontController 클래스 정의

	private Map<String,SubController> map = new HashMap();		// 사용자의 요청을 받기 위한 map 객체 생성 (key, value 값으로 받음 / 구체적인 요청은 SubController 로 넘겨주기 위해 클래스 자료형 사용)
																// 제너릭에 대한 이해 필요
	
	FrontController(){		// FrontController 생성자
		System.out.println("FrontController()");		// 생성자 호출 시 FrontController() 출력
		init();				// init 메소드 실행 (입력된 uri에 따른 SubController 객체 생성을 위한 메소드)
	}
	private void init() {		// init 메소드 정의 (init 메소드는 FrontController 클래스 안에서만 접근이 가능하도록 private 지정)
		System.out.println("FrontController's init()");		// init 메소드 실행 시 FrontController's init() 출력
		// 요청 API (설계 단에서 특정 uri를 모두 설계 한 후 지정)
		// /book	- BookController
		// /member	- MemberController
		// /lend	- LendController
		map.put("/book", new BookController());			// 요청 uri (/book) 와 그에 해당하는 SubController(인터페이스)를 구현한 BookController 객체를 생성
		map.put("/member", new MemberController());		// 요청 uri (/member) 와 그에 해당하는 subController(인터페이스)를 구현한 MemberController 객체를 생성
		map.put("/lend", new LendController());			// 요청 uri (/lend) 와 그에 해당하는 subController(인터페이스)를 구현한 LendController 객체를 생성
	}
	// 여기까지가 FrontController 객체에 대한 정의
	
	// 이 부분은 생성된 FrontController 객체 실행에 대한 정의
	// 사용자의 요청 uri 에 맞는 subController를 가져와 execute 를 실행
	public Map<String,Object> execute(String uri, int ServiceNo, Map<String,Object> params)	// 어떤 uri 가 들어왔을 때
	{
		System.out.println("FrontController's execute()");		// FrontCotroller 의 execute 메솓 실행 시 호출
		SubController controller = map.get(uri);		// map에서 uri 만 선별(key값이 uri이고 해당하는 주소를 저장) 한 다음 해당하는 subcontroller의 주소를 연결 후 객체를 생성 
		return controller.execute(ServiceNo, params);	// 관련된 subcontroller 객체의 서비스넘버와, 파람스 전달 (execute 메소드 실행)
	}
	
}
