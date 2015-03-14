/**
 * Created by IntelliJ IDEA.
 * User: Lawrence
 * Date: 3/8/2015
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        /*
            Assignments and casting:
            1. You can write xa = ya, but you must cast xa  before assigning it to ya
            2. If it is an array of Y objects, you can assign it to xa, but you must cast it to Y[] before
                assigning it to xa
            3. If it is an array of X objects in xa, you must cast it to Y[] before assigning it to ya. You
                do not need to cast it back to assign it to xa.
               Same thing it it was an array of Y objects in ya. The compiler must see you cast it because
                it isn't sure if it is X or Y objects even though you know.
         */
        X[] xa = new X[10];
        Y[] ya = new Y[10];
        xa = ya;
        ya = (Y[]) xa;
        for (int i = 0 ; i < 10; i++) {
            ya[i] = new Y();
        }
        xa = ya;
        ya = (Y[]) xa;
        for (int i = 0; i < 10; i++) {
        //    xa[i] = new X();
        }
        ya = (Y[]) xa;
        xa = ya;
        for (int i = 0; i < 10; i++) {
            xa[i] = new Y();
        }
        ya = (Y[]) xa;
        xa = ya;

        /*
            Conflicting Declarations:
            1. It will compile if you implement the method from the abstract class
            2. It will compile because the method implementation is from the superclass
            3. It will not compile because the method is not implemented
            4. It will compile
         */
        Y yClass = new Y();

        /*
            More Conflicting Declarations:
            1. Yes, it will compile. It makes no difference
            2. It makes a difference as you have to specify which one. Using Z.VALUE or X.VALUE
            3. Must use either Z.VALUE or X.VALUE
         */
        Y y = new Y();
        System.out.println(y.getValue());

        /*
            Method Overriding:
            1. It gets the sub class's method
            2. It gets an errors because you can't cast it to the sub class
            3. No.
         */
        y = new Y();
        System.out.println(((X) y).method(5));
        X x = new X();
        //System.out.println(((Y) x).method(5));
        Y y1 = new Y();
        X x1 = y1;
        System.out.println(((X) x1).method(5));
    }

    private static class X {
        final static int VALUE = 5;
        public int method(int z) {
            return 1;
        }
    }

    private static class Y extends X implements Z {
        public int method(int z) {
            return 10013;
        }

        public int getValue() {
            return Z.VALUE;
        }
    }

    private static interface Z {
        final static int VALUE = 10;
        public int method(int x);
    }
}
