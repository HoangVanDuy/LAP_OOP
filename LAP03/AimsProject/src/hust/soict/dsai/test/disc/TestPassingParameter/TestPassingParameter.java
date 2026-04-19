package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderella");

        swap(jungleDVD,cinderellaDVD);
        System.out.println("jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle DVD title: " + jungleDVD.getTitle());
    }

//    private static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        String tmp = d1.getTitle();
        d1.setTitle(d2.getTitle());
        d2.setTitle(tmp);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
