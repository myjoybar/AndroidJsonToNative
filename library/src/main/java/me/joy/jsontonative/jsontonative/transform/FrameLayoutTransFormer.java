package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import me.joy.jsontonative.jsontonative.attrs.FrameLayoutAttr;

/**
 * Created by Joy on 2019/6/6
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
