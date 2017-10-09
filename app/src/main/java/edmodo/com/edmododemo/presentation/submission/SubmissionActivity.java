package edmodo.com.edmododemo.presentation.submission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Submission;

public class SubmissionActivity extends AppCompatActivity {

    public static final String SUBMISSION_ARG = "SUBMISSION_ARG";
    public static final String SUBMISSION_TITLE_ARG = "SUBMISSION_TITLE_ARG";

    @BindView(R.id.submission_owner_imageview)
    ImageView ownerImageView;
    @BindView(R.id.submission_owner_textview)
    TextView ownerNameTextView;
    @BindView(R.id.submission_date)
    TextView submissionDateTextView;
    @BindView(R.id.submission_detail_textview)
    TextView submissionDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(getIntent().getStringExtra(SUBMISSION_TITLE_ARG));
        Gson gson = new Gson();
        String gsonObjectString = getIntent().getStringExtra(SUBMISSION_ARG);
        Submission submission = gson.fromJson(gsonObjectString, Submission.class);

        Glide.with(this).load(submission.submissionCreator.avatars.avatarSmallUrl).into(ownerImageView);
        ownerNameTextView.setText(submission.submissionCreator.firstName);
        submissionDetailTextView.setText(submission.content);
        submissionDateTextView.setText(submission.submissionDate);
    }
}
