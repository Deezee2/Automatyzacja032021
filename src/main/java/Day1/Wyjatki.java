package Day1;

public class Wyjatki {

    public static void main(String[] args) {
        m2();
    }

    public static void m2(){
        m1();
    }

    public static void m1(){
        int x = 10;
        int y = 0;
        try {
            System.out.println("Start");
            double z = x / y ;
            System.out.println("Udało się. Wynik = "+z);
        }catch (ArithmeticException e){
            System.out.println("Wyjatek !!!");
            System.out.println(e.getMessage());
            e.printStackTrace(); // gdzieś zalogować -> mieć na później
            throw new ArithmeticException("Dzieli przez zero jełop!");
        }finally {
            System.out.println("Zawsze na koniec");
        }
        System.out.println("Juz po");
    }
}
