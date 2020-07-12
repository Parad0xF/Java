import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.Arrays;

public class TimeMesurment {

    public static void main(String[] args) {

        System.out.println("Performing the time measure of the O(N*logN) sorting algorithm ");
        resultArraysSort();
        System.out.println("");
        System.out.println("Performing the time measure of the Bubble sorting algorithm ");
        resultBubble();
        System.out.println("");
        System.out.println("Performing the time measure of the Insertion sorting algorithm ");
        resultInsertion();
        System.out.println("");
        System.out.println("Performing the time measure of the Selection sorting algorithm ");
        resultSelection();
        System.out.println("");

    }


    public void saveDataInFile(String data, String fileName)
            throws IOException {
        RandomAccessFile stream = new RandomAccessFile(fileName, "rw");
        FileChannel channel = stream.getChannel();
        byte[] strBytes = data.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();
    }



    public static void resultArraysSort(){

        int[] testData;
        Random random = new Random();

        for (int size = 50_000; size <= 200_000; size *= 2) {
            System.out.printf("Size: %,d\n", size);
            testData = new int[size];

            System.out.println("Sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i;
            }
            timePerformanceOlogN(testData);
            System.out.println("Random test data");
            for (int i = 0; i < size; i++) {
                testData[i] = random.nextInt();
            }
            timePerformanceOlogN(testData);
            System.out.println("Reverse sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i-1;
            }
            timePerformanceOlogN(testData);

        }

    }



    public static void resultInsertion(){

        int[] testData;
        Random random = new Random();

        for (int size = 50_000; size <= 200_000; size *= 2) {
            System.out.printf("Size: %,d\n", size);
            testData = new int[size];

            System.out.println("Sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i;
            }
            timePerformanceInsertion(testData);
            System.out.println("Random test data");
            for (int i = 0; i < size; i++) {
                testData[i] = random.nextInt();
            }
            timePerformanceInsertion(testData);
            System.out.println("Reverse sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i-1;
            }
            timePerformanceInsertion(testData);

        }

    }

    public static void resultSelection(){

        int[] testData;
        Random random = new Random();


        for (int size = 50_000; size <= 200_000; size *= 2) {
            System.out.printf("Size: %,d\n", size);
            testData = new int[size];

            System.out.println("Sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i;
            }
            timePerformanceSelection(testData);
            System.out.println("Random test data");
            for (int i = 0; i < size; i++) {
                testData[i] = random.nextInt();
            }
            timePerformanceSelection(testData);
            System.out.println("Reverse sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i-1;
            }
            timePerformanceSelection(testData);


        }

    }



    public static void resultBubble(){

        int[] testData;
        Random random = new Random();

        for (int size = 50_000; size <= 200_000; size *= 2) {
            System.out.printf("Size: %,d\n", size);
            testData = new int[size];

            System.out.println("Sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i;
            }
            timePerformanceBubble(testData);

            System.out.println("Random test data");

            for (int i = 0; i < size; i++) {
                testData[i] = random.nextInt();
            }
            timePerformanceBubble(testData);

            System.out.println("Reverse sorted test data");
            for (int i = 0; i < size; i++) {
                testData[i] = i-1;
            }
            timePerformanceBubble(testData);

        }

    }

    public static void timePerformanceOlogN(int[] array){
        long start, end, totalRuntime;
        start = System.currentTimeMillis();
        Arrays.sort(array);
        end = System.currentTimeMillis();
        totalRuntime = (end - start);
        System.out.printf("     Lapse time: %d milliseconds\n", totalRuntime  );
    }


    public static void timePerformanceInsertion(int[] array){
        long start, end, totalRuntime;
        start = System.currentTimeMillis();
        Sort.insertionSort(array);
        end = System.currentTimeMillis();
        totalRuntime = (end - start);
        System.out.printf("     Lapse time: %d seconds\n", totalRuntime/1000  );
    }

    public static void timePerformanceBubble(int[] array){
        long start, end, totalRuntime;
        start = System.currentTimeMillis();
        Sort.bubbleSort(array);
        end = System.currentTimeMillis();
        totalRuntime = (end - start);
        System.out.printf("     Lapse time: %d seconds\n", totalRuntime/1000  );
    }


    public static void timePerformanceSelection(int[] array){
        long start, end, totalRuntime;
        start = System.currentTimeMillis();
        Sort.selectionSort(array);
        end = System.currentTimeMillis();
        totalRuntime = (end - start);
        System.out.printf("     Lapse time: %d seconds\n", totalRuntime/1000  );
    }
}
