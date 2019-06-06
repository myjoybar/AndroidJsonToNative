package me.joy.jsontonative.util;

import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView.ScaleType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy on 2019/6/6
 */

public class Protocol {



  public static final String WRAP = "wrap";
  public static final String MATCH = "match";
  public static final String ZERO = "0";

  public static final String VIEW_TYPE_VIEW = "android.view.View";
  public static final String VIEW_TYPE_VIEWGROUP = "android.view.ViewGroup";
  public static final String VIEW_TYPE_LINEARLAYOUT = "android.widget.LinearLayout";
  public static final String VIEW_TYPE_RELATIVELAYOUT = "android.widget.RelativeLayout";
  public static final String VIEW_TYPE_FRAMELAYOUT = "android.widget.FrameLayout";
  public static final String VIEW_TYPE_SCROLLVIEW = "android.widget.ScrollView";
  public static final String VIEW_TYPE_HORIZONTALSCROLLVIEW = "android.widget.HorizontalScrollView";

  public static final String VIEW_TYPE_TEXT_VIEW = "android.widget.TextView";
  public static final String VIEW_TYPE_BUTTON = "android.widget.Button";
  public static final String VIEW_TYPE_IMAGEVIEW = "android.widget.ImageView";




  public static final Map<String, Integer> LINEARLAYOUT_ORIENTATION = new HashMap<>();
  public static final Map<String, Integer> VISIBILITY_TYPE = new HashMap<>();
  public static final Map<String, Integer> GRAVITY_TYPE = new HashMap<>();
  public static final Map<String, Integer> SHAPE_TYPE = new HashMap<>();
  public static final Map<String, Integer> GRADIENT_TYPE = new HashMap<>();
  public static final Map<String, GradientDrawable.Orientation> GRADIENT_ORIENTATION = new HashMap<>();

  public static final Map<String, ScaleType> SCALE_TYPE = new HashMap<>();



  static {
    LINEARLAYOUT_ORIENTATION.put("vertical", 1);
    LINEARLAYOUT_ORIENTATION.put("horizontal",0);
  }



  static {
    VISIBILITY_TYPE.put("visible", View.VISIBLE);
    VISIBILITY_TYPE.put("gone", View.GONE);
    VISIBILITY_TYPE.put("invisible", View.INVISIBLE);
  }


  static {
    GRAVITY_TYPE.put("center", Gravity.CENTER);
    GRAVITY_TYPE.put("center_horizontal", Gravity.CENTER_HORIZONTAL);
    GRAVITY_TYPE.put("center_vertical", Gravity.CENTER_HORIZONTAL);
    GRAVITY_TYPE.put("left", Gravity.LEFT);
    GRAVITY_TYPE.put("right", Gravity.RIGHT);
    GRAVITY_TYPE.put("top", Gravity.TOP);
    GRAVITY_TYPE.put("bottom", Gravity.BOTTOM);
    GRAVITY_TYPE.put("top_left", Gravity.TOP|Gravity.LEFT);
    GRAVITY_TYPE.put("top_right", Gravity.TOP|Gravity.RIGHT);
    GRAVITY_TYPE.put("bottom_right", Gravity.BOTTOM|Gravity.RIGHT);
    GRAVITY_TYPE.put("bottom_left", Gravity.BOTTOM|Gravity.LEFT);

  }


  static {
    SHAPE_TYPE.put("rectangle", GradientDrawable.RECTANGLE);
    SHAPE_TYPE.put("oval", GradientDrawable.OVAL);
    SHAPE_TYPE.put("line", GradientDrawable.LINE);
    SHAPE_TYPE.put("ring", GradientDrawable.RING);
  }


  static {
    GRADIENT_TYPE.put("linear", GradientDrawable.LINEAR_GRADIENT); // Gradient is linear (default.)
    GRADIENT_TYPE.put("radial", GradientDrawable.RADIAL_GRADIENT); //Gradient is circular.
    GRADIENT_TYPE.put("sweep", GradientDrawable.SWEEP_GRADIENT); //radient is a sweep.
  }

  static {
    GRADIENT_ORIENTATION.put("top_bottom", GradientDrawable.Orientation.TOP_BOTTOM);
    GRADIENT_ORIENTATION.put("tr_bl", GradientDrawable.Orientation.TR_BL);
    GRADIENT_ORIENTATION.put("right_left", GradientDrawable.Orientation.RIGHT_LEFT);
    GRADIENT_ORIENTATION.put("br_tl", GradientDrawable.Orientation.BR_TL);
    GRADIENT_ORIENTATION.put("bottom_top", GradientDrawable.Orientation.BOTTOM_TOP);
    GRADIENT_ORIENTATION.put("bl_tr", GradientDrawable.Orientation.BL_TR);
    GRADIENT_ORIENTATION.put("left_right", GradientDrawable.Orientation.LEFT_RIGHT);
    GRADIENT_ORIENTATION.put("tl_br", GradientDrawable.Orientation.TL_BR);
  }


  static {
    SCALE_TYPE.put("matrix",ScaleType.MATRIX);
    SCALE_TYPE.put("center", ScaleType.CENTER);
    SCALE_TYPE.put("centerCrop", ScaleType.CENTER_CROP);
    SCALE_TYPE.put("centerInside", ScaleType.CENTER_INSIDE);
    SCALE_TYPE.put("fitCenter", ScaleType.FIT_CENTER);
    SCALE_TYPE.put("fitEnd", ScaleType.FIT_END);
    SCALE_TYPE.put("fitStart", ScaleType.FIT_START);
    SCALE_TYPE.put("fitXY", ScaleType.FIT_XY);
  }


}
