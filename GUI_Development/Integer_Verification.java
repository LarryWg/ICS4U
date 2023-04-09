import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Integer_Verification extends JFrame implements ActionListener{
    private JTextField textField;
    private JButton verifyButton, cancelButton;
    private JLabel resultLabel;

    public Integer_Verification(){
        setTitle("Integer Verifier");
        setSize(300,150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(new JLabel("Enter an integer:"), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new Insets(5, 5, 5, 5);
        textField = new JTextField(8);
        panel.add(textField, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        verifyButton = new JButton("Verify");
        verifyButton.addActionListener(this);
        panel.add(verifyButton, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 5, 5, 5);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        panel.add(cancelButton, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 5, 5, 5);
        resultLabel = new JLabel("");
        panel.add(resultLabel, c);

        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==verifyButton){
            try{
                int value = Integer.parseInt(textField.getText());
                resultLabel.setText("\n"+value+" is an integer.");
            }catch(NumberFormatException ee){
                resultLabel.setText("\n"+textField.getText()+" is not an integer.");
            }
        } else if(e.getSource()==cancelButton){
            dispose();
        }
    }
    
    public static void main(String[] args){
        new Integer_Verification();
    }
}

