public class PermutationsOfAString{
    public static void main(final String[] args){
        final String myCountry = "India";
	final char[] arrayOfChars = myCountry.toCharArray();

	permute(arrayOfChars, 0, arrayOfChars.length - 1);
    }

    private static void printCharArray(final char[] chars){
        if(chars == null) {
	    System.out.println("NULL");
	} else {
	    for(final char ch : chars){
	        System.out.print(ch);
	    }
	}
	System.out.println();
    }

    private static void swap(final char chars[], int firstIndex, final int lastIndex){
        final char valueInTempVariable = chars[firstIndex];
	chars[firstIndex] = chars[lastIndex];
	chars[lastIndex]  = valueInTempVariable;
    }

    private static void permute(final char[] chars, final int startIndex, final int endIndex){
        if(startIndex == endIndex){ printCharArray(chars); }
	else{
	    for(int index = startIndex; index <= endIndex; ++index){
	        swap(chars, startIndex, index);
		permute(chars, index + 1, endIndex);
	        swap(chars, startIndex, index);
	    }
	}
    }
}
