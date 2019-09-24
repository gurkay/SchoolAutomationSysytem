/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



/**
 *
 * @author gurkay
 */
public class CtrRank {
    private int rank_id;
    private String rank_name;
    private Short status_id;
    private CtrStatus ctrStatus;

    public int getRank_id() {
        return rank_id;
    }

    public void setRank_id(int rank_id) {
        this.rank_id = rank_id;
    }

    public String getRank_name() {
        return rank_name;
    }

    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }

    public Short getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Short status_id) {
        this.status_id = status_id;
    }

    public CtrStatus getCtrStatus() {
        return ctrStatus;
    }

    public void setCtrStatus(CtrStatus ctrStatus) {
        this.ctrStatus = ctrStatus;
    }
    
}
