package main;

import javax.swing.JFrame;

public class RamenApp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RamenPanel panel;
	public RamenApp(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RamenPanel bpnl = new RamenPanel(this);
		this.add(bpnl); 
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main (String[] args){
		new RamenApp("RamenApp");
		
	}
	public void restart() {
		panel.removeAll();
		panel = new RamenPanel(this);
		this.add(panel); 
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}