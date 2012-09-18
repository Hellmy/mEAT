package de.zeunerds.meat.client.presentation;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import de.zeunerds.meat.client.core.usermanagement.UsermanagementCore;
import de.zeunerds.meat.client.presentation.usermanagement.UsermanagementPresentation;

public class Presentation {
	
	private UsermanagementCore usermanagementCore = new UsermanagementCore();
	
	
	public Presentation() {
		JFrame f = new JFrame("MEAT");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(500, 500));
		f.pack();
		f.setVisible(true);
		
//		List<Observable> observableList = new ArrayList<Observable>();
//		observableList.add(usermanagementCore);
		
		AbstractPanel usermanagementPresentation = new UsermanagementPresentation(usermanagementCore);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Usermanagement", usermanagementPresentation);
		tabbedPane.add(new JLabel("foo"));
		f.add(tabbedPane);
		
	}
	
	private void initUsermanagementPresentation() {
		
		// TODO überlegen ob auslagern sinnvoll ist
		
	}
	

}
