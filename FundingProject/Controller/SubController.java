package FundingProject.Controller;

import java.util.Map;

public interface SubController {

	Map<String,Object> execute(int serviceNo, Map<String,Object> params);
}
