package MemberCRUD.Domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import MemberCRUD.Domain.Dao.MemberDao;
import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dao.SessionDao;
import MemberCRUD.Domain.Dao.SessionDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;
import MemberCRUD.Domain.Dto.SessionDto;

public class MemberServiceImpl implements MemberService {
	private List<Integer> SessionIdList;	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private MemberCRUD.Domain.Dao.MemberDao MemberDao;
	private SessionDao sessionDao;
	// 싱글톤 패턴
	private static MemberService instance;
	public static MemberService getInstance() throws Exception {
		if(instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}
	private MemberServiceImpl() throws Exception {
		System.out.println("MemberServiceImpl's MemberServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		MemberDao = MemberDaoImpl.getInstance();
		sessionDao = SessionDaoImpl.getInstance();
		
		SessionIdList = new ArrayList();
		
		// 접속중인 sessionid를 session테이블에서 list로 저장
		List<SessionDto> tmpList = sessionDao.SelectAll();
		for(SessionDto dto : tmpList) {
			SessionIdList.add(dto.getSessionId());
		}
		
	}
	// 회원가입
	@Override
	public boolean MemberJoin(MemberDto dto) throws Exception {
		// 패스워드 암호화
		String encrypt = bCryptPasswordEncoder.encode(dto.getPw());
		dto.setPw(encrypt);		
		
		return MemberDao.Insert(dto);
	}
	
	// 로그인
	@Override
	public Map<String,Object> login(String id,String pw,int sessionId) throws Exception {
		Map<String,Object> result = new HashMap();
		
		// 1. SessionList에 동일한 세션정보가 있는 지 확인
		for(int i : SessionIdList) {
			if(sessionId == i)	{		// 로그인한 상태
				result.put("response", false);
				result.put("msg", "이미 해당 계정은 로그인한 상태입니다.");
				return result;
			}
		}
		
		// 2. 로그인된 상태가 아니라면 user 테이블로부터 동일한 이름의 user정보를 가져오기 (getUser())
		MemberDto savedUser = getMember(id);		// savedUser 가 뭔지???
		if(savedUser == null) {		
			result.put("response", false);
			result.put("msg", "동일 계정이 존재하지 않습니다.");
			return result;
		}
		
		// 3. PW 일치여부 확인
		if( !bCryptPasswordEncoder.matches( pw, savedUser.getPw() ) ) {
			result.put("response", false);
			result.put("msg", "패스워드가 일치하지 않습니다.");
			return result;		// 일치안한다면('!') 로그인 실패
		}
		// 4,5번이 실제적으로 로그인 처리 과정
		// 4. PW 일치한다면 session 테이블에 세션정보 저장
		SessionDto sessionDto = new SessionDto();
		sessionDto.setUsername(savedUser.getId());
		sessionDto.setRole(savedUser.getAuthority());
		boolean isSessionSaved = sessionDao.Insert(sessionDto);
		if(!isSessionSaved) {
			result.put("response", false);
			result.put("msg", "로그인 처리중 오류가 발생하였습니다. Session 생성 실패...");
			return result;		
		}
		
		// 5. PW 일치한다면 sessionList에 sessionId 값 저장
		Integer sid = sessionDao.Select(sessionDto.getUsername()).getSessionId();
		result.put("response", true);
		result.put("msg", "로그인 성공!");
		result.put("sessionId", sid);
		SessionIdList.add(sid);
		return result;
		// 동일한 세션정보도 없고 로그인한 상태도 아니고 pw도 일치한다면 세션 객체를 만들어서 db에 저장
		
	}
	
	private MemberDto getMember(String id) throws Exception {
		return MemberDao.Select(id);
	}
	
	// 로그아웃
	@Override
	public Map<String,Object> logout(int sessionId) throws Exception {
		Map<String,Object> response = new HashMap();	// 리턴받을 용도인 객체
		
		// 1. sessionIdList에 sessionId가 있는 지 확인
		boolean isExisted = SessionIdList.contains(sessionId);
//		System.out.println("isExistId : " + isExisted);
		if(!isExisted) {
			response.put("response", false);
			response.put("msg", "현재 로그인된 상태가 아닙니다.");
			return response;
		}
		
		// 2. 있다면, Session테이블에서 dto 삭제
		boolean isremoved = sessionDao.Delete(sessionId);
		if(!isremoved) {
			response.put("response", false);
			response.put("msg", "시스템 상의 문제로 세션삭제가 불가합니다. 관리자에게 문의해주세요.");
			return response;
		}
		// 3. List에서 sessionId 제거
		boolean isremoved2 = SessionIdList.remove(Integer.valueOf(sessionId));
		
		// 4. 로그아웃 성공
		response.put("response", true);
		response.put("msg", "로그아웃 성공!");
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
