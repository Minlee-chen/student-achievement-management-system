package model;

public class QueryScore {
    private String SN;
    private String SNO;
    private String CNO;
    private String CN;
    private float Score;

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
    }

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float score) {
        Score = score;
    }
}
