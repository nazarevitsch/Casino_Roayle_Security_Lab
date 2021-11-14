package com.bida.casino.royal.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "account")
public class Account {

    public Account(Long id, int money) {
        this.id = id;
        this.money = money;
    }

    public Account(){}

    @Id
    @Column(name = "a_id")
    private Long id;

    @Column(name = "a_money")
    private int money;

    @CreationTimestamp
    @Column(name = "a_creation_time")
    private ZonedDateTime creationTime;
}
