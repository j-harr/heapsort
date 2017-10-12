public class main {
    public static void main(String [] args){
        greeting();
        final int ARRAY1SIZE = 100;
        int[] array1 = new int[ARRAY1SIZE];
        for(int i = 0; i < ARRAY1SIZE; i++){
            array1[i] = 100 - i;
        }
        for(int i = 0; i < ARRAY1SIZE; i++){
            System.out.print(array1[i]);
            System.out.print(",");
        }

    }

    static void greeting(){
        System.out.println("Welcome to Heapsort");
    }
}
