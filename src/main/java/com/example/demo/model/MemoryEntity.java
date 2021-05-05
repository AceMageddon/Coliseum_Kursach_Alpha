package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "memory", schema = "public", catalog = "coliseumstats")
public class MemoryEntity {
    private long id;
    private int parryammount;
    private int highscore;
    private int battlestatus;
    private Integer level;
    private long playerid;
    private long enemyid;
    private Integer strike;
    private Integer playernum;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parryammount")
    public int getParryammount() {
        return parryammount;
    }

    public void setParryammount(int parryammount) {
        this.parryammount = parryammount;
    }

    @Basic
    @Column(name = "highscore")
    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    @Basic
    @Column(name = "battlestatus")
    public int getBattlestatus() {
        return battlestatus;
    }

    public void setBattlestatus(int battlestatus) {
        this.battlestatus = battlestatus;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "playerid")
    public long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(long playerid) {
        this.playerid = playerid;
    }

    @Basic
    @Column(name = "enemyid")
    public long getEnemyid() {
        return enemyid;
    }

    public void setEnemyid(long enemyid) {
        this.enemyid = enemyid;
    }

    @Basic
    @Column(name = "strike")
    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    @Basic
    @Column(name = "playernum")
    public Integer getPlayernum() {
        return playernum;
    }

    public void setPlayernum(Integer playernum) {
        this.playernum = playernum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryEntity that = (MemoryEntity) o;
        return id == that.id && parryammount == that.parryammount && highscore == that.highscore && battlestatus == that.battlestatus && playerid == that.playerid && enemyid == that.enemyid && Objects.equals(level, that.level) && Objects.equals(strike, that.strike) && Objects.equals(playernum, that.playernum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parryammount, highscore, battlestatus, level, playerid, enemyid, strike, playernum);
    }
}
