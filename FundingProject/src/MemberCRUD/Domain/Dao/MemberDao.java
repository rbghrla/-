package MemberCRUD.Domain.Dao;

import java.util.List;

import MemberCRUD.Domain.Dto.MemberDto;

public interface MemberDao {

	//MemberDto CRUD
	//SELECT
	MemberDto Select(String id) throws Exception;

	//SELECTALL
	List<MemberDto> SelectAll() throws Exception;

	//INSERT
	boolean Insert(MemberDto dto) throws Exception;

	// UPDATE
	boolean Update(String id, MemberDto dto) throws Exception;

	// DELETE
	boolean Delete(String id) throws Exception;

}