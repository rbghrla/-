package MemberCRUD.Controller;

import java.util.HashMap;
import java.util.Map;

import MemberCRUD.Domain.Dao.MemberDaoImpl;
import MemberCRUD.Domain.Dto.MemberDto;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// 01 Controller Test
//		FrontController frontController = new FrontController();
//		Map<String,Object> params = new HashMap();
//		params.put("memberDto", new MemberDto("1","abcd","hong","대구",4551,"구매자"));
//		frontController.execute("/member, 1, params");
		
		// Insert
		
		
		// Delete
		MemberDaoImpl dao = new MemberDaoImpl();
		dao.Delete("1");
		
		
		
	}
}
