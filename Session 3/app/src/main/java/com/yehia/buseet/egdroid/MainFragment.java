package com.yehia.buseet.egdroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Button btn1;
    //    private OnCommunicationListener onCommunicationListener;
    private boolean isLand;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        this.onCommunicationListener = (OnCommunicationListener) getActivity();

        isLand = getResources().getBoolean(R.bool.isLandscape);

        btn1 = view.findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLand)
                    startActivity(new Intent(getActivity(), DetailsActivity.class));
                else {
//                    onCommunicationListener.communicate("Test Callback");

                    EventBus.getDefault().post("Test EventBus");
                }

            }
        });
    }
}
