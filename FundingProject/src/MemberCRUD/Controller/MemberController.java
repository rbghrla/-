package MemberCRUD.Controller;

import java.util.HashMap;
import java.util.Map;

import MemberCRUD.Domain.Dto.MemberDto;
import MemberCRUD.Domain.Service.MemberService;
import MemberCRUD.Domain.Service.MemberServiceImpl;

public class MemberController implements SubController {
	private MemberService memberService;
	
	public MemberController() {
		try {
			memberService = MemberServiceImpl.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("MemberController's execute()");
		// 서비스 번호별로 분기 처리
		// 1 Insert(회원가입), 2 Update, 3 Delete, 4 SelectAll, 5 Select, 6 Login, 7 Logout
		if(serviceNo == 1) {
			System.out.println("[SC]MemberController's Insert..");
			// 1. 파라미터 받음
			MemberDto dto = (MemberDto)params.get("memberDto");
			// 2. 유효성 체크
			if(!isValid(dto)) {
				return null;
			}
			// 3. 서비스 실행
			boolean isJoined = false;	// isJoined 이 try문 안에 있어 뷰로 전달하기 위해 전역화 시켜야함
			try {
				isJoined = memberService.MemberJoin(dto);	// 실행 여부를 논리형으로 확인
			} catch (Exception e) {
				e.printStackTrace();
			}	
			// 4. 뷰로 전달
			Map<String,Object> result = new HashMap();
			result.put("response", isJoined);
			
			return result;
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
		else if(serviceNo == 6){
			System.out.println("[SC]MemberController's Login..");
			// 1. 파라미터 받기
			String id = (String) params.get("id");
			String pw = (String) params.get("pw");
			Integer sessionId = (Integer)params.get("sessionId");
			
			// 2. 입력값(Data) 유효성 체크
			if(!isValid(id,pw,sessionId)) {
				return null;
			}
			// 3. 서비스 실행
			Map<String,Object> response = null;
			try {
				response = memberService.login(id, pw, sessionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4. 뷰로 전달
			return response;
		}
		else if(serviceNo == 7){
			System.out.println("[SC]MemberController's Logut..");
			// 1. 파라미터 받기
			Integer sessionId = (Integer)params.get("sessionId");
			// 2. 입력값(Data) 유효성 체크
			Map<String,Object> response = null;
			if(!isValid(sessionId)) {
				response = new HashMap();
				response.put("response", false);
				response.put("msg", "Data Validation Check Error..");
				return response;
			}
			// 3. 서비스 실행
			try {
				response = memberService.logout(sessionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4. 뷰로 전달
			return response;
		}
		else {
			
		}
		
		return null;
	}

	private boolean isValid(Integer sessionId) {
		// NullCheck
		// trim -> 앞뒤 공백 제거
		return true;
	}

	private boolean isValid(String id, String pw, Integer sessionId) {
		// NullCheck
		// trim -> 앞뒤 공백 제거
		return true;
	}

	private boolean isValid(MemberDto dto) {
		// NullCheck
		// trim -> 앞뒤 공백 제거
		return true;
	}

}
