package com.cg.onlinewallet.dao;

import java.time.LocalDate;
import java.util.*;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletAccountType;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.exception.AccountException;

public class AccountDaoMapImpl implements AccountDao {
	private Map<Integer, WalletAccount> accountMap;
	List<WalletTransaction> list = new ArrayList<WalletTransaction>();
	public AccountDaoMapImpl()
	{
		accountMap = new HashMap<Integer, WalletAccount>();
		

	}

	@Override
	public int createWalletAccount(WalletAccount walletAccount) throws AccountException {
		if (accountMap.containsKey(walletAccount.getAccountId())) {

			throw new AccountException("Id Exists");
		} else {
			accountMap.put(walletAccount.getAccountId(), walletAccount);
		}
		return walletAccount.getAccountId();

	}

	@Override
	public double withdraw(int accountId, double amount) throws AccountException {
		WalletAccount walletAccount = accountMap.get(accountId);

		
		WalletTransaction transaction = new WalletTransaction();

		

		transaction.setDescription(" debit ");

		Random random = new Random();
		int transactionId = random.nextInt(100) + 1000;
		transaction.setTransactionId(transactionId);
		walletAccount.setList(list);
		transaction.setAmount(amount);
		list.add(transaction);
		walletAccount.setBalance(walletAccount.getBalance() - amount);
		return walletAccount.getBalance();
	}

	@Override
	public double deposit(int accountId, double amount) throws AccountException {
		
		WalletAccount walletAccount = accountMap.get(accountId);


		
		WalletTransaction transaction = new WalletTransaction();

		// List<WalletTransaction> list = new ArrayList<WalletTransaction>();
		

		transaction.setDescription(" credit ");
		Random random = new Random();
		int transactionId = random.nextInt(100) + 1000;
		transaction.setTransactionId(transactionId);
		walletAccount.setList(list);
		transaction.setAmount(amount);
		list.add(transaction);
		
		walletAccount.setBalance(walletAccount.getBalance() + amount);
		return walletAccount.getBalance();

	}

	public WalletAccount find(int accountId) throws AccountException {
		WalletAccount walletAccount = null;
		boolean flag = accountMap.containsKey(accountId);
		if (flag) {

			walletAccount = accountMap.get(accountId);
			// accountMap.put(accountId, walletAccount);
		} else {
			throw new AccountException("id does not found");
		}

		return walletAccount;

	}

	@Override
	public WalletAccount deleteAccount(int accountId) throws AccountException {

		WalletAccount walletAccount = accountMap.get(accountId);

		walletAccount = accountMap.remove(accountId);
		return walletAccount;
	}

	@Override
	public void fundTransfer(int accountId1, int accountId2, double amount) throws AccountException {

		WalletAccount walletAccount1 = accountMap.get(accountId1);
		
      
		
		WalletAccount walletAccount2 = accountMap.get(accountId2);
 
		withdraw(accountId1,amount);
		deposit(accountId2,amount);

		
		
	}

	@Override
	public List<WalletTransaction> findAllTransaction(int accountId) throws AccountException {
		List<WalletTransaction> list = null;
		WalletAccount walletAccount = null;

		walletAccount = accountMap.get(accountId);

		list = walletAccount.getList();

		return list;
	}

}

