
package com.example.android2gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GridFragment extends Fragment {

    GridView mUiGrid;
    GridAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(
                "Galeria moich fotografii");
        mUiGrid = (GridView) rootView.findViewById(R.id.grid);
        mAdapter = new GridAdapter(getActivity());
        mUiGrid.setAdapter(mAdapter);
        mUiGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItem = (int) mAdapter.getItem(position);
                Intent intent = new Intent(view.getContext(), ImageActivity.class);
                intent.putExtra("resID", selectedItem);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
