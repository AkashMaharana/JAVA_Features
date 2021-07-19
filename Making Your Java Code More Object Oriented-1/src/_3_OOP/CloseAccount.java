package _3_OOP;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class CloseAccount implements AccountState {

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
		return this;
	}

	@Override
	public AccountState closeAccount() {
		return this;
	}

}
