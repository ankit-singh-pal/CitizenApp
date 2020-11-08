package perfect.mr.complainbox.TestCase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;

import java.util.List;

import perfect.mr.complainbox.R;

public class UAdapter extends RecyclerView.Adapter<UAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<UDataAdapter> productList;

    public UAdapter(Context mCtx, List<UDataAdapter> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder contactHolder, int position) {
        UDataAdapter UDataAdapter = productList.get(position);

      /*  //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);*/

        contactHolder.TextViewID.setText(UDataAdapter.getId());
        contactHolder.TextViewComplainNo.setText(UDataAdapter.getComplainNo());
        contactHolder.TextViewName.setText(UDataAdapter.getName());
        contactHolder.TextViewLocationPin.setText(UDataAdapter.getLocationPin());
        contactHolder.TextViewCity.setText(UDataAdapter.getName());
        contactHolder.TextViewState.setText(UDataAdapter.getState());
        contactHolder.TextViewPincode.setText(String.valueOf(UDataAdapter.getPincode()));
        contactHolder.TextViewPhoneNumber.setText(UDataAdapter.getContactNumber());
        contactHolder.TextViewDetailView.setText(UDataAdapter.getDetailView());
        contactHolder.TextViewDate.setText(UDataAdapter.getDate());
        contactHolder.TextViewTime.setText(UDataAdapter.getTime());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

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


        ImageView imageView;

        public ProductViewHolder(View row) {
            super(row);


            TextViewID = (TextView) row.findViewById(R.id.textView1) ;
            TextViewComplainNo = (TextView) row.findViewById(R.id.textView2) ;
            TextViewName = (TextView) row.findViewById(R.id.textView3) ;
            TextViewLocationPin = (TextView) row.findViewById(R.id.textView4) ;
            TextViewCity = (TextView) row.findViewById(R.id.textView5) ;
            TextViewState = (TextView) row.findViewById(R.id.textView6) ;
            TextViewPincode = (TextView) row.findViewById(R.id.textView7) ;
            TextViewPhoneNumber = (TextView) row.findViewById(R.id.textView8) ;
            TextViewDetailView = (TextView) row.findViewById(R.id.textView9);
            TextViewDate = (TextView) row.findViewById(R.id.textView10);
            TextViewTime = (TextView) row.findViewById(R.id.textView11) ;

        //    imageView = itemView.findViewById(R.id.imageView);
        }
    }
}