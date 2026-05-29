package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public interface Playable {
    String getPlayDescription() throws PlayerException;

    void play() throws PlayerException;
}
