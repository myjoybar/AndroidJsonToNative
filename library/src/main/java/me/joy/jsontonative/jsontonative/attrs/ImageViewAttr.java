package me.joy.jsontonative.jsontonative.attrs;

/**
 * Created by Joy on 2019/6/6
 */

public class ImageViewAttr extends BaseViewAttr {

  private String src;
  private String scaleType; //  ScaleType.FIT_CENTER // https://www.cnblogs.com/pandapan/p/4614837.html

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getScaleType() {
    return scaleType;
  }

  public void setScaleType(String scaleType) {
    this.scaleType = scaleType;
  }
}
