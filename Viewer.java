import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

public class Viewer {

    private Canvas canvas;
    private static JFrame frame;
    private static final Dimension APP_SIZE = new Dimension(1480, 900);
    private static final Dimension CANVAS_SIZE = new Dimension(1500, 1500); 
    private boolean created = false;
    private JButton soundButton;

    public Viewer() {

	Controller controller = new Controller(this);

	Model model = controller.getModel();

	canvas = new Canvas(model);
	canvas.setPreferredSize(CANVAS_SIZE);

	JScrollPane scrollPane = new JScrollPane(canvas);

	// Run
	JMenuItem run = new JMenuItem("Run");
	run.addActionListener(controller);
    run.setActionCommand("Run");

	JMenu runMenu = new JMenu("Run");
	runMenu.add(run);

	// Level
	JMenuItem nextLevel = new JMenuItem("Next Level");
	nextLevel.addActionListener(controller);
    nextLevel.setActionCommand("Next Level");

    JMenuItem restartLevel = new JMenuItem("Restart Level");
    restartLevel.addActionListener(controller);
    restartLevel.setActionCommand("Restart Level");

    JMenuItem selectLevel = new JMenuItem("Load Level");
    selectLevel.addActionListener(controller);
    selectLevel.setActionCommand("Load Level");

	JMenu levelMenu = new JMenu("Level");
	levelMenu.add(nextLevel);
	levelMenu.add(restartLevel);
	levelMenu.add(new JSeparator());
	levelMenu.add(selectLevel);

	// Sound
	JMenu volume = new JMenu("Volume");
	JMenuItem s100 = new JMenuItem("100%");
	s100.addActionListener(controller);
    s100.setActionCommand("100%");
	JMenuItem s75 = new JMenuItem("75%");
	s75.addActionListener(controller);
    s75.setActionCommand("75%");
	JMenuItem s50 = new JMenuItem("50%");
	s50.addActionListener(controller);
    s50.setActionCommand("50%");
	JMenuItem s25 = new JMenuItem("25%");
	s25.addActionListener(controller);
    s25.setActionCommand("25%");
	JMenuItem s0 = new JMenuItem("0%");
	s0.addActionListener(controller);
    s0.setActionCommand("0%");


	JMenuItem soundOn = new JMenuItem("Sound ON");
	soundOn.addActionListener(controller);
    soundOn.setActionCommand("Sound ON");

	JMenuItem soundOff = new JMenuItem("Sound OFF");
	soundOff.addActionListener(controller);
    soundOff.setActionCommand("Sound OFF");

	JMenu soundMenu = new JMenu("Sound");
	soundMenu.add(volume);
	volume.add(s100);
	volume.add(s75);
	volume.add(s50);
	volume.add(s25);
	volume.add(s0);
	soundMenu.add(new JSeparator());
	soundMenu.add(soundOn);
	soundMenu.add(soundOff);

	// Menu
	JMenuBar menuBar = new JMenuBar();

	menuBar.add(levelMenu);
	menuBar.add(soundMenu);
	menuBar.add(runMenu);

	//JToolBar Buttons

	JButton restartButton = new JButton (new ImageIcon("images/Restart.png"));
	restartButton.addActionListener(controller);
    restartButton.setActionCommand("Restart Level");
    restartButton.setBackground(new Color(209, 247, 202));
    restartButton.setBorder(BorderFactory.createEmptyBorder());
    restartButton.setFocusable(false);


    String[] items = new String[] {"Level 1",
     								"Level 2",
     								"Level 3",
     								"Level 4",
     								"Level 5",
     								"Level 6",
     								"Level 7",
     								"Level 8"
     								};
    JComboBox levelList = new JComboBox<String> (items);
    levelList.setSelectedIndex(0);
	levelList.addActionListener(controller);
	levelList.setFocusable(false);
	levelList.setSize(100, 200);
	levelList.setBackground(new Color(209, 247, 202));
	levelList.setFont(new Font("Impact", Font.PLAIN, 20));


    JLabel selectLevelLabel = new JLabel("Select Level :");
    selectLevelLabel.setFont(new Font("Impact", Font.PLAIN, 20));

	soundButton = new JButton (new ImageIcon("images/SoundON.png"));
	soundButton.addActionListener(controller);
    soundButton.setActionCommand("Sound ON/OFF");
    soundButton.setBackground(new Color(209, 247, 202));
    soundButton.setBorder(BorderFactory.createEmptyBorder());
    soundButton.setFocusable(false);

    //JToolBar
   	
	JToolBar toolBar = new JToolBar("Tool bar");
	toolBar.add(restartButton);
	toolBar.addSeparator();
	toolBar.add(selectLevelLabel);
	toolBar.addSeparator();
	toolBar.add(levelList);
	toolBar.addSeparator();
	toolBar.add(soundButton);
	toolBar.setFloatable(false);
	toolBar.setRollover(true);
	toolBar.setBackground(new Color(209, 247, 202));
	toolBar.setBorder(BorderFactory.createEmptyBorder());

	// Frame
	frame = new JFrame("Sokoban");
	frame.setSize(APP_SIZE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setJMenuBar(menuBar);
	frame.setLocation(100, 0);
	frame.setVisible(true);
	frame.addKeyListener(controller);
	frame.add(scrollPane);
	scrollPane.setBorder(BorderFactory.createEmptyBorder());
	frame.add(toolBar, BorderLayout.PAGE_START);

	created = true;
    }

    public JButton getSoundButton () {
    	return soundButton;
    }

    public void update() {
		canvas.repaint();
    }

    public static JFrame getMainFrame() {
    	return frame;
    }
}