import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BoxView;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import sun.awt.geom.AreaOp.AddOp;

public class IrcGui extends JFrame implements ActionListener {

	
	private JLabel nickNameL = new JLabel("Nick");
	private JLabel messageLabel = new JLabel("Message");
	private JTextField nickTextF = new JTextField(10);
	private String nickName;
	private JButton connect, disconnect;
	private JPanel boxPanel = new JPanel();
	private JPanel textviewPanel = new JPanel();
	public JTextArea textBox = new JTextArea(20,40);
	private JTextField messageField = new JTextField(32);
	JScrollPane scrollPane;
	IrcBot ircBot = new IrcBot();
	
	public IrcGui() {
		super("Bujanoci.net Chat");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		connect = new JButton("Connect");
		disconnect = new JButton("Disconnect");
		boxPanel.add(connect);
		boxPanel.add(disconnect);
		boxPanel.add(nickNameL);
		boxPanel.add(nickTextF);
		
		textviewPanel.add(textBox);
		
		textBox.setEditable(true);
		textBox.setVisible(true);
		JScrollPane scrollingResult = new JScrollPane(scrollPane);
		scrollingResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textviewPanel.add(scrollingResult);
		textviewPanel.add(messageLabel);
		textviewPanel.add(messageField);
		
		connect.addActionListener(this);
		disconnect.addActionListener(this);
		nickTextF.addActionListener(this);
		messageField.addActionListener(this);
		getContentPane().add("South", boxPanel);
		getContentPane().add("North", textviewPanel);

	}
	public void setNickname(String thisNick)
	{
		nickName = thisNick;
		this.setName(nickName);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IrcGui ircGui = new IrcGui();
		ircGui.setLayout(new GridLayout());
		ircGui.setBounds(50, 50, 1000, 500);
		ircGui.setVisible(true);
		ircGui.setLocation(550,300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == connect)
		{
			String nickName = messageField.getText();
			textBox.append(nickName);
			messageField.selectAll();
			try {
				ircBot.connect("192.168.1.7");
			} catch (NickAlreadyInUseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IrcException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == disconnect)
		{
			ircBot.disconnect();
		}
			
	
	}

}
