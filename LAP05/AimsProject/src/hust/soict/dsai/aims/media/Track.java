package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getPlayDescription() throws PlayerException {
        if (this.length <= 0) {
            throw new PlayerException("ERROR: Track length is zero!");
        }
        return "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }

    @Override
    public void play() throws PlayerException {
        System.out.println(getPlayDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return length == track.length && title != null && title.equals(track.title);
    }
}
