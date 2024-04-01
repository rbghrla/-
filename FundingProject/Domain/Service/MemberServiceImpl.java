package FundingProject.Domain.Service;

import FundingProject.Domain.Dao.MemberDaoImpl;
import FundingProject.Domain.Dto.MemberDto;

public class MemberServiceImpl {

	private MemberDaoImpl dao;
	public MemberServiceImpl() throws Exception {
		dao = new MemberDaoImpl();
	}
	
	public boolean memberRegister(MemberDto dto) throws Exception {
		return dao.Insert(dto);
	}
}
