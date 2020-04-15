
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elif
 */
public class MyDeque<E> {

    ArrayList<E> myArrayList = new ArrayList<>();

    //insert front
    public void push(E item) {
        myArrayList.add(0, item);
    }

    //insert rear
    public void inject(E item) {
        myArrayList.add(item);
    }

    //remove front
    public E pop() {
        E x;
        if (myArrayList.isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        } else {
            x = myArrayList.remove(0);
            return x;
        }
    }

    //remove rear
    public E eject() {
        E x;
        if (myArrayList.isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        } else {
            x = myArrayList.remove(myArrayList.size() - 1);
            return x;
        }
    }

    public void print() {
        Iterator it = myArrayList.iterator();
        while (it.hasNext()) {
            E x = (E) it.next();
            System.out.println(x);
        }
    }

}
