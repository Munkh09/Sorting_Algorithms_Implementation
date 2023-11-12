
import java.sql.Date;

public class PersonSorter {

    // Constants representing sorting mode by the field of class person.
    public static final int BY_LAST_NAME 		= 0;
    public static final int BY_DATE_OF_BIRTH 	= 1;
    String[] A = new String[10];

    public static Person[] sortBy(Person[] A, int byValue) {
        switch (byValue) {
            case BY_LAST_NAME:
                return sortByLastName(A);
            case BY_DATE_OF_BIRTH:
                return sortByDateOfBirth(A);
            default:
                return A;
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // TODO: Implement the two sorting methods                            //
    // 		 Note that A.clone always creates first a copy of the input     //
    //////////////////////////////////////////////////////////////////////////

    //Used Merge Sort for sorting by Date of Birth
    private static Person[] sortByDateOfBirth(Person[] A) {
        if (A.length > 1) {
            merge_sort_dateOfBirth(A, 0, A.length - 1);
            return A;
        } else {
            System.out.println("Array is too small");
            return A;
        }
    }
    //The conquer part of the merge sort
    public static void merge_sort_dateOfBirth(Person[] array, int firstIndex, int lastIndex ) {
        if (firstIndex < lastIndex) {
            int midpoint = (firstIndex + lastIndex) / 2;
            merge_sort_dateOfBirth(array, firstIndex, midpoint);
            merge_sort_dateOfBirth(array, midpoint + 1, lastIndex);
            merge_dateOfBirth(array, firstIndex, midpoint, lastIndex);
        }
    }
    //The combine part that combines the sorted subarrays
    public static void merge_dateOfBirth(Person[] mainArray, int firstIndex, int middleIndex, int lastIndex){
        int n1 = middleIndex - firstIndex + 1;
        int n2 = lastIndex - middleIndex;
        Person[] leftArray = new Person[n1 + 1];
        Person[] rightArray = new Person[n2 + 1];
        for (int i = 0; i < n1; i++){
            leftArray[i] = mainArray[firstIndex + i];
        }
        for (int i = 0; i < n2; i++){
            rightArray[i] = mainArray[middleIndex + 1 + i];
        }
        leftArray[n1] = new Person("last", "first", Date.valueOf("5000-11-11"));  // the sentinel value for the left temporary Array
        rightArray[n2] = new Person("last", "first", Date.valueOf("5000-11-11"));  // the sentinel value for the right temporary Array
        int i = 0;
        int j = 0;
        for (int k = firstIndex; k <= lastIndex; k++){
            if (leftArray[i].getDateOfBirth().compareTo(rightArray[j].getDateOfBirth()) <= 0) {
                mainArray[k] = leftArray[i];
                i = i + 1;
            } else {
                mainArray[k] = rightArray[j];
                j = j + 1;
            }
        }

    }

    //Used Insertion Sort to sort by Last Names; Designed for arrays starting index 0
    private static Person[] sortByLastName(Person[] A) {
        if (A.length > 1) {
            for (int j = 1; j < A.length; j++) {
                Person key = A[j];
                int i = j - 1;
                while (i >= 0 && A[i].getLastName().compareTo(key.getLastName()) > 0) {
                    A[i + 1] = A[i];
                    i = i - 1;
                }
                A[i + 1] = key;
            }
            return A;
        } else {
            System.out.println("Array is too small.");
            return A;
        }
    }


    /*
     * TODO: Complete this method
     */
    //Used QuickSort as was instructed to sort first by last name then by date of birth
    //this method initiates the quicksort
    public static Person[] sortByLastNameAndDateOfBirth(Person[] A) {
        quick_sort(A, 0, A.length-1);
        return A;
    }

    //this is the conquer part of the quick sort
    public static void quick_sort(Person[] mainArray, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int q = partition(mainArray, beginIndex, endIndex);
            quick_sort(mainArray, beginIndex, q - 1);
            quick_sort(mainArray, q + 1, endIndex);
        }
    }
    //this is the combine/partition part of the quick sort,
    //returns an index of an array, which is the final location of the person
    //the left and right subarrays then need to be partitioned again after this method
    public static int partition(Person[] array, int beginIndex, int endIndex) {
        Person v = array[endIndex];
        int i = beginIndex - 1;
        for (int j = beginIndex; j <= endIndex - 1; j++){
            if (!array[j].getLastName().equalsIgnoreCase(v.getLastName())){
                if(array[j].getLastName().compareTo(v.getLastName()) <= 0){
                    i = i + 1;
                    Person tempPerson = array[i];  //swapping the people
                    array[i] = array[j];
                    array[j] = tempPerson;
                }
            } else {
                if(array[j].getDateOfBirth().compareTo(v.getDateOfBirth()) <= 0){
                    i = i + 1;
                    Person tempPerson = array[i];  //swapping the people
                    array[i] = array[j];
                    array[j] = tempPerson;
                }
            }
        }
        Person tempPerson = array[i+1];  //swapping the people; the last time for this partition
        array[i+1] = array[endIndex];
        array[endIndex] = tempPerson;

        return i + 1;  //the person on this location/index will not move again; it has been finalized
    }


}

