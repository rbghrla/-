package MemberCRUD.Domain.Service;

import java.util.Map;

import MemberCRUD.Domain.Dto.MemberDto;

public interface MemberService {

	// 회원가입
	boolean MemberJoin(MemberDto dto) throws Exception;

	Map<String, Object> login(String id, String pw, int sessionId) throws Exception;

	// 로그아웃
	Map<String, Object> logout(int sessionId) throws Exception;

}