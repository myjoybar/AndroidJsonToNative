package me.joy.jsontonative.jsontonative.attrs;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class LinearLayoutAttr extends BaseViewAttr {

  private String orientation; // vertical 1, horizontal 0
  private String gravity;//CENTER_VERTICAL

  public String getOrientation() {
    return orientation;
  }

  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  public String getGravity() {
    return gravity;
  }

  public void setGravity(String gravity) {
    this.gravity = gravity;
  }
}
