package me.joy.jsontonative.jsontonative.attrs.shape;

/**
 * Created by Joy on 2019/6/6
 */

public class SolidSelectorAttr extends ShapeAttr {
  private String colorNormal;
  private String colorPressed;

  public String getColorNormal() {
    return colorNormal;
  }

  public void setColorNormal(String colorNormal) {
    this.colorNormal = colorNormal;
  }

  public String getColorPressed() {
    return colorPressed;
  }

  public void setColorPressed(String colorPressed) {
    this.colorPressed = colorPressed;
  }
}
