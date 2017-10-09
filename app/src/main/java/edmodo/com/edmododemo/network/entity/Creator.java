package edmodo.com.edmododemo.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Don Liang on 10/8/17.
 */

public class Creator {

    @SerializedName("id")
    public String creatorId;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("avatars")
    public Avatar avatars;
}
