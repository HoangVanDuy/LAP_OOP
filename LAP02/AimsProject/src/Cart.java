public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
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
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                found = true;

                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found");
        }
    }

    // Total cost
    public float totalCost() {
        float total = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }

        return total;
    }

    // Show cart
    public void displayCart() {
        System.out.println("----- CART -----");
        for (int i = 0; i < qtyOrdered; i++) {
            itemsOrdered[i].printInfo();
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("-----------------");
    }
}