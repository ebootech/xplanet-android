package tech.eboot.xplanet.model.bean.msg;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 11:28.
 */
public class MessageModel implements MultiItemEntity {

    @Override
    public int getItemType() {
        return 0;
    }

    String nikeName;
    String avatarImg;

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
