package com.nytimes.sections.articles.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nytimes.sections.articles.R;

/**
 * Created by Oclemy on 7/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView title,byline,published_date;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);

        title= (TextView) itemView.findViewById(R.id.title);
        byline= (TextView) itemView.findViewById(R.id.byline);
        published_date= (TextView) itemView.findViewById(R.id.published_date);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
}
