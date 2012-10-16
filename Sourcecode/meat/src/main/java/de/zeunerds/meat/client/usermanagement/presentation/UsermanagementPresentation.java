package de.zeunerds.meat.client.usermanagement.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.List;
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

import de.zeunerds.meat.client.presentation.AbstractPanel;
import de.zeunerds.meat.client.usermanagement.core.UsermanagementCore;
import de.zeunerds.meat.server.usermanagement.dao.Account;
import de.zeunerds.meat.server.usermanagement.dao.Person;

public class UsermanagementPresentation extends AbstractPanel {
	
	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	
	private UsermanagementCore mUsermanagementCore;
	
	private DefaultTableModel mTableModel = new DefaultTableModel();

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

		mTableModel.addColumn("Col1");

		JTable table = new JTable(mTableModel);
		table.setColumnModel(createColumnModel());
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(26);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(0, 0));

		mTableModel.addRow(new Object[] { "v1", "v2" });
		mTableModel.addRow(new Object[] { "v1" });
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setMinimumSize(new Dimension(200, 100));

		// Create Load-Button
		JButton button = new JButton("Load all Accounts with Persons");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mUsermanagementCore.loadAccount("testor");
				mUsermanagementCore.getPersons("testor");
			}
		});
		// Create Change-Button
		JButton button2 = new JButton("Change Account");
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

//				mAccount.setName("testtesttest");
//				try {
//					mUsermanagementCore.saveAccount(mAccount);
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
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
			mTableModel.addRow(new Object[] {((Account) arg).getPkey() + " "});
		}
		else if(arg instanceof Person) {
//			mTableModel.addRow(new Object[] {)
		}
		else if(o instanceof UsermanagementCore){
			try {
				Method meth = UsermanagementCore.class.getMethod((String) arg);
				List<Person> list = (List<Person>) meth.invoke(o);
				for(Person p : list) {
					mTableModel.addRow(new Object[] {p.getName()});
					mLogger.debug(p.getName());
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mLogger.debug("update");
		
	}

}
