package MemberCRUD.Domain.Dao;

import java.util.List;

import MemberCRUD.Domain.Dto.SessionDto;

public interface SessionDao {

	// SessionDto CRUD
	// SELECT (sessionId)
	SessionDto Select(int sessionId) throws Exception;

	// SELECT (username)
	SessionDto Select(String username) throws Exception;

	// SELECTALL
	List<SessionDto> SelectAll() throws Exception;

	// INSERT
	boolean Insert(SessionDto sessionDto) throws Exception;

	// UPDATE (SessionDto 수정은 필요없음)
	// DELETE
	boolean Delete(int sessionId) throws Exception;

}