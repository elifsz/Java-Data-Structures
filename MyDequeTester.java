/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elif
 */
public class MyDequeTester {

    public static void main(String[] args) {
        MyDeque<Integer> my2 = new MyDeque<>();
        my2.push(20);
        my2.push(30);
        my2.print();
        System.out.println("--");
        my2.eject();
        my2.print();
        my2.inject(303030);
        System.out.println("--");
        my2.print();
        my2.inject(1223);
        my2.push(123);
        System.out.println("--");
        my2.print();
    }
}
