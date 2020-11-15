package com.nit.entity;

public class BankAccount {

	private long account;
	private String username;
	private Double balance;
	private String status;

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccount [account=" + account + ", username=" + username + ", balance=" + balance + ", status="
				+ status + "]";
	}

}
