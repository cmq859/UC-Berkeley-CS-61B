public class Main {
    public static void main(String[] args) {
        int[] list = {1,5,6,2,3,6,1,3,67,8,1,2,3,5,3,24,4};
        System.out.println("The old list: ");
        printList(list);
        bubbleSort(list);
        System.out.println("The new list: ");
        printList(list);
    }

    private static void bubbleSort(int[] a) {
        Boolean swap = true;
        while (swap) {
            swap = false;
            for(int i = 0; i < a.length - 1; i++) {
                if(a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swap = true;
                }
            }
        }
    }

    private static void printList(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}
