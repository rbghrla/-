package FundingProject.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36_1.Controller.BookController;
import Ch36_1.Controller.LendController;
import Ch36_1.Controller.MemberController;
import Ch36_1.Controller.SubController;

public class FrontController {
	private Map<String,SubController> map = new HashMap();
	
	FrontController(){
		System.out.println("FrontController()");
		init();
	}
	
	private void init() {
		System.out.println("FrontController's init()");
		
		// 요청 API 
		// 	BookController - /book 관련 요청들어오면 처리 담당
		// 	MemberController - /member
		// 	LendController - /lend 
		// 이런것들을 미리 저장해놓고 시작해야함 Map 형태로 저장할 것이다.
		
		map.put("/member", new MemberController()); // "/member" 는 요청, new MemberController()는 서브컨트롤러
		
	}
	
	//사용자의 요청 uri에 만든 subController를 가져와 execute를 실행
	public Map<String,Object> execute(String uri, int ServiceNo, Map<String,Object> params){
			
		System.out.println("FrontController's execute()");
		SubController controller = map.get(uri); //3개의 컨트롤러를 다 받아야하니까 상위클래스인 SubController 사용
		return controller.execute(ServiceNo, params);
			
	}
}
