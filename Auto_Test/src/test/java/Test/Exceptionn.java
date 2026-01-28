package Test;

public class Exceptionn {

    public static void main(String[] args) {


        int[] eray = {1,2,3,4,5,};
//        System.out.println(eray[7]);
        try {
            System.out.println(eray[7]);
        }
        catch (Exception e) {
//        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
//        finally {
        System.out.println("ERROR");
//        }

        int[] eray2 = {1, 2, 3, 4, 5,};
        System.out.println(eray2);
    }
}
