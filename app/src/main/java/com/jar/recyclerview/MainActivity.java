package com.jar.recyclerview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jar.recyclerview.adapter.PageAdapter;
import com.jar.recyclerview.fragment.MainRecyclerViewFragment;
import com.jar.recyclerview.fragment.PerfilFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRefs();
        initPageAdapter();

    }

    private void initRefs() {
        toolBar = (Toolbar) findViewById(R.id.actionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(toolBar != null)
            setSupportActionBar(toolBar);

    }

    private void initPageAdapter() {
        viewPager.setAdapter(new PageAdapter(
                getSupportFragmentManager(),
                getPageFragments()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_sentiment_very_satisfied);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_people);
    }

    private List<Fragment> getPageFragments() {
        return Arrays.asList(
                new MainRecyclerViewFragment(),
                new PerfilFragment()
        );
    }

}
