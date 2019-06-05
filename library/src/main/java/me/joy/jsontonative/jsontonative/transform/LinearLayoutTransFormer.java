package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import me.joy.jsontonative.jsontonative.attrs.LinearLayoutAttr;
import me.joy.jsontonative.util.Protocol;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class LinearLayoutTransFormer extends
    BaseViewTransFormer<LinearLayout, LinearLayoutAttr> {


  public LinearLayoutTransFormer(Context context, LinearLayout self, ViewGroup parent,
      LinearLayoutAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }


  @Override
  public void setCustomAttr() {
    setOrientation();
    setGravity();
    defaultConfig();
  }

  private void setOrientation() {
    String orientation = viewAttr.getOrientation();
    if (!TextUtils.isEmpty(orientation)) {
      self.setOrientation(Protocol.LINEARLAYOUT_ORIENTATION.get(orientation.toLowerCase()));
    }
  }


  protected void setGravity() {
    String gravityStr = viewAttr.getGravity();
    if (!TextUtils.isEmpty(gravityStr)) {
      self.setGravity(Protocol.GRAVITY_TYPE.get(gravityStr.toLowerCase()));
    }
  }

  private void defaultConfig() {
    self.setBaselineAligned(false);
  }
}
