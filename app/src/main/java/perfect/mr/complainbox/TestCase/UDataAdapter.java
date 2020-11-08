package perfect.mr.complainbox.TestCase;
import java.util.ArrayList;


public class UDataAdapter {
String id,complainNo,name,locationPin,city,state,pincode,contactNumber,detailView,date,time;
        //wardNumber,wardName


    public UDataAdapter(String id, String complainNo, String name, String locationPin, String city, String state, String pincode, String contactNumber, String detailView, String date, String time) {
        this.id = id;
        this.complainNo = complainNo;
        this.name = name;
        this.locationPin = locationPin;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.contactNumber = contactNumber;
        this.detailView = detailView;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComplainNo() {
        return complainNo;
    }

    public void setComplainNo(String complainNo) {
        this.complainNo = complainNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationPin() {
        return locationPin;
    }

    public void setLocationPin(String locationPin) {
        this.locationPin = locationPin;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDetailView() {
        return detailView;
    }

    public void setDetailView(String detailView) {
        this.detailView = detailView;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}