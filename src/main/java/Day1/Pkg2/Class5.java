package Day1.Pkg2;

import Day1.Pkg1.Class1;

public class Class5 {
    Class1 class1 = new Class1();

    public void metoda(){
        class1.publiczne=1;
//        class1.protektowana=1;  // ta nie
//        class1.zadna=1;  // ta nie
        class1.setZadna(1);
//        class1.prywatna=1;  // ta nie
    }

}