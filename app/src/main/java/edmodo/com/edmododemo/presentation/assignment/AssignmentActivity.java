package edmodo.com.edmododemo.presentation.assignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmodo.com.edmododemo.network.entity.Creator;
import edmodo.com.edmododemo.presentation.viewholder.ItemClickListener;
import edmodo.com.edmododemo.R;
import edmodo.com.edmododemo.network.entity.Assignment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


public class AssignmentActivity extends AppCompatActivity
        implements AssignmentView, ItemClickListener {

    private AssignmentPresenterImpl assignmentPresenterImpl;
    private AssignmentListAdapter assignmentListAdapter;

    @BindView(R.id.card_recycler_view)
    RecyclerView assignmentRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fab)
    FloatingActionButton addAssignmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        assignmentPresenterImpl = new AssignmentPresenterImpl(this);
        assignmentPresenterImpl.getAssignmentList();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        assignmentRecyclerView.setLayoutManager(layoutManager);
        assignmentListAdapter = new AssignmentListAdapter(this);
        assignmentRecyclerView.setAdapter(assignmentListAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                assignmentPresenterImpl.refetchAssignmentList();
            }
        });

        addAssignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewAssignment();
            }
        });
    }

    @Override
    public void showAssignment(List<Assignment> assignmentList) {
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
        assignmentListAdapter.setAssignmentArrayList(assignmentList);
        assignmentListAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearAssignmentList() {
        assignmentListAdapter.clearList();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        assignmentPresenterImpl.detachView();
        super.onDestroy();
    }

    @Override
    public void onItemClickedListener(Object model, int position) {
        if (model instanceof Assignment) {
            assignmentPresenterImpl.onItemClicked(position, new StartDetailActivityCommand((Assignment) model, this));
        }
    }

    private void addNewAssignment() {
        Assignment assignment = new Assignment();
        assignment.title = "More Edmodo Android Assignment";
        assignment.dueDate="2017-10-08";
        assignment.description = "Give me more";
        Creator creator = new Creator();
        creator.creatorId = "Don Liang";
        assignment.creator = creator;
        assignmentListAdapter.addAssignment(assignment);
    }
}

