package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 100;

    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    // Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsInStore[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Added to cart: " + disc.getTitle());
        } else {
            System.out.println("The cart is almost full");
        }
    }


    // Remove DVD
    public void removeDigitalVideoDisc(String title) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
                found = true;

                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }

                itemsInStore[qtyOrdered - 1] = null;
                qtyOrdered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found");
        }
    }

    //print
    public void print() {
        System.out.println("******** CART ********");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc items = itemsInStore[i];
            System.out.println(items.toString());
        }
        System.out.println("***********************");
    }

}
