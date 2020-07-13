package CollegeManagement;

public class Member {
	private String name;
	private int age;
	private String id;
	private String pw;
	private int type;

	public Member() {
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Member(String name, int age, String id, String pw, int type) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	//
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getpw() {
		return this.pw;
	}

}
