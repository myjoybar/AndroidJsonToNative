package me.joy.jsontonative.jsontonative.attrs.shape;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class ShapeAttr {

  private String shape; //RECTANGLE = 0; OVAL = 1; LINE = 2; RING = 3;

  private String strokeColor;
  private String strokeWidth;
 // private CornersAttr cornersAttr;
  private String[] radius; // colors[] = {left_top ,right_top, right_bottom ,left_bottom};

  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }

  public String getStrokeColor() {
    return strokeColor;
  }

  public void setStrokeColor(String strokeColor) {
    this.strokeColor = strokeColor;
  }

  public String getStrokeWidth() {
    return strokeWidth;
  }

  public void setStrokeWidth(String strokeWidth) {
    this.strokeWidth = strokeWidth;
  }

//  public CornersAttr getCornersAttr() {
//    return cornersAttr;
//  }
//
//  public void setCornersAttr(CornersAttr cornersAttr) {
//    this.cornersAttr = cornersAttr;
//  }

  public String[] getRadius() {
    return radius;
  }

  public void setRadius(String[] radius) {
    this.radius = radius;
  }
}
