package de.zeunerds.meat.client.presentation;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import de.zeunerds.meat.client.usermanagement.core.UsermanagementCore;
import de.zeunerds.meat.client.usermanagement.presentation.LoginPresentation;
import de.zeunerds.meat.client.usermanagement.presentation.UsermanagementPresentation;

public class Presentation {

	private final UsermanagementCore usermanagementCore = new UsermanagementCore();

	// private LoginCore loginCore = new LoginCore();

	public Presentation() {
		JFrame f = new JFrame("MEAT");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(500, 500));
		f.pack();
		f.setVisible(true);

		// List<Observable> observableList = new ArrayList<Observable>();
		// observableList.add(usermanagementCore);

		AbstractPanel loginPresentation = new LoginPresentation(
				usermanagementCore);

		AbstractPanel usermanagementPresentation = new UsermanagementPresentation(
				usermanagementCore);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Usermanagement", usermanagementPresentation);
		tabbedPane.add(new JLabel("foo"));

		f.add(loginPresentation);
		f.pack();

	}

	private void initUsermanagementPresentation() {

		// TODO überlegen ob auslagern sinnvoll ist

	}

}
