package com.cg.onlinewallet.service;

import java.util.List;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.exception.AccountException;

public interface AccountService {
	public boolean validateAccountId(int accountId) throws AccountException;
	public boolean validateBalance(double balance) throws AccountException;

	public void fundTransfer(int accountId1 , int accountId2 , double amount) throws AccountException;
	public int createWalletAccount(WalletAccount account) throws AccountException;
	public double withdraw(int accountId , double amount) throws AccountException;
	public double deposit(int accountId , double amount) throws AccountException;
	public WalletAccount deleteAccount(int accountId) throws AccountException;
	public List<WalletTransaction> findAllTransaction(int transactionId) throws AccountException;
	public WalletAccount  find(int accountId) throws AccountException ;
}
