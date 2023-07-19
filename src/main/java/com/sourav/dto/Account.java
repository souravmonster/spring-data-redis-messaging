package com.sourav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountName;
    private long accountNumber;
    private String type;
    private Double amount;
    private String billingCity;
    private String billingState;
    private String billingCountry;

    public enum PaymentType {

        DONE(1, "Done"),
        PENDING(2, "Pending"),
        PROCESSED(3, "Processed"),
        FAILED(4, "Failed"),
        EMPTY(5, "Empty");

        private int id;
        private String defaultDisplayName;

        private PaymentType(int id, String defaultDisplayName) {
            this.id = id;
            this.defaultDisplayName = defaultDisplayName;
        }

        public int getId() {
            return id;
        }
        public String getDefaultDisplayName() {
            return defaultDisplayName;
        }

        public static PaymentType getEnumByName(String name) {

            for (PaymentType paymentType : PaymentType.values()) {
                if (paymentType.getDefaultDisplayName().equalsIgnoreCase(name)) {
                    return paymentType;
                }
            }
            return EMPTY;
        }
    }
}
