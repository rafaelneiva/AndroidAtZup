package br.com.zup.androidatzup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rafaelneiva on 08/08/18.
 */
public class PlaceholderFiveFragment extends Fragment {

    public PlaceholderFiveFragment() {
    }

    public static PlaceholderFiveFragment newInstance() {
        PlaceholderFiveFragment fragment = new PlaceholderFiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, 5));
        return rootView;
    }
}
