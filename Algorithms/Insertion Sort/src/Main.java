public class Main {
    public static void main(String[] args) {
        int[] list = {1,6,1,3,7,8,2,3,8,9,2,4,5,7,3,4,2,34,5};
        System.out.println("The old list: ");
        printList(list);
        insertionSort(list);
        System.out.println("The new list: ");
        printList(list);
    }

    private static void insertionSort(int[] a) {
        Boolean order = true;
        while (order) {
            order = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    order = true;
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
