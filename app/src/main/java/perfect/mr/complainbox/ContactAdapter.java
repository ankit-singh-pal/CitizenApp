package perfect.mr.complainbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import perfect.mr.complainbox.TestCase.UDataAdapter;

public class ContactAdapter extends ArrayAdapter {

    List list= new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(UDataAdapter object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.cardview,parent,false);
            contactHolder= new ContactHolder();

            contactHolder.TextViewID = (TextView) row.findViewById(R.id.textView1) ;
            contactHolder.TextViewComplainNo = (TextView) row.findViewById(R.id.textView2) ;
            contactHolder.TextViewName = (TextView) row.findViewById(R.id.textView3) ;
            contactHolder.TextViewLocationPin = (TextView) row.findViewById(R.id.textView4) ;
            contactHolder.TextViewCity = (TextView) row.findViewById(R.id.textView5) ;
            contactHolder.TextViewPincode = (TextView) row.findViewById(R.id.textView6) ;
            contactHolder.TextViewState = (TextView) row.findViewById(R.id.textView7) ;
            contactHolder.TextViewPhoneNumber = (TextView) row.findViewById(R.id.textView8) ;
            contactHolder.TextViewDetailView = (TextView) row.findViewById(R.id.textView9);
            contactHolder.TextViewDate = (TextView) row.findViewById(R.id.textView10);
            contactHolder.TextViewTime = (TextView) row.findViewById(R.id.textView11) ;

                    row.setTag(contactHolder);
        }
        else {
            contactHolder= (ContactHolder) row.getTag();

        }

        UDataAdapter UDataAdapter = (UDataAdapter) this.getItem(position);

        contactHolder.TextViewID.setText(UDataAdapter.getId());
        contactHolder.TextViewComplainNo.setText(UDataAdapter.getComplainNo());
        contactHolder.TextViewName.setText(UDataAdapter.getName());
        contactHolder.TextViewLocationPin.setText(UDataAdapter.getLocationPin());
        contactHolder.TextViewCity.setText(UDataAdapter.getName());
        contactHolder.TextViewPincode.setText(String.valueOf(UDataAdapter.getPincode()));
        contactHolder.TextViewState.setText(UDataAdapter.getState());
        contactHolder.TextViewPhoneNumber.setText(UDataAdapter.getContactNumber());
        contactHolder.TextViewDetailView.setText(UDataAdapter.getDetailView());
        contactHolder.TextViewDate.setText(UDataAdapter.getDate());
        contactHolder.TextViewTime.setText(UDataAdapter.getTime());

        return row;
    }

    static class ContactHolder{


        public TextView TextViewID;
        public TextView TextViewComplainNo;
        public TextView TextViewName;
        public TextView TextViewLocationPin;
        public TextView TextViewCity;
        public TextView TextViewPincode;
        public TextView TextViewState;
        public TextView TextViewPhoneNumber;
        public TextView TextViewDetailView;
        public TextView TextViewDate;
        public TextView TextViewTime;


    }
}