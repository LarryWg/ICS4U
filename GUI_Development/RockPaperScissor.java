import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RockPaperScissor implements ActionListener{
    int playerScore, computerScore, roundNumber;
    JLabel instructionLabel, resultLabel;
    JButton rockButton, paperButton, scissorButton, backButton, playAgainButton, instructionsButton, playButton, quitButton;
    JFrame startFrame, instructionFrame, gameFrame, winnerFrame;

    public RockPaperScissor(){
        startFrame = new JFrame("Rock Paper Scissors");
        startFrame.setSize(500,500);
        startFrame.setResizable(false);
        startFrame.setLayout(new GridLayout(3,1));
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(this);
        startFrame.add(instructionsButton);

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        startFrame.add(playButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        startFrame.add(quitButton);

        startFrame.setVisible(true);
        startFrame.setLocationRelativeTo(null);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==instructionsButton){
            instructionFrame = new JFrame("Instructions");
            instructionFrame.setSize(500,200);
            instructionFrame.setResizable(false);
            instructionLabel = new JLabel("<html><center>Welcome to Rock Paper Scissors! Click the button for the move you want to make. You'll play against the computer. First to 3 wins!</center></html>", SwingConstants.CENTER);
            instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

            backButton = new JButton("Back");
            backButton.addActionListener(this);

            JPanel instructionPanel = new JPanel();
            instructionPanel.setLayout(new BorderLayout());
            instructionPanel.add(instructionLabel, BorderLayout.CENTER);
            instructionPanel.add(backButton, BorderLayout.SOUTH);
            instructionFrame.add(instructionPanel);
            instructionFrame.setVisible(true);
            instructionFrame.setLocationRelativeTo(null);
            startFrame.setVisible(false);
            
            instructionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            

        } else if (e.getSource() == playButton){
            playerScore = 0;
            computerScore = 0;
            roundNumber = 1;

            gameFrame = new JFrame("Rock Paper Scissors");
            gameFrame.setSize(500,250);
            gameFrame.setResizable(false);

            rockButton = new JButton("Rock");
            rockButton.setFont(new Font("Arial", Font.BOLD, 24));
            rockButton.setPreferredSize(new Dimension(150, 50));
            rockButton.addActionListener(this);
            paperButton = new JButton("Paper");
            paperButton.setFont(new Font("Arial", Font.BOLD, 24));
            paperButton.setPreferredSize(new Dimension(150, 50));
            paperButton.addActionListener(this);
            scissorButton = new JButton("Scissors");
            scissorButton.setFont(new Font("Arial", Font.BOLD, 24));
            scissorButton.setPreferredSize(new Dimension(150, 50));
            scissorButton.addActionListener(this);

            JPanel gamePanel = new JPanel(new FlowLayout());
            
            gamePanel.add(rockButton);
            gamePanel.add(paperButton);
            gamePanel.add(scissorButton);

            resultLabel = new JLabel("Round " + roundNumber + " - Fight!");
            resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
            gamePanel.add(resultLabel, BorderLayout.SOUTH);

            gameFrame.add(gamePanel);
            gameFrame.setVisible(true);
            gameFrame.setLocationRelativeTo(null);
            startFrame.setVisible(false);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            
                

        } else if (e.getSource()==backButton){
            instructionFrame.dispose();
            startFrame.setVisible(true);
        } else if (e.getSource()== rockButton || e.getSource()== paperButton|| e.getSource()== scissorButton){
            String playerMove = e.getActionCommand();
            String computerMove = getRandomMove();
            String roundResult = getRoundResult(playerMove, computerMove);
                       
            if (roundResult.equals("Player")) {
                playerScore++;
            } else if (roundResult.equals("Computer")) {
                computerScore++;
            }
            
            resultLabel.setText("<html><center>Round " + roundNumber + ": " + roundResult + "<br><br>Player move: " + playerMove + " | Computer move: " + computerMove + "<br><br>Score: Player: " + playerScore + " | Computer: " + computerScore + "</center></html>");
            roundNumber++;

            if (playerScore == 3 || computerScore == 3){
                String winner = playerScore == 3 ? "Player" : "Computer";
                gameFrame.dispose();
                winnerFrame = new JFrame("Winner");
                winnerFrame.setSize(500, 200);

                JPanel winnerPanel = new JPanel();
                winnerPanel.setLayout(new BorderLayout());
                winnerPanel.setPreferredSize(new Dimension(500, 300));

                JLabel winnerLabel = new JLabel("<html><center>" + winner + " wins the game!<br>Final Score: Player " + playerScore + ", Computer " + computerScore + "</center></html>", SwingConstants.CENTER);
                winnerLabel.setFont(new Font("Arial", Font.PLAIN, 28));
                winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

                playAgainButton = new JButton("Play Again");
                playAgainButton.addActionListener(this);

                quitButton = new JButton("Quit");
                quitButton.addActionListener(this);

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout());
                buttonPanel.add(playAgainButton);
                buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
                buttonPanel.add(quitButton);

                winnerPanel.add(winnerLabel, BorderLayout.CENTER);
                winnerPanel.add(buttonPanel, BorderLayout.SOUTH);
                winnerFrame.add(winnerPanel);
                winnerFrame.setVisible(true);
                winnerFrame.setLocationRelativeTo(null);
                winnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        } else if(e.getSource()==playAgainButton){
            playerScore =0;
            computerScore =0;
            roundNumber=1;
            startFrame.setVisible(true);
            winnerFrame.dispose();
            
        } else if (e.getSource()==quitButton){
            System.exit(0);
        }
    }

    public String getRoundResult(String playerMove, String computerMove) {
        if (playerMove.equals("Rock")) {
            if (computerMove.equals("Paper")) {
                return "Computer";
            } else if (computerMove.equals("Scissors")) {
                return "Player";
            }
        } else if (playerMove.equals("Paper")) {
            if (computerMove.equals("Scissors")) {
                return "Computer";
            } else if (computerMove.equals("Rock")) {
                return "Player";
            }
        } else if (playerMove.equals("Scissors")) {
            if (computerMove.equals("Rock")) {
                return "Computer";
            } else if (computerMove.equals("Paper")) {
                return "Player";
            }
        }
        return "Tie";
    }

    public String getRandomMove() {
        Random random = new Random();
        int move = random.nextInt(3);
    
        switch (move) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            default:
                return "Scissors";
        }
    }
    
    public static void main(String[] args){
        new RockPaperScissor();
    }

}
