package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dto.BookDto;
import Ch36.Domain.Service.BookServiceImpl;

public class BookController implements SubController {
	
	private BookServiceImpl service;			// 북컨트롤러에서 사용할 북서비스 지정
	public BookController() {					// 북컨트롤러가 생성될때
		try {
			service = new BookServiceImpl();	// 북서비스가 연결됨
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 1 Insert , 2 Update , 3 Delete , 4 SelectAll , 5 Select
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("BookController's execute()");
		// 서브컨트롤러의 역할 4가지!
		// 1. 파라미터 받기
		// 2. 입력값 검증 (유효성체크(데이터), Validation Check)
		// 3. 서비스 실행
		// 4. 뷰페이지로 이동 (or Rest Data 전달)
		
		// 서비스 번호 별로 분기 처리
		if(serviceNo == 1) {			// INSERT
			// 1 파라미터 받기
			BookDto dto = (BookDto)params.get("bookDto");
			System.out.println("[SC]BookController's Insert.." + dto);
			// 2 유효값 검증
			if( !isValid(dto) ) {
				return null;	// 유효하지 않으면 null 예외 발생 유도
			}
			// 3 서비스 실행
			boolean isRegistered = false;		// 등록 여부를 확인하기 위해 외부로 빼고 결과 뷰로 전달
			try {
				isRegistered = service.bookRegister(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4 뷰로 전달 (이동)
			Map<String,Object> result = new HashMap();
			result.put("response", isRegistered);
		} 
		else if(serviceNo == 2) {		// UPDATE
			System.out.println("[SC]BookController's Update..");
		}
		else if(serviceNo == 3) {		// DELETE
			System.out.println("[SC]BookController's Delete..");
		}
		else if(serviceNo == 4) {		// SELECTALL
			System.out.println("[SC]BookController's SelectAll..");
		}
		else if(serviceNo == 5) {		// SELECTONE
			System.out.println("[SC]BookController's Select..");
		}
		else {
			System.out.println("");
		}
	
		return null;
	}
	// 유효성 검증 메소드 정의
	private boolean isValid(BookDto dto) {
		// Null 체크
		// Trim 제거
		// 자료형 변환도 필요할 수 있음(들어오는 자료가 String 일 때, 그에 맞는 자료형으로 변환 필요)
		return true;
	}

}
