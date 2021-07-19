package _3_Traditional;

public class Account {
	
	private boolean isVerified;
	private boolean isClosed;
	private int balance;
	private boolean isFroozen;
	private AccountUnFrozen onUnFrozen;
	
	public Account(AccountUnFrozen onUnFrozen) {
		this.balance=0;
		this.onUnFrozen=onUnFrozen;
	}
	
	public void closeAccount() {
		this.isClosed=true;
	}
	
	public void isHolderVerified() {
		this.isVerified=true;
	}
	
	public void deposit(int depositAmount) {
		if(this.isClosed) {
			return;
		}
		if(this.isFroozen) {
			this.isFroozen=false;
			this.onUnFrozen.handle();
		}
		this.balance=this.balance+depositAmount;
		//deposit money
	}
	
	public void withdraw(int withdrawlAmount) {
		if(!this.isVerified) {
			return;
		}
		if(this.isClosed) {
			return;
		}
		if(this.isFroozen) {
			this.isFroozen=false;
			this.onUnFrozen.handle();
		}
		this.balance=this.balance-withdrawlAmount;
		//withdraw money
	}
	
	public void freezeAccount() {
		if(this.isClosed) {
			return;
		}
		if(!this.isVerified) {
			return;
		}
		this.isFroozen=true;
	}

}
