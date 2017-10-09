package edmodo.com.edmododemo.presentation.presenter;

/**
 * Created by Don Liang on 10/8/17.
 */

public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();
}
