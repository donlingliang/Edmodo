package edmodo.com.edmododemo.presentation.details;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import edmodo.com.edmododemo.network.entity.Submission;
import edmodo.com.edmododemo.presentation.command.ActionCommand;
import edmodo.com.edmododemo.presentation.submission.SubmissionActivity;

/**
 * Created by Don Liang on 10/8/17.
 */

public class StartSubmissionActivityCommand implements ActionCommand {

    private Context commandContext;
    private Submission submission;
    private String title;

    public StartSubmissionActivityCommand(Submission submission, Context context, String title) {
        this.commandContext = context;
        this.submission = submission;
        this.title = title;
    }

    @Override
    public void execute() {
        String assignmentString = new Gson().toJson(submission);
        Intent intent = new Intent(commandContext, SubmissionActivity.class);
        intent.putExtra(SubmissionActivity.SUBMISSION_TITLE_ARG, title);
        intent.putExtra(SubmissionActivity.SUBMISSION_ARG, assignmentString);
        commandContext.startActivity(intent);
    }
}
