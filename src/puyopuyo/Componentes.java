package puyopuyo;

public class Componentes {
	
	private int posX, posY, color;
	private String img;
	
    public Componentes(){
    	this.posX = 0;
		this.posY = 0;
		this.color = 0;
		this.img = "";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /*
	private Image componentes[];

	 public Componentes(int nFrames){
		posX = 0;
		posY = 0;
		frame = 1;
		this.nFrames = nFrames;
		componentes = new Image[nFrames+1];
	 }
	 
	public void addFrame(int frameNum, String path){
		try {
		    URL url = Componentes.class.getResource(path);
		    componentes[frameNum] = Toolkit.getDefaultToolkit().getImage(url);
		}
		catch(Exception ex) {
		    System.err.println("Could not load image:" + path + " " + ex.toString());
		}
	 }
	public void draw(Graphics g) {
		g.drawImage(componentes[frame], posX, posY, null);
	}
	*/
}
