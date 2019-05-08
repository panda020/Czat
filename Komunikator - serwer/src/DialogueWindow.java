import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DialogueWindow {

    JFrame frame;
    JPanel panel;
    JScrollPane inputScroll, displayScroll;
    JTextArea textInput, displayArea;
    JButton sendButton;
    ImagePanel imgPanel;

    public void createWindow(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 500));

        imgPanel = new ImagePanel();
        imgPanel.setPreferredSize(new Dimension(600, 350));

        displayArea = new JTextArea();
        //displayArea.setBackground(Color.PINK);
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setOpaque(false);
        displayArea.setForeground(Color.WHITE);

        displayScroll = new JScrollPane(displayArea);
        displayScroll.setPreferredSize(new Dimension(590, 350));
        displayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        displayScroll.setOpaque(false);
        displayScroll.getViewport().setOpaque(false);
        // frame.add(displayScroll, BorderLayout.NORTH);
        imgPanel.add(displayScroll);
        frame.add(imgPanel, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 110));
        frame.add(panel, BorderLayout.SOUTH);

        textInput = new JTextArea();
        textInput.setBackground(Color.LIGHT_GRAY);
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);

        inputScroll = new JScrollPane(textInput);
        inputScroll.setPreferredSize(new Dimension(400, 100));
        inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(inputScroll, new FlowLayout(FlowLayout.LEFT));

        sendButton = new JButton("Wyślij");
        sendButton.setPreferredSize(new Dimension(130, 70));
        panel.add(sendButton, new FlowLayout(FlowLayout.RIGHT));



        frame.pack();
        frame.setVisible(true);
    }
}