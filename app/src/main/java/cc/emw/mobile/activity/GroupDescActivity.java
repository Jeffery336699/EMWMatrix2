package cc.emw.mobile.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hmy.popwindow.PopItemAction;
import com.hmy.popwindow.PopWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.emw.mobile.R;
import cc.emw.mobile.view.MyNestedScrollView;

public class GroupDescActivity extends BaseActivity {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.rl_channel_management)
    RelativeLayout rlChannelManagement;
    @BindView(R.id.parent)
    MyNestedScrollView parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_desc);
        ButterKnife.bind(this);

        initview();
    }


    private void initview() {
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.drawable.delete_selector);
    }

    @NonNull
    @OnClick({R.id.rl_channel_management})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_channel_management://频道管理
                showPopBottom();
                break;
        }
    }

    private void showPopBottom() {
        PopWindow popWindow = new PopWindow.Builder(this)
                .setStyle(PopWindow.PopWindowStyle.PopUp)
                .addItemAction(new PopItemAction("转为私有频道"))
                .addItemAction(new PopItemAction("封存频道", PopItemAction.PopItemStyle.Normal))
                .addItemAction(new PopItemAction("离开频道", PopItemAction.PopItemStyle.Normal, new PopItemAction.OnClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(getApplicationContext(), "选项3", Toast.LENGTH_SHORT).show();
                    }
                }))
                .addItemAction(new PopItemAction("删除频道", PopItemAction.PopItemStyle.Warning))
                .addItemAction(new PopItemAction("取消", PopItemAction.PopItemStyle.Cancel))
                .create();
        popWindow.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:

                break;
            case R.id.create_normal_team:

                break;
            case R.id.create_regular_team:

                break;
            case R.id.search_advanced_team:

                break;
            case R.id.add_buddy:

                break;
            case R.id.shoucang:
                View inflate = View.inflate(getApplicationContext(), R.layout.channel_management, null);
                PopWindow popWindow = new PopWindow.Builder(this)
                        .setStyle(PopWindow.PopWindowStyle.PopDown).setView(inflate).create();
                popWindow.show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
