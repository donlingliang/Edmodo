package edmodo.com.edmododemo.presentation.assignment;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.presentation.command.ActionCommand;
import edmodo.com.edmododemo.presentation.details.DetailActivity;

/**
 * Created by Don Liang on 10/8/17.
 */

public class StartDetailActivityCommand implements ActionCommand {

    private Context commandContext;
    private Assignment assignment;

    public StartDetailActivityCommand(Assignment assignment, Context context) {
        this.commandContext = context;
        this.assignment = assignment;
    }

    @Override
    public void execute() {
        String assignmentString = new Gson().toJson(assignment);
        Intent intent = new Intent(commandContext, DetailActivity.class);
        intent.putExtra(DetailActivity.ASSIGNMENT_ARG, assignmentString);
        commandContext.startActivity(intent);
    }
}
