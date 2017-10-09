package edmodo.com.edmododemo.network;

import edmodo.com.edmododemo.network.api.AssignmentService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Don Liang on 10/8/17.
 */

public class EdmodoClient {

    AssignmentService assignmentService;
    Retrofit retrofitInstance;

    public EdmodoClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofitInstance = new Retrofit.Builder()
                .baseUrl(EdmodoApiConstants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public AssignmentService getAssignmentService() {
        return assignmentService = retrofitInstance.create(AssignmentService.class);
    }
}
