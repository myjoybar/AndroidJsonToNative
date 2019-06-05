package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import me.joy.jsontonative.jsontonative.attrs.RelativeLayoutAttr;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class RelativeLayoutTransFormer extends
    BaseViewTransFormer<RelativeLayout, RelativeLayoutAttr> {



  public RelativeLayoutTransFormer(Context context, RelativeLayout self, ViewGroup parent,
      RelativeLayoutAttr viewAttr) {
    super(context, self, parent, viewAttr);
  }


  @Override
  public void setCustomAttr() {

  }





}
