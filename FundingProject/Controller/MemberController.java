package FundingProject.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36_1.Controller.SubController;
import FundingProject.Domain.Dto.MemberDto;
import FundingProject.Domain.Service.MemberServiceImpl;

public class MemberController implements SubController{

	private MemberServiceImpl service;
	public MemberController() {
		try {
			service = new MemberServiceImpl();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("MemberController's execute()");
		
		if(serviceNo==1) {
			MemberDto dto = (MemberDto)params.get("memberDto");
			System.out.println("[SC]MemberController's Insert.." + dto);
			
			if(!isValid(dto)) {
				return null;
			}
			
			boolean isRegistered = false;
			try {
				isRegistered = service.memberRegister(dto);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			Map<String, Object> result = new HashMap();
			result.put("response", isRegistered);
		}
		else if(serviceNo==2) 
		{
			System.out.println("");
		}
		else if(serviceNo==3)
		{
			System.out.println("");
		}
		else if(serviceNo==4)
		{
			System.out.println("");
		}
		else if(serviceNo==5)
		{
			System.out.println("");
		}
		else
		{
			System.out.println("");
		}
		
		return null;
		
	}
	private boolean isValid(MemberDto dto) {
		return true;
	}

}
