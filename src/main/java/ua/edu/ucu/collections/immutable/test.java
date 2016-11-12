package ua.edu.ucu.collections.immutable;


/**
 * Created by oleh on 12.11.16.
 */
public class test {
    final private StringBuilder s1;
    public test(StringBuilder s){
        this.s1 = s;
    }
    public void str(){
        System.out.print(s1);
    }
    public StringBuilder get(){
        return this.s1;
    }
    public static void main(String[] arg){
        test a = new test(new StringBuilder("aaaaaa"));

        StringBuilder b = new StringBuilder("aaaaaa");
        StringBuilder c = b;
        c.setCharAt(2, 'k');

        a.str();
        StringBuilder k = a.get();
        k.setCharAt(2, 'k');
        a.str();
    }
}
