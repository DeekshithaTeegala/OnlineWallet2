package com.cg.onlinewallet.bean;

import java.util.ArrayList;
import java.util.List;

public class WalletAccount 
{
	
	private int accountId;
	private double balance;
	private WalletAccountType status;
	private List<WalletTransaction> list;
	
	
	public WalletAccount(int accountId, double balance, WalletAccountType status, List<WalletTransaction> list)
	{
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.list = new ArrayList<WalletTransaction>();
	}
	public WalletAccount()
	{
		super();
		
	}
	
	public List<WalletTransaction> getList()
	{
		return list;
	}
	public void setList(List<WalletTransaction> list) 
	{
		this.list = list;
	}
	
	
	public int getAccountId()
	{
		return accountId;
	}
	public void setAccountId(int accountId) 
	{
		this.accountId = accountId;
	}
	public double getBalance() 
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public WalletAccountType getStatus() 
	{
		return status;
	}
	public void setStatus(WalletAccountType status)
	{
		this.status = status;
	}
	public void addTransaction(WalletTransaction transaction)
	{
	    list.add(transaction);	
	}


}
