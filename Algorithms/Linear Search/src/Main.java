public class Main {
    public static void main(String[] args) {
        int[] list = {11,6,3,4,8,2,4,7,2,4,15,1,35,6,1,64,13,3,51,59,3,31,3,21,35,45,3,95};
        int num = 64;
        int index = linearSearch(list, num);
        if (index >= 0) {
            System.out.println("The number " + num + " was found at index " + index);
        } else {
            System.out.println("It does not exist in the list");
        }
    }

    private static int linearSearch(int[] a, int num) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == num)
                return i;
        }
        return -1;
    }
}
