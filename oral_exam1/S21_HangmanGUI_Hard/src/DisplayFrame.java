/**
 * DisplayFrame.java - This class extends JPanel and is used to create the graphics
 * used in the hangman game.
 * @author Sophia Mallaro
 * @see DisplayFrame
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayFrame extends JPanel {
    private JPasswordField word;
    private JTextField guesses;
    private Hangman hangman;
    private JLabel guessesLabel;
    private JLabel wordLabel;
    private JTextField incorrectGuesses;
    private int wrongGuesses;
    private JTextField guess;
    private JLabel incorrectGuessesLabel;
    private JLabel guessLabel;
    private JLabel progressLabel;
    private JTextField progress;
    private JTextField guessWord;
    private JLabel guessWordLabel;

    /**
     * This constructors creates a new DisplayFrame image with five JTextFields, one JPasswordField,
     * and labels for the text fields. Additionally, it has the initial picture. When the user guesses correctly,
     * it updates the in progress word. When the user guesses incorrectly, it subtracts from the number of
     * guesses left and adds to the picture.
     */

   DisplayFrame() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(200,600);

        word = new JPasswordField(10);
        guesses = new JTextField("6");
        guess = new JTextField(1);
        incorrectGuesses = new JTextField(10);
        guessesLabel = new JLabel("Guesses Remaining");
        wordLabel = new JLabel("Enter Word to Be Guessed");
        guessLabel = new JLabel("Enter guess");
        incorrectGuessesLabel = new JLabel("Incorrect Guesses");
        progress = new JTextField(10);
        guessWord = new JTextField(10);
        guessWordLabel = new JLabel("Guess Word:");
        wrongGuesses = 0;

        guessesLabel.setLabelFor(guesses);
        guesses.setEditable(false);
        incorrectGuesses.setEditable(false);
        wordLabel.setLabelFor(word);
        progress.setEditable(false);
        guess.setEditable(false);
        guessWord.setEditable(false);

        add(wordLabel);
        add(word);
        add(progress);
        add(guessesLabel);
        add(guesses);
        add(guessLabel);
        add(guess);
        add(incorrectGuessesLabel);
        add(incorrectGuesses);
        add(guessWordLabel);
        add(guessWord);

        word.addActionListener( //Annonymus inner class for action field
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        try {
                            hangman = new Hangman(event.getActionCommand());
                            word.setEditable(false);
                            progress.setText(hangman.getProgress());
                            guess.setEditable(true);
                            guessWord.setEditable(true);
                        } catch (IllegalArgumentException ex) {
                            word.setEditable(true);
                        }
                    }
                }
        );

        guess.addActionListener( //Annonymus inner class for action field
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        char nextGuess = event.getActionCommand().toLowerCase().charAt(0);
                        if ((event.getActionCommand().length() == 1) && hangman.checkGuess(nextGuess)) {
                            if (hangman.guess(nextGuess)) {
                                progress.setText(hangman.getProgress());
                                if (hangman.checkCorrect()) {
                                    JOptionPane.showMessageDialog(null, "You win! The correct word was " + hangman.getWord(), "Result", JOptionPane.WARNING_MESSAGE);
                                    System.exit(0);
                                }
                            } else {
                                incorrectGuesses.setText(hangman.getIncorrect());
                                wrongGuesses++;
                                repaint();
                                if(wrongGuesses == 6) {
                                    JOptionPane.showMessageDialog(null, "You lose, the correct word was " + hangman.getWord(), "Result", JOptionPane.WARNING_MESSAGE);
                                    System.exit(0);
                                }
                                guesses.setText(Integer.toString(hangman.getGuessesRemaining()));
                            }
                        }
                        guess.setText("");
                    }
                }
        );

        guessWord.addActionListener( //Annonymus inner class for action field
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if (event.getActionCommand().equals(hangman.getWord().toLowerCase())) {
                            JOptionPane.showMessageDialog(null, "You win! The correct word was " + hangman.getWord(), "Result", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "You lose, the correct word was " + hangman.getWord(), "Result", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                    }
                }
        );
    }

    /**
     * This method overrides JPanel's paintComponent method. It constructs the initial image right away.
     * As wrong guesses are made, repaint is called and additional parts of the man are added.
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawLine(50,450,150,450);
        g.drawLine(150, 450, 150, 280);
        g.drawLine(150, 280, 100, 280);
        g.drawLine(100, 275, 100, 290);

        if(wrongGuesses >= 1) {
            g.drawOval(85,290, 30,30); //miss 1
        }
        if(wrongGuesses >=2 ) {
            g.drawLine(100,320,100,380); //miss 2
        }
        if(wrongGuesses>=3) {
            g.drawLine(100,380,125,430); //miss 3
        }
        if(wrongGuesses>=4) {
            g.drawLine(100,380,75,430); //miss 4
        }

        if(wrongGuesses>=5) {
            g.drawLine(100,345,120,320); //miss 5
        }

        if(wrongGuesses>=6) {
            g.drawLine(100,345,80,320); //miss 6
        }
    }

}
