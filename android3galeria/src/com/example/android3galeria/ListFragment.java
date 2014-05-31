
package com.example.android3galeria;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import szoste.Zadanie6;

public class ListFragment extends Fragment {

    ListView mUiListView;
    ImageAdapter mAdapter;
    Button mUiButton;
    Button mUiButton6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mUiListView = (ListView) rootView.findViewById(R.id.list_container);
        mAdapter = new ImageAdapter(getActivity());
        mUiListView.setAdapter(mAdapter);
        mUiButton = (Button) rootView.findViewById(R.id.button);
        mUiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Zadanie5.class);
                startActivity(intent);
            }
        });
        mUiButton6 = (Button) rootView.findViewById(R.id.button6);
        mUiButton6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Zadanie6.class);
                startActivity(intent);
            }
        });

        mUiListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItem = position;
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("position", selectedItem);
                startActivity(intent);

            }
        });

        return rootView;
    }
}
