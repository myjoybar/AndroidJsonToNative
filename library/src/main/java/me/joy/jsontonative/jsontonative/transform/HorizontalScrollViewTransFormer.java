package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import me.joy.jsontonative.jsontonative.attrs.HorizontalScrollViewAttr;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class HorizontalScrollViewTransFormer extends
    BaseViewTransFormer<HorizontalScrollView, HorizontalScrollViewAttr> {


  public HorizontalScrollViewTransFormer(Context context, HorizontalScrollView self, ViewGroup parent,
      HorizontalScrollViewAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }

  @Override
  public void setCustomAttr() {
    setShowScrollbar();
  }

  public void setShowScrollbar() {
    Log.d("BaseViewTransFormer", "viewAttr.isShowScrollbar() = "+viewAttr.isShowScrollbar());
    self.setHorizontalScrollBarEnabled(viewAttr.isShowScrollbar());
  }



}
