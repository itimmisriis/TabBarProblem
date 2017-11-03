package com.hfad.catchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class InboxFragment extends Fragment implements TestClickListener {

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        String items[] = { "Route 1", "Route 2", "Route 3" };

        mRecyclerView =  (RecyclerView)view.findViewById(R.id.recycler_View);

        TestAdapter adapter = new TestAdapter(items);

        mRecyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        StaggeredGridLayoutManager mStaggeredLayoutManager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        return view;
    }

    private void NextScreen() {
        Fragment fragment = new TabBarParentFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("NextScreen").commit();
    }

    @Override
    public void OnTestItemClicked() {
        NextScreen();
    }
}
