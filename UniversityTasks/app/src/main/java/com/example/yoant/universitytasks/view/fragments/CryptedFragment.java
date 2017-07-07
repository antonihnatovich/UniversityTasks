package com.example.yoant.universitytasks.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yoant.universitytasks.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CryptedFragment extends Fragment {

    private static final String KEY = "method";



    public CryptedFragment() {
    }

    public static final CryptedFragment newInstance(String pCryptMethod) {
        CryptedFragment fragment = new CryptedFragment();
        Bundle args = new Bundle();
        args.putString(KEY, pCryptMethod);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crypted, container, false);
    }

}
