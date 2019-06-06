package me.joy.tonative.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import me.joy.jsontonative.jsontonative.extensionplugin.IPlugin;
import me.joy.tonative.R;

/**
 * Created by Joy on 2019/6/6
 */

public class PluginImpl implements IPlugin {

  private Context context;

  public PluginImpl(Context context) {
    this.context = context;
  }

  @Override
  public void onViewClick(String type, String[] args) {

    switch (type) {
      case "1":
        String msg = "";
        if (null != args) {
          msg = args[0];
        }
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        break;
      case "2":

        final AlertDialog.Builder builder =
            new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(args[0]);
        builder.setMessage(args[1]);
        builder.setPositiveButton("确定",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
              }
            });
        builder.setNegativeButton("关闭",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
              }
            });
        // 显示
        builder.show();
        break;
      default:
        break;
    }

  }

  @Override
  public void onViewLongClick(String type, String[] args) {

  }

  @Override
  public void setBackground(final View view, String url) {
    Glide.with(context).load(url).into(new SimpleTarget<Drawable>() {
      @Override
      public void onResourceReady(@NonNull Drawable resource,
          @Nullable Transition<? super Drawable> transition) {
        view.setBackground(resource);
      }
    });

  }

  @Override
  public void setForeground(View view, String url) {

  }

  @Override
  public void setImgSrc(ImageView imageView, String url) {
    Glide.with(context).load(url).into(imageView);
  }
}
