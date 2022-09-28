// Himanshu Ravikumar Trivedi
import java.io.*; import java.awt.*;import javax.swing.*;
public class Main {
    public static void main(String[] args) {       
        System.out.println("Welcome to the Software");
        System.out.println("Developed by Himanshu Trivedi");
        JFrame Frame=new JFrame();
        
        Frame.setTitle("File Encryption and Decryption -> Himanshu Trivedi");
        Frame.setSize(500,500);
        Frame.setLocationRelativeTo(null); // so that it comes at top
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//for quitting as soon as it closes

        Font font=new Font("Times New Roman",Font.BOLD,35);
        //creating button
        JButton button=new JButton();
        button.setText("Select the Document");
        button.setFont(font);

        //creating text field
        JTextField textField=new JTextField(11);
    
        textField.setFont(font); // For Selection of the Font
        textField.setText("8"); // Say by Default key is 8
        button.addActionListener( // on Clicking on Button , following functionality takes place
            X->
            {
                System.out.println("You Have Clicked the Button");
                String Text=textField.getText(); // Taking the Key as input String
                int VALUES=Integer.parseInt(Text); // Converting that String input to int value
                operate(VALUES);// We Are Calling Operate Function
            }
        );
        Frame.setLayout(new FlowLayout());
        /*  FlowLayout is a type of Layout other examples are .
         BorderLayoutBoxLayout,CardLayout,FlowLayout,GridBagLayout,GridLayout,GroupLayout,SpringLayout. */
        Frame.add(button);
        Frame.add(textField);
        Frame.setVisible(true); // For making the Layout Visible
    }
    private static void operate(int key)
    {
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {
            FileInputStream FileStream=new FileInputStream(file);
            // FileInputStream class is useful to read data from a file in the form of sequence of bytes
            byte []Data=new byte[FileStream.available()];
            // ByteArrayInputStream/Available() returns the number of remaining bytes that can be read
            FileStream.read(Data);// It Reads data in form of bytes
            int i=0;
            for(byte BYTE:Data)
            {
              System.out.println(BYTE);
              Data[i]=(byte)(BYTE^key); // We are Storing Each byte by doing it's XOR operation with Key Value
              i++;
            }
            /* Example  a^a=0  
                cipher text: byte^key=ans -> Encryption
                plain text:  ans^key=byte -> Decryption 
            */
            FileOutputStream FileOutput_Stream=new FileOutputStream(file);
            FileOutput_Stream.write(Data);
            FileOutput_Stream.close();
            FileStream.close();
            JOptionPane.showMessageDialog(null, "Done");// After the completion of Encryption/Decryption
        }catch(Exception Exception)
        {
            Exception.printStackTrace();
            /* printStackTrace() 
            used to print this Throwable along with other details like 
            class name and line number where the exception occurred means its backtrace.*/
        }
    }
}
/*import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;*/