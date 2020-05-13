package me.joy.jsontonative.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;

/**
 * 创建各类Shape 和 Selector Created by joybar on 1/11/16.
 */

public class DrawableCreator {


  public static final class ShapeBuilder {

    private GradientDrawable gradientDrawable;

    private int shape;
    private String solidColor;
    private float[] radii;
    private int strokeWidth;
    private String strokeColor;

    /**
     * 颜色渐变的shape
     */
    public ShapeBuilder(String solidColor) {
      this.solidColor = solidColor;
      gradientDrawable = new GradientDrawable();
    }

    /**
     * 颜色渐变的shape
     *
     * @param orientation GradientDrawable.Orientation.TOP_BOTTOM GradientDrawable.Orientation.TR_BL
     * @param gradientColors "colors": ["#F0FFFF", "#EEEEE0", "#EE5C42"], int colors[] = { 0xff255779 , 0xff3e7492, 0xffa6c0cd };
     * @param gradientType GradientDrawable.LINEAR_GRADIENT GradientDrawable.RADIAL_GRADIENT
     * GradientDrawable.SWEEP_GRADIENT
     */
    public ShapeBuilder(GradientDrawable.Orientation orientation, String[] gradientColors,
        int gradientType) {
      int length = gradientColors.length;
      int[] gradientColor = new int[length];
      for (int i = 0; i < length; i++) {
        gradientColor[i] = Color.parseColor((gradientColors[i]));
      }
      gradientDrawable = new GradientDrawable(orientation, gradientColor);
      gradientDrawable.setGradientType(gradientType);
    }

    /**
     * 设置形状
     *
     * @param shape GradientDrawable.RECTANGLE GradientDrawable.OVAL GradientDrawable.LINE
     * GradientDrawable.RING
     */
    public ShapeBuilder setShape(int shape) {
      this.shape = shape;
      return this;
    }


    /**
     * 设置圆角半径 ordered top-left, top-right, bottom-right, bottom-left. when the shape is of type
     * RECTANGLE.
     *
     * @param radii float[] r = {4,4,4,4}
     */
    public ShapeBuilder setCornerRadii(float[] radii) {
      this.radii = radii;
      return this;
    }


    /**
     * 设置边框
     */
    public ShapeBuilder setStroke(int width, String color) {

      this.strokeWidth = width;
      this.strokeColor = color;
      return this;
    }

    public GradientDrawable build() {
      gradientDrawable.setShape(shape);
      if (!TextUtils.isEmpty(solidColor)) {
        gradientDrawable.setColor(Color.parseColor(solidColor));
      }
      if (null != radii && radii.length != 0) {
        if (radii[0] == radii[1] && radii[1] == radii[2] && radii[2] == radii[3]) {
          gradientDrawable.setCornerRadius(radii[0]);
        } else {
          float[] r = new float[]{radii[0], radii[0], radii[1], radii[1],
              radii[2], radii[2], radii[3], radii[3]};
          gradientDrawable.setCornerRadii(r);
        }

      }

      if (!TextUtils.isEmpty(strokeColor)) {
        gradientDrawable.setStroke(strokeWidth, Color.parseColor(strokeColor));
      }
      return gradientDrawable;
    }


  }


  public static final class SelectorBuilder {


    private String colorNormal;
    private String colorPressed;

    private int shape;

    private GradientDrawable.Orientation orientation;
    String[] gradientColorsNormal;
    String[] gradientColorsPressed;
    private int gradientType;

    private int strokeWidth;
    private String strokeColor;

    private float[] radii;


    public SelectorBuilder(String colorNormal, String colorPressed) {
      this.colorNormal = colorNormal;
      this.colorPressed = colorPressed;
    }

    /**
     * @param orientation GradientDrawable.Orientation.TOP_BOTTOM GradientDrawable.Orientation.TR_BL
     * ……
     * @param gradientColorsNormal int colors[] = { 0xff255779 , 0xff3e7492, 0xffa6c0cd };
     * //分别为开始颜色，中间夜色，结束颜色
     * @param gradientColorsPressed int colors[] = { 0xff255779 , 0xff3e7492, 0xffa6c0cd };
     * //分别为开始颜色，中间夜色，结束颜色
     * @param gradientType GradientDrawable.LINEAR_GRADIENT GradientDrawable.RADIAL_GRADIENT
     * GradientDrawable.SWEEP_GRADIENT
     */
    public SelectorBuilder(GradientDrawable.Orientation orientation, String[] gradientColorsNormal,
        String[] gradientColorsPressed,
        int gradientType) {
      this.orientation = orientation;
      this.gradientColorsNormal = gradientColorsNormal;
      this.gradientColorsPressed = gradientColorsPressed;
      this.gradientType = gradientType;

    }

    /**
     * 设置形状
     *
     * @param shape GradientDrawable.RECTANGLE GradientDrawable.OVAL GradientDrawable.LINE
     * GradientDrawable.RING
     */
    public SelectorBuilder setShape(int shape) {
      this.shape = shape;
      return this;
    }


    public SelectorBuilder setStroke(int width, String color) {
      this.strokeWidth = width;
      this.strokeColor = color;
      return this;
    }


    public SelectorBuilder setCornerRadii(float[] radii) {
      this.radii = radii;
      return this;
    }


    public StateListDrawable build() {

      // 非渐变
      if (null == gradientColorsNormal) {
        ShapeBuilder shapeNormalBuilder = new ShapeBuilder(colorNormal);
        shapeNormalBuilder.setShape(shape);
        shapeNormalBuilder.setStroke(strokeWidth, strokeColor);
        shapeNormalBuilder.setCornerRadii(radii);
        Drawable normal = shapeNormalBuilder.build();

        ShapeBuilder shapePressedBuilder = new ShapeBuilder(colorPressed);
        shapePressedBuilder.setShape(shape);
        shapePressedBuilder.setStroke(strokeWidth, strokeColor);
        shapePressedBuilder.setCornerRadii(radii);
        Drawable pressed = shapePressedBuilder.build();

        StateListDrawable sd = new StateListDrawable();

        sd.addState(new int[]{android.R.attr.state_pressed}, pressed);// 按下状态的背景
        sd.addState(new int[]{}, normal); //常规状态的背景

        return sd;

      } else {
        ShapeBuilder shapeNormalBuilder = new ShapeBuilder(orientation, gradientColorsNormal,
            gradientType);
        shapeNormalBuilder.setShape(shape);
        shapeNormalBuilder.setStroke(strokeWidth, strokeColor);
        shapeNormalBuilder.setCornerRadii(radii);
        Drawable normal = shapeNormalBuilder.build();

        ShapeBuilder shapePressedBuilder = new ShapeBuilder(orientation, gradientColorsPressed,
            gradientType);
        shapePressedBuilder.setShape(shape);
        shapePressedBuilder.setStroke(strokeWidth, strokeColor);
        shapePressedBuilder.setCornerRadii(radii);
        Drawable pressed = shapePressedBuilder.build();

        StateListDrawable sd = new StateListDrawable();

        sd.addState(new int[]{android.R.attr.state_pressed}, pressed);// 按下状态的背景
        sd.addState(new int[]{}, normal); //常规状态的背景

        return sd;
      }

    }

  }


}
