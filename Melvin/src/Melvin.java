import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 *  <h1>Melvin</h1>
 *  Driver class
 *  Written Using Java 15
 *  @author Maraiah Matson, William Muhlbach
 *  @version 1.1
 *  @since 2021-03-16
 */
final class Melvin{
    private Melvin(){
        // adding this method prevents instantiation of Melvin elsewhere as a safeguard
    }

    public static void main(String[] args) throws IOException {
        //StoragePlaceholder storage = new StoragePlaceholder(5);
        Storage storage = Storage.load();
        Window.load();
        Goal test = new Goal();
        test.setName("test");
        //test.setStart("2021-03-24");
        //test.setEnd("2021-03-31");
        //test.setFrequency(1);
        test.setMessage("i exist");
        test.setGoodBad(true);
        test.setShortLong(true);
        test.setDescription("test of data");
        storage.add(test);
        System.out.println(test.toString());

        // debug example
        Debug debug = Debug.getInstance();
        // CHANGE THIS VARIABLE TO TOGGLE DEBUGGING MODE
        debug.active = true;

        // storage test
        //Storage storage = new Storage();
        //storage.test();
        storage.close();

    }


}

class CreateButtonListener implements ActionListener{
    Debug debug = Debug.getInstance();
    Storage storage = Storage.load();
    @Override
    public void actionPerformed(ActionEvent e) {
        GoalCreatePopup popup = new GoalCreatePopup();
        if(popup.saved== JOptionPane.OK_OPTION){
            storage.add(popup.newGoal);
        }
        debug.print(popup.saved);
        debug.print("\nThis is a test\n");
        //refresh();
    }
}

class GoalSelectedListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
