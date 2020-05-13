package me.joy.jsontonative.util;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Joy on 2019/6/6
 */

public class ViewIDUtils {

  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

  private static final Map<Integer, Integer> sMapId = new HashMap<>();

  public static void setViewId(View view, int id) {
    int viewId = generateID(id);
    view.setId(viewId);
  }


  public static int getViewID(int id) {
    return sMapId.get(id);
  }


  private static int generateID(int id) {
    int generateViewId = generateViewId();
    sMapId.put(id, generateViewId);
    return generateViewId;
  }


  private static int generateViewId() {
    for (; ; ) {
      final int result = sNextGeneratedId.get();
      // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
      int newValue = result + 1;
      if (newValue > 0x00FFFFFF) {
        newValue = 1; // Roll over to 1, not 0.
      }
      if (sNextGeneratedId.compareAndSet(result, newValue)) {
        return result;
      }
    }
  }



  /**
   * 获取value下string.xml文件下的字符串id
   * @param context
   * @param strName
   * @return
   */
  public static int getStringResID(Context context,String strName){
    return context.getResources().getIdentifier(strName,"string",context.getPackageName());
  }


  /**
   * 获取drawable文件夹下的图片或xml的id
   * @param context
   * @param imgName
   * @return
   */
  public static int getDrawableImgResID(Context context,String imgName){
    return context.getResources().getIdentifier(imgName,"drawable",context.getPackageName());
  }

  /**
   * 获取mipmap文件夹下的图片或xml的id
   * @param context
   * @param imgName
   * @return
   */
  public static int getMipmapImgResID(Context context,String imgName){
    return context.getResources().getIdentifier(imgName,"mipmap",context.getPackageName());
  }



  /**
   * 获取res文件夹下的color.xml文件下某个颜色字段的id
   * @param context
   * @param colorName
   * @return
   */
  public static int getColorResID(Context context,String colorName){
    return context.getResources().getIdentifier(colorName,"color",context.getPackageName());
  }



}
