package me.joy.jsontonative.core;

import java.util.ArrayList;
import java.util.List;
import me.joy.jsontonative.jsontonative.attrs.BaseViewAttr;
import me.joy.jsontonative.jsontonative.attrs.ButtonViewAttr;
import me.joy.jsontonative.jsontonative.attrs.FrameLayoutAttr;
import me.joy.jsontonative.jsontonative.attrs.HorizontalScrollViewAttr;
import me.joy.jsontonative.jsontonative.attrs.ImageViewAttr;
import me.joy.jsontonative.jsontonative.attrs.LinearLayoutAttr;
import me.joy.jsontonative.jsontonative.attrs.RelativeLayoutAttr;
import me.joy.jsontonative.jsontonative.attrs.ScrollViewAttr;
import me.joy.jsontonative.jsontonative.attrs.TextViewAttr;
import me.joy.jsontonative.jsontonative.data.ViewNode;
import me.joy.jsontonative.util.GsonUtil;
import me.joy.jsontonative.util.Protocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Joy on 2019/6/6
 */
public class ViewNodeHelper {

  private static final String TAG_NAME = "name";
  private static final String TAG_ATTR = "attr";
  private static final String TAG_CHILDREN = "children";

  public static ViewNode parse(String json) {
    ViewNode viewNode = new ViewNode();
    try {
      JSONObject jsonObject = new JSONObject(json);

      if (jsonObject.has(TAG_NAME)) {
        String name = jsonObject.optString(TAG_NAME);
        viewNode.setName(name);
        if (jsonObject.has(TAG_ATTR)) {

          switch (name) {
            case Protocol.VIEW_TYPE_VIEW:
              BaseViewAttr baseViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), BaseViewAttr.class);
              viewNode.setAttr(baseViewAttr);
              break;
            case Protocol.VIEW_TYPE_VIEWGROUP:
              BaseViewAttr baseViewGroupAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), BaseViewAttr.class);
              viewNode.setAttr(baseViewGroupAttr);
              break;
            case Protocol.VIEW_TYPE_FRAMELAYOUT:
              FrameLayoutAttr frameLayoutAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), FrameLayoutAttr.class);
              viewNode.setAttr(frameLayoutAttr);
              break;
            case Protocol.VIEW_TYPE_LINEARLAYOUT:

              LinearLayoutAttr linearLayoutAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), LinearLayoutAttr.class);
              viewNode.setAttr(linearLayoutAttr);
              break;

            case Protocol.VIEW_TYPE_RELATIVELAYOUT:

              RelativeLayoutAttr relativeLayoutAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), RelativeLayoutAttr.class);
              viewNode.setAttr(relativeLayoutAttr);
              break;

            case Protocol.VIEW_TYPE_SCROLLVIEW:
              ScrollViewAttr scrollViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), ScrollViewAttr.class);
              viewNode.setAttr(scrollViewAttr);
              break;
            case Protocol.VIEW_TYPE_HORIZONTALSCROLLVIEW:
              HorizontalScrollViewAttr horizontalScrollViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), HorizontalScrollViewAttr.class);
              viewNode.setAttr(horizontalScrollViewAttr);
              break;
            case Protocol.VIEW_TYPE_TEXT_VIEW:
              TextViewAttr textViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), TextViewAttr.class);
              viewNode.setAttr(textViewAttr);
              break;
            case Protocol.VIEW_TYPE_BUTTON:
              ButtonViewAttr buttonViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), ButtonViewAttr.class);
              viewNode.setAttr(buttonViewAttr);
              break;

            case Protocol.VIEW_TYPE_IMAGEVIEW:
              ImageViewAttr imageViewAttr = GsonUtil
                  .parseJsonStrToBean(jsonObject.optString(TAG_ATTR), ImageViewAttr.class);
              viewNode.setAttr(imageViewAttr);
              break;
            default:
              break;
          }
        }
      }

      if (jsonObject.has(TAG_CHILDREN)) {
        List<ViewNode> list = new ArrayList<>();
        String children = jsonObject.optString(TAG_CHILDREN);
        JSONArray jsonArray = new JSONArray(children);
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
          String itemStr = jsonArray.getString(i);
          ViewNode viewNodeChild = parse(itemStr);
          list.add(viewNodeChild);
        }
        viewNode.setChildren(list);

      }

    } catch (JSONException e) {
      e.printStackTrace();
    }
    return viewNode;

  }


}
