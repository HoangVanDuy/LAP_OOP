import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(" What's your name ?");
            String name = sc.nextLine();
            System.out.println("How old are you?");
            int age = sc.nextInt();
            System.out.println("How tall are you (m)?");
            float dheight = sc.nextFloat();
            sc.close();
            System.out.println("Mrs/ms." + name + "," + age + " years old" + "," + "Your height is " + dheight + ".");
        } catch (Exception e) {
            System.out.println(" Error your input !");
        }

    }
}
