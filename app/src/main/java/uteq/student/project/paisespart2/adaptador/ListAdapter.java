package uteq.student.project.paisespart2.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uteq.student.project.paisespart2.R;
import uteq.student.project.paisespart2.entidad.Pais;
import uteq.student.project.paisespart2.entidad.Pais2;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Pais2> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<Pais2> paisList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = paisList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_card_pais, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_Pais, text_Capital, text_Iso;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_Pais = itemView.findViewById(R.id.text_Pais);
            text_Capital = itemView.findViewById(R.id.text_Capital);
            text_Iso = itemView.findViewById(R.id.text_Iso);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bindData(final Pais2 item) {
            text_Pais.setText(item.getName());
            text_Capital.setText(item.getName_capital());
            text_Iso.setText(item.getIso2());
        }

    }

}
