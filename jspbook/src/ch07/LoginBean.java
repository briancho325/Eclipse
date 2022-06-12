/**
 * 
 */
package jspbook.ch07;

/**
 * File : LoginBean.java
 * Desc : 로그인 처리 빈즈 클래스
 * @author 황희정(dinfree@dinfree.com)
 */
public class LoginBean {
	
	// 사용자로 부터 입력받은 아이디와 비밀번호 저장
	private String userid;
	private String passwd;
	
	// DB로 부터 가져온 아이디와 비밀번호로 가정함
	final String _userid="hansung";
	final String _passwd="1234";
	
	// 로그인 계정 정보가 맞는지 확인하는 메서드
	public boolean checkUser() {
		if(userid.equals(_userid)&&passwd.equals(_passwd)) {
			return true;
		}
		else
			return false;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}