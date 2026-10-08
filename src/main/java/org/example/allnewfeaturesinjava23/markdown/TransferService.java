package org.example.allnewfeaturesinjava23.markdown;

import java.math.BigDecimal;

/// # Transfer Service
///
/// Validates simulated bank transfer requests.
///
/// ## Business Rules
///
/// - Source account must not be blank.
/// - Destination account must not be blank.
/// - Transfer amount must be **positive**.
///
/// ## Transfer Status
///
/// | Status | Description |
/// |--------|-------------|
/// | ACCEPTED | Validation passed |
///
/// ## Example
///
/// ```java
/// var service = new TransferService();
///
/// var receipt = service.transfer(
///     "ACC001",
///     "ACC002",
///     new BigDecimal("100.00")
/// );
///
/// System.out.println(receipt.status());
/// ```
///
/// Uses [BigDecimal] for monetary amounts.
///
/// This example validates requests only; it does not
/// move real funds.
public class TransferService {
    /// Validates a transfer request.
    ///
    /// @param fromAccount source account identifier
    /// @param toAccount   destination account identifier
    /// @param amount      positive transfer amount
    /// @return an immutable [TransferReceipt]
    ///         with status `ACCEPTED`
    /// @throws IllegalArgumentException if the request is invalid
    public TransferReceipt transfer(String fromAccount, String toAccount, BigDecimal amount) {
        if (fromAccount == null
                || fromAccount.isBlank()
                || toAccount == null
                || toAccount.isBlank()
                || amount == null
                || amount.signum() <= 0) {
            throw new IllegalArgumentException("Invalid transfer request");
        }
        return new TransferReceipt("ACCEPTED", amount);
    }

    /// Represents the result of a validated transfer.
    ///
    /// @param status validation status
    /// @param amount requested transfer amount
    public record TransferReceipt(String status, BigDecimal amount) {
    }
}
