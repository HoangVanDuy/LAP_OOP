package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            while (true) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc) {
                System.out.println("The cart has been updated.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("1. DVD  2. CD  3. Book");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            
            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title));
            } else if (type == 2) {
                store.addMedia(new CompactDisc(title));
            } else if (type == 3) {
                store.addMedia(new Book(title));
            }
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found in store.");
            }
        }
    }

    public static void seeCurrentCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    System.out.println("Order created. Cart is empty now.");
                    cart.emptyCart();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediasInCart() {
        System.out.println("1. Filter by ID  2. Filter by Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortMediasInCart() {
        System.out.println("1. Sort by Title  2. Sort by Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            cart.sortByTitleCost();
            System.out.println("Sorted by Title.");
        } else if (choice == 2) {
            cart.sortByCostTitle();
            System.out.println("Sorted by Cost.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitleReturn(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMediaInCart() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitleReturn(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void initData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        store.addMedia(dvd3);
        
        Book book1 = new Book("Harry Potter", "Fantasy", 20.0f);
        store.addMedia(book1);
        
        CompactDisc cd1 = new CompactDisc("Adele 21", "Music", "Adele", 15.0f, "Adele");
        cd1.addTrack(new Track("Rolling in the Deep", 228));
        cd1.addTrack(new Track("Someone Like You", 285));
        store.addMedia(cd1);
    }
}
