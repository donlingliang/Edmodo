package edmodo.com.edmododemo.presentation.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Don Liang on 10/8/17.
 */

public abstract class BindableViewHolder<T> extends RecyclerView.ViewHolder {

    public BindableViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T model, int position);
}
