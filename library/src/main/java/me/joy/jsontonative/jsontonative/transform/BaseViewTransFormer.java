package me.joy.jsontonative.jsontonative.transform;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import me.joy.jsontonative.jsontonative.attrs.BaseViewAttr;
import me.joy.jsontonative.jsontonative.attrs.click.ClickAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.GradientSelectorAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.GradientShapeAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.SolidSelectorAttr;
import me.joy.jsontonative.jsontonative.attrs.shape.SolidShapeAttr;
import me.joy.jsontonative.jsontonative.extensionplugin.IPlugin;
import me.joy.jsontonative.jsontonative.extensionplugin.PluginInjector;
import me.joy.jsontonative.util.DrawableCreator;
import me.joy.jsontonative.util.DrawableCreator.SelectorBuilder;
import me.joy.jsontonative.util.DrawableCreator.ShapeBuilder;
import me.joy.jsontonative.util.Protocol;
import me.joy.jsontonative.util.Utils;
import me.joy.jsontonative.util.ViewIDUtils;


/**
 * Created by Joy on 2019/6/6
 */

public  class BaseViewTransFormer<V extends View, T extends BaseViewAttr> {

  private static String TAG = "BaseViewTransFormer";
  private static final int ID_LIMIT = 0;


  protected final Context context;
  protected final V self;
  protected final ViewGroup parent;
  protected final T viewAttr;


  public BaseViewTransFormer(Context context, V self, ViewGroup parent, T viewAttr) {
    this.context = context;
    this.self = self;
    this.parent = parent;
    this.viewAttr = viewAttr;
  }

  public void transForm() {
    if (null == viewAttr) {
      throw new IllegalArgumentException(
          String.format("the %s viewAttr can not be naull", self.getClass().getSimpleName()));
    }
    setId();
    setTag();
    setVisibility();
    setLayoutGravity();
    setLayoutWeight();
    setWidth();
    setHeight();
    setMinHeight();
    setMinWidth();
    setMaxHeight();
    setMaxWidth();
    setPadding();
    setMargin();

    setBackground();
    setForeground();
    setAlpha();
    setBackgroundColor();
    setGradientShapeAttr();
    setSolidShapeAttr();
    setGradientSelectorAttr();
    setSolidSelectorAttr();
    setClick();
    setLongClick();
    setClickable();

    setRelativeLayoutChildView();
    setCustomAttr();

  }


  protected void setId() {
    int id;
    if (((id = viewAttr.getId())) > ID_LIMIT) {
      // self.setId(id);
      ViewIDUtils.setViewId(self, id);
    }
  }

  protected void setTag() {
    String tag = "";
    if (!TextUtils.isEmpty((tag = viewAttr.getTag()))) {
      self.setTag(tag);
    }
  }

  protected void setVisibility() {
    if (viewAttr != null) {
      String visibilityStr = viewAttr.getVisibility();
      if (!TextUtils.isEmpty(visibilityStr)) {
        int visibility = Protocol.VISIBILITY_TYPE.get(visibilityStr);
        self.setVisibility(visibility);
      }
    }
  }

  protected void setLayoutGravity() {
    View parent = (View) self.getParent();
    if (parent instanceof LinearLayout) {
      LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) self.getLayoutParams();
      String gravityStr = viewAttr.getLayoutGravity();
      if (!TextUtils.isEmpty(gravityStr)) {
        lp.gravity = Protocol.GRAVITY_TYPE.get(gravityStr.toLowerCase());
        self.setLayoutParams(lp);
      }
    } else if (parent instanceof FrameLayout) {
      FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) self.getLayoutParams();
      String gravityStr = viewAttr.getLayoutGravity();
      if (!TextUtils.isEmpty(gravityStr)) {
        lp.gravity = Protocol.GRAVITY_TYPE.get(gravityStr.toLowerCase());
        self.setLayoutParams(lp);
      }
    }

  }


  protected void setLayoutWeight() {
    int layoutWeight;
    if (((layoutWeight = viewAttr.getLayoutWeight())) > 0) {
      View parent = (View) self.getParent();
      if (parent instanceof LinearLayout) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) self.getLayoutParams();
        lp.weight = layoutWeight;
        self.setLayoutParams(lp);
      }
    }
  }


  protected void setWidth() {
    int width;
    if (((width = Utils.convertUnitToPx(context, viewAttr.getWidth(), -3))) != -3) {
      LayoutParams layoutParams = self.getLayoutParams();
      if (null != layoutParams) {
        layoutParams.width = width;
        self.setLayoutParams(layoutParams);
      }

    }
  }


  public void setMinWidth() {
    int minWidth;
    if (((minWidth = Utils.convertUnitToPx(context, viewAttr.getHeight(), 0))) != 0) {
      self.setMinimumWidth(minWidth);
    }
  }


  public void setMaxWidth() {
    int maxWidth;
    if (((maxWidth = Utils.convertUnitToPx(context, viewAttr.getHeight(), 0))) != 0) {
      self.setMinimumWidth(maxWidth);
    }
  }


  public void setMinHeight() {
    int minHeight;
    if (((minHeight = Utils.convertUnitToPx(context, viewAttr.getHeight(), 0))) != 0) {
      self.setMinimumWidth(minHeight);
    }
  }


  public void setMaxHeight() {
    int maxHeight;
    if (((maxHeight = Utils.convertUnitToPx(context, viewAttr.getHeight(), 0))) != 0) {
      self.setMinimumWidth(maxHeight);
    }
  }


  protected void setHeight() {
    int height;
    if (((height = Utils.convertUnitToPx(context, viewAttr.getHeight(), -3))) != -3) {
      LayoutParams layoutParams = self.getLayoutParams();
      if (null != layoutParams) {
        layoutParams.height = height;
        self.setLayoutParams(layoutParams);
      }

    }
  }

  protected void setPadding() {
    int paddingLeft = Utils.convertUnitToPx(context, viewAttr.getPaddingLeft(), 0);
    int paddingRight = Utils.convertUnitToPx(context, viewAttr.getPaddingRight(), 0);
    int paddingTop = Utils.convertUnitToPx(context, viewAttr.getPaddingTop(), 0);
    int paddingBottom = Utils.convertUnitToPx(context, viewAttr.getPaddingBottom(), 0);
    self.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);

  }


  protected void setMargin() {

    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) self
        .getLayoutParams();

    int marginLeft = Utils.convertUnitToPx(context, viewAttr.getMarginLeft(), 0);
    int marginRight = Utils.convertUnitToPx(context, viewAttr.getMarginRight(), 0);
    int marginTop = Utils.convertUnitToPx(context, viewAttr.getMarginTop(), 0);
    int marginBottom = Utils.convertUnitToPx(context, viewAttr.getMarginBottom(), 0);
    marginLayoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
    self.setLayoutParams(marginLayoutParams);

  }

  public void setAlpha() {
    int alpha = viewAttr.getAlpha();
    if (alpha > 0) {
      self.setAlpha(alpha);
    }
  }


  protected void setBackgroundColor() {
    String backgroundColor = "";
    if (!TextUtils.isEmpty((backgroundColor = viewAttr.getBackgroundColor()))) {
      self.setBackgroundColor(Color.parseColor(backgroundColor));
    }
  }


  protected void setSolidShapeAttr() {
    SolidShapeAttr solidShapeAttr;
    if (((solidShapeAttr = viewAttr.getSolidShapeAttr())) != null) {
      String fillColor = solidShapeAttr.getSolidColor();
      int shape = Protocol.SHAPE_TYPE.get(solidShapeAttr.getShape().toLowerCase());
      String strokeColor = solidShapeAttr.getStrokeColor();
      int strokeWidth = Utils.convertUnitToPx(context, solidShapeAttr.getStrokeWidth(), 0);
      String[] radiusStr = solidShapeAttr.getRadius();
      float[] roundRadius = new float[4];
      if (null != radiusStr && radiusStr.length == 4) {
        for (int i = 0; i < radiusStr.length; i++) {
          roundRadius[i] = Utils.convertUnitToDp(context, radiusStr[i], 0);
        }
      }

      DrawableCreator.ShapeBuilder shapeBuilder = new ShapeBuilder(fillColor);
      shapeBuilder.setShape(shape);
      shapeBuilder.setStroke(strokeWidth, strokeColor);
      shapeBuilder.setCornerRadii(roundRadius);

      self.setBackground(shapeBuilder.build());


    }
  }

  protected void setGradientShapeAttr() {
    GradientShapeAttr gradientShape;
    if (((gradientShape = viewAttr.getGradientShapeAttr())) != null) {
      int strokeWidth = Utils.convertUnitToDp(context, gradientShape.getStrokeWidth(), 0);
      int shape = Protocol.SHAPE_TYPE.get(gradientShape.getShape().toLowerCase());
      int gradientType = Protocol.GRADIENT_TYPE
          .get(gradientShape.getGradientType().toLowerCase());
      GradientDrawable.Orientation orientation = Protocol.GRADIENT_ORIENTATION
          .get(gradientShape.getOrientation().toLowerCase());
      String strokeColor = gradientShape.getStrokeColor();

      String[] radiusStr = gradientShape.getRadius();
      float[] roundRadius = new float[4];
      if (null != radiusStr && radiusStr.length == 4) {
        for (int i = 0; i < radiusStr.length; i++) {
          roundRadius[i] = Utils.convertUnitToDp(context, radiusStr[i], 0);
        }
      }

      DrawableCreator.ShapeBuilder shapeBuilder = new ShapeBuilder(orientation,
          gradientShape.getColors(), gradientType);
      shapeBuilder.setShape(shape);
      shapeBuilder.setStroke(strokeWidth, strokeColor);
      shapeBuilder.setCornerRadii(roundRadius);
      self.setBackground(shapeBuilder.build());


    }
  }

  protected void setSolidSelectorAttr() {

    SolidSelectorAttr solidSelectorAttr = null;
    if (((solidSelectorAttr = viewAttr.getSolidSelectorAttr())) != null) {
      int strokeWidth = Utils.convertUnitToDp(context, solidSelectorAttr.getStrokeWidth(), 0);
      int shape = Protocol.SHAPE_TYPE.get(solidSelectorAttr.getShape().toLowerCase());
      String colorNormal = solidSelectorAttr.getColorNormal();
      String colorPressed = solidSelectorAttr.getColorPressed();
      String strokeColor = solidSelectorAttr.getStrokeColor();
      String[] radiusStr = solidSelectorAttr.getRadius();
      float[] roundRadius = new float[4];
      if (null != radiusStr && radiusStr.length == 4) {
        for (int i = 0; i < radiusStr.length; i++) {
          roundRadius[i] = Utils.convertUnitToDp(context, radiusStr[i], 0);
        }
        DrawableCreator.SelectorBuilder selectorBuilder = new SelectorBuilder(colorNormal,
            colorPressed);
        selectorBuilder.setCornerRadii(roundRadius);
        selectorBuilder.setShape(shape);
        selectorBuilder.setStroke(strokeWidth, strokeColor);
        self.setBackground(selectorBuilder.build());

      }

    }
  }


  protected void setGradientSelectorAttr() {

    GradientSelectorAttr gradientSelectorAttr = null;
    if (((gradientSelectorAttr = viewAttr.getGradientSelectorAttr())) != null) {
      int strokeWidth = Utils.convertUnitToDp(context, gradientSelectorAttr.getStrokeWidth(), 0);
      int shape = Protocol.SHAPE_TYPE.get(gradientSelectorAttr.getShape().toLowerCase());
      String[] colorNormal = gradientSelectorAttr.getColorsNormal();
      String[] colorPressed = gradientSelectorAttr.getColorsPressed();
      int gradientType = Protocol.GRADIENT_TYPE
          .get(gradientSelectorAttr.getGradientType().toLowerCase());
      GradientDrawable.Orientation orientation = Protocol.GRADIENT_ORIENTATION
          .get(gradientSelectorAttr.getOrientation().toLowerCase());
      String strokeColor = gradientSelectorAttr.getStrokeColor();
      String[] radiusStr = gradientSelectorAttr.getRadius();
      float[] roundRadius = new float[4];
      if (null != radiusStr && radiusStr.length == 4) {
        for (int i = 0; i < radiusStr.length; i++) {
          roundRadius[i] = Utils.convertUnitToDp(context, radiusStr[i], 0);
        }
      }

      DrawableCreator.SelectorBuilder selectorBuilder = new SelectorBuilder(orientation,
          colorNormal, colorPressed, gradientType);
      selectorBuilder.setCornerRadii(roundRadius);
      selectorBuilder.setShape(shape);
      selectorBuilder.setStroke(strokeWidth, strokeColor);
      self.setBackground(selectorBuilder.build());

    }

  }

  public void setClickable() {
    boolean clickable = viewAttr.isClickable();
    self.setClickable(clickable);
    self.setEnabled(clickable);
  }


  protected void setClick() {
    final ClickAttr clickAttr = viewAttr.getClick();
    if (clickAttr != null) {
      self.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          IPlugin plugin = PluginInjector.getInstance().getPlugin();
          if (null != plugin) {
            plugin.onViewClick(clickAttr.getActionType(), clickAttr.getArgs());
          }

        }
      });
    }
  }


  protected void setLongClick() {

    final ClickAttr clickAttr = viewAttr.getLongClick();
    if (clickAttr != null) {
      self.setOnLongClickListener(new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          IPlugin plugin = PluginInjector.getInstance().getPlugin();
          if (null != plugin) {
            plugin.onViewLongClick(clickAttr.getActionType(), clickAttr.getArgs());
          }
          return false;
        }
      });
    }
  }


  private void setRelativeLayoutChildView() {
    View parent = (View) self.getParent();
    if (parent instanceof RelativeLayout) {
      RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) self.getLayoutParams();
      setAlignParentLeft(lp, viewAttr.isAlignParentLeft());
      setAlignParentTop(lp, viewAttr.isAlignParentTop());
      setAlignParentRight(lp, viewAttr.isAlignParentRight());
      setAlignParentBottom(lp, viewAttr.isAlignParentBottom());

      setCenterInParent(lp, viewAttr.isCenterInParent());
      setCenterHorizontal(lp, viewAttr.isCenterHorizontal());
      setCenterVertical(lp, viewAttr.isCenterVertical());

      setAboveID(lp, viewAttr.getAboveID());
      setBelowID(lp, viewAttr.getBelowID());
      setToLeftOfID(lp, viewAttr.getToLeftOfID());
      setToRightOfID(lp, viewAttr.getToRightOfID());

      setAlignLeftID(lp, viewAttr.getAlignLeftID());
      setAlignTopID(lp, viewAttr.getAlignTopID());
      setAlignRightID(lp, viewAttr.getAlignRightID());
      setAlignBottomID(lp, viewAttr.getAlignBottomID());
      self.setLayoutParams(lp);
    }
  }


  public void setAlignParentLeft(RelativeLayout.LayoutParams lp, boolean alignParentLeft) {
    if (alignParentLeft) {
      lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    }

  }

  public void setAlignParentTop(RelativeLayout.LayoutParams lp, boolean alignParentTop) {
    if (alignParentTop) {
      lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
    }
  }

  public void setAlignParentRight(RelativeLayout.LayoutParams lp, boolean alignParentRight) {
    if (alignParentRight) {
      lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    }
  }

  public void setAlignParentBottom(RelativeLayout.LayoutParams lp, boolean alignParentBottom) {
    if (alignParentBottom) {
      lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    }
  }

  public void setCenterInParent(RelativeLayout.LayoutParams lp, boolean centerInParent) {
    if (centerInParent) {
      lp.addRule(RelativeLayout.CENTER_IN_PARENT);
    }
  }

  public void setCenterHorizontal(RelativeLayout.LayoutParams lp, boolean centerHorizontal) {
    if (centerHorizontal) {
      lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
    }
  }

  public void setCenterVertical(RelativeLayout.LayoutParams lp, boolean centerVertical) {
    if (centerVertical) {
      lp.addRule(RelativeLayout.CENTER_VERTICAL);
    }
  }


  public void setAboveID(RelativeLayout.LayoutParams lp, int aboveID) {
    if (aboveID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(aboveID);
      lp.addRule(RelativeLayout.ABOVE, realId);
    }

  }


  public void setBelowID(RelativeLayout.LayoutParams lp, int belowID) {
    if (belowID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(belowID);
      lp.addRule(RelativeLayout.BELOW, realId);
    }
  }

  public void setToLeftOfID(RelativeLayout.LayoutParams lp, int toLeftOfID) {
    if (toLeftOfID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(toLeftOfID);
      lp.addRule(RelativeLayout.LEFT_OF, realId);
    }
  }

  public void setToRightOfID(RelativeLayout.LayoutParams lp, int toRightOfID) {
    if (toRightOfID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(toRightOfID);
      lp.addRule(RelativeLayout.RIGHT_OF, realId);
    }
  }

  public void setAlignLeftID(RelativeLayout.LayoutParams lp, int alignLeftID) {
    if (alignLeftID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(alignLeftID);
      lp.addRule(RelativeLayout.ALIGN_LEFT, realId);
    }
  }

  public void setAlignTopID(RelativeLayout.LayoutParams lp, int alignTopID) {
    if (alignTopID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(alignTopID);
      lp.addRule(RelativeLayout.ALIGN_TOP, realId);
    }
  }

  public void setAlignRightID(RelativeLayout.LayoutParams lp, int alignRightID) {
    if (alignRightID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(alignRightID);
      lp.addRule(RelativeLayout.ALIGN_RIGHT, realId);
    }
  }

  public void setAlignBottomID(RelativeLayout.LayoutParams lp, int alignBottomID) {
    if (alignBottomID > ID_LIMIT) {
      int realId = ViewIDUtils.getViewID(alignBottomID);
      lp.addRule(RelativeLayout.ALIGN_BOTTOM, realId);
    }
  }


  protected void setBackground() {
    IPlugin plugin = PluginInjector.getInstance().getPlugin();
    if (null != plugin && !TextUtils.isEmpty(viewAttr.getBackground())) {
      plugin.setBackground(self, viewAttr.getBackground());
    }
  }

  protected void setForeground() {
    IPlugin plugin = PluginInjector.getInstance().getPlugin();
    if (null != plugin && !TextUtils.isEmpty(viewAttr.getForeground())) {
      plugin.setForeground(self, viewAttr.getForeground());
    }
  }



  protected  void setCustomAttr(){};

}


