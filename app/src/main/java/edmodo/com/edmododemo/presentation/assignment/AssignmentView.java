package edmodo.com.edmododemo.presentation.assignment;

import java.util.List;

import edmodo.com.edmododemo.network.entity.Assignment;

/**
 * Created by Don Liang on 10/8/17.
 */

public interface AssignmentView {

    void showAssignment(List<Assignment> assignmentList);

    void clearAssignmentList();

    void showProgressBar();

    void hideProgressBar();
}
