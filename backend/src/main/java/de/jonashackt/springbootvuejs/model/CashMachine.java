package de.jonashackt.springbootvuejs.model;

import javax.persistence.*;

/**
 * Банкомат
 * @author aleksandr
 * @date 2019-01-26 21:00
 */
@Entity
@Table(name = "CASH_MACHINE")
public class CashMachine {

    @Id
    @GeneratedValue
    private Long id;

    // РАБОТАЕТ ЛИ БАНКОМАТ 24/7
    @Column(name = "IS_WORKING")
    private Boolean aroundTheClock;

    // ЛИМИТ НА СНЯТИЕ
    @Column(name = "WITHDRAWAL_LIMIT")
    private Integer withdrawalLimit;

    // ЛИМИТ НА ДЕПОЗИТ
    @Column(name = "DEPOSIT_LIMIT")
    private Integer depositLimit;

    // ШИРОТА
    @Column(name = "LATITUDE")
    private Double latitude;

    // ДОЛГОТА
    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NAME")
    private String name;

    @Column

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAroundTheClock() {
        return aroundTheClock;
    }

    public void setAroundTheClock(Boolean aroundTheClock) {
        this.aroundTheClock = aroundTheClock;
    }

    public Integer getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(Integer withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public Integer getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(Integer depositLimit) {
        this.depositLimit = depositLimit;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
