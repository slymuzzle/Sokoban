import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Model implements Runnable {

    private Viewer viewer;
    private int[][] desktop;
    private int[][] indexesGoal;
    private int indexX;
    private int indexY;
    private Levels levels;
    private boolean isOk;
    private Sound sound;
    private JFileChooser fc;
    private boolean flagIcon = false;
    private static String levelPath;
    Thread t;


    public Model(Viewer viewer) {
	this.viewer = viewer;
	isOk = true;
	levels = new Levels();
	sound = new Sound();
	nextLevel();
    }

    private void initialization() {


	int one = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 1) {
				indexX = i;
				indexY = j;
				one++;
			}
		}
	}

	if(one != 1) {
		isOk = false;
	}

	int column = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 4) {
				column++;
			}
		}
	}
	indexesGoal = new int[2][column];
	int a = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 4) {
				indexesGoal[0][a] = i;
				indexesGoal[1][a] = j;
				a++;
			}
		}
	}
    }

    public void doAction(String value) {
    	int level;
    	switch(value) {
			case "Next Level":
				nextLevel();
			break;
			case "Restart Level":
				restartLevel();
			break;
			case "Load Level":
				level = 8;
				showFileChooser();
				levelPath = getPathFromFileChooser();
				loadNewLevel(levelPath);
			break;
			case "Run":
			t = new Thread(this);
			System.out.println("Thread created" + t);
			t.start();
			break;
			case "Level 1":
				level = 1;
				selectLevel(level);
			break;
			case "Level 2":
				level = 2;
				selectLevel(level);
			break;
			case "Level 3":
				level = 3;
				selectLevel(level);
			break;
			case "Level 4":
				level = 4;
				selectLevel(level);
			break;
			case "Level 5":
				level = 5;
				selectLevel(level);
			break;
			case "Level 6":
				level = 6;
				selectLevel(level);
			break;
			case "Level 7":
				level = 7;
				selectLevel(level);
			break;
			case "Level 8":
				level = 8;
				selectLevel(level);
			break;
			case "100%":
				sound.setVolume(1f);
			break;
			case "75%":
				sound.setVolume(0.75f);
			break;
			case "50%":
				sound.setVolume(0.5f);
			break;
			case "25%":
				sound.setVolume(0.25f);
			break;
			case "0%":
				sound.setVolume(0f);
			break;
			case "Sound ON/OFF":
			JButton soundButton = viewer.getSoundButton();
			 if (flagIcon == false) {
			 	soundButton.setIcon(new ImageIcon("images/SoundOFF.png"));
			 	soundButton.revalidate();
			 	sound.stop();
			 	flagIcon = true;
			 } else {
			 	soundButton.setIcon(new ImageIcon("images/SoundON.png"));
			 	soundButton.revalidate();
			 	sound.play();
			 	flagIcon = false;
			 }
			break;
			case "Sound ON":
				sound.play();
			break;
			case "Sound OFF":
				sound.stop();
			break;
    	}
    	viewer.update();
	}

    public void move(String direction) {


	switch(direction) {
		case "Left":
			moveLeft();
		break;

		case "Up":
			moveUp();
		break;

		case "Right":
			moveRight();
		break;

		case "Down":
			moveDown();
		break;


	}
	check();
	viewer.update();
	won();
    }




    private void check() {

	for(int j = 0; j < indexesGoal[0].length; j++) {
                int a = indexesGoal[0][j];
                int b = indexesGoal[1][j];

		if(desktop[a][b] == 0) {
			desktop[a][b] = 4;
		}
	}


    }

    private void moveRight() {
	if(desktop[indexX][indexY + 1] == 3) {
		if(desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
			desktop[indexX][indexY + 1] = 0;
			desktop[indexX][indexY + 2] = 3;
		}
	}
	if(desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
		desktop[indexX][indexY] = 0;
		indexY = indexY + 1;
		desktop[indexX][indexY] = 1;
	}
    }

    private void moveLeft() {
	if(desktop[indexX][indexY - 1] == 3) {
		if(desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
			desktop[indexX][indexY - 1] = 0;
			desktop[indexX][indexY - 2] = 3;
		}
	}

	if(desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
		desktop[indexX][indexY] = 0;
		indexY = indexY - 1;
		desktop[indexX][indexY] = 1;
	}


    }

    private void moveUp() {
	if(desktop[indexX - 1][indexY] == 3) {
		if(desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
			desktop[indexX - 1][indexY] = 0;
			desktop[indexX - 2][indexY] = 3;
		}
	}


	if(desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
		desktop[indexX][indexY] = 0;
		indexX = indexX - 1;
		desktop[indexX][indexY] = 1;
	}
    }

    private void moveDown() {

	if(desktop[indexX + 1][indexY] == 3) {
		if(desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
			desktop[indexX + 1][indexY] = 0;
			desktop[indexX + 2][indexY] = 3;
		}
	}


	if(desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
		desktop[indexX][indexY] = 0;
		indexX = indexX + 1;
		desktop[indexX][indexY] = 1;
	}
    }

    public int[][] getDesktop() {
	return desktop;
    }


    private void printDesktop() {
		for(int i = 0; i < desktop.length; i++) {
			for(int j = 0; j < desktop[i].length; j++) {
				System.out.print(desktop[i][j] + " ");
			}
		System.out.println();
		}
		System.out.println();
		System.out.println();
	}

   	private void nextLevel() {
	desktop = levels.nextLevel();
	initialization();
   }

    public void restartLevel() {
    	desktop = levels.restart();
    	initialization();
    }

    private void won() {
	boolean flag = true;
	for(int j = 0; j < indexesGoal[0].length; j++) {
                int a = indexesGoal[0][j];
                int b = indexesGoal[1][j];
		if(desktop[a][b] != 3) {
			flag = false;
			break;
		}
	}
	if(flag) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), "You are won!.");
		nextLevel();
		viewer.update();
	}
    }

    public boolean isReady() {
	return isOk;
    }

    private void showFileChooser() {
     	fc = new JFileChooser();
     	int returnVal = fc.showOpenDialog(viewer.getMainFrame());
     }

    private String getPathFromFileChooser() {
     	File fileName = fc.getSelectedFile();
        String levelPath = fileName.getPath();

        return levelPath;
     }

    private void loadNewLevel(String path) {
       	desktop = levels.loadNewLevel(path);
        initialization();
    }

    public static String getLevelPath() {
    	return levelPath;
    }
        
    private void selectLevel(int level) {
     	desktop = levels.selectLevel(level);
     	initialization();
	}
		public void run() {
			try {
				for(int x = 0; x <=2  ; x++) {
					for(int i = 0; i <= 5; i++){
					moveRight();
					viewer.update();
					Thread.sleep(100);
					}
					for(int j = 0; j <= 5; j++){
					moveDown();
					viewer.update();
					Thread.sleep(100);
					}
					for(int k = 0; k <= 5; k++){
					moveLeft();
					viewer.update();
					Thread.sleep(100);
					}
					for(int l = 0; l <= 5; l++){
					moveUp();
					viewer.update();
					Thread.sleep(100);
					}
				}
			} catch(InterruptedException e) {
				System.out.println("Main thread crush");
			}
	}

}