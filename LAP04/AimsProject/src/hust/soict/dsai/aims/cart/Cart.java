package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }

    public Media searchByTitleReturn(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void emptyCart() {
        itemsOrdered.clear();
    }
}
