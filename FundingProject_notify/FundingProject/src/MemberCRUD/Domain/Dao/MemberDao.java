package MemberCRUD.Domain.Dao;

import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public interface MemberDao {

	//SELECT
	List<MemberDto> Select(String id);

	//SELECTALL
	List<MemberDto> SelectAll() throws Exception;

	//INSERT
	boolean Insert(MemberDto dto) throws Exception;

	// UPDATE
	boolean Update(String id, MemberDto dto) throws Exception;

	// DELETE
	void Delete(String id) throws Exception;

}