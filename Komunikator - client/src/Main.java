import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static String wiadomoscOdebrana = null, wiadomoscWysylana = null;
    static PrintWriter pr;
    static boolean connected = false;


    public static void main(String[] args) {

        //tworzenie klienta
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 4999); // change ip
            //s = new Socket("localhost",4999);
            pr = new PrintWriter( s.getOutputStream());
            connected = true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        DialogueWindow window = new DialogueWindow();
        window.createWindow();

        InputStreamReader in = null;
        BufferedReader bf = null;

        //przycisk wyslij
        window.sendButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wiadomoscWysylana = window.textInput.getText();
                window.displayArea.append( "Client: " + wiadomoscWysylana + "\n");
                pr.println( wiadomoscWysylana );
                pr.flush();
                window.textInput.setText( null );

            }
        } );
//odbieranie wiadomosci
        while (connected) {
            try {
                in = new InputStreamReader( s.getInputStream() );
                bf = new BufferedReader( in );
                wiadomoscOdebrana = bf.readLine();
                //wyswietlanie wiadomosci w oknie
                window.displayArea.append( "Serwer: " + wiadomoscOdebrana + "\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}