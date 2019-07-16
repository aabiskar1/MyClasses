package com.aabiskar.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;

public class DataAdapter extends FirestoreRecyclerAdapter<DataItems, DataAdapter.dataHolder> {
    private OnItemClickListener listener;
    public DataAdapter(@NonNull FirestoreRecyclerOptions<DataItems> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull dataHolder holder, int position, @NonNull DataItems model) {
                holder.txtTitle.setText(model.getModule_title());
                holder.txtTime.setText(model.getModule_time());
                holder.txtBlock.setText(model.getModule_block());
                holder.txtRoom.setText(model.getModule_room());
                holder.txt_moduleTeacher.setText(model.getModule_teacher());
                holder.txt_moduleType.setText(model.getModule_type());
                holder.txt_moduleGroup.setText(model.getModule_group());
                holder.txt_moduleOrder.setText(model.getModule_order());
                holder.txt_moduleDay.setText(model.getModule_day());
    }

    @NonNull
    @Override
    public dataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_data_card, viewGroup, false);
       return new dataHolder(v);
    }

    class dataHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtTime;
        TextView txtBlock;
        TextView txtRoom;
        TextView txt_moduleType;
        TextView txt_moduleTeacher;
        TextView txt_moduleGroup;
        TextView txt_moduleOrder;
        TextView txt_moduleDay;
        public FloatingActionButton closeBtn;
        public dataHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.card_moduleTitle);
            txtTime =  itemView.findViewById(R.id.card_moduleTime);
            txtRoom = itemView.findViewById(R.id.card_room);
            txtBlock = itemView.findViewById(R.id.card_block);
            txt_moduleType = itemView.findViewById(R.id.card_moduleType);
            txt_moduleTeacher = itemView.findViewById(R.id.card_ModuleTeacher);
            txt_moduleGroup = itemView.findViewById(R.id.card_groups);
            txt_moduleOrder = itemView.findViewById(R.id.card_order);
            txt_moduleDay = itemView.findViewById(R.id.card_moduleDay);
            closeBtn = itemView.findViewById(R.id.closeFabBtn);

            closeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
