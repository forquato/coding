package de.dimk.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class RewardTransaction {

    @Id
    private Long Id;
    private Date createdDate;
    private BigDecimal amount;
    private String description;
    private String payeeName;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
