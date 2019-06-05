package me.joy.jsontonative.jsontonative.data;

import java.util.Arrays;
import java.util.List;
import me.joy.jsontonative.jsontonative.attrs.BaseViewAttr;

/**
 * @author Joy
 * @description
 * @date 2019/5/24
 */
public class ViewNode {

  private String name;
  private List<ViewNode> children;
  private BaseViewAttr attr;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public List<ViewNode> getChildren() {
    return children;
  }

  public void setChildren(List<ViewNode> children) {
    this.children = children;
  }


  public BaseViewAttr getAttr() {
    return attr;
  }

  public void setAttr(BaseViewAttr attr) {
    this.attr = attr;
  }

  @Override
  public String toString() {
    String viewNodeStr = "";
    if(children!=null){
      viewNodeStr = Arrays.toString(children.toArray());
    }
    return "ViewNode{" +
        "name='" + name + '\'' +
        ", children=" + children +
        '}';
  }
}
