import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
    private JFrame frame;
    private JPanel panel, inputPanel, signsPanel, resultPanel;
    private JLabel title, num1Label, num2Label, resultLabel;
    private JTextField num1Field, num2Field;
    private JButton add, subtract, multiply, divide;

    public Calculator(){
        frame = new JFrame("Calculator");
        frame.setSize(400,250);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(244, 244, 246));
        title = new JLabel("Calculator");
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title, BorderLayout.NORTH);

        inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(new Color(244, 244, 246));
        num1Label = new JLabel("First Number:");
        num1Field = new JTextField();
        num2Label = new JLabel("Second Number:");
        num2Field = new JTextField();
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);
        
        JPanel inputPanel2 = new JPanel(new FlowLayout());
        inputPanel2.setBackground(new Color(244, 244, 246));
        inputPanel2.add(inputPanel);
        panel.add(inputPanel2, BorderLayout.CENTER);

        signsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        signsPanel.setBackground(new Color(244, 244, 246));
        add = new JButton("+");
        add.setBackground(new Color(117, 117, 117));
        add.setForeground(Color.WHITE);
        subtract = new JButton("-");
        subtract.setBackground(new Color(117, 117, 117));
        subtract.setForeground(Color.WHITE);
        multiply = new JButton("x");
        multiply.setBackground(new Color(117, 117, 117));
        multiply.setForeground(Color.WHITE);
        divide = new JButton("/");
        divide.setBackground(new Color(117, 117, 117));
        divide.setForeground(Color.WHITE);
        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        signsPanel.add(add);
        signsPanel.add(subtract);
        signsPanel.add(multiply);
        signsPanel.add(divide);
        panel.add(signsPanel, BorderLayout.SOUTH);

        resultPanel = new JPanel(new FlowLayout());
        resultPanel.setBackground(new Color(244, 244, 246));
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        resultPanel.add(resultLabel);
        panel.add(resultPanel, BorderLayout.SOUTH);
        JPanel signsPanel2 = new JPanel(new GridLayout(2,1,10,10));
        signsPanel2.setBackground(new Color(244, 244, 246));
        signsPanel2.add(signsPanel);
        signsPanel2.add(resultPanel);
        panel.add(signsPanel2, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    
    }

    public void actionPerformed(ActionEvent e){
        double result = 0;
        double num1 = 0;
        double num2 = 0;
        try{
            num1 = Double.parseDouble(num1Field.getText());
            num2 = Double.parseDouble(num2Field.getText());
        } catch (NumberFormatException ee){
            JOptionPane.showMessageDialog(frame, "Invalid input.");
            return;
        }
        if (e.getSource() == add) {
            result = num1 + num2;
        } else if (e.getSource() == subtract) {
            result = num1 - num2;
        } else if (e.getSource() == multiply) {
            result = num1 * num2;
        } else if (e.getSource() == divide) {
            if (num2 == 0) {
                JOptionPane.showMessageDialog(frame, "Cannot divide by zero.");
                return;
            }
            result = num1 / num2;
        }

        resultLabel.setText(String.format("Result: %.2f", result));
    }
    public static void main(String[] args){
        new Calculator();
    }
}
