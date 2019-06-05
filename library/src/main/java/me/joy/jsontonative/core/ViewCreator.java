package me.joy.jsontonative.core;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
import me.joy.jsontonative.jsontonative.transform.BaseViewTransFormer;
import me.joy.jsontonative.jsontonative.transform.ButtonViewTransFormer;
import me.joy.jsontonative.jsontonative.transform.FrameLayoutTransFormer;
import me.joy.jsontonative.jsontonative.transform.HorizontalScrollViewTransFormer;
import me.joy.jsontonative.jsontonative.transform.ImageViewTransFormer;
import me.joy.jsontonative.jsontonative.transform.LinearLayoutTransFormer;
import me.joy.jsontonative.jsontonative.transform.RelativeLayoutTransFormer;
import me.joy.jsontonative.jsontonative.transform.ScrollViewTransFormer;
import me.joy.jsontonative.jsontonative.transform.TextViewTransFormer;
import me.joy.jsontonative.util.Protocol;


/**
 * @author Joy
 * @description
 * @date 2019/6/4
 */
public class ViewCreator {

  private static String TAG = "ViewParseHelper";

  public static void recursiveViewNode(Context context, View parent, ViewNode viewNode) {
    if (null != viewNode) {
      Log.d(TAG, "viewNode name = " + viewNode.getName());
      Log.d(TAG, "viewNode getAttr = " + viewNode.getAttr());
      View view = createView(context, parent, viewNode);
      List<ViewNode> children = viewNode.getChildren();
      int size;
      if (children != null && ((size = children.size())) != 0) {
        for (int i = 0; i < size; i++) {
          recursiveViewNode(context, view, children.get(i));
        }
      }
    }

  }


  public static View createView(Context context, View parent, ViewNode viewNode) {
//    if (null == parent) {
//      throw new IllegalArgumentException("this ViewNode parent can not be null");
//    }
    String name = viewNode.getName();
    View view;
    switch (name) {

      case Protocol.VIEW_TYPE_VIEW:
        view = new View(context);
        ((ViewGroup) parent).addView(view);
        BaseViewAttr baseViewAttr =  viewNode.getAttr();
        BaseViewTransFormer baseViewTransFormer = new BaseViewTransFormer(context,
             view, (ViewGroup) parent,
            baseViewAttr);
        baseViewTransFormer.transForm();

        break;

      case Protocol.VIEW_TYPE_VIEWGROUP:
        view = new View(context);
        ((ViewGroup) parent).addView(view);
        BaseViewAttr baseViewGroupAttr =  viewNode.getAttr();
        BaseViewTransFormer baseViewGroupTransFormer = new BaseViewTransFormer(context,
            view, (ViewGroup) parent,
            baseViewGroupAttr);
        baseViewGroupTransFormer.transForm();

        break;

      case Protocol.VIEW_TYPE_FRAMELAYOUT:
        view = new FrameLayout(context);
        ((ViewGroup) parent).addView(view);
        FrameLayoutAttr frameLayoutAttr = (FrameLayoutAttr) viewNode.getAttr();
        FrameLayoutTransFormer frameLayoutTransFormer = new FrameLayoutTransFormer(context,
            (FrameLayout) view, (ViewGroup) parent,
            frameLayoutAttr);
        frameLayoutTransFormer.transForm();

        break;

      case Protocol.VIEW_TYPE_LINEARLAYOUT:
        view = new LinearLayout(context);
        ((ViewGroup) parent).addView(view);
        LinearLayoutAttr attr = (LinearLayoutAttr) viewNode.getAttr();
        LinearLayoutTransFormer transFormer = new LinearLayoutTransFormer(context,
            (LinearLayout) view, (ViewGroup) parent,
            attr);
        transFormer.transForm();
        break;

      case Protocol.VIEW_TYPE_RELATIVELAYOUT:
        view = new RelativeLayout(context);
        ((ViewGroup) parent).addView(view);
        RelativeLayoutAttr relativeLayoutAttr = (RelativeLayoutAttr) viewNode.getAttr();
        RelativeLayoutTransFormer relativeLayoutTransFormer = new RelativeLayoutTransFormer(context,
            (RelativeLayout) view, (ViewGroup) parent,
            relativeLayoutAttr);
        relativeLayoutTransFormer.transForm();
        break;

      case Protocol.VIEW_TYPE_SCROLLVIEW:
        view = new ScrollView(context);
        ((ViewGroup) parent).addView(view);
        ScrollViewAttr scrollViewAttr = (ScrollViewAttr) viewNode.getAttr();
        ScrollViewTransFormer scrollViewTransFormer = new ScrollViewTransFormer(context,
            (ScrollView) view, (ViewGroup) parent,
            scrollViewAttr);
        scrollViewTransFormer.transForm();
        break;

      case Protocol.VIEW_TYPE_HORIZONTALSCROLLVIEW:
        view = new HorizontalScrollView(context);
        ((ViewGroup) parent).addView(view);
        HorizontalScrollViewAttr horizontalScrollViewAttr = (HorizontalScrollViewAttr) viewNode
            .getAttr();
        HorizontalScrollViewTransFormer horizontalScrollViewTransFormer = new HorizontalScrollViewTransFormer(
            context,
            (HorizontalScrollView) view, (ViewGroup) parent,
            horizontalScrollViewAttr);
        horizontalScrollViewTransFormer.transForm();
        break;

      case Protocol.VIEW_TYPE_TEXT_VIEW:
        view = new TextView(context);
        ((ViewGroup) parent).addView(view);
        TextViewAttr textViewAttr = (TextViewAttr) viewNode.getAttr();
        TextViewTransFormer textViewTransFormer = new TextViewTransFormer(context, (TextView) view,
            (ViewGroup) parent,
            textViewAttr);
        textViewTransFormer.transForm();
        break;
      case Protocol.VIEW_TYPE_BUTTON:
        view = new Button(context);
        ((ViewGroup) parent).addView(view);
        ButtonViewAttr buttonViewAttr = (ButtonViewAttr) viewNode.getAttr();
        ButtonViewTransFormer buttonViewTransFormer = new ButtonViewTransFormer(context,
            (Button) view, (ViewGroup) parent,
            buttonViewAttr);
        buttonViewTransFormer.transForm();
        break;

      case Protocol.VIEW_TYPE_IMAGEVIEW:
        view = new ImageView(context);
        ((ViewGroup) parent).addView(view);
        ImageViewAttr imageViewAttr = (ImageViewAttr) viewNode.getAttr();
        ImageViewTransFormer imageViewTransFormer = new ImageViewTransFormer(context,
            (ImageView) view, (ViewGroup) parent,
            imageViewAttr);
        imageViewTransFormer.transForm();
        break;

      default:
        throw new IllegalArgumentException(
            String.format("this ViewNode name %s could not be support", name));
    }

    return view;
  }


}
