package perfect.mr.complainbox.TestCase;

public class ADataAdapter {

    String id,name,wardNo,wardName,city,state,complainNo,viewDetail,    time,date;

    public ADataAdapter(String id, String name, String wardNo, String wardName, String city, String state, String complainNo, String viewDetail, String time, String date) {
        this.id = id;
        this.name = name;
        this.wardNo = wardNo;
        this.wardName = wardName;
        this.city = city;
        this.state = state;
        this.complainNo = complainNo;
        this.viewDetail = viewDetail;
        this.time = time;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplainNo() {
        return complainNo;
    }

    public void setComplainNo(String complainNo) {
        this.complainNo = complainNo;
    }

    public String getViewDetail() {
        return viewDetail;
    }

    public void setViewDetail(String viewDetail) {
        this.viewDetail = viewDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
