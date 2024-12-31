import game.GameLogic;
import javax.swing.*;
import java.awt.*;

public class MatchCards {
    private final GameLogic gameLogic;
    private final JFrame frame;
    private final JLabel errorLabel;
    private final JButton restartButton;
    
    public MatchCards() {
        gameLogic = new GameLogic();
        frame = new JFrame("Pokemon Match Cards");
        errorLabel = new JLabel("Errors: 0");
        restartButton = new JButton("Restart Game");
        
        initializeUI();
    }
    
    private void initializeUI() {
        setupFrame();
        setupGameBoard();
        setupControls();
        
        startGame();
    }
    
    private void setupFrame() {
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel headerPanel = new JPanel();
        headerPanel.add(errorLabel);
        frame.add(headerPanel, BorderLayout.NORTH);
    }
    
    private void setupGameBoard() {
        JPanel boardPanel = new JPanel(new GridLayout(GameLogic.ROWS, GameLogic.COLS));
        
        for (int i = 0; i < gameLogic.getCards().size(); i++) {
            JButton cardButton = createCardButton();
            gameLogic.addCardButton(cardButton);
            boardPanel.add(cardButton);
        }
        
        frame.add(boardPanel, BorderLayout.CENTER);
    }
    
    private JButton createCardButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(GameLogic.CARD_WIDTH, GameLogic.CARD_HEIGHT));
        button.setIcon(gameLogic.getCards().get(gameLogic.getCards().size()-1).getImage());
        button.setFocusable(false);
        
        button.addActionListener(e -> {
            if (gameLogic.handleCardClick(button)) {
                startHideTimer();
            }
            updateErrorDisplay();
        });
        
        return button;
    }
    
    private void setupControls() {
        restartButton.setEnabled(false);
        restartButton.addActionListener(e -> restartGame());
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(restartButton);
        frame.add(controlPanel, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void startGame() {
        Timer initialTimer = new Timer(1500, e -> {
            hideAllCards();
            gameLogic.setGameReady(true);
            restartButton.setEnabled(true);
        });
        initialTimer.setRepeats(false);
        initialTimer.start();
    }
    
    private void startHideTimer() {
        Timer timer = new Timer(15000, e -> gameLogic.hideSelectedCards());
        timer.setRepeats(false);
        timer.start();
    }
    
    private void hideAllCards() {
        for (int i = 0; i < gameLogic.getCards().size(); i++) {
            gameLogic.getCardButtons().get(i).setIcon(gameLogic.getCardBack());
        }
    }
    
    private void updateErrorDisplay() {
        errorLabel.setText("Errors: " + gameLogic.getErrors());
    }
    
    private void restartGame() {
        gameLogic.resetGame();
        updateErrorDisplay();
        for (int i = 0; i < gameLogic.getCards().size(); i++) {
            gameLogic.getCardButtons().get(i).setIcon(
                gameLogic.getCards().get(i).getImage()
            );
        }
        startGame();
    }
}