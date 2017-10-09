package edmodo.com.edmododemo.presentation.assignment;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.network.EdmodoClient;
import edmodo.com.edmododemo.presentation.command.ActionCommand;
import edmodo.com.edmododemo.presentation.presenter.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Don Liang on 10/8/17.
 */

public class AssignmentPresenterImpl implements BasePresenter<AssignmentView> {

    private AssignmentView assignmentView;

    public AssignmentPresenterImpl(AssignmentView assignmentView) {
        attachView(assignmentView);
    }

    @Override
    public void attachView(AssignmentView view) {
        this.assignmentView = view;
    }

    @Override
    public void detachView() {
        this.assignmentView = null;
    }

    public void refetchAssignmentList() {
        assignmentView.clearAssignmentList();
        getAssignmentList();
    }

    public void getAssignmentList() {
        EdmodoClient edmodoClient = new EdmodoClient();

        Call<List<Assignment>> call = edmodoClient.getAssignmentService().getAssignment(null, null);
        call.enqueue(new Callback<List<Assignment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Assignment>> call, Response<List<Assignment>> response) {
                if (response.isSuccessful()) {
                    assignmentView.hideProgressBar();
                    assignmentView.showAssignment(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Assignment>> call, Throwable t) {
                Log.d("Error", t.getMessage());
                assignmentView.showProgressBar();
            }
        });
    }

    public void onItemClicked(int position, ActionCommand actionCommand) {
        actionCommand.execute();
    }
}
