package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import me.joy.jsontonative.jsontonative.attrs.ButtonViewAttr;

/**
 * Created by Joy on 2019/6/6
 */

public class ButtonViewTransFormer<V extends Button, T extends ButtonViewAttr> extends
    TextViewTransFormer<V, T> {


  public ButtonViewTransFormer(Context context, V self, ViewGroup parent, T viewAttr) {
    super(context, self, parent, viewAttr);
  }


  @Override
  public void setCustomAttr() {
    super.setCustomAttr();
    setAllCaps();



  }

  private void setAllCaps() {
    self.setAllCaps(false);//禁止转为大写
  }



}
