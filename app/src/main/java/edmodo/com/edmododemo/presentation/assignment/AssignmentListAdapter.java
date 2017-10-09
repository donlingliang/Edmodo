package edmodo.com.edmododemo.presentation.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.presentation.viewholder.BindableViewHolder;

/**
 * Created by Don Liang on 10/8/17.
 */

public class AssignmentListAdapter extends RecyclerView.Adapter<BindableViewHolder> {

    private List<Assignment> assignmentArrayList = new ArrayList<>();
    private ItemClickListener mItemClickListener;

    public AssignmentListAdapter(ItemClickListener itemClickListener) {
        super();
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_assignment_row, parent, false);
        return new AssignmentViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(BindableViewHolder holder, int position) {
        holder.bind(assignmentArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return assignmentArrayList.size();
    }

    public void setAssignmentArrayList(List<Assignment> arrayList) {
        this.assignmentArrayList = arrayList;
    }

    public void clearList() {
        this.assignmentArrayList.clear();
        notifyDataSetChanged();
    }

    public void addAssignment(Assignment assignment) {
        this.assignmentArrayList.add(assignment);
        notifyItemInserted(assignmentArrayList.size() - 1);
    }
}

