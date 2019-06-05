package me.joy.jsontonative.jsontonative.attrs.shape;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class GradientSelectorAttr extends ShapeAttr {

  private String colorsNormal[]; //{ 0xff255779 , 0xff3e7492, 0xffa6c0cd };
  private String colorsPressed[]; //{ 0xff255779 , 0xff3e7492, 0xffa6c0cd };
  private String gradientType; // GradientDrawable.LINEAR_GRADIENT
  private String orientation; //GradientDrawable.Orientation.TOP_BOTTOM

  public String[] getColorsNormal() {
    return colorsNormal;
  }

  public void setColorsNormal(String[] colorsNormal) {
    this.colorsNormal = colorsNormal;
  }

  public String[] getColorsPressed() {
    return colorsPressed;
  }

  public void setColorsPressed(String[] colorsPressed) {
    this.colorsPressed = colorsPressed;
  }

  public String getGradientType() {
    return gradientType;
  }

  public void setGradientType(String gradientType) {
    this.gradientType = gradientType;
  }

  public String getOrientation() {
    return orientation;
  }

  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }
}
