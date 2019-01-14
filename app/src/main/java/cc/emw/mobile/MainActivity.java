package cc.emw.mobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.emw.mobile.fragment.CiclerTalkFragment;
import cc.emw.mobile.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.chat)
    TextView chat;
    @BindView(R.id.draw)
    DrawerLayout draw;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.home)
    TextView home;
    private HomeFragment mHomeFragment;
    private CiclerTalkFragment mCiclerTalkFragment;

    private HomeFragment homeFragment;
    private CiclerTalkFragment ciclerTalkFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.commit();
    }

    @OnClick({R.id.chat,R.id.home})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.chat:
                if(mCiclerTalkFragment==null){
                    mCiclerTalkFragment = new CiclerTalkFragment();
                }
                replaceFragment(mCiclerTalkFragment);
                break;
            case R.id.home:

                if(mHomeFragment==null){
                    mHomeFragment = new HomeFragment();
                }
                replaceFragment(mHomeFragment);
                break;
        }

    }

    private void replaceFragment(Fragment ciclerTalkFragment) {
        if (draw.isDrawerOpen(GravityCompat.START)) {
            draw.closeDrawer(GravityCompat.START);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment_container, ciclerTalkFragment);
            transaction.commit();
        }
    }
}
