package com.ghkanban.ghkanban.mainboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ghkanban.ghkanban.R;
import com.ghkanban.ghkanban.data.ListRepository;
import com.ghkanban.ghkanban.data.RepositoryObject;

import java.util.List;

public class MainBoardActivity extends AppCompatActivity implements MainBoardContract.View{

    private static final int NUM_PAGES = 2;
    private static final String TAG_PREFIX = "MBF";

    private ViewPager mPager;

    // inject
    MainBoardContract.Presenter mPresenter;

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_board);

        mPresenter = new MainBoardPresenter();

        // Set up the toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                // action when change page
                pageChanged(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.dropView();
    }



    private void pageChanged(int position) {

        if (position == 0) {
            mPresenter.changeToRemoteRepositories();
        } else {
            mPresenter.changeToLocalRepositories();
        }
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {

            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void showLoadingIndicator(boolean active) {

    }

    @Override
    public void showLocalRepositories(List<RepositoryObject> repositoryObjectList) {

    }

    @Override
    public void showRemoteRepositories(ListRepository repositoryObjectList) {
    }

    @Override
    public void showNoRepositories() {

    }

    @Override
    public void showSuccessfulAdded() {

    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MainBoardFragment mainBoardFragment = new MainBoardFragment();
            return mainBoardFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if (position == 0)
                return getResources().getString(R.string.main_board_text_explore);
            else
                return getResources().getString(R.string.main_board_text_local);
        }
    }
}