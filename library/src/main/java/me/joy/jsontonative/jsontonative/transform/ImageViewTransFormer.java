package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import me.joy.jsontonative.jsontonative.attrs.ImageViewAttr;
import me.joy.jsontonative.jsontonative.extensionplugin.IPlugin;
import me.joy.jsontonative.jsontonative.extensionplugin.PluginInjector;
import me.joy.jsontonative.util.Protocol;

/**
 * Created by Joy on 2019/6/6
 */

public class ImageViewTransFormer extends
    BaseViewTransFormer<ImageView, ImageViewAttr> {


  public ImageViewTransFormer(Context context, ImageView self, ViewGroup parent,
      ImageViewAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }


  @Override
  public void setCustomAttr() {
    setImgSrc();
    setScaleType();
  }

  public void setImgSrc() {
    IPlugin plugin = PluginInjector.getInstance().getPlugin();
    if (null != plugin && !TextUtils.isEmpty(viewAttr.getSrc())) {
      plugin.setImgSrc(self, viewAttr.getSrc());
    }
  }


  public void setScaleType() {
    String scaleType = viewAttr.getScaleType();
    if (!TextUtils.isEmpty(scaleType)) {
      self.setScaleType(Protocol.SCALE_TYPE.get(scaleType));
    }
  }

}
