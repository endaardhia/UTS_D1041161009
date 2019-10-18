package com.example.utscoba;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

/***
 * The adapter class for the RecyclerView, contains the materi data.
 */
class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.ViewHolder> {

    // Member variables.
    private ArrayList<Materi> mMateriData;
    private Context mContext;


    /**
     * Constructor that passes in the materi data and the context.
     *
     * @param materiData ArrayList containing the materi data.
     * @param context    Context of the application.
     */

    MateriAdapter(Context context, ArrayList<Materi> materiData) {
        this.mMateriData = materiData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent   The ViewGroup into which the new View will be added
     *                 after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public MateriAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder   The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder,
                                 int position) {
        // Get current materi.
        Materi currentMateri = mMateriData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentMateri);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mMateriData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        // Member Variables for the TextViews
        private TextView mTitleText;

        private ImageView mMateriImage;
        private TextView mIsiText;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mMateriImage = itemView.findViewById(R.id.materiImage);
            mIsiText = itemView.findViewById(R.id.IsiDetail);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Materi currentMateri) {
            // Populate the textviews with data.
            mTitleText.setText(currentMateri.getTitle());

            mIsiText.setText(currentMateri.getIsi());


            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentMateri.getImageResource()).into(mMateriImage);

        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @Override
        public void onClick(View view) {
            Materi currentMateri = mMateriData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentMateri.getTitle());
            detailIntent.putExtra("image_resource",
                    currentMateri.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}
