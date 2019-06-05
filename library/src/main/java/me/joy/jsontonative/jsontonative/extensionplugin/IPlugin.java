package me.joy.jsontonative.jsontonative.extensionplugin;

import android.view.View;
import android.widget.ImageView;

/**
 * @author Joy
 * @description
 * @date 2019/6/4
 */
public interface IPlugin {

  void onViewClick(String type, String[] args);

  void onViewLongClick(String type, String[] args);

  void setBackground(View view, String url);
  void setForeground(View view, String url);
  void setImgSrc(ImageView imageView, String url);

}
