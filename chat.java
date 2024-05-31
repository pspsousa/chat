import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApp extends JFrame implements ActionListener {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatApp() {
        setTitle("ChatApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        
        inputField = new JTextField();
        inputField.addActionListener(this); 
        add(inputField, BorderLayout.SOUTH);

        
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        add(sendButton, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton || e.getSource() == inputField) {
            String mensagem = inputField.getText();
            if (!mensagem.isEmpty()) {
               
                chatArea.append("Você: " + mensagem + "\n");
                inputField.setText(""); 
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatApp().setVisible(true);
        });
    }
}
