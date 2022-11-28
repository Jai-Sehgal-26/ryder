package com.example.ryder.ui.main.cabs;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryder.R;
import com.example.ryder.ui.main.cabs.live.LiveCabsFragment;
import com.example.ryder.ui.main.cabs.request.RequestFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class CabsFragment extends Fragment {

    private CabsViewModel mViewModel;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private LiveCabsFragment liveCabsFragment;
    private ArrayList<String> titles = new ArrayList<>();
    CabAdapter cabAdapter;

    public static CabsFragment newInstance() {
        return new CabsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(CabsViewModel.class);
        // TODO: Use the ViewModel
        titles.add("Live Cabs");
        titles.add("Requests");
        tabLayout = getView().findViewById(R.id.tab_layout);
        viewPager = getView().findViewById(R.id.viewpager);
        cabAdapter = new CabAdapter(getChildFragmentManager(), getLifecycle());

        cabAdapter.addFragment(new LiveCabsFragment());
        cabAdapter.addFragment(new RequestFragment());
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(cabAdapter);
        new TabLayoutMediator(tabLayout, viewPager, this::onConfigureTab).attach();



    }


    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }

    public class CabAdapter extends FragmentStateAdapter {

        private final int NUM_TABS = 2;
        private ArrayList<Fragment> fragmentList = new ArrayList<>();

        public CabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        public void addFragment(Fragment fragment) {
            fragmentList.add(fragment);
        }


        @Override
        public int getItemCount() {
            return NUM_TABS;
        }
    }

}