package please_make_it_english;

import java.util.*;

class Main {

	public static void main(String[] args) {

		try {

			// get an input data
			Scanner sc = new Scanner(System.in);
	
			// get the number of data lines
			int lineNum = sc.nextInt();
	
			// get the input data
			ArrayList<Integer> inputList = new ArrayList<Integer>();
			for (int i = 0; i < lineNum; i++) {

				inputList.add(sc.nextInt());
			}

			// for output data
			StringBuilder output = new StringBuilder();
			// for one line's input number
			int intInputNumber = 0;
			String strInputNumber = "";
			// for the one line's input number splitted into 3 letters
			String splittedInputNumber[] = null;

			// loop for the number of data lines
			for (int j = 0; j < lineNum; j++) {
	
				// initialize
				output.delete(0, output.length());
				// get one line's input number
				intInputNumber =  (int) inputList.get(j);
	
				// add a comma to split later
				strInputNumber = String.format("%,d", intInputNumber);
	
				// when the number is negative: add "-"
				if ("-".equals(strInputNumber.substring(0,1))) {
	
					output.append("Negative ");
					strInputNumber = strInputNumber.substring(1);
				}
	
				// make an output
				// less than 4 letters: no split
				if (strInputNumber.indexOf(",") < 0) {

					splittedInputNumber = new String[1];
					splittedInputNumber[0] = strInputNumber;
				// more than 3 letters: split into 3 letters
				} else {
					
					splittedInputNumber = strInputNumber.split(",");
				}

				// loop for the number of arrays
				for (int k = 0; k < splittedInputNumber.length; k++) {

					// translate one letter
					output.append(getWord(splittedInputNumber[k]));

					// add the unit
					switch(splittedInputNumber.length - k) {
						case 4:
							output.append("Billion ");
							break;
						case 3:
							output.append("Million ");
							break;
						case 2:
							output.append("Thousand ");
							break;
					}
				}
				
				System.out.println(output.substring(0, output.length() - 1));
			}
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	private static String getWord(String splitedNum) {

		StringBuilder sb = new StringBuilder();

		switch (splitedNum.length()) {
			// 000-999
			case 3:
				// when the hundred's digit is not "0": translate it and add the unit
				if (!"0".equals(splitedNum.substring(0,1))) {
					
					sb.append(translate(splitedNum.substring(0,1)));
					sb.append("Hundred ");
				}

				// when the ten's digit is "0": no translate
				// when the ten's digit is "1": translate the ten's digit and onoe's digit
				// when other than the above: translate the ten's digit
				if ("0".equals(splitedNum.substring(1,2))) {
				} else if ("1".equals(splitedNum.substring(1,2))) {

					sb.append(translate(splitedNum.substring(1,3)));
				} else {
					
					sb.append(translate(splitedNum.substring(1,2) + "0"));
				}

				// when the one's digit is "0" or the ten's digit is "1": no translate
				// when other than the above: translate the one's digit
				if ("0".equals(splitedNum.substring(2)) || "1".equals(splitedNum.substring(1,2))) {
				} else {
					
					sb.append(translate(splitedNum.substring(2)));
				}
				break;
			// 00-99
			case 2:
				// when the ten's digit is "0": no translate
				// when the ten's digit is "1": translate the ten's digit and onoe's digit
				// when other than the above: translate the ten's digit
				if ("0".equals(splitedNum.substring(0,1))) {
				} else if ("1".equals(splitedNum.substring(0,1))) {

					sb.append(translate(splitedNum));
				} else {
					
					sb.append(translate(splitedNum.substring(0,1) + "0"));
				}

				// when the one's digit is "0" or the ten's digit is "1": no translate
				// when other than the above: translate the one's digit
				if ("0".equals(splitedNum.substring(1)) || "1".equals(splitedNum.substring(0,1))) {
				} else {
					
					sb.append(translate(splitedNum.substring(1)));
				}
				break;
			// 0-9
			case 1:				
				sb.append(translate(splitedNum));
				break;
		}

		return sb.toString();
	}

	private static String translate(String num) {

		switch (num) {
			case "0":
				return "Zero ";
			case "1":
				return "One ";
			case "2":
				return "Two ";
			case "3":
				return "Three ";
			case "4":
				return "Four ";
			case "5":
				return "Five ";
			case "6":
				return "Six ";
			case "7":
				return "Seven ";
			case "8":
				return "Eight ";
			case "9":
				return "Nine ";
			case "10":
				return "Ten ";
			case "11":
				return "Eleven ";
			case "12":
				return "Twelve ";
			case "13":
				return "Thirteen ";
			case "14":
				return "Fourteen ";
			case "15":
				return "Fifteen ";
			case "16":
				return "Sixteen ";
			case "17":
				return "Seventeen ";
			case "18":
				return "Eighteen ";
			case "19":
				return "Nineteen ";
			case "20":
				return "Twenty ";
			case "30":
				return "Thirty ";
			case "40":
				return "Forty ";
			case "50":
				return "Fifty ";
			case "60":
				return "Sixty ";
			case "70":
				return "Seventy ";
			case "80":
				return "Eighty ";
			case "90":
				return "Ninety ";
		}
		return "";
	}
}
