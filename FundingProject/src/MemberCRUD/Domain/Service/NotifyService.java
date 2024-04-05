package MemberCRUD.Domain.Service;

import java.util.List;

import MemberCRUD.Domain.Dto.NotifyDto;

public interface NotifyService {

	boolean notifyRegister(NotifyDto dto) throws Exception;

	List<NotifyDto> getAllnotify() throws Exception;

}