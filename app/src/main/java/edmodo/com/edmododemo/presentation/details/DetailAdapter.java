package edmodo.com.edmododemo.presentation.details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Submission;

/**
 * Created by Don Liang on 10/8/17.
 */

public class DetailAdapter extends RecyclerView.Adapter<SubmissionViewHolder> {

    private List<Submission> assignmentArrayList = new ArrayList<>();
    private ItemClickListener mItemClickListener;

    public DetailAdapter(ItemClickListener itemClickListener) {
        super();
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public SubmissionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_submission_row, parent, false);
        return new SubmissionViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(SubmissionViewHolder holder, int position) {
        holder.bind(assignmentArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return assignmentArrayList == null ? 0 : assignmentArrayList.size();
    }

    public void setAssignmentArrayList(List<Submission> arrayList) {
        this.assignmentArrayList = arrayList;
    }
}
