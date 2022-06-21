package puyopuyo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Keyboard extends JPanel {
	int event;
	public Keyboard(Puyo p1, Puyo p2) {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
	
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				event = e.getKeyCode();
				if (event != 0)
					movePuyo(p1, p2);
			}
	
			@Override
			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public void movePuyo(Puyo p1, Puyo p2) {
		if (event == KeyEvent.VK_RIGHT) {
			p1.getAnimado().Right();
			p1.Right();
			p2.getAnimado().Right();
			p2.Right();
			System.out.println("Moveu para direita");
		}
		else if (event == KeyEvent.VK_LEFT) {
			p1.getAnimado().Left();
			p1.Left();
			p2.getAnimado().Left();
			p2.Left();
			System.out.println("Moveu para esq");
		}
		else if (event == KeyEvent.VK_DOWN) {
			p1.getAnimado().Down();
			p1.Down();
			p2.getAnimado().Down();
			p2.Down();
			System.out.println("Moveu para baixo");
		}
		else if (event == KeyEvent.VK_UP) {
			p1.getAnimado().Gira(p2.getAnimado());
			p1.Gira(p2);
			System.out.println("Girou");
		}
		
	}
}
