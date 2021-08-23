package tech.poorguy.simplemaven;

public class Demo {
    public void sayHi() {
        try {
            sayHiImpl(0);
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    public void sayHiImpl(int num) {
        int a = 4 / num;
    }

    public static void main(String[] args){
        new Demo().sayHi();
    }
}
