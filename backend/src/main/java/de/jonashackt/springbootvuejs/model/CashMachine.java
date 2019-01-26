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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // РАБОТАЕТ ЛИ БАНКОМАТ 24/7
    @Column(name = "IS_WORKING")
    private boolean aroundTheClock;

    // ЛИМИТ НА СНЯТИЕ
    @Column(name = "WITHDRAWAL_LIMIT")
    private int withdrawalLimit;

    // ЛИМИТ НА ДЕПОЗИТ
    @Column(name = "DEPOSIT_LIMIT")
    private int depositLimit;

    // ШИРОТА
    @Column(name = "LATITUDE")
    private double latitude;

    // ДОЛГОТА
    @Column(name = "LONGITUDE")
    private double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getAroundTheClock() {
        return aroundTheClock;
    }

    public void setAroundTheClock(boolean aroundTheClock) {
        this.aroundTheClock = aroundTheClock;
    }

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(int withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public int getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(int depositLimit) {
        this.depositLimit = depositLimit;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
