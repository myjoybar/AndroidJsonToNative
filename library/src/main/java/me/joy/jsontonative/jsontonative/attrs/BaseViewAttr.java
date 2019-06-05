package me.joy.jsontonative.jsontonative.attrs;


import me.joy.jsontonative.jsontonative.attrs.click.ClickAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.GradientSelectorAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.GradientShapeAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.SolidSelectorAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.SolidShapeAttr;
import me.joy.jsontonative.util.Protocol;

/**
 * @author Joy
 * @description
 * @date 2019/5/27
 */
public class BaseViewAttr {


  private int id; // id >=1
  private String tag;
  private String visibility = "visible";

  private String layoutGravity;//CENTER_VERTICAL
  private int layoutWeight;


  //RelativeLayout 相关
  private boolean alignParentLeft;
  private boolean alignParentTop;
  private boolean alignParentRight;
  private boolean alignParentBottom;

  private boolean centerInParent;
  private boolean centerHorizontal;
  private boolean centerVertical;


  private int aboveID;
  private int belowID;
  private int toLeftOfID;
  private int toRightOfID;

  private int alignLeftID;
  private int alignTopID;
  private int alignRightID;
  private int alignBottomID;

  //size相关

  private String width = Protocol.WRAP; //unit dp,  if width = -2  means wrap_content,  if width = -1  means match_parent
  private String height = Protocol.WRAP; //unit dp  if width = -2  means wrap_content,  if width = -1  means match_parent

  private String minWidth;
  private String maxWidth;
  private String minHeight;
  private String maxHeight;

  private String paddingLeft = Protocol.ZERO;
  private String paddingRight = Protocol.ZERO;
  private String paddingTop = Protocol.ZERO;
  private String paddingBottom = Protocol.ZERO;


  private String marginLeft = Protocol.ZERO;
  private String marginRight = Protocol.ZERO;
  private String marginTop = Protocol.ZERO;
  private String marginBottom = Protocol.ZERO;

  //背景前景相关

  private int alpha; // 0~255
  private String background;
  private String foreground;
  private String backgroundColor;

  // gradientShape,solidShapeAttr,solidSelectorAttr,gradientSelectorAttr only could be selected one in four
  private SolidShapeAttr solidShapeAttr;
  private GradientShapeAttr gradientShapeAttr;
  private SolidSelectorAttr solidSelectorAttr;
  private GradientSelectorAttr gradientSelectorAttr;


  //点击相关
  private boolean clickable = true;
  private ClickAttr click;
  private ClickAttr longClick;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  public String getWidth() {
    return width;
  }

  public String getHeight() {
    return height;
  }

  public int getAlpha() {
    return alpha;
  }

  public void setAlpha(int alpha) {
    this.alpha = alpha;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public String getForeground() {
    return foreground;
  }

  public void setForeground(String foreground) {
    this.foreground = foreground;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public GradientShapeAttr getGradientShapeAttr() {
    return gradientShapeAttr;
  }

  public void setGradientShapeAttr(
      GradientShapeAttr gradientShapeAttr) {
    this.gradientShapeAttr = gradientShapeAttr;
  }

  public SolidShapeAttr getSolidShapeAttr() {
    return solidShapeAttr;
  }

  public void setSolidShapeAttr(SolidShapeAttr solidShapeAttr) {
    this.solidShapeAttr = solidShapeAttr;
  }

  public SolidSelectorAttr getSolidSelectorAttr() {
    return solidSelectorAttr;
  }

  public void setSolidSelectorAttr(
      SolidSelectorAttr solidSelectorAttr) {
    this.solidSelectorAttr = solidSelectorAttr;
  }

  public GradientSelectorAttr getGradientSelectorAttr() {
    return gradientSelectorAttr;
  }

  public void setGradientSelectorAttr(
      GradientSelectorAttr gradientSelectorAttr) {
    this.gradientSelectorAttr = gradientSelectorAttr;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getPaddingLeft() {
    return paddingLeft;
  }

  public void setPaddingLeft(String paddingLeft) {
    this.paddingLeft = paddingLeft;
  }

  public String getPaddingRight() {
    return paddingRight;
  }

  public void setPaddingRight(String paddingRight) {
    this.paddingRight = paddingRight;
  }

  public String getPaddingTop() {
    return paddingTop;
  }

  public void setPaddingTop(String paddingTop) {
    this.paddingTop = paddingTop;
  }

  public String getPaddingBottom() {
    return paddingBottom;
  }

  public void setPaddingBottom(String paddingBottom) {
    this.paddingBottom = paddingBottom;
  }

  public String getMarginLeft() {
    return marginLeft;
  }

  public void setMarginLeft(String marginLeft) {
    this.marginLeft = marginLeft;
  }

  public String getMarginRight() {
    return marginRight;
  }

  public void setMarginRight(String marginRight) {
    this.marginRight = marginRight;
  }

  public String getMarginTop() {
    return marginTop;
  }

  public void setMarginTop(String marginTop) {
    this.marginTop = marginTop;
  }

  public String getMarginBottom() {
    return marginBottom;
  }

  public void setMarginBottom(String marginBottom) {
    this.marginBottom = marginBottom;
  }

  public boolean isClickable() {
    return clickable;
  }

  public void setClickable(boolean clickable) {
    this.clickable = clickable;
  }

  public ClickAttr getClick() {
    return click;
  }

  public void setClick(ClickAttr click) {
    this.click = click;
  }

  public ClickAttr getLongClick() {
    return longClick;
  }

  public void setLongClick(ClickAttr longClick) {
    this.longClick = longClick;
  }

  public String getVisibility() {
    return visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public String getLayoutGravity() {
    return layoutGravity;
  }

  public void setLayoutGravity(String layoutGravity) {
    this.layoutGravity = layoutGravity;
  }

  public int getLayoutWeight() {
    return layoutWeight;
  }

  public void setLayoutWeight(int layoutWeight) {
    this.layoutWeight = layoutWeight;
  }

  public String getMinWidth() {
    return minWidth;
  }

  public void setMinWidth(String minWidth) {
    this.minWidth = minWidth;
  }

  public String getMaxWidth() {
    return maxWidth;
  }

  public void setMaxWidth(String maxWidth) {
    this.maxWidth = maxWidth;
  }

  public String getMinHeight() {
    return minHeight;
  }

  public void setMinHeight(String minHeight) {
    this.minHeight = minHeight;
  }

  public String getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(String maxHeight) {
    this.maxHeight = maxHeight;
  }


  public boolean isAlignParentLeft() {
    return alignParentLeft;
  }

  public void setAlignParentLeft(boolean alignParentLeft) {
    this.alignParentLeft = alignParentLeft;
  }

  public boolean isAlignParentTop() {
    return alignParentTop;
  }

  public void setAlignParentTop(boolean alignParentTop) {
    this.alignParentTop = alignParentTop;
  }

  public boolean isAlignParentRight() {
    return alignParentRight;
  }

  public void setAlignParentRight(boolean alignParentRight) {
    this.alignParentRight = alignParentRight;
  }

  public boolean isAlignParentBottom() {
    return alignParentBottom;
  }

  public void setAlignParentBottom(boolean alignParentBottom) {
    this.alignParentBottom = alignParentBottom;
  }

  public boolean isCenterInParent() {
    return centerInParent;
  }

  public void setCenterInParent(boolean centerInParent) {
    this.centerInParent = centerInParent;
  }

  public boolean isCenterHorizontal() {
    return centerHorizontal;
  }

  public void setCenterHorizontal(boolean centerHorizontal) {
    this.centerHorizontal = centerHorizontal;
  }

  public boolean isCenterVertical() {
    return centerVertical;
  }

  public void setCenterVertical(boolean centerVertical) {
    this.centerVertical = centerVertical;
  }

  public int getAboveID() {
    return aboveID;
  }

  public void setAboveID(int aboveID) {
    this.aboveID = aboveID;
  }

  public int getBelowID() {
    return belowID;
  }

  public void setBelowID(int belowID) {
    this.belowID = belowID;
  }

  public int getToLeftOfID() {
    return toLeftOfID;
  }

  public void setToLeftOfID(int toLeftOfID) {
    this.toLeftOfID = toLeftOfID;
  }

  public int getToRightOfID() {
    return toRightOfID;
  }

  public void setToRightOfID(int toRightOfID) {
    this.toRightOfID = toRightOfID;
  }

  public int getAlignLeftID() {
    return alignLeftID;
  }

  public void setAlignLeftID(int alignLeftID) {
    this.alignLeftID = alignLeftID;
  }

  public int getAlignTopID() {
    return alignTopID;
  }

  public void setAlignTopID(int alignTopID) {
    this.alignTopID = alignTopID;
  }

  public int getAlignRightID() {
    return alignRightID;
  }

  public void setAlignRightID(int alignRightID) {
    this.alignRightID = alignRightID;
  }

  public int getAlignBottomID() {
    return alignBottomID;
  }

  public void setAlignBottomID(int alignBottomID) {
    this.alignBottomID = alignBottomID;
  }
}
