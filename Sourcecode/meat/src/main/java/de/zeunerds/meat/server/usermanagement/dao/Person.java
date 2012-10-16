package de.zeunerds.meat.server.usermanagement.dao;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1477984149524330829L;
	private long mPkey;
	private String mName;
	private Account mAccountMappingFkey;
	private Account mCreatorFkey;

	public Person() {

	}

	public long getPkey() {
		return mPkey;
	}

	public void setPkey(long mPkey) {
		this.mPkey = mPkey;
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public Account getAccountMappingFkey() {
		return mAccountMappingFkey;
	}

	public void setAccountMappingFkey(Account mAccountMappingFkey) {
		this.mAccountMappingFkey = mAccountMappingFkey;
	}

	public Account getCreatorFkey() {
		return mCreatorFkey;
	}

	public void setCreatorFkey(Account mCreatorFkey) {
		this.mCreatorFkey = mCreatorFkey;
	}

}
