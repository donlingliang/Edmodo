package edmodo.com.edmododemo.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Don Liang on 10/8/17.
 */

public class Avatar {

    @SerializedName("small")
    public String avatarSmallUrl;

    @SerializedName("large")
    public String avatarLargeUrl;

}
