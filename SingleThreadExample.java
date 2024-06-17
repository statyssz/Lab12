public class SingleThreadExample {
    public static void main(String[] args) {
        final int SIZE = 1000000;
        long[] array = new long[SIZE];


        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            array[i] = array[i] * 2;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения однопоточного метода: " + (endTime - startTime) + " ms");
    }
}
