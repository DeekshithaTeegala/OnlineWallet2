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

public class AccountServiceImpl implements AccountService
{
	
	private AccountDao accountDao;
	List<WalletTransaction>   list = new ArrayList<WalletTransaction>();
	public AccountServiceImpl() 
	{
		accountDao = new AccountDaoMapImpl();
	}
    @Override
	public void fundTransfer(int accountId1 , int accountId2 , double amount) throws AccountException
	{
		
       accountDao.withdraw(accountId1, amount);
       accountDao.deposit(accountId2, amount);
	
	}
	@Override
	public int createWalletAccount(WalletAccount account) throws AccountException
	  {
		Random random=new Random();
		int accountId=random.nextInt(100)+1000;
		


		
		account.setAccountId(accountId);
	
		return accountDao.createWalletAccount(account);
	}

	@Override
	public double withdraw(int accountId, double amount) throws AccountException 
	{
		
		
		
		WalletAccount walletAccount = accountDao.find(accountId);
		WalletTransaction transaction = new WalletTransaction();
		
	
		list.add(transaction);
		
		transaction.setDescription(" amount withdrawn ");
		
		Random random=new Random();
		int transactionId=random.nextInt(100)+1000;
		transaction.setTransactionId(transactionId);
		walletAccount.setList(list);
		transaction.setAmount(amount);

		double balance = accountDao.withdraw(accountId,amount);
		return balance ;
	}
		
	



	@Override
	public double deposit(int accountId, double amount) throws AccountException 
	{
		WalletAccount walletAccount=accountDao.find(accountId);
		WalletTransaction transaction = new WalletTransaction();

		//List<WalletTransaction>   list = new ArrayList<WalletTransaction>();
		list.add(transaction);
		
		transaction.setDescription(" amount deposited");
		Random random=new Random();
		int transactionId=random.nextInt(100)+1000;
		transaction.setTransactionId(transactionId);
		walletAccount.setList(list);
		transaction.setAmount(amount);
		
		double balance = accountDao.deposit(accountId,amount);
		return balance;
	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws AccountException {
		WalletAccount walletAccount=new WalletAccount();
		return accountDao.deleteAccount(accountId);
		
	}
	@Override
	public List<WalletTransaction> findAllTransaction(int accountId) throws AccountException
	{
		WalletAccount walletAccount=accountDao.find(accountId);
		return accountDao.findAllTransaction(accountId);
	}
	@Override
	public WalletAccount  find(int accountId) throws AccountException 
	{
	
		return accountDao.find(accountId);
	}
	
}
