package tryCatchFinally;

public class TryCatchFinally {

	public static void main(String[] args) {
		try{
			new TryCatchFinally().testTryCatchFinally();
		}catch(Exception e){System.out.println("print if flow comeback here");}
	}
	
	int testTryCatchFinally(){
		try{
			throw new NullPointerException();
		}catch(NullPointerException e){
			if(true){
				return handleException();
			}
			throw e;
		}
	}
	int handleException(){ return 10;}

}
