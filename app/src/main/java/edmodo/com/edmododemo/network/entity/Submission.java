package edmodo.com.edmododemo.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Don Liang on 10/8/17.
 */

public class Submission {

    @SerializedName("submitted_at")
    public String submissionDate;

    @SerializedName("creator")
    public Creator submissionCreator;

    @SerializedName("content")
    public String content;
}
