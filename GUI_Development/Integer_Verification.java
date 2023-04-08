import java.swing.*;
import java.awt.event.*;
import java.awt.*;

class Interger_Verification extends JFrame implements ActionListener{
    private JButton verifyButton;
    private JTextField verifyTextField, cancelButton;
    private JLabel verifyLabel;

    public Interger_Verification(){
        setTitle("Interger Verification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField = new JTextField(10);
        add(textField);
        verifyButton = new JButton("Verify");
        verifyButton.addActionListener(this);
        add(verifyButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        add(cancelButton);
        resultLabel = new JLabel("");
        add(resultLabel);
        
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==verifyButton){
            try{
                int value = Interger.parseInt(textField.getText());
                resultLabel.setText(value+" is an integer.");
            }catch(NumberFormatException ee){
                resultLabel.setText(textField.getText()+" is not an integer.");
            }
        } else if(e.getSource()==cancelButton){
            dispose();
        }
    }
    
    public static void main(String[] args){
        new Interger_Verification();
    }
}

