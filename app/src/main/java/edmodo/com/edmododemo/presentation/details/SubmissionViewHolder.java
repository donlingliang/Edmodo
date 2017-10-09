package edmodo.com.edmododemo.presentation.details;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Submission;
import edmodo.com.edmododemo.presentation.viewholder.BindableViewHolder;
import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;

/**
 * Created by Don Liang on 10/8/17.
 */

public class SubmissionViewHolder extends BindableViewHolder<Submission> {

    @BindView(R.id.creator_name_textview)
    public TextView creatorNameTextView;
    @BindView(R.id.creator_submit_date_textview)
    public TextView creatorSubmitDateTextView;
    @BindView(R.id.creator_avatar_imageview)
    public ImageView creatorAvatarImageView;

    private ItemClickListener mItemClickListener;

    public SubmissionViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public void bind(Submission model, int position) {
        final Submission submission = model;

        String fullName;
        StringBuilder stringBuilder = new StringBuilder();
        if (submission.submissionCreator.firstName != null) {
            stringBuilder.append(submission.submissionCreator.firstName);
        }
        if (submission.submissionCreator.lastName != null) {
            stringBuilder.append(submission.submissionCreator.lastName);
        }
        fullName = stringBuilder.toString();
        creatorNameTextView.setText(fullName);
        creatorSubmitDateTextView.setText(submission.submissionDate);

        Glide.with(itemView.getContext()).load(submission.submissionCreator.avatars.avatarSmallUrl).into(creatorAvatarImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClickedListener(submission, getAdapterPosition());
                }
            }
        });
    }
}
