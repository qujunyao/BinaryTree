package qujy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GetOneValue {
	private static GetOneValue oneValue;
	private final static String [] LETTER = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private final static String [] NUMBER = {"0","1","2","3","4","5","6","7","8","9"};
	private static String let ;
	
	private static Queue<String> queueLetter = new LinkedList<String>();
	private static Queue<String> queueNumber = new LinkedList<String>();
	
	private static String getQueueLetter(){
		if(queueLetter.isEmpty()){
			queueLetter.addAll(Arrays.asList(LETTER));
		}
		return queueLetter.poll();
	}
	
	private static String geQueueNumber() {
		if(queueNumber.isEmpty()){
			queueNumber.addAll(Arrays.asList(NUMBER));
		}
		return queueNumber.poll();
	}
	public static String num(){
		String s = geQueueNumber();
		if(s!=null&&"0".equals(s)){
			let = getQueueLetter();
		}
		return let+s;
	}
	
	public static GetOneValue getInstance()
	{
		if (oneValue == null)
		{
			oneValue = new GetOneValue();
		}
		return oneValue;
	}

}
