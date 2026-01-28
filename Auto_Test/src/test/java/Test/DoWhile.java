package Test;

public class DoWhile {

    public static void test() {


        /**
         * циклы
         * do while
         */

        int count = 10;
        while (count > 0) {
            count--;
            if (count == 4) {
                break;
            }
            System.out.println(count);
        }

        int row = 1;
        while (row < 4) {
            int cal = 1;
            while (cal <= 5) {
                System.out.print("#");
                cal++;
            }
            System.out.println();
            row++;
        }

        int rows = 1;
        do {
            System.out.println("gg " + rows);
            rows++;
        }
        while (false);
        while (rows < 4) ;


        int rows2 = 1;
        do {
            System.out.println("gg " + rows2);
            rows2++;
            if (rows2 == 5) {
                break;
            }
        } while (true);
//        while (rows < 4);


        for (int i = 0; i < 15; i++) {
            if (i % 3 == 0)
                continue;
            System.out.println("ee " + i);
        }


    }
}
