package tech.eboot.xplanet.model.bean.msg;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @auther Planck
 * @date 2022/2/25
 * @time 11:28.
 */
public class ChatInfoModel implements MultiItemEntity {
    public int type = 0;//xiaoxileixing

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
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
