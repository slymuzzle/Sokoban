import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Font;


public class Canvas extends JPanel {

    private Model model;

    private Image imagePlayer;
	private Image imageWall;
	private Image imageBox;
	private Image imageGoal;
	private Image imageFloor;
	private Image imageFence;
	private Image imageFenceLeftCornerUp;
	private Image imageFenceLeftCornerDown;
	private Image imageFenceRightCornerUp;
	private Image imageFenceRightCornerDown;
	private Image imageFenceDown;


    private Image imageDuke;

    public Canvas(Model model) {
	this.model = model;
	setBackground(new Color(209, 247, 202));

	File fileNamePlayer = new File("images/player64.png");
	File fileNameWall = new File("images/wall64.png");
	File fileNameBox = new File("images/box64.png");
	File fileNameGoal = new File("images/goal64.png");
	File fileNameFloor = new File("images/floor64.png");
	File fileNameFence = new File("images/fence64.png");
	File fileNameFenceLeftCornerUp = new File("images/fenceleftcornerup64.png");
	File fileNameFenceLeftCornerDown = new File("images/fenceleftcornerdown64.png");
	File fileNameFenceRightCornerUp = new File("images/fencerightcornerup64.png");
	File fileNameFenceRightCornerDown = new File("images/fencerightcornerdown64.png");
	File fileNameFenceDown = new File("images/fencedown64.png");


	File fileNameDuke = new File("images/duke_jetsurf_orig.png");
	try {
		imagePlayer = ImageIO.read(fileNamePlayer);
		imageWall = ImageIO.read(fileNameWall);
		imageBox = ImageIO.read(fileNameBox);
		imageGoal = ImageIO.read(fileNameGoal);
		imageFloor = ImageIO.read(fileNameFloor);
		imageFence = ImageIO.read(fileNameFence);
		imageFenceLeftCornerUp = ImageIO.read(fileNameFenceLeftCornerUp);
		imageFenceLeftCornerDown = ImageIO.read(fileNameFenceLeftCornerDown);
		imageFenceRightCornerUp = ImageIO.read(fileNameFenceRightCornerUp);
		imageFenceRightCornerDown = ImageIO.read(fileNameFenceRightCornerDown);
		imageFenceDown = ImageIO.read(fileNameFenceDown);
		imageDuke = ImageIO.read(fileNameDuke);
	} catch(IOException e) {
	    System.out.println(e);
	}

    }

    public void paint(Graphics pen) {
	super.paint(pen);

	boolean flag = model.isReady();


	if(flag) {
		drawDesktop(pen);
	} else {

		pen.drawImage(imageDuke, 0, 0, getWidth(), getHeight(), null);
		pen.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 50));
		pen.setColor(Color.red);
		pen.drawString("Initialization Error!", 50, 100);
	}

    }

    private void drawDesktop(Graphics pen) {

	int[][] desktop = model.getDesktop();
	int x = 64;
	int y = 32;
	int width = 64;
	int height = 64;
	int offset = 0;


	for(int i = 0; i < desktop.length; i++) {
	    for(int j = 0; j < desktop[i].length; j++) {


		if(desktop[i][j] == 1) {
			pen.setColor(Color.red);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imagePlayer, x, y, null);
			pen.setColor(Color.white);
			//pen.drawRect(x, y, width, height);

		} else if(desktop[i][j] == 2) {
			pen.setColor(Color.orange);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageWall, x, y, null);
			pen.setColor(Color.white);
			//pen.drawRect(x, y, width, height);
		} else if(desktop[i][j] == 3) {
			pen.setColor(Color.blue);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageBox, x, y, null);
			pen.setColor(Color.white);
			//pen.drawRect(x, y, width, height);
		} else if(desktop[i][j] == 4) {
			pen.setColor(Color.blue);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageGoal, x, y, null);
			pen.setColor(Color.white);
			//pen.drawRect(x, y, width, height);
		} else if(desktop[i][j] == 0) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFloor, x, y, null);
		} else if(desktop[i][j] == 5) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFence, x, y, null);
		} else if(desktop[i][j] == 6) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFenceDown, x, y, null);
		} else if(desktop[i][j] == 7) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFenceLeftCornerUp, x, y, null);
		} else if(desktop[i][j] == 8) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFenceLeftCornerDown, x, y, null);
		} else if(desktop[i][j] == 9) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFenceRightCornerUp, x, y, null);
		} else if(desktop[i][j] == 10) {
			pen.setColor(Color.white);
			pen.fillRect(x, y, width, height);
			pen.drawImage(imageFenceRightCornerDown, x, y, null);
		} else{
			pen.setColor(new Color(209, 247, 202));
			pen.fillRect(x, y, width, height);
		}

		x = x + width + offset;

	    }

	x = 64;

	y = y + height + offset;
	}



    }
}