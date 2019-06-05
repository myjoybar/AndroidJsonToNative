package me.joy.jsontonative.jsontonative.attrs;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class TextViewAttr extends BaseViewAttr {

  private String textColor;
  private String textSize; //sp
  private String text;
  private String gravity;//CENTER_VERTICAL

  public String getTextColor() {
    return textColor;
  }

  public void setTextColor(String textColor) {
    this.textColor = textColor;
  }

  public String getTextSize() {
    return textSize;
  }

  public void setTextSize(String textSize) {
    this.textSize = textSize;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getGravity() {
    return gravity;
  }

  public void setGravity(String gravity) {
    this.gravity = gravity;
  }
}
