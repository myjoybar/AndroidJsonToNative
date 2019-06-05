package me.joy.jsontonative.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/**
 * @author Joy
 * @description
 * @date 2019/5/24
 */
public class Utils {


  public static JSONObject readJson(String filename, Context context) {
    StringBuilder returnString = new StringBuilder();
    InputStream fIn = null;
    InputStreamReader isr = null;
    BufferedReader input = null;
    try {
      fIn = context.getResources().getAssets().open(filename);
      isr = new InputStreamReader(fIn);
      input = new BufferedReader(isr);
      String line;
      while ((line = input.readLine()) != null) {
        returnString.append(line);
      }
    } catch (Exception e) {
      e.getMessage();
    } finally {
      try {
        if (isr != null) {
          isr.close();
        }
        if (fIn != null) {
          fIn.close();
        }
        if (input != null) {
          input.close();
        }
      } catch (Exception e2) {
        e2.getMessage();
      }
    }
    try {
      return new JSONObject(returnString.toString());
    } catch (Exception e) {
      return null;
    }
  }


  public static String readJsonStr(String filename, Context context) {
    StringBuilder returnString = new StringBuilder();
    InputStream fIn = null;
    InputStreamReader isr = null;
    BufferedReader input = null;
    try {
      fIn = context.getResources().getAssets().open(filename);
      isr = new InputStreamReader(fIn);
      input = new BufferedReader(isr);
      String line;
      while ((line = input.readLine()) != null) {
        returnString.append(line);
      }
    } catch (Exception e) {
      e.getMessage();
    } finally {
      try {
        if (isr != null) {
          isr.close();
        }
        if (fIn != null) {
          fIn.close();
        }
        if (input != null) {
          input.close();
        }
      } catch (Exception e2) {
        e2.getMessage();
      }
    }
    try {
      return returnString.toString();
    } catch (Exception e) {
      return null;
    }
  }



  // 转换dip为px
  public static int dp2px(Context context, int dip) {
    float scale = context.getResources()
        .getDisplayMetrics().density;
    return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
  }

  // 转换px为dip
  public static int px2dp(Context context, float pxValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }

  /**
   * sp转换成px
   */
  private int sp2px(Context context, float spValue) {
    float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * fontScale + 0.5f);

  }

  /**
   * px转换成sp
   */
  private static int px2sp(Context context, float pxValue) {
    float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (pxValue / fontScale + 0.5f);
  }







  /**
   *  把计量单位转为PX
   *   默认入参单位为DP
   */
  public static int convertUnitToPx(Context context, String value, int exceptionResult) {
    int result = exceptionResult;
    if (!TextUtils.isEmpty(value)) {
      if (value.endsWith("dp")) {
        result = dp2px(context,
            parseStrToInt(value.substring(0, value.length() - 2), exceptionResult));
      } else if (value.endsWith("px")) {
        result = parseStrToInt(value.substring(0, value.length() - 2), exceptionResult);

      } else if (value.equals(Protocol.MATCH)) {
        result = -1;
      } else if (value.equals(Protocol.WRAP)) {
        result = -2;
      } else {
        // 默认DP
        result = dp2px(context, parseStrToInt(value, exceptionResult));
      }
    }

    return result;
  }



  /**
   *   把计量单位转为DP
   *   默认入参单位为DP
   */
  public static int convertUnitToDp(Context context, String value, int exceptionResult) {
    int result = exceptionResult;
    if (!TextUtils.isEmpty(value)) {
      if (value.endsWith("dp")) {

        result = parseStrToInt(value.substring(0, value.length() - 2), exceptionResult);
      } else if (value.endsWith("px")) {
        result = px2dp(context,
            parseStrToInt(value.substring(0, value.length() - 2), exceptionResult));
      } else if (value.equals(Protocol.MATCH)) {
        result = -1;
      } else if (value.equals(Protocol.WRAP)) {
        result = -2;
      } else {
        // 默认DP
        result = parseStrToInt(value.substring(0, value.length() - 2), exceptionResult);
      }
    }

    return result;
  }




  public static int convertTextSizeUnit(Context context, String value, int exceptionResult) {
    int result = exceptionResult;
    if (!TextUtils.isEmpty(value)) {
      if (value.endsWith("sp")) {
        result = parseStrToInt(value.substring(0, value.length() - 2), exceptionResult);
      } else if (value.endsWith("px")) {
        result = px2sp(context,
            parseStrToInt(value.substring(0, value.length() - 2), exceptionResult));

      } else {
        //默认SP
        result = parseStrToInt(value, exceptionResult);
      }
    }

    return result;
  }


  private static int parseStrToInt(String str, int exceptionResult) {
    int result = exceptionResult;
    try {
      result = Integer.parseInt(str);
    } catch (Exception e) {
      Log.e("convertUnitToPx", "parseInt error: " + e.getMessage());
    }
    return result;
  }


}
