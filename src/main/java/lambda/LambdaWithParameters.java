package lambda;

interface ExecutableWithParameters{
	int execute(int a, int b);
}

class RunnerWithParameters{
	public void run(ExecutableWithParameters e){
		System.out.println("In Runner:run");
		e.execute(1,5);
	}
}

public class LambdaWithParameters {

	public static void main(String[] args) {
		RunnerWithParameters runner = new RunnerWithParameters();
		runner.run(new ExecutableWithParameters(){
			public int execute(int a, int b) {
				System.out.println("In anonymous class:execute");
				return a+b;
			}
		});
		
		runner.run((int a, int b) -> {
			System.out.println("Lambda implementation "+ (a+b));		
			return a+b;
			});

	}

}
