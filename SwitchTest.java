public class SwitchTest {
	
	public enum UserStatus{
		PENDING, ACTIVE, INACTIVE, DELETED
	}
	
	private UserStatus userStatus = UserStatus.ACTIVE;

	public static void main(String[] args) {
		
		SwitchTest switchTest = new SwitchTest();
		
		switchTest.testAvoidFallThrough();
		switchTest.testCompoundCase();
		switchTest.testExpressionForm();
		
	}

	private void testAvoidFallThrough() {
		
		switch(this.userStatus) {
			case PENDING -> System.out.println("Pending");
			case ACTIVE -> System.out.println("Active");
			case INACTIVE -> System.out.println("Inactive");
			case DELETED -> System.out.println("Deleted");
			default -> System.out.println("Default");
		};
	}
	
	private void testCompoundCase() {
		
		switch(this.userStatus) {
			case DELETED -> System.out.println("Deleted");
			case PENDING, ACTIVE, INACTIVE -> System.out.println("Not Deleted");			
		};
	}
	
	private void testExpressionForm() {
		
		var status = switch(this.userStatus) {
			case PENDING -> "Pending";
			case ACTIVE -> "Active";
			case INACTIVE -> "Inactive";
			case DELETED -> "Deleted";
			
			/* comente um dos cases para ver 
			   o erro abaixo relacionado a exaustão(exhaustiveness):
			   the switch expression does not cover all possible input values
			*/
		};
		
		System.out.println(status);
	}

}
