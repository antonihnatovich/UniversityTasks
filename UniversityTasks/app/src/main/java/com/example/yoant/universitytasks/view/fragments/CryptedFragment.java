package com.example.yoant.universitytasks.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yoant.universitytasks.R;
import com.example.yoant.universitytasks.adapters.recycler.CryptAdapter;
import com.example.yoant.universitytasks.helper.Constant;
import com.example.yoant.universitytasks.helper.VariablesHolder;
import com.example.yoant.universitytasks.logic.Cryptographer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CryptedFragment extends Fragment {

    public CryptedFragment() {
    }

    public static final CryptedFragment newInstance(String pCryptMethod) {
        CryptedFragment fragment = new CryptedFragment();
        Bundle args = new Bundle();
        args.putString(Constant.KEY, pCryptMethod);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crypted, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        //Getting values from Variables holder class.
        String word = VariablesHolder.word;
        String key = VariablesHolder.key + "";

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);
        TextView textViewFreshWord = (TextView)view.findViewById(R.id.fragment_label_word_value);
        TextView textViewKey = (TextView) view.findViewById(R.id.fragment_label_key_value);
        TextView textViewCryptedWord = (TextView) view.findViewById(R.id.fragment_label_crypted_value);

        CryptAdapter adapter = new CryptAdapter(word, Integer.parseInt(key));


        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        //Setting the label values
        textViewFreshWord.setText(word);
        textViewKey.setText(key);
        //TODO CHANGE THE METHOD DEPENDS ON THE ALGORITHM NAME VALUE
        textViewCryptedWord.setText(Cryptographer.cryptCaesarDecrypt(word, Integer.parseInt(key)));
    }

}
