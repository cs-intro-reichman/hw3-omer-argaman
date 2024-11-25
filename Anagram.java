/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Madam Curie")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		/* String a = args[0];
		String b = args[1];
		boolean test = isAnagram(a, b);
		System.out.println(a + " and " + b + " are anagrams: " + test);
		String c = args[2];
		System.out.println("I will rearrange the words: " + c + " to: " + randomAnagram(c));
		*/
		
		}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processedStr1 = preProcess(str1);
		String processedStr2 = preProcess(str2);
	    processedStr1 = processedStr1.replaceAll("[^a-zA-Z]", "");
		processedStr2 = processedStr2.replaceAll("[^a-zA-Z]", "");
		int length1 = processedStr1.length();
		int length2 = processedStr2.length();
		int counter = 0;
		if (length1!= length2){
			return false;
		}
		for ( int i1 = 0; i1 < length1; i1++){
			for (int i2 = 0; i2 < processedStr2.length(); i2++){		
				if (processedStr1.charAt(i1)== processedStr2.charAt(i2)){
                    processedStr2 = processedStr2.substring(0, i2) + processedStr2.substring(i2+1);
                    counter++;
					break;
				} 

			}
		}
		if ( counter == length1){
			return true;
		}
		    
		return false;

	}	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"

	public static String preProcess(String str) {
		String Filtered = str.replaceAll("[^a-zA-Z ]", "");
		Filtered = Filtered.toLowerCase();
		return Filtered;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String Rearranged = "";
		int length = str.length();
		for (int i = 0; i < length; i++){
			int j = (int)(Math.random() * str.length());
			Rearranged = Rearranged + str.charAt(j);
			str = str.substring(0, j) + str.substring(j+1);
		}
		return Rearranged;
	}
}
