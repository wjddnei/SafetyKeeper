package com.example.safetykeeper.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safetykeeper.Adapter.ProfileAdapter;
import com.example.safetykeeper.Model.Profile;
import com.example.safetykeeper.R;

import java.util.ArrayList;

import retrofit2.http.HEAD;

public class MainFragment extends Fragment {
    private ArrayList<Profile> items = new ArrayList<>();

    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        setHasOptionsMenu(true);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);
        list();

        Context context = rootView.getContext();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.profileRecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        ProfileAdapter adapter = new ProfileAdapter(context, items);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
    private void list() {
        items.clear();
        items.add(new Profile(R.drawable.ic_launcher_background,"혜미"));
        items.add(new Profile(R.drawable.ic_launcher_foreground,"찬"));
        items.add(new Profile(R.drawable.ic_launcher_background,"혜미"));
        items.add(new Profile(R.drawable.ic_launcher_foreground,"찬"));
        items.add(new Profile(R.drawable.ic_launcher_background,"혜미"));
        items.add(new Profile(R.drawable.ic_launcher_foreground,"찬"));
    }

}
