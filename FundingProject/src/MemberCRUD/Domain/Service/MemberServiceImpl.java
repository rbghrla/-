package MemberCRUD.Domain.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dao.SessionDaoImpl;

public class MemberServiceImpl {
	private List<Integer> SessionIdList;	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private MemberDaoImpl MemberDao;
	private SessionDaoImpl sessionDao;
	
	public MemberServiceImpl() {
		System.out.println("MemberServiceImpl's MemberServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		MemberDao = new MemberDaoImpl();
		sessionDao = new SessionDaoImpl();
		
		SessionIdList = new ArrayList();
		
		// 접속중인 sessionid를 session테이블에서 list로 저장
		List<SessionDto> tmpList = sessionDao.SelectAll();
		for(SessionDto dto : tmpList) {
			SessionIdList.add(dto.getSessionId());
		}
		
	}
	
	
	
}
