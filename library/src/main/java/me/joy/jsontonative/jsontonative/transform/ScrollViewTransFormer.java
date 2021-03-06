package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ScrollView;
import me.joy.jsontonative.jsontonative.attrs.ScrollViewAttr;

/**
 * Created by Joy on 2019/6/6
 */

public class ScrollViewTransFormer extends
    BaseViewTransFormer<ScrollView, ScrollViewAttr> {


  public ScrollViewTransFormer(Context context, ScrollView self, ViewGroup parent,
      ScrollViewAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }

  @Override
  public void setCustomAttr() {
    setShowScrollbar();
  }

  public void setShowScrollbar() {
    self.setVerticalScrollBarEnabled(viewAttr.isShowScrollbar());
  }



}
