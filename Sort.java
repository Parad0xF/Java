public class Sort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) // Bubble up i’th record
            for (int j = array.length - 1; j > i; j--)
                if ((array[j] < (array[j - 1])))
                    swap(array, j, j - 1);

    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) // Insert i’th record
            for (int j = i; (j > 0) && (array[j] < (array[j - 1])); j--) {
                swap(array, j, j - 1);
            }


    }

    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;


    }

    public static void selectionSort(int[] array) {
        int countSwaps = 0;
        for (int i = 0; i < array.length - 1; i++) {  // Select i’th record
            int lowindex = i; // Remember its index
            for (int j = array.length - 1; j > i; j--) { // Remember its index
                if (array[j] < (array[lowindex])) // Find the least value
                    lowindex = j; // Put it in place
                //countSwaps++;
                swap(array, i, lowindex);
            }
        }
    }



/*
    public static void bubbleSort(int[] array, int left, int right) {

        for (int i = left ; i < right - 1; i++) { // Bubble up i’th record
            for (int j = right - 1; j > i; j--){
                if ((array[j] < (array[j - 1]))) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array, int left, int right) {
        for (int i = left; i < right; i++) // Insert i’th record
            for (int j = i; (j > left) && (array[j] < (array[j - 1])); j--) {
                swap(array, j, j - 1);
            }


    }

    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;


    }

    public static void selectionSort(int[] array, int left, int right) {
        //int countSwaps = 0;
        for (int i=left; i < right -1; i++) {
            int lowindex = i;
            for (int j= right -1 ; j>i; j--){
                if (array[j] < (array[lowindex])) { // Find the least value
                    lowindex = j; // Put it in place
                }
            }
            swap(array, i, lowindex);
        }
    }


 */
}
