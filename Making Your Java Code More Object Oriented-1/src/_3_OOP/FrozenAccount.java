package _3_OOP;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class FrozenAccount implements AccountState {
	
	private AccountUnfrozen onUnfrozen;
	
	public FrozenAccount(AccountUnfrozen onUnfrozen) {
		this.onUnfrozen=onUnfrozen;
	}

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return this.unfreeze();
	}

	private AccountState unfreeze() {
		this.onUnfrozen.handle();
		return new ActiveAccount(this.onUnfrozen);
	}

	@Override
	public AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> substractFromBalance) {
		if(balance.compareTo(amount)>=0) {
			substractFromBalance.accept(amount);
		}
		return this.unfreeze();
	}

	@Override
	public AccountState freezeAccount() {
		return this;
	}

	@Override
	public AccountState holderVerified() {
		return this;
	}

	@Override
	public AccountState closeAccount() {
		return new CloseAccount();
	}

}
