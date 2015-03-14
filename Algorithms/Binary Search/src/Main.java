public class Main {
    public static void main(String[] args) {
        int[] list = {1,6,38,39,52,57,61,65,85,88,89,90,91,95,100};
        int num = 90;
        int index = binarySearch(list, num, 0, list.length);
        if(index > 0) {
            System.out.println("The number " + num + " was found at index " + index);
        }
        else {
            System.out.println("The number " + num + " does not exist in the list");
        }
    }

    private static int binarySearch(int[] a, int num, int lower, int upper) {
        if(lower > upper)
            return -1;
        int mid = (lower + upper) / 2;
        if(a[mid] == num){
            return mid;
        } else if (a[mid] > num) {
            return binarySearch(a, num, lower, mid-1);
        } else {
            return binarySearch(a, num, mid+1, upper);
        }
    }
}
