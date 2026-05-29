package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, director, 0, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    @Override
    public String getPlayDescription() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is zero!");
        }
        return "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
    }

    @Override
    public void play() throws PlayerException {
        System.out.println(getPlayDescription());
    }

    @Override
    public String toString() {
        return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - " + getCost();
    }
}
