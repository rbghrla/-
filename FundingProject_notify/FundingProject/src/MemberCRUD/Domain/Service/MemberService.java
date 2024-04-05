package MemberCRUD.Domain.Service;

import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public interface MemberService {

	boolean MemberRegister(MemberDto dto) throws Exception;

	List<MemberDto> getAllMember() throws Exception;

}