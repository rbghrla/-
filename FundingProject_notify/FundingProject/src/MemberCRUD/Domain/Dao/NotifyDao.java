package MemberCRUD.Domain.Dao;

import java.util.List;

import MemberCRUD.Domain.Dto.NotifyDto;

public interface NotifyDao {

	//INSERT
	boolean Insert(NotifyDto dto) throws Exception;

	//SELECT
	List<NotifyDto> SelectAll() throws Exception;

	//UPDATE
	boolean Update(String id, NotifyDto dto) throws Exception;

	//DELETE
	void Delete(String id) throws Exception;

}