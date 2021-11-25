package com.company;

import javax.swing.*;

public class ColorVisualizer extends JFrame {

	private static final long serialVersionUID = -3144218759873864161L;

	public ColorVisualizer(Color color) {
		setSize(400, 200);
		setTitle("Color Visualizer");

		getContentPane().setBackground(java.awt.Color.decode(color.getHex()));
		JLabel label = new JLabel("<html><span style='font-size:20px'>" + color.getHex() + "</span></html>",
				SwingConstants.CENTER);
		add(label);

		setVisible(true);
		setFocusable(true);
		requestFocus();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
