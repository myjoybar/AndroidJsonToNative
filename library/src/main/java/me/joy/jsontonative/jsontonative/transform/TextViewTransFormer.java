package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import me.joy.jsontonative.jsontonative.attrs.TextViewAttr;
import me.joy.jsontonative.util.Protocol;
import me.joy.jsontonative.util.Utils;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class TextViewTransFormer<V extends TextView, T extends TextViewAttr> extends
    BaseViewTransFormer<V, T> {


  public TextViewTransFormer(Context context, V self, ViewGroup parent,
      T viewAttr) {
    super(context, self, parent, viewAttr);
  }

  @Override
  public void setBackground() {

  }



  /**
   * private String color; private int textSize; //sp private String text;
   */
  @Override
  public void setCustomAttr() {
    setColor();
    setText();
    setTextSize();
    setGravity();
  }


  private void setColor() {
    String color = viewAttr.getTextColor();
    if (!TextUtils.isEmpty(color)) {
      self.setTextColor(Color.parseColor(color));
    }
  }

  private void setText() {
    String text = viewAttr.getText();
    if (!TextUtils.isEmpty(text)) {
      self.setText(text);
    }
  }

  private void setTextSize() {
    String textSizeStr = viewAttr.getTextSize();
    if (!TextUtils.isEmpty(textSizeStr)) {
      int textSize = Utils.convertTextSizeUnit(context, viewAttr.getTextSize(), 14);
      self.setTextSize(textSize);
    }

  }

  /**
   * 待完善
   */
  protected void setGravity() {
    if (viewAttr != null) {
      String gravityStr = viewAttr.getGravity();
      if (!TextUtils.isEmpty(gravityStr)) {
        self.setGravity(Protocol.GRAVITY_TYPE.get(gravityStr.toLowerCase()));
      }
    }
  }
}
