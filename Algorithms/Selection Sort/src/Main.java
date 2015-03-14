public class Main {
    public static void main(String[] args) {
        int[] list = {1,4,13,6,7,34,6,7,1,4,7,8,1,4,6,1,3,5};
        System.out.println("The old list: ");
        printList(list);
        selectionSort(list);
        System.out.println("The new list: ");
        printList(list);
    }

    private static void selectionSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            Boolean swap = false;
            int min = a[i], index = 0;
            for(int n = i + 1; n < a.length; n++) {
                if(a[n] < min) {
                    min = a[n];
                    index = n;
                    swap = true;
                }
            }
            if(swap) {
                int temp = a[i];
                a[i] = min;
                a[index] = temp;
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
