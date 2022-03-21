package tech.eboot.xplanet.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import java.util.List;
import tech.eboot.xplanet.model.bean.msg.MessageModel;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 10:56.
 */
public class MessageHomeAdapter extends BaseMultiItemQuickAdapter<MessageModel, BaseDataBindingHolder> {

    public MessageHomeAdapter(@Nullable List<MessageModel> data) {
        super(data);
    }

    @Override
    protected void convert(@NonNull BaseDataBindingHolder baseDataBindingHolder, MessageModel messageModel) {

    }

}
