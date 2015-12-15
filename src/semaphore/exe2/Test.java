package semaphore.exe2;

enum Family {
	YOAV("Father", 38),
	EIAYR("Mother", 39),
	ZOHARI("Daugther", 6),
	ETAN("Child", 3);
	
	private final String role;
	private final int age;
	
	private Family(String role, int age) {
		this.role = role;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return role + " : " + age;
	}
}

public class Test {
	public static void main(String... args) {
		System.out.println(Family.YOAV.toString());
	}
}
