package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        //Print
        cart.print();

        //Search
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id to search: ");
        int id = sc.nextInt();
        sc.nextLine();
        cart.searchById(id);

        System.out.print("Enter title to search: ");
        String title = sc.nextLine();
        cart.searchByTitle(title);

        sc.close();
    }
}
