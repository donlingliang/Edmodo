package edmodo.com.edmododemo.presentation.assignment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.presentation.viewholder.BindableViewHolder;
import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;

/**
 * Created by Don Liang on 10/8/17.
 */

public class AssignmentViewHolder extends BindableViewHolder<Assignment> {

    @BindView(R.id.assignment_title_textview)
    public TextView assignmentTitle;
    @BindView(R.id.assignment_due_date_textview)
    public TextView assignmentDueDate;
    ItemClickListener mItemClickListener;

    public AssignmentViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mItemClickListener = itemClickListener;
    }

    @Override
    public void bind(Assignment model, int position) {
        final Assignment assignment = model;
        assignmentTitle.setText(model.title);
        assignmentDueDate.setText(model.dueDate);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClickedListener(assignment, getAdapterPosition());
                }
            }
        });
    }
}
