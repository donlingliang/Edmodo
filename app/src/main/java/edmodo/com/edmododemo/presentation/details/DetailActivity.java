package edmodo.com.edmododemo.presentation.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.network.entity.Submission;
import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;

public class DetailActivity extends AppCompatActivity implements DetailPresenter.SubmissionViewListener, ItemClickListener {

    public static final String ASSIGNMENT_ARG = "ASSIGNMENT_ARG";

    private DetailPresenter submissionPresenter;
    private DetailAdapter detailAdapter;

    @BindView(R.id.submission_recycler_view)
    RecyclerView submissionRecyclerView;
    @BindView(R.id.assignment_details_textView)
    TextView assignmentDetailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void assignmentListReady(List<Submission> detailList) {
        detailAdapter.setAssignmentArrayList(detailList);
        detailAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClickedListener(Object model, int position) {
        if (model instanceof Submission) {
            submissionPresenter.onItemClicked(position, new StartSubmissionActivityCommand((Submission) model,
                    this, getSupportActionBar().getTitle().toString()));
        }
    }

    private void initView() {
        submissionPresenter = new DetailPresenter(this);

        Gson gson = new Gson();
        String gsonObjectString = getIntent().getStringExtra(ASSIGNMENT_ARG);
        Assignment assignment = gson.fromJson(gsonObjectString, Assignment.class);
        getSupportActionBar().setTitle(assignment.title);
        assignmentDetailView.setText(assignment.description);
        submissionPresenter.initPresenter(assignment);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        submissionRecyclerView.setLayoutManager(layoutManager);
        detailAdapter = new DetailAdapter(this);
        submissionRecyclerView.setAdapter(detailAdapter);
    }
}
