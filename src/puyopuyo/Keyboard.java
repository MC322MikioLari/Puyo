package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener{
	int event = 0;
	Puyo p1, p2;
	public Keyboard(Notifier metro) {
		this.p1 = null;
		this.p2 = null;
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				event = e.getKeyCode();
				Action(metro);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	public void Action(Notifier metro) {
		metro.addActionListener(this);
	}
	public void settingEvent() {
		if (event != 0) {
			p1.setEvent(event);
			p2.setEvent(event);
		}
	}
	public void link(Puyo Puyo1, Puyo Puyo2) {
		this.p1 = Puyo1;
		this.p2 = Puyo2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (event == KeyEvent.VK_RIGHT) { //Virando para direita
			p1.setShiftY(0);
			p1.setShiftX(35);
			p2.setShiftY(0);
			p2.setShiftX(35);
			System.out.println("Moveu para direita");
			event = 0;
		}
		else if (event == KeyEvent.VK_LEFT) { //Virando para esquerda
			p1.setShiftY(0);
			p1.setShiftX(-35);
			p2.setShiftY(0);
			p2.setShiftX(-35);
			System.out.println("Moveu para esq");
			event = 0;
		}
		else if (event == KeyEvent.VK_DOWN) { // Indo para baixo
			p1.setShiftY(20);
			p1.setShiftX(0);
			p2.setShiftY(20);
			p2.setShiftX(0);
			System.out.println("Moveu para baixo");
			event = 0;
		}
		else if (event == KeyEvent.VK_UP) { // Girando
			if (p1.getAngulo() == 0) {
				p1.setShiftX(-35);
				p1.setShiftY(-8);
				p1.setAngulo(45);
			}
			else if (p1.getAngulo() == 45) {
				p1.setShiftX(35);
				p1.setShiftY(-5);
				p1.setAngulo(90);
			 }
			 else if (p1.getAngulo()==90) {
				p1.setShiftX(35);
			 	p1.setShiftY(44);
			 	p1.setAngulo(135);
			 }
			 else if (p1.getAngulo()==135) {
				p1.setShiftX(-35);
			 	p1.setShiftY(54);
			 	p1.setAngulo(0);
			 }
			System.out.println("Girou");
			event = 0;
	   }
	}
}
