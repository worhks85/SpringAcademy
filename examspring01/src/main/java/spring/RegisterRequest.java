package spring;

//요청 정보만을 담는 객체를 정의 (커맨드 객체)
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmpassword;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//비밀번호와 비밀번호 확인이 동일한지 여부를 반환하는 메서드
	public boolean isPasswordEqualsToConfirPassword() {
		return password.equals(confirmpassword);
	}
	
	
	
	
	
}