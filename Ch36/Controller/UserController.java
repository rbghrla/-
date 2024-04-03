package Ch36.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36.Domain.Dto.UserDto;
import Ch36.Domain.Service.UserServiceImpl;

public class UserController implements SubController {
	private UserServiceImpl userService;	// UserController 내부에 UserService를 연결
	
	public UserController(){
		try {
			userService = new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 1 Insert , 2 Update , 3 Delete , 4 SelectAll , 5 Select , 6 Login
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("UserController's execute()");
		if(serviceNo == 1) {			// 회원가입
			// 1. 파라미터 받음
			UserDto dto = (UserDto)params.get("userDto");
			// 2. 유효성 체크
			if(!isValid(dto)) {
				return null;
			}
			// 3. 서비스 실행
			boolean isJoined = false;	// isJoined 이 try문 안에 있어 뷰로 전달하기 위해 전역화 시켜야함
			try {
				isJoined = userService.UserJoin(dto);	// 실행 여부를 논리형으로 확인
			} catch (Exception e) {
				e.printStackTrace();
			}	
			// 4. 뷰로 전달
			Map<String,Object> result = new HashMap();
			result.put("response", isJoined);
			
		} else if(serviceNo == 2) {
			
		} else if(serviceNo == 3) {
			
		} else if(serviceNo == 4) {
			
		} else if(serviceNo == 5) {
			
		} else if(serviceNo == 6) {		// 로그인
			// 1. 파라미터 받기
			String username = (String) params.get("username");
			String password = (String) params.get("password");
			Integer sessionId = (Integer)params.get("sessionId");
			
			// 2. 입력값(Data) 유효성 체크
			if(!isValid(username,password,sessionId)) {
				return null;
			}
			// 3. 서비스 실행
			Map<String,Object> response = null;
			try {
				response = userService.login(username, password, sessionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4. 뷰로 전달
			return response;
			
		} else if(serviceNo == 7) {		// 로그아웃
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
				response = userService.logout(sessionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4. 뷰로 전달
			return response;
			
		} else {
			
		}
		return null;
	}

	private boolean isValid(Integer sessionId) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isValid(String username, String password, Integer sessionId) {
		// NullCheck
		// trim -> 앞뒤 공백 제거
		return true;
	}

	private boolean isValid(UserDto dto) {		// 유효성 체크 함수
		// NullCheck
		// trim -> 앞뒤 공백 제거
		return true;
	}

}
