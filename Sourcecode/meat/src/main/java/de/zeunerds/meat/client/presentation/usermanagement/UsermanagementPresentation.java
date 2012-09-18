package de.zeunerds.meat.client.presentation.usermanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.client.core.usermanagement.UsermanagementCore;
import de.zeunerds.meat.client.presentation.AbstractPanel;
import de.zeunerds.meat.server.usermanagement.dao.Account;

public class UsermanagementPresentation extends AbstractPanel {
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	
	private UsermanagementCore mUsermanagementCore;
	
	private Account mAccount;

	/*
	 * Die Präsentationsschicht registriert sich als Observer beim
	 * entsprechenden Dialogkern
	 */
	public UsermanagementPresentation(final UsermanagementCore usermanagementCore) {
		// register as Observer and standard init
		super();
		mUsermanagementCore = usermanagementCore;
		mUsermanagementCore.addObserver(this);
		setLayout(new BorderLayout());

		// Create the Useroverview
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Col1");

		JTable table = new JTable(tableModel);
		table.setColumnModel(createColumnModel());
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(26);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(0, 0));

		tableModel.addRow(new Object[] { "v1", "v2" });
		tableModel.addRow(new Object[] { "v1" });
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setMinimumSize(new Dimension(200, 100));

		// Create Load-Button
		JButton button = new JButton("Load all Accounts");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Account account = mUsermanagementCore.loadAccount("test2");
				mLogger.debug(account.getName());
				mAccount = account;
			}
		});
		// Create Change-Button
		JButton button2 = new JButton("Change Account");
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				mAccount.setName("testtesttest");
				try {
					mUsermanagementCore.saveAccount(mAccount);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(button, BorderLayout.NORTH);
		buttonPanel.add(button2, BorderLayout.AFTER_LAST_LINE);
		// Create split Area
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setRightComponent(buttonPanel);

		add(splitPane);
		
	}

	private TableColumnModel createColumnModel() {
		DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

		TableColumn column = new TableColumn();
		column.setModelIndex(0);
		column.setHeaderValue("foo");
		column.setPreferredWidth(23);
		// column.setCellRenderer(cellRenderer)
		columnModel.addColumn(column);

		return columnModel;
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Account) {
			//TODO do something
		}
		mLogger.debug("update");
		
	}

}
