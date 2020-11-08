import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberConverterGUI implements ActionListener{
	
	private final String bases[]= {"Dec","Bin","Hex"};
	private final String basesNoDec[]= {"Bin","Hex"};
	private JButton btnConverti;
	private JTextField num2convert;
	private JTextField numConverted;
	private JComboBox basesMenu1;
	private JComboBox basesMenu2;
	
	public NumberConverterGUI() {
		JFrame frame = new JFrame();
		frame.setSize(1150,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Number Converter");

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		frame.add(panel, BorderLayout.CENTER);
		
		num2convert = new JTextField(20);
		num2convert.setBackground(Color.YELLOW);
		num2convert.setBounds(500, 25, 400, 75);
		num2convert.setFont(new Font("Arial Black", Font.PLAIN, 25));
		
		panel.add(num2convert);
		
		numConverted = new JTextField(20);
		numConverted.setBackground(Color.CYAN);
		numConverted.setBounds(500, 225, 400, 75);
		numConverted.setFont(new Font("Arial Black", Font.PLAIN, 25));
		
		
		panel.add(numConverted);
		
		JLabel lab1 = new JLabel("Inserire il numero da convertire -->");
		lab1.setBounds(15, 25, 500, 75);
		lab1.setFont(new Font("Arial Black", Font.PLAIN, 25));

		
		panel.add(lab1);
		
		JLabel lab2 = new JLabel("Risultato -->");
		lab2.setBounds(325, 225, 500, 75);
		lab2.setFont(new Font("Arial Black", Font.PLAIN, 25));

		
		panel.add(lab2);		
		
		JLabel lab3 = new JLabel("Base di partenza");
		lab3.setBounds(950, 30, 500, 16);
		lab3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		panel.add(lab3);
		
		JLabel lab4 = new JLabel("Base di arrivo");
		lab4.setBounds(950, 230, 500, 16);
		lab4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		panel.add(lab4);
		
		btnConverti = new JButton("Converti!");
		btnConverti.setBounds(600, 135, 200, 50);
		btnConverti.setFont(new Font("Arial Black", Font.PLAIN, 25));
		btnConverti.addActionListener(this);
		panel.add(btnConverti);
		
		
		basesMenu1 = new JComboBox(bases);
		basesMenu1.setBounds(950, 50, 150, 20);
		basesMenu1.addActionListener(this);
		
		panel.add(basesMenu1);
		
		basesMenu2 = new JComboBox(basesNoDec);
		basesMenu2.setBounds(950, 250, 150, 20);
		
		panel.add(basesMenu2);
	
		frame.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		String n2c = num2convert.getText();
		String base1 = String.valueOf(basesMenu1.getSelectedItem());
		String base2 = String.valueOf(basesMenu2.getSelectedItem());

		
		if(e.getSource()==btnConverti) {
			numConverted.setText(Converters.convert(n2c, base1, base2));
		}else {
			if(base1=="Bin") {
				basesMenu2.removeAllItems();
				basesMenu2.addItem(bases[0]);
				basesMenu2.addItem(bases[2]);
			} else if (base1=="Hex") {
				basesMenu2.removeAllItems();
				basesMenu2.addItem(bases[0]);
				basesMenu2.addItem(bases[1]);
			} else {
				basesMenu2.removeAllItems();
				basesMenu2.addItem(bases[1]);
				basesMenu2.addItem(bases[2]);
			}
			
		}
		
		
	}
	
}