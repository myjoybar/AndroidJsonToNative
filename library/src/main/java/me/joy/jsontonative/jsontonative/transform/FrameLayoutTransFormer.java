package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import me.joy.jsontonative.jsontonative.attrs.FrameLayoutAttr;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class FrameLayoutTransFormer extends
    BaseViewTransFormer<FrameLayout, FrameLayoutAttr> {


  public FrameLayoutTransFormer(Context context, FrameLayout self, ViewGroup parent,
      FrameLayoutAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }

  @Override
  public void setCustomAttr() {

  }


}
