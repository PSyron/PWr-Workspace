
package dziewiate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.android3galeria.R;

public class SecondGrid9Adapter extends BaseAdapter {
    private Context context;

    public int[] zdjecia = {
            R.drawable.donatan, R.drawable.ellie, R.drawable.lp, R.drawable.script,
            R.drawable.lonely
    };

    private LayoutInflater mInflater = null;

    static class ViewHolder {

        ImageView pic;

    }

    public SecondGrid9Adapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return zdjecia.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_scroll_grid, null);

            viewHolder = new ViewHolder();

            viewHolder.pic = (ImageView) view.findViewById(R.id.scroll_item);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.pic.setImageResource(zdjecia[position]);

        return view;
    }
}
