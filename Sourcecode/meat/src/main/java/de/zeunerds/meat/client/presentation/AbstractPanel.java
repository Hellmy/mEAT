package de.zeunerds.meat.client.presentation;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPanel extends JPanel implements Observer{
	
	public AbstractPanel(List<Observable> observableList) {
		super();
		for(Observable observale : observableList) {
			observale.addObserver(this);
		}
	}
	
	public AbstractPanel() {
		super();
	}
}
