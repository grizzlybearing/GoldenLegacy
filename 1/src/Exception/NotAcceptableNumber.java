package Exception;

public class NotAcceptableNumber extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5522468125238025546L;
	
	public NotAcceptableNumber(){
		super();
	}
	public NotAcceptableNumber(String msg){
		super(msg);
	}
}
