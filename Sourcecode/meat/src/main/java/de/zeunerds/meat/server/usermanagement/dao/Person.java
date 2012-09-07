package de.zeunerds.meat.server.usermanagement.dao;

public class Person {

	private long mPkey;
	private String mName;
	private long mAccountMappingFkey;
	private long mCreatorFkey;

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

	public long getAccountMappingFkey() {
		return mAccountMappingFkey;
	}

	public void setAccountMappingFkey(long mAccountMappingFkey) {
		this.mAccountMappingFkey = mAccountMappingFkey;
	}

	public long getCreatorFkey() {
		return mCreatorFkey;
	}

	public void setCreatorFkey(long mCreatorFkey) {
		this.mCreatorFkey = mCreatorFkey;
	}

}
