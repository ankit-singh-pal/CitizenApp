package perfect.mr.complainbox;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import perfect.mr.complainbox.TestCase.UDataAdapter;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;

    List<UDataAdapter> UDataAdapters;

    public void add(List<UDataAdapter> getUDataAdapter){


        this.UDataAdapters = getUDataAdapter;

    }
    public void add(Context context){


        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        UDataAdapter UDataAdapter =  UDataAdapters.get(position);

        viewHolder.TextViewID.setText(UDataAdapter.getId());
        viewHolder.TextViewComplainNo.setText(UDataAdapter.getComplainNo());
        viewHolder.TextViewName.setText(UDataAdapter.getName());
        viewHolder.TextViewLocationPin.setText(UDataAdapter.getLocationPin());
        viewHolder.TextViewCity.setText(UDataAdapter.getName());
        viewHolder.TextViewPincode.setText(String.valueOf(UDataAdapter.getPincode()));
        viewHolder.TextViewState.setText(UDataAdapter.getState());
        viewHolder.TextViewPhoneNumber.setText(UDataAdapter.getContactNumber());
        viewHolder.TextViewDetailView.setText(UDataAdapter.getDetailView());
        viewHolder.TextViewDate.setText(UDataAdapter.getDate());
        viewHolder.TextViewTime.setText(UDataAdapter.getTime());


    }

    @Override
    public int getItemCount() {

        return UDataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

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


        public ViewHolder(View itemView) {

            super(itemView);

            TextViewID = (TextView) itemView.findViewById(R.id.textView1) ;
            TextViewComplainNo = (TextView) itemView.findViewById(R.id.textView2) ;
            TextViewName = (TextView) itemView.findViewById(R.id.textView3) ;
            TextViewLocationPin = (TextView) itemView.findViewById(R.id.textView4) ;
            TextViewCity = (TextView) itemView.findViewById(R.id.textView5) ;
            TextViewPincode = (TextView) itemView.findViewById(R.id.textView6) ;
            TextViewState = (TextView) itemView.findViewById(R.id.textView7) ;
            TextViewPhoneNumber = (TextView) itemView.findViewById(R.id.textView8) ;
            TextViewDetailView = (TextView) itemView.findViewById(R.id.textView9);
            TextViewDate = (TextView) itemView.findViewById(R.id.textView10);
            TextViewTime = (TextView) itemView.findViewById(R.id.textView11) ;

        }
    }
}