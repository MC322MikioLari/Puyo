package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Keyboard extends JPanel implements ActionListener{
	
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
	
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
			if (p1.getX() + Celula <= widthWindow-WIDTH && p2.getX() + Celula <= widthWindow-WIDTH) {
				if ((p1.checkPuyos(p1.getX() + Celula, p1.getY()) == false) && (p2.checkPuyos(p2.getX() + Celula, p2.getY()) == false)) {
					p1.setX(p1.getX() + Celula);
					p2.setX(p2.getX() + Celula);
					System.out.println("Moveu para direita");
					event = 0;
				}
			}
		}
		else if (event == KeyEvent.VK_LEFT) { //Virando para esquerda
			if (p1.getX() - Celula >= 0 && p2.getX() - Celula >= 0) {
				if ((p1.checkPuyos(p1.getX() - Celula, p1.getY()) == false) && (p2.checkPuyos(p2.getX() - Celula, p2.getY()) == false)) {
					p1.setX(p1.getX() - Celula);
					p2.setX(p2.getX() - Celula);
					System.out.println("Moveu para esq");
					event = 0;
				}
			}
		}
		else if (event == KeyEvent.VK_DOWN) { // Indo para baixo
			if (p1.getY() + Celula <= heightWindow && p2.getY() + Celula <= heightWindow) {
				if ((p1.checkPuyos(p1.getX(), p1.getY()+Celula) == false) && (p2.checkPuyos(p2.getX(), p2.getY()+ Celula) == false)) {
					p1.setY(p1.getY() + Celula);
					p2.setY(p2.getY() + Celula);
					System.out.println("Moveu para baixo");
					event = 0;
				}
			}
		}
		else if (event == KeyEvent.VK_UP) { // Girando
			System.out.println(p2.getY());
			if (p1.getAngulo() == 0) {
				p1.setX(p1.getX() - Celula);
				p1.setY(p2.getY());
				p1.setAngulo(45);
			}
			else if (p1.getAngulo() == 45) {
				p1.setX(p1.getX() + Celula);
				p1.setY(p1.getY() - Celula);
				p1.setAngulo(90);
			 }
			 else if (p1.getAngulo() == 90) {
				p1.setX(p1.getX() + Celula);
				p1.setY(p1.getY() + Celula);
			 	p1.setAngulo(135);
			 }
			 else if (p1.getAngulo() == 135) {
			 	p1.setX(p1.getX() - Celula);
				p1.setY(p1.getY() + Celula);
			 	p1.setAngulo(0);
			 }
			System.out.println("Girou");
			event = 0;
	   }
		p1.setLocation(p1.getX(), p1.getY());
		p2.setLocation(p2.getX(), p2.getY());
	}
}
