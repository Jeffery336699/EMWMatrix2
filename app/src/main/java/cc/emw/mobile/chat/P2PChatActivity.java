package cc.emw.mobile.chat;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cc.emw.mobile.R;
import cc.emw.mobile.activity.BaseActivity;
import cc.emw.mobile.chat.fragment.MessageFragment;
import cc.emw.mobile.fragment.HomeFragment;

public class P2PChatActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_pchat);
        setTitle("聊天");
        initFragment();
    }
    private void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_chat,new MessageFragment());
        transaction.commit();
    }
}
