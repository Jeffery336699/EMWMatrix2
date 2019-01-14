package cc.emw.mobile.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cc.emw.mobile.R;
import cc.emw.mobile.adapter.InventoryAdapter;
import cc.emw.mobile.bean.CiclerItemBean;
import cc.emw.mobile.utils.ToastUtil;
import cc.emw.mobile.view.SlideRecyclerView;

/**
 * A simple {@link Fragment} subclass.　圈子协同fragment
 */
public class MessageFragmentNew extends Fragment {

    @BindView(R.id.tv_item_title)
    TextView tvItemTitle;
    @BindView(R.id.ry_item)
    SlideRecyclerView ryItem;
    private Unbinder unbinder;
    private Context mContext;
    private List<CiclerItemBean.ItemData> list=new ArrayList<>();
    private InventoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        initModulData();
        initView();
        return view;
    }

    private void initModulData() {
        for(int i=0;i<5;i++){
            CiclerItemBean.ItemData itemData = new CiclerItemBean.ItemData();
            itemData.setContent("这是内容了。。"+i);
            itemData.setTime("12.1"+i);
            itemData.setNum((i+2)+"");
            list.add(itemData);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
    }

    private void initView() {
        ryItem.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new InventoryAdapter(mContext, list, R.layout.ry_item_layout);
        adapter.setOnDeleteClickListener(new InventoryAdapter.OnDeleteClickLister() {

            @Override
            public void onTagClick(View view, int position, String tagType) {
                ToastUtil.showToast(mContext,position+"--"+tagType);
                list.remove(position);
                adapter.notifyDataSetChanged();
                ryItem.closeMenu();
            }
        });
        ryItem.setAdapter(adapter);
    }

    public static class MyOnclickListener implements View.OnClickListener{

        private CiclerItemBean.ItemData itemData;
        private SoftReference<Context> softReference;

        public MyOnclickListener(CiclerItemBean.ItemData itemData,Context context) {
            this.itemData = itemData;
            softReference=new SoftReference<>(context);
        }

        @Override
        public void onClick(View view) {
            if (softReference!=null&&softReference.get()!=null){
                Context context = softReference.get();
                ToastUtil.showToast(context,""+itemData.getContent());
            }
        }
    }

    public static MessageFragmentNew newInstance(Bundle bundle) {
        MessageFragmentNew fragment = new MessageFragmentNew();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
