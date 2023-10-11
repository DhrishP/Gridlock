import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtClick {
    public static void main(String[] args) {
        // Create a Frame (a window)
        Frame frame = new Frame("AWT Example");

        // Create a Button
        Button button = new Button("Click Me");

        // Add an ActionListener to the Button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        // Add the Button to the Frame
        frame.add(button);

        // Set the size of the Frame
        frame.setSize(300, 200);

        // Make the Frame visible
        frame.setVisible(true);

        // Handle closing the Frame
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
