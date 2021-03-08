package Day1;

public class HelloWorld {
    public static String wiadomosc = "Hello";
    public static int ile_razy_wyswietlic = 6;

    public static void wypisz() {
        for (int i = 0; i < ile_razy_wyswietlic; i++) {
            System.out.println(wiadomosc);
        }

//        int counter = 0;
//        while(counter<ile_razy_wyswietlic){  //wykona się 0 lub więcej razy
//            System.out.println(wiadomosc);
//            counter++;
//        }

        int counter = 0;
        do {                   //wykona się co najmniej 1 lub więcej razy
            System.out.println(wiadomosc);
            counter++;
        }while (counter < ile_razy_wyswietlic);

    }

        public static void main(String[] args) {

        wypisz();

//        String message = "Hello World";
//
//        String message2 = new String("Hello World");
//
//        String number = "123.245.234";
//
//        System.out.println(123245234==Integer.
//                parseInt(number.replace(".","")));
//
//        System.out.println(message.equals("Hello World"));
//        System.out.println(message.equals(message2));
//
//        System.out.println( "Hello World" );
    }
}
