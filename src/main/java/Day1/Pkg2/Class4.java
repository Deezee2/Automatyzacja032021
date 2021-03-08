package Day1.Pkg2;

import Day1.Pkg1.Class1;

public class Class4 extends Class1 {
    public void metoda2(){
        publiczne=1;
        protektowana=1;
        // zadna=1;  // ta nie
        // prywatna=1;  // ta nie
    }
}




//Class4 - inny pkg, dziedziczy po 1 - do których pól dostęp?
//Class5 - inny pkg, nie dziedziczy, tylko tworzy obiekt klasy 1 - do których pól dostęp?
