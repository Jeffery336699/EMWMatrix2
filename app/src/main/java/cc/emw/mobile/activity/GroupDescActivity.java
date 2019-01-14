package cc.emw.mobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cc.emw.mobile.R;

public class GroupDescActivity extends AppCompatActivity {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_desc);
        ButterKnife.bind(this);

        initview();
    }

    private void initview() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.delete_selector);
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
            case R.id.search_btn:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
