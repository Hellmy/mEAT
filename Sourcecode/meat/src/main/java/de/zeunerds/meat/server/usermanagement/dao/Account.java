package de.zeunerds.meat.server.usermanagement.dao;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3698682971125858974L;
	private long mPkey;
	private String mPassword;
	private String mUsername;
	private String mName;
	private String mFirstname;

	public Account() {

	}

	public Account(String username, String password, String name,
			String firstname) {
		mUsername = username;
		mPassword = password;
		mName = name;
		mFirstname = firstname;
	}

	public long getPkey() {
		return mPkey;
	}

	public void setPkey(long mPkey) {
		this.mPkey = mPkey;
	}

	public String getPassword() {
		return mPassword;
	}

	public void setPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getUsername() {
		return mUsername;
	}

	public void setUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public String getFirstname() {
		return mFirstname;
	}

	public void setFirstname(String mFirstname) {
		this.mFirstname = mFirstname;
	}

}
