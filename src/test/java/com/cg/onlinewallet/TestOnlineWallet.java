package com.cg.onlinewallet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletAccountType;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoMapImpl;

class TestOnlineWallet {

	
	AccountDao   accountDao = null;
	
	@BeforeEach
	public  void setup()  throws Exception
	{
		accountDao = new AccountDaoMapImpl();
	   List<WalletTransaction>  list = new ArrayList<WalletTransaction>();
	    WalletAccount  walletAccount = new WalletAccount(1001,5000,WalletAccountType.SAVING,list);
	    accountDao.createWalletAccount(walletAccount);
	}
	
	@Test
	public void testWithdraw()  throws Exception
	{
		double balance = accountDao.withdraw(1001,1000);
		assertEquals(4000, balance);
		
	}
	
	@Test
	public void testDeposit()  throws Exception
	{
		double balance = accountDao.deposit(1001,1000);
		assertEquals(6000, balance);
		
	}
	
	@Test
	public void testTransaction()  throws Exception
	{
		double balance = accountDao.deposit(1001,1000);
	    //balance = accountDao.deposit(1001,1000);
		//balance = accountDao.withdraw(1001,1000);
		
		List<WalletTransaction>  list =accountDao.findAllTransaction(1001);
		
		assertEquals(1,list.size());
	}
	
	
	

}
