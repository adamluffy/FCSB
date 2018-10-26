package fcsb.franky.com.my.fcsb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class VehicleMillageFragment extends Fragment {

    public VehicleMillageFragment() {
        // Required empty public constructor
    }

    public static VehicleMillageFragment newInstance(String param1, String param2) {
        VehicleMillageFragment fragment = new VehicleMillageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_vehicle_millage, container, false);
    }



}
