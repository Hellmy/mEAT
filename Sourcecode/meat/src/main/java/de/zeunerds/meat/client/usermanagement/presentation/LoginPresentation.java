package de.zeunerds.meat.client.usermanagement.presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.client.presentation.AbstractPanel;
import de.zeunerds.meat.client.usermanagement.core.UsermanagementCore;

public class LoginPresentation extends AbstractPanel {

	private final Logger mLogger = LoggerFactory.getLogger(this.getClass());

	private final UsermanagementCore mUsermanagementCore;

	private final DefaultTableModel mTableModel = new DefaultTableModel();

	/*
	 * Die Präsentationsschicht registriert sich als Observer beim
	 * entsprechenden Dialogkern
	 */
	public LoginPresentation(final UsermanagementCore usermanagementCore) {
		// register as Observer and standard init
		super();
		usermanagementCore.addObserver(this);
		mUsermanagementCore = usermanagementCore;

		GridBagLayout gridBag = new GridBagLayout();
		setLayout(gridBag);

		GridBagConstraints c = new GridBagConstraints();
		// c.weightx = 1;
		// c.gridx = 0;
		c.fill = GridBagConstraints.NONE;

		JTextField usernameField = new JTextField("meat");
		JPasswordField passwordField = new JPasswordField("test");
		passwordField.setPreferredSize(new Dimension(100, 10));
		usernameField.setSize(new Dimension(200, 200));
		usernameField.setPreferredSize(new Dimension(200, 200));

		// c.gridwidth = GridBagConstraints.;
		gridBag.setConstraints(usernameField, c);
		// c.gridx = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gridBag.setConstraints(passwordField, c);
		this.add(usernameField);
		this.add(passwordField);
		// setSize(new Dimension(300, 300));

	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
