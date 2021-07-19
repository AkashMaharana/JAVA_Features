package _3_OOP;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal balance;
	private AccountState accountState;
	
	public Account(AccountUnfrozen onUnfrozen) {
		this.balance=BigDecimal.ZERO;
		this.accountState=new ActiveAccount(onUnfrozen);
	}
	
	public void holderVerified() {
		this.accountState=this.accountState.holderVerified();
	}
	
	public void closeAccount() {
		this.accountState=this.accountState.closeAccount();
	}
	
	public void freezeAccount() {
		this.accountState=this.accountState.freezeAccount();
	}
	
	public void deposit(BigDecimal amount) {
		this.accountState=this.accountState.deposit(amount, this::addToBalance);
	}
	
	private void addToBalance(BigDecimal amount) {
		this.balance=this.balance.add(amount);
	}
	
	public void withdraw(BigDecimal amount) {
		this.accountState=this.accountState.withdraw(this.balance, amount, this::subtractFromBalance);
	}
	
	private void subtractFromBalance(BigDecimal amount) {
		this.balance=this.balance.subtract(amount);
	}
	
	

}
