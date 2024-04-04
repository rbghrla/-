package MemberCRUD.Domain.Service;

import java.util.List;

import MemberCRUD.Domain.Dao.MemberDao;
import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dao.NotifyDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;



public class MemberServiceImpl implements MemberService {

	private MemberDao dao;
	
	private static  NotifyService instance;
	public static  NotifyService getInstance() throws Exception {
		if(instance==null)
			instance=MemberServiceImpl.getInstance();
		return instance;
	}
	
	private MemberServiceImpl() throws Exception {
		dao = MemberDaoImpl.getInstance();
	} //BookServieceImple 이 만들어질때 BookDao도 같이 만들어진다.
	
	@Override
	public boolean MemberRegister(MemberDto dto) throws Exception {
		return dao.Insert(dto); //true, false 값 반환
	}
	
	
	@Override
	public List<MemberDto> getAllMember() throws Exception{
		return dao.SelectAll();
	}
	
	
	
}
