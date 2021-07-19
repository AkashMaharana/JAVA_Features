package _3_OOP;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class NotVerifiedAccount implements AccountState{
	
	private AccountUnfrozen onUnFrozen;
	
	public NotVerifiedAccount(AccountUnfrozen onUnfrozen) {
		this.onUnFrozen=onUnfrozen;
	}

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		return this;
	}

	@Override
	public AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> substractFromBalance) {
		return this;
	}

	@Override
	public AccountState freezeAccount() {
		return this;
	}

	@Override
	public AccountState holderVerified() {
		return new ActiveAccount(this.onUnFrozen);
	}

	@Override
	public AccountState closeAccount() {
		return this;
	}

}
