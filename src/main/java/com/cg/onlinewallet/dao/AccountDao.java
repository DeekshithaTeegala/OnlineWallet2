package com.cg.onlinewallet.dao;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.exception.AccountException;

import java.util.List;

public interface AccountDao {

	public int createWalletAccount(WalletAccount account) throws AccountException;
	public double withdraw(int accountId ,double amount) throws AccountException;
	public double deposit(int accountId,double amount) throws AccountException;
	public List<WalletTransaction> findAllTransaction(int accountId) throws AccountException;
	public WalletAccount deleteAccount(int accountId) throws AccountException;
	public WalletAccount  find(int accountId) throws AccountException ;
	public void fundTransfer(int accountId1 , int accountId2 , double amount) throws AccountException;
	
}
