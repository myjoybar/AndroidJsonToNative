package me.joy.jsontonative.util;

import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joy
 * @description
 * @date 2019/6/4
 */
public class ViewIDUtils {

  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

  private static final Map<Integer, Integer> sMapId = new HashMap<>();

  public static void setViewId(View view, int id) {
    Log.d("AAAAAA", "setViewId name = " + view.getClass().getSimpleName());
    int viewId = generateID(id);
    Log.d("AAAAAA", "setViewId id = " +id+ " viewId = " +viewId);
    view.setId(viewId);
    Log.d("AAAAAA", "after id = "+ view.getId() );
  }


  public static int getViewID(int id) {
    Log.d("AAAAAA", "getViewID id = " +id+ " sMapId.get(id) = " + sMapId.get(id));
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


}