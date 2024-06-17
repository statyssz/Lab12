public class MultiThreadExample {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000000;
        long[] array = new long[SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        long[] array1 = new long[SIZE / 2];
        long[] array2 = new long[SIZE / 2];
        System.arraycopy(array, 0, array1, 0, SIZE / 2);
        System.arraycopy(array, SIZE / 2, array2, 0, SIZE / 2);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array1.length; i++) {
                array1[i] = array1[i] * 2;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < array2.length; i++) {
                array2[i] = array2[i] * 2;
            }
        });


        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();

        System.arraycopy(array1, 0, array, 0, SIZE / 2);
        System.arraycopy(array2, 0, array, SIZE / 2, SIZE / 2);

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения многопоточного метода: " + (endTime - startTime) + " ms");
    }
}
