package j2c.pojos;

public class Search {

    public String srchTxt;
    public long userId;

    public Search() {

    }

    public Search(String srchTxt) {
        this.srchTxt = srchTxt;
    }

    public Search(String srchTxt, long userId) {
        this.srchTxt = srchTxt;
        this.userId = userId;
    }

    public String getSrchTxt() {
        return srchTxt;
    }

    public void setSrchTxt(String srchTxt) {
        this.srchTxt = srchTxt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }





}
