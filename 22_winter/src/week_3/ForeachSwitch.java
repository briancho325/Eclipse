package week_3;
//Week를 Switch로 한글(문자)로도 할수있
public class ForeachSwitch {
	enum Week {월, 화, 수, 목, 금, 토, 일}

	public static void main(String[] args) {

		for (Week day : Week.values())
			switch(day) {
			
			case 월:
				System.out.println(day + "요일입니다");
				break;
			case 화:
				System.out.println(day + "요일입니다");
				break;
			case 수:
				System.out.println(day + "요일입니다");
				break;
			case 목:
				System.out.println(day + "요일입니다");
				break;
			case 금:
				System.out.println(day + "요일입니다");
				break;
			case 토:
				System.out.println(day + "요일입니다");
				break;
			case 일:
				System.out.println(day + "요일입니다");
				break;
				
			}
	}

}
//** for 문안싸도 switch 가능 week day1 = week.월;
