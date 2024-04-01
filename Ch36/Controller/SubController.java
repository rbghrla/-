package Ch36.Controller;

import java.util.Map;

public interface SubController {
	// 인터페이스 SubController를 정의해 특정 subcontroller 가 구현받아 사용할 수 있도록 함
	
	// 1 Insert , 2 Update , 3 Delete , 4 SelectAll , 5 Select
	Map<String,Object> execute(int serviceNo, Map<String,Object> params);	// key, value 값으로 value 값으로 다 받음
	
	
}
