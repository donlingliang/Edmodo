package edmodo.com.edmododemo.presentation.details;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import edmodo.com.edmododemo.network.EdmodoApiConstants;
import edmodo.com.edmododemo.network.EdmodoClient;
import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.network.entity.Submission;
import edmodo.com.edmododemo.presentation.command.ActionCommand;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Don Liang on 10/8/17.
 */

public class DetailPresenter {

    private SubmissionViewListener submissionViewListener;
    private Assignment mAssignment;

    public DetailPresenter(SubmissionViewListener submissionViewListener) {
        this.submissionViewListener = submissionViewListener;
    }

    public void initPresenter(Assignment assignment) {
        mAssignment = assignment;
        getSubmissions();
    }

    public void getSubmissions() {
        EdmodoClient edmodoClient = new EdmodoClient();

        Call<List<Submission>> call = edmodoClient.getAssignmentService().getSubmissions(mAssignment.assignmentId, mAssignment.creator.creatorId, EdmodoApiConstants.ACCESS_TOKEN);
        call.enqueue(new Callback<List<Submission>>() {
            @Override
            public void onResponse(@NonNull Call<List<Submission>> call, Response<List<Submission>> response) {
                submissionViewListener.assignmentListReady(response.body());
            }

            @Override
            public void onFailure(Call<List<Submission>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    public void onItemClicked(int position, ActionCommand actionCommand) {
        actionCommand.execute();
    }

    public interface SubmissionViewListener {
        void assignmentListReady(List<Submission> assignmentList);
    }
}
