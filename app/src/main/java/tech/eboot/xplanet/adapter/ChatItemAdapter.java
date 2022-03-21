package tech.eboot.xplanet.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;

import java.util.List;

import tech.eboot.xplanet.model.bean.msg.ChatInfoModel;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 10:56.
 */
public class ChatItemAdapter extends BaseMultiItemQuickAdapter<ChatInfoModel, BaseDataBindingHolder> {

    public ChatItemAdapter(@Nullable List<ChatInfoModel> data) {
        super(data);
    }

    @Override
    protected void convert(@NonNull BaseDataBindingHolder baseDataBindingHolder, ChatInfoModel messageModel) {

    }

}
