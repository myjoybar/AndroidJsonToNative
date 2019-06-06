package me.joy.jsontonative.jsontonative.attrs.shape;

/**
 * Created by Joy on 2019/6/6
 */

public class GradientShapeAttr extends ShapeAttr {

  private String colors[]; //{ 0xff255779 , 0xff3e7492, 0xffa6c0cd };
  private String gradientType; // GradientDrawable.LINEAR_GRADIENT
  private String orientation; //GradientDrawable.Orientation.TOP_BOTTOM

  public String[] getColors() {
    return colors;
  }

  public void setColors(String[] colors) {
    this.colors = colors;
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
