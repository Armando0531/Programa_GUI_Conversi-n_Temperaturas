import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class VentanaInicio extends JFrame implements ActionListener{

	JTextField cajaTemp1,cajaTemp2;
	JComboBox<String> comboTmp1 = new JComboBox<String>();
	JComboBox<String> comboTmp2 = new JComboBox<String>();


	public VentanaInicio() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setLocationRelativeTo(null);
		setTitle("Eventos ComboBox");
		setVisible(true);
		
		JLabel txtConversor = new JLabel("---------Conversor TEMPERATURAS-------");
        add(txtConversor);
        
		JLabel lblConv = new JLabel("convertir:");
		add(lblConv);
		
		cajaTemp1 = new JTextField(5);
		cajaTemp1.setToolTipText("Presiona ENTER para Convertir");
		cajaTemp1.addActionListener(this);
		add(cajaTemp1);
		
		comboTmp1.addItem("Centigrados");
		comboTmp1.addItem("Fahrenheit");
		comboTmp1.addItem("Rankine");
		comboTmp1.addItem("Kelvin");
		comboTmp1.addActionListener(this);
		add(comboTmp1);
		
		JLabel to = new JLabel("A:");
		add(to);
		
		comboTmp2.addItem("Centigrados");
		comboTmp2.addItem("Fahrenheit");
		comboTmp2.addItem("Rankine");
		comboTmp2.addItem("Kelvin");
		comboTmp2.addActionListener(this);
		add(comboTmp2);
		
		cajaTemp2 = new JTextField(5);
		cajaTemp2.setEditable(false);
		add(cajaTemp2);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==cajaTemp1||e.getSource()==comboTmp1||e.getSource()==comboTmp2) {
			double cnv=Double.parseDouble(cajaTemp1.getText());
			if (comboTmp1.getSelectedItem()=="Centigrados" && comboTmp2.getSelectedItem()=="Fahrenheit") {
				cnv=(cnv*1.8)+32;
			}else if (comboTmp1.getSelectedItem()=="Centigrados" && comboTmp2.getSelectedItem()=="Rankine") {
				cnv=(cnv*1.8)+491.67;
			}else if (comboTmp1.getSelectedItem()=="Fahrenheit" && comboTmp2.getSelectedItem()=="Centigrados") {
				cnv=(cnv-32)*5/9;	
			}else if (comboTmp1.getSelectedItem()=="Fahrenheit" && comboTmp2.getSelectedItem()=="Rankine") {
				cnv=(cnv+459.67);	
			}else if (comboTmp1.getSelectedItem()=="Rankine" && comboTmp2.getSelectedItem()=="Centigrados") {
				cnv=(cnv-491.67)*5/9;	
			}else if (comboTmp1.getSelectedItem()=="Rankine" && comboTmp2.getSelectedItem()=="Fahrenheit") {
				cnv=(cnv-459.67);	
			}
			cnv = Math.round(cnv * 100.0) / 100.0;
			cajaTemp2.setText(String.valueOf(cnv));
			
		}
		
	}

}
public class PruebaGUI {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInicio();
            }
        });

	}

}