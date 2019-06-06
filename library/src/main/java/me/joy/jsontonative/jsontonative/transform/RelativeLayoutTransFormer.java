package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import me.joy.jsontonative.jsontonative.attrs.RelativeLayoutAttr;

/**
 * Created by Joy on 2019/6/6
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
