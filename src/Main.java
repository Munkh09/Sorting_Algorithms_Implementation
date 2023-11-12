import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Creating the arrays
        int[] arrayTenth1 = new int[10];
        int[] arrayTenth2 = new int[10];
        int[] arrayHundredth1 = new int[100];
        int[] arrayHundredth2 = new int[100];
        int[] arrayThousandth1 = new int[1000];
        int[] arrayThousandth2 = new int[1000];
        int[] arrayTenThousandth1 = new int[10000];
        int[] arrayTenThousandth2 = new int[10000];
        Random random = new Random();

        //Filling the arrays with random numbers;
        for(int i = 0; i < arrayTenth1.length; i++){
            int num = random.nextInt(100);
            arrayTenth1[i] = num;
            arrayTenth2[i] = num;
        }
        for(int i = 0; i < arrayHundredth1.length; i++){
            int num = random.nextInt(100);
            arrayHundredth1[i] = num;
            arrayHundredth2[i] = num;
        }
        for(int i = 0; i < arrayThousandth1.length; i++){
            int num = random.nextInt(100);
            arrayThousandth1[i] = num;
            arrayThousandth2[i] = num;
        }
        for(int i = 0; i < arrayTenThousandth1.length; i++){
            int num = random.nextInt(100);
            arrayTenThousandth1[i] = num;
            arrayTenThousandth2[i] = num;
        }

        //The output part
        System.out.println("Comparing on arrays with size 10");
        System.out.println("The unsorted array is: " + toString(arrayTenth1));
        long startTime1 = System.nanoTime();  //the way to see the running time of insertion_sort
        insertion_sort(arrayTenth1);
        long endTime1 = System.nanoTime();    ////the way to see the running time of insertion_sort
        long duration1 = (endTime1 - startTime1);
        System.out.println("The insertion sort took: " + duration1 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayTenth1));

        System.out.println(" ");

        System.out.println("The unsorted array is: " + toString(arrayTenth2));
        long startTime2 = System.nanoTime();
        merge_sort(arrayTenth2, 0, arrayTenth2.length -1);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("The merge sort took: " + duration2 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayTenth2));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Comparing on arrays with size 100");
        System.out.println("The unsorted array is: " + toString(arrayHundredth1));
        long startTime3 = System.nanoTime();
        insertion_sort(arrayHundredth1);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.println("The insertion sort took: " + duration3 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayHundredth1));

        System.out.println(" ");

        System.out.println("The unsorted array is: " + toString(arrayHundredth2));
        long startTime4 = System.nanoTime();
        merge_sort(arrayHundredth2, 0, arrayHundredth2.length -1);
        long endTime4 = System.nanoTime();
        long duration4 = (endTime4 - startTime4);
        System.out.println("The merge sort took: " + duration4 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayHundredth2));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Comparing on arrays with size 1,000");
        System.out.println("The unsorted array is: " + toString(arrayThousandth1));
        long startTime5 = System.nanoTime();
        insertion_sort(arrayThousandth1);
        long endTime5 = System.nanoTime();
        long duration5 = (endTime5 - startTime5);
        System.out.println("The insertion sort took: " + duration5 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayThousandth1));

        System.out.println(" ");

        System.out.println("The unsorted array is: " + toString(arrayThousandth2));
        long startTime6 = System.nanoTime();
        merge_sort(arrayThousandth2, 0, arrayThousandth2.length -1);
        long endTime6 = System.nanoTime();
        long duration6 = (endTime6 - startTime6);
        System.out.println("The merge sort took: " + duration6 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayThousandth2));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Comparing on arrays with size 10,000");
        System.out.println("The unsorted array is: " + toString(arrayTenThousandth1));
        long startTime7 = System.nanoTime();
        insertion_sort(arrayTenThousandth1);
        long endTime7 = System.nanoTime();
        long duration7 = (endTime7 - startTime7);
        System.out.println("The insertion sort took: " + duration7 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayTenThousandth1));

        System.out.println(" ");

        System.out.println("The unsorted array is: " + toString(arrayTenThousandth2));
        long startTime8 = System.nanoTime();
        merge_sort(arrayTenThousandth2, 0, arrayTenThousandth2.length -1);
        long endTime8 = System.nanoTime();
        long duration8 = (endTime8 - startTime8);
        System.out.println("The merge sort took: " + duration8 + " nanoseconds");
        System.out.println("The sorted array is: " + toString(arrayTenThousandth2));

    }
    //Private method to view the unsorted and sorted arrays
    private static String toString(int[] array){
        String s = " ";
        for (int i = 0; i < array.length; i++){
            s +=  " " + array[i];
        }
        return s;
    }

    //Implemented Insertion Sort; It is designed for arrays that start from the index 0
    public static void insertion_sort(int[] array) {
        if (array.length > 1) {
            for (int j = 1; j < array.length; j++) {
                int key = array[j];
                int i = j - 1;
                while (i >= 0 && array[i] > key) {
                    array[i + 1] = array[i];
                    i = i - 1;
                }
                array[i + 1] = key;
            }
        }
    }

    //Implemented Merge Sort; Designed for arrays starting from index 0;
    //call the merge function (the combine part)
    public static void merge_sort( int[] array, int firstIndex, int lastIndex ) {
        if (firstIndex < lastIndex) {
            int midpoint = (firstIndex + lastIndex) / 2;
            merge_sort(array, firstIndex, midpoint);
            merge_sort(array, midpoint + 1, lastIndex);
            merge(array, firstIndex, midpoint, lastIndex);
        }
    }

    //the merge function, which is the combine part of the divide,conquer, and combine parts
    public static void merge(int[] mainArray, int firstIndex, int middleIndex, int lastIndex){
        int n1 = middleIndex - firstIndex + 1;
        int n2 = lastIndex - middleIndex;
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];
        for (int i = 0; i < n1; i++){
            leftArray[i] = mainArray[firstIndex + i];
        }
        for (int i = 0; i < n2; i++){
            rightArray[i] = mainArray[middleIndex + 1 + i];
        }
        leftArray[n1] = 1000000;   //the sentinel value for the left array
        rightArray[n2] = 1000000;   //the sentinel value for the right array
        int i = 0;
        int j = 0;
        for (int k = firstIndex; k <= lastIndex; k++){
            if (leftArray[i] <= rightArray[j]) {
                mainArray[k] = leftArray[i];
                i = i + 1;
            } else {
                mainArray[k] = rightArray[j];
                j = j + 1;
            }
        }

    }
}
