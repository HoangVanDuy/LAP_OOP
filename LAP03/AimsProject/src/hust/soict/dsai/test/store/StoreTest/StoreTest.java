package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.Scanner;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        //Create new dvd objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDigitalVideoDisc(dvd3);

        store.print();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        store.removeDigitalVideoDisc(title);
        store.print();
        scanner.close();
    }
}
