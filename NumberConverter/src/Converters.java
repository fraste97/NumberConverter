import java.util.ArrayList;

public class Converters {
	private static int i;
	private static final String bases[]= {"Dec","Bin","Hex"};
	
	public static String convert(String num, String base1, String base2) {
		if(base1==bases[0]) {
			if(base2==bases[1]) return decToBin(num);
			else return decToHex(num);
		}
		else if (base1==bases[1]) {
			if (base2==bases[0]) return binToDec(num);
			else return binToHex(num);
		}else {
			if (base2==bases[0]) return hexToDec(num);
			else return hexToBin(num);
		}
			
	}
	
	public static String binToDec(String binS) {
		char[] bin = binS.toUpperCase().toCharArray();
		long dec = 0;
		int size = bin.length-1;
		i=0;
	
		while(i<=size) {
			int dig = (int)bin[i]-48;
			dec =  (long) (dec + (dig*(Math.pow(2, size-i))));
			i++;
		} 
		return String.valueOf(dec);
	}
	
	public static String hexToDec(String hexS) {
		char[] hex = hexS.toUpperCase().toCharArray();
		long dec = 0;
		int size = hex.length-1;
		i=0;
		
		while(i<=size) {
			int digit = (int)hex[i];
			
			if (digit>64) digit = digit-55;
			else digit = digit-48;
			dec = (long) (dec + digit*(Math.pow(16, size-i)));
			i++;
		}
		
		return String.valueOf(dec);
	}
	
	public static String decToBin(String decS){
		
		long dec = Long.valueOf(decS);
		
		ArrayList<Integer> bin = new ArrayList<Integer>();
		
		if(dec != 0) {

			while(dec > 0) {
				bin.add((int)dec%2);
				dec=dec/2;			
			}
			
			
			return arrayIntToStr(invertI(bin));
			
		} else {
			bin.add(0);
			return bin.toString();
		}
	}
	
	public static String decToHex(String decS){
		long dec = Long.valueOf(decS);
		i=0;
		ArrayList<Character> hex = new ArrayList<Character>();
		if(dec != 0) {
			int res; 
			while(dec > 0) {
				res=(int)(dec%16);
				
				if(res<10) hex.add((char)(res+48));
				else hex.add((char)(res+55));
				
				dec=dec/16;
				i++;
			
			}
			
			return arrayCharToStr(invertC(hex));
			
		} else {
			return "0";
		}
	}
	
	public static String binToHex(String num) {
		return decToHex(binToDec(num));
	}
	
	public static String hexToBin(String num) {
		return decToBin(hexToDec(num));
	}
	
	// inverts an array of Integer type elements	
	private static ArrayList<Integer> invertI(ArrayList<Integer> listToInvert){
		ArrayList<Integer> invertedList = new ArrayList<Integer>();
		for(int j=listToInvert.size()-1; j>=0; j--) {
			invertedList.add((int)listToInvert.get(j));
		}return invertedList;
	}
	
	// inverts an array of Character elements	
	private static ArrayList<Character> invertC(ArrayList<Character> listToInvert){
		ArrayList<Character> invertedList = new ArrayList<Character>();
		for(int j=listToInvert.size()-1; j>=0; j--) {
			invertedList.add(listToInvert.get(j));
		}return invertedList;
	}
	
	private static String arrayIntToStr(ArrayList<Integer> i) {
		StringBuilder str = new StringBuilder();
		for (int digit:i) str.append(digit);
		return str.toString();
	}
	
	private static String arrayCharToStr(ArrayList<Character> i) {
		StringBuilder str = new StringBuilder();
		for (char digit:i) str.append(digit);
		return str.toString();
	}

}




