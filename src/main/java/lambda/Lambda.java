package lambda;

interface Executable{
	void execute();
}

class Runner{
	public void run(Executable e){
		System.out.println("In Runner:run");
		e.execute();
	}
}

public class Lambda {

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable(){
			public void execute() {
				System.out.println("In anonymous class:execute");
			}
			
		});
		
		runner.run(() ->System.out.println("1st way: Lambda implementation"));
		
		runner.run(() ->{
			System.out.println("2nd way: 1st line");
			System.out.println("2nd way: 2nd line");
			});

	}

}
