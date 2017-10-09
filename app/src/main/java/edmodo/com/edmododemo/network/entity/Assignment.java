package edmodo.com.edmododemo.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Don Liang on 10/8/17.
 */

public class Assignment {

    @SerializedName("id")
    public String assignmentId;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("due_at")
    public String dueDate;

    @SerializedName("creator")
    public Creator creator;
}
