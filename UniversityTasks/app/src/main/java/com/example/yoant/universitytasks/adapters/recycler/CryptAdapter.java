package com.example.yoant.universitytasks.adapters.recycler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yoant.universitytasks.R;
import com.example.yoant.universitytasks.helper.Constant;
import com.example.yoant.universitytasks.helper.Letter;
import com.example.yoant.universitytasks.logic.Cryptographer;

import java.util.ArrayList;
import java.util.List;

public class CryptAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Letter> mListFresh;

    public CryptAdapter(String word, int key, String algorithm) {
        mListFresh = new ArrayList<>();
        setupWord(word, key, algorithm);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new CryptItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CryptItemViewHolder viewHolder = (CryptItemViewHolder) holder;
        final Letter letter = mListFresh.get(position);
        viewHolder.textViewSeparator.setText("<===>");
        if (letter.isFlipped) {
            viewHolder.textViewWord.setText(letter.letterFlipped);
            viewHolder.textViewNumber.setText(letter.codeFlipped + "");
        } else {
            viewHolder.textViewWord.setText(letter.letterFresh);
            viewHolder.textViewNumber.setText(letter.codeFresh + "");
        }


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter.isFlipped = !letter.isFlipped;
                if (letter.isFlipped) {
                    viewHolder.textViewWord.setText(letter.letterFlipped);
                    viewHolder.textViewNumber.setText(letter.codeFlipped + "");
                    viewHolder.itemView.setBackgroundColor(Color.GRAY);
                } else {
                    viewHolder.textViewWord.setText(letter.letterFresh);
                    viewHolder.textViewNumber.setText(letter.codeFresh + "");
                    viewHolder.itemView.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListFresh.size();
    }

    private class CryptItemViewHolder extends RecyclerView.ViewHolder {

        TextView textViewWord;
        TextView textViewNumber;
        TextView isChanged;
        TextView textViewSeparator; //TODO change this at the runtime to <==>


        public CryptItemViewHolder(View itemView) {
            super(itemView);
            textViewNumber = (TextView) itemView.findViewById(R.id.element_code_value);
            textViewWord = (TextView) itemView.findViewById(R.id.element_letter_value);
            textViewSeparator = (TextView) itemView.findViewById(R.id.element_separator);
            isChanged = (TextView) itemView.findViewById(R.id.element_is_reset);
        }
    }

    private void setupWord(String word, int key, String pAlgorithm) {
        String mCryptedWord;
        if (pAlgorithm.equals(Constant.algorithmFirstName))
            mCryptedWord = Cryptographer.cryptCaesarDecrypt(word, key);
        else
            mCryptedWord = Cryptographer.cryptCaesarCrypt(word, key);
        char[] wordAsArray = word.toCharArray();
        char[] cryptedWordAsArray = mCryptedWord.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            mListFresh.add(
                    new Letter(wordAsArray[i] + "", cryptedWordAsArray[i] + "",
                            (int) (wordAsArray[i]), (int) (cryptedWordAsArray[i])));
        }
    }
}
