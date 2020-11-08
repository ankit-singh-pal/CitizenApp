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

public class AAdapter extends RecyclerView.Adapter<AAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<ADataAdapter> productList;

    public AAdapter(Context mCtx, List<ADataAdapter> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.acardview, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder contactHolder, int position) {
        ADataAdapter ADataAdapter = productList.get(position);

      /*  //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);*/

        contactHolder.TextViewID.setText(ADataAdapter.getId());
        contactHolder.TextViewName.setText(ADataAdapter.getName());
        contactHolder.TextViewWardNumber.setText(ADataAdapter.getWardNo());
        contactHolder.TextViewWardName.setText(ADataAdapter.getWardName());
        contactHolder.TextViewCity.setText(ADataAdapter.getCity());
        contactHolder.TextViewState.setText(ADataAdapter.getState());
        contactHolder.TextViewComplainNo.setText(ADataAdapter.getComplainNo());
        contactHolder.TextViewDetailView.setText(ADataAdapter.getViewDetail());
        contactHolder.TextViewTime.setText(ADataAdapter.getTime());
        contactHolder.TextViewDate.setText(ADataAdapter.getDate());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView TextViewID;
        public TextView TextViewName;
        public TextView TextViewWardNumber;
        public TextView TextViewWardName;
        public TextView TextViewCity;
        public TextView TextViewState;
        //public TextView TextViewPhoto;
        public TextView TextViewComplainNo;
        public TextView TextViewDetailView;
        public TextView TextViewTime;
        public TextView TextViewDate;

        ImageView imageView;

        public ProductViewHolder(View row) {
            super(row);


            TextViewID = (TextView) row.findViewById(R.id.textView1) ;
            TextViewName = (TextView) row.findViewById(R.id.textView2) ;
            TextViewWardNumber=(TextView) row.findViewById(R.id.textView3);
            TextViewWardName=(TextView) row.findViewById(R.id.textView4);
            TextViewCity = (TextView) row.findViewById(R.id.textView5) ;
            TextViewState = (TextView) row.findViewById(R.id.textView6) ;
            TextViewComplainNo = (TextView) row.findViewById(R.id.textView7) ;
            TextViewDetailView = (TextView) row.findViewById(R.id.textView8);
            TextViewTime = (TextView) row.findViewById(R.id.textView9) ;
            TextViewDate = (TextView) row.findViewById(R.id.textView10);

            //    imageView = itemView.findViewById(R.id.imageView);
        }
    }
}