package Funding_Project.Controller;

import java.util.List;

import Funding_Project.Domain.Dao.MemberDao;
import Funding_Project.Domain.Dto.MemberDto;

public class Application {
	public static void main(String[] args) throws Exception {
		MemberDao dao = new MemberDao();
		
		dao.SelectAll();
		dao.Select("dsa");
		
		
	}
}
