package aghacom.rimaa.rimaashoppinglist.MainListFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aghacom.rimaa.rimaashoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentListFragment extends Fragment {


    public CurrentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_list2, container, false);
    }

}
