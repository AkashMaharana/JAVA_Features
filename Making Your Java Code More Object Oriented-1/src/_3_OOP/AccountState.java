package _3_OOP;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {

	AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);

	AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> substractFromBalance);

	AccountState freezeAccount();

	AccountState holderVerified();

	AccountState closeAccount();

}
