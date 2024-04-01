package MemberCRUD.Controller;

import java.util.Map;

import MemberCRUD.Domain.Dto.MemberDto;

public class MemberController implements SubController {

	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("MemberController's execute()");
		// 서비스 번호별로 분기 처리
		if(serviceNo == 1) {
			System.out.println("[SC]MemberController's Insert..");
		}
		else if(serviceNo == 2) {
			System.out.println("[SC]MemberController's Update..");
		}
		else if(serviceNo == 3) {
			// 1. 파라미터 받기
			MemberDto dto = (MemberDto)params.get("memberDto");
			System.out.println("[SC]MemberController's Delete..");
			// 2. 입력값 검증 (유효성 체크)
			// 3. 서비스 실행
			// 4. 뷰페이지로 이동
		}
		else if(serviceNo == 4) {
			System.out.println("[SC]MemberController's SelectAll..");
		}
		else if(serviceNo == 5) {
			System.out.println("[SC]MemberController's Select..");
		}
		else {
			System.out.println("");
		}
		
		
		
		
		return null;
	}

}
