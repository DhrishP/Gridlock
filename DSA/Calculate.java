import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate extends Frame implements ActionListener {

    private TextField display;
    private Button[] numericButtons;
    private Button addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

    private String input;
    private double num1, num2;
    private char operator;

    public Calculate() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Display
        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Numeric Buttons
        Panel numericPanel = new Panel();
        numericPanel.setLayout(new GridLayout(4, 3));

        numericButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numericButtons[i] = new Button(Integer.toString(i));
            numericButtons[i].addActionListener(this);
            numericPanel.add(numericButtons[i]);
        }

        // Operator Buttons
        Panel operatorPanel = new Panel();
        operatorPanel.setLayout(new GridLayout(5, 1));

        addButton = new Button("+");
        subtractButton = new Button("-");
        multiplyButton = new Button("*");
        divideButton = new Button("/");
        equalsButton = new Button("=");
        clearButton = new Button("C");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);

        operatorPanel.add(addButton);
        operatorPanel.add(subtractButton);
        operatorPanel.add(multiplyButton);
        operatorPanel.add(divideButton);
        operatorPanel.add(equalsButton);
        operatorPanel.add(clearButton);

        add(numericPanel, BorderLayout.CENTER);
        add(operatorPanel, BorderLayout.EAST);

        // Initialize
        input = "";
        num1 = num2 = 0;
        operator = '\0';
    }

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String buttonText = clickedButton.getLabel();

        // Handle numeric buttons
        for (int i = 0; i < 10; i++) {
            if (buttonText.equals(Integer.toString(i))) {
                input += buttonText;
                display.setText(input);
                return;
            }
        }

        // Handle operator buttons
        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                if (!input.isEmpty()) {
                    num1 = Double.parseDouble(input);
                    operator = buttonText.charAt(0);
                    input = "";
                    display.setText("");
                }
                break;

            case "=":
                if (!input.isEmpty()) {
                    num2 = Double.parseDouble(input);
                    double result = calculateResult();
                    display.setText(Double.toString(result));
                    input = "";
                    num1 = result;
                }
                break;

            case "C":
                input = "";
                num1 = num2 = 0;
                operator = '\0';
                display.setText("");
                break;
        }
    }

    private double calculateResult() {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    display.setText("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Calculate calculator = new Calculate();
        calculator.setVisible(true);
    }
}
