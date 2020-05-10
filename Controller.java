import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Controller implements KeyListener, ActionListener {

    private Model model;

    public Controller(Viewer viewer) {
	model = new Model(viewer);
    }

    public Model getModel() {
	return model;
    }

    public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    String command;
    if (source instanceof JMenuItem) {
        command = event.getActionCommand();
   	 	model.doAction(command);
    } else if (source instanceof JComboBox) {
    	JComboBox box = (JComboBox)event.getSource();
    	command = (String)box.getSelectedItem();
    	model.doAction(command);
    	} else if (source instanceof JButton) {
    	command = event.getActionCommand();
    	model.doAction(command);
    	}
	}

    public void keyTyped(KeyEvent event) {

    }

    public void keyPressed(KeyEvent event) {

	int keyCode = event.getKeyCode();

	String direction = "";

	switch(keyCode) {

		case 37:
			direction = "Left";
		break;
		case 38:
			direction = "Up";
		break;
		case 39:
			direction = "Right";
		break;
		case 40:
			direction = "Down";
		break;
		default:
			return;

	}
	model.move(direction);

    }

    public void keyReleased(KeyEvent event) {

    }

}