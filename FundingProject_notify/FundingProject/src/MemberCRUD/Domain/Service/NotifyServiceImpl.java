package MemberCRUD.Domain.Service;

import java.util.List;

import MemberCRUD.Domain.Dao.NotifyDao;
import MemberCRUD.Domain.Dao.NotifyDaoImpl;
import MemberCRUD.Domain.Dto.NotifyDto;



public class NotifyServiceImpl implements NotifyService {


	private NotifyDao dao;
	
	private static  NotifyService instance;
	public static  NotifyService getInstance() throws Exception {
		if(instance==null)
			instance=new  NotifyServiceImpl();
		return instance;
	}
	
	private NotifyServiceImpl() throws Exception {
		dao = NotifyDaoImpl.getInstance();
	} 
	
	@Override
	public boolean notifyRegister(NotifyDto dto) throws Exception {
		return dao.Insert(dto); //true, false 값 반환
	}
	
	
	@Override
	public List<NotifyDto> getAllnotify() throws Exception{
		return dao.SelectAll();
	}
	
	
	
	
	
	
}
