package dto;
public class UserDTO {
		  
		  
		  private String username;
		  private String password;
		  private String user_fullname;
		  private String phone_no;
		  private String email;
		  private String address;
		
		  
		public UserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserDTO( String username, String password, String user_fullname, String phone_no,
				String email, String address) {
			super();
			
			this.username = username;
			this.password = password;
			this.user_fullname = user_fullname;
			this.phone_no = phone_no;
			this.email = email;
			this.address = address;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUser_fullname() {
			return user_fullname;
		}
		public void setUser_fullname(String user_fullname) {
			this.user_fullname = user_fullname;
		}
		public String getPhone_no() {
			return phone_no;
		}
		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		  
		  
		  
}
