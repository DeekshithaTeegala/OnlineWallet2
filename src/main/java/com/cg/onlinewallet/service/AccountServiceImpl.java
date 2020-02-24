package com.cg.onlinewallet.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.exception.*;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	

	public AccountServiceImpl() {
		accountDao = new AccountDaoMapImpl();
	}

	@Override
	public boolean validateAccountId(int accountId) throws AccountException {
		boolean flag = true;
		String id = String.valueOf(accountId);
		flag = id.matches("[0-9]{4}");
		return flag;
	}

	@Override
	public boolean validateBalance(double balance) throws AccountException {
		boolean flag = true;
		String bal = String.valueOf(balance);

		flag = bal.matches("[0-9]{4}");
        
		return flag;
	}

	

	@Override
	public int createWalletAccount(WalletAccount account) throws AccountException 
	{
		Random random = new Random();
		int accountId = random.nextInt(100) + 1000;
		

		account.setAccountId(accountId);
		

		double balance=account.getBalance();
	
		return accountDao.createWalletAccount(account);

	}

	@Override
	public double withdraw(int accountId, double amount) throws AccountException {
		WalletAccount walletAccount = null;
	
		
		
		boolean flag1 = validateAccountId(accountId);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
     
		double balance = accountDao.withdraw(accountId, amount);

		return balance;
	}

	@Override
	public double deposit(int accountId, double amount) throws AccountException {

		boolean flag1 = validateAccountId(accountId);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
      
		double balance = accountDao.deposit(accountId, amount);
		return balance;
	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws AccountException
	{
		boolean flag1 = validateAccountId(accountId);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
		
		return accountDao.deleteAccount(accountId);

	}

	@Override
	public void fundTransfer(int accountId1, int accountId2, double amount) throws AccountException {
		boolean flag1 = validateAccountId(accountId1);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
	  boolean flag2= validateAccountId(accountId2);
	    if(!flag2)
	    	throw new AccountException("account id should be of 4 digits");
		
		accountDao.withdraw(accountId1, amount);
		accountDao.deposit(accountId2, amount);

	}
	
	@Override
	public List<WalletTransaction> findAllTransaction(int accountId) throws AccountException {
		boolean flag1 = validateAccountId(accountId);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
		WalletAccount walletAccount = accountDao.find(accountId);
		return accountDao.findAllTransaction(accountId);
	}

	@Override
	public WalletAccount find(int accountId) throws AccountException {
		boolean flag1 = validateAccountId(accountId);
        if(!flag1)
        	throw new AccountException("account id should be of 4 digits");
		return accountDao.find(accountId);
	}

}
