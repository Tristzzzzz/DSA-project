package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoradListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
