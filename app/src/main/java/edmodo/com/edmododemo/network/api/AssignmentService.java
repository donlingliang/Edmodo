package edmodo.com.edmododemo.network.api;

import java.util.List;

import edmodo.com.edmododemo.network.EdmodoApiConstants;
import edmodo.com.edmododemo.network.entity.Assignment;
import edmodo.com.edmododemo.network.entity.Submission;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Don Liang on 10/8/17.
 */

public interface AssignmentService {

    // https://api.edmodo.com/assignments?access_token=
    @GET("assignments?access_token=" + EdmodoApiConstants.ACCESS_TOKEN)
    Call<List<Assignment>> getAssignment(@Query("page") String page,
                                         @Query("per_page") Integer count);

    // https://api.edmodo.com/assignment_submissions?assignment_id=ASSIGNMENT_ID&
    // assignment_creator_id=73240721&access_token=
    @GET("assignment_submissions?")
    Call<List<Submission>> getSubmissions(@Query("assignment_id") String assignmentId,
                                          @Query("assignment_creator_id") String creatorId,
                                          @Query("access_token") String accessToken);
}