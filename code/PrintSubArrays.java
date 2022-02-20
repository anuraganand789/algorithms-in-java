public class PrintSubArrays {

    static int loopCount(int intValue){
        int sum = 0;

        while(intValue > 0) sum += intValue--;

        return sum;
    }

    static void print(final int[] intArray){

        final int arrLength = intArray.length;

        int startIndex   = 0;
        int currentIndex     = startIndex;

        int currentIterationEndIndex = startIndex;
        int totalLoopCount = loopCount(arrLength);

        while(totalLoopCount > 0){

            System.out.printf("%d ", intArray[currentIndex]);

            if(currentIndex == currentIterationEndIndex){

                ++currentIterationEndIndex;

                if(currentIterationEndIndex == arrLength){
                    ++startIndex;
                    currentIterationEndIndex = startIndex;
                }

                currentIndex = startIndex;
                --totalLoopCount;

                System.out.println();
            } else {
                ++currentIndex;
            }
        }
    }

    public static void main(String[] args) {
        final int[] arr = {1, 2, 3, 4, 5};
        print(arr);
    }
}
