package me.joy.tonative;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import me.joy.jsontonative.core.ViewCreator;
import me.joy.jsontonative.core.ViewNodeHelper;
import me.joy.jsontonative.jsontonative.data.ViewNode;
import me.joy.jsontonative.jsontonative.extensionplugin.PluginInjector;
import me.joy.jsontonative.util.Utils;
import me.joy.tonative.plugin.PluginImpl;


public class JsonViewActivity extends AppCompatActivity {

  private static String TAG = "JsonViewActivity";
  private String jsonFileName; //"viewConfig.json"

  public static void launch(Context context, String jsonFileName) {
    Intent intent = new Intent(context, JsonViewActivity.class);
    intent.putExtra("jsonFileName", jsonFileName);
    context.startActivity(intent);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);
    ViewCreator.getInstance().init(this);
    jsonFileName = getIntent().getStringExtra("jsonFileName");
    final View rootView = findViewById(android.R.id.content);
    PluginInjector.getInstance().register(new PluginImpl(this));
    start(this, rootView, Utils.readJsonStr(jsonFileName, this));

  }

  private void start(Context context, View parent, String json) {
    ViewNode viewNode = ViewNodeHelper.parse(json);
    ViewCreator.getInstance().recursiveViewNode(context, parent, viewNode);

  }


}