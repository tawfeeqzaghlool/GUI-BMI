// A GUI to compute a person's body mass index (BMI).
// Final version with event handling.
import java.awt.*;//for Dimension
import java.awt.event.*;//for ActionListener
import javax.swing.*;//for GUI components
public class BmiGui2 implements ActionListener{

	//BmiGui2 is its own runnable client program
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		BmiGui2 gui = new BmiGui2();
	}
	
	//onscreen components stored as fields
	private JFrame frame;
	private JTextField heightField;
	private JTextField weightField;
	private JLabel bmiLabel;
	private JButton computeButton;
	
	public BmiGui2(){ // construct new BmiGui2
		
		//set up components
		heightField = new JTextField(5);
		weightField = new JTextField(5);
		bmiLabel = new JLabel(
				"Type your height and weight");
		computeButton = new JButton("Compute");
		
		//attach GUI as event listener to Compute Button
		computeButton.addActionListener(this);
		//Layout
		JPanel north = new JPanel(new GridLayout(2, 2));
		north.add(new JLabel("Height: "));
		north.add(heightField);
		north.add(new JLabel("Weight: "));
		north.add(weightField);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add(computeButton);
		
		//overall frame
		frame = new JFrame("BMI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(north, BorderLayout.NORTH);
		frame.add(bmiLabel, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	//Handles clicks on Compute button by computing the BMI
	public void actionPerformed(ActionEvent event){
		//read height/weight info from text fields
		String heightText = heightField.getText();
		double height = Double.parseDouble(heightText);
		String weightText = weightField.getText();
		double weight = Double.parseDouble(weightText);
		
		//compute BMI and display it onscreen
		double bmi = weight / (height * height) * 703;
		bmiLabel.setText("BMI: " + bmi);
	}

}
