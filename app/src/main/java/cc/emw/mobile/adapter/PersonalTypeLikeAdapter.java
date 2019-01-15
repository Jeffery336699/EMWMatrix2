package cc.emw.mobile.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class PersonalTypeLikeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public PersonalTypeLikeAdapter(int item_personal_like, @Nullable List<String> data) {
        super(item_personal_like,data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}

