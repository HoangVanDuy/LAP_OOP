package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private final Media media;
    private final Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblTitle = new JLabel(media.getTitle());
        lblTitle.setFont(new Font(lblTitle.getFont().getName(), Font.BOLD, 16));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblTitle);

        JLabel lblCategory = new JLabel("Category: " + media.getCategory());
        lblCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblCategory);

        JLabel lblCost = new JLabel(String.format("%.2f $", media.getCost()));
        lblCost.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblCost);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(e -> addToCart());
        buttonPanel.add(btnAdd);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> playMedia());
            buttonPanel.add(btnPlay);
        }

        add(buttonPanel);
    }

    private void addToCart() {
        try {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(this,
                    "Added \"" + media.getTitle() + "\" to cart.",
                    "Cart",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (LimitExceededException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Cart full",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void playMedia() {
        try {
            String details = ((Playable) media).getPlayDescription();
            JOptionPane.showMessageDialog(this,
                    details,
                    "Play",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (PlayerException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Player Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
