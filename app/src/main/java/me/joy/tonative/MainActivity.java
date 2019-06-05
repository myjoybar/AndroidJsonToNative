package me.joy.tonative;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private static String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.btn_click).setOnClickListener(this);
    findViewById(R.id.btn_shape).setOnClickListener(this);
    findViewById(R.id.btn_textview).setOnClickListener(this);
    findViewById(R.id.btn_img).setOnClickListener(this);
    findViewById(R.id.btn_fl).setOnClickListener(this);
    findViewById(R.id.btn_ll).setOnClickListener(this);
    findViewById(R.id.btn_rl).setOnClickListener(this);
    findViewById(R.id.btn_sv).setOnClickListener(this);
    findViewById(R.id.btn_hsv).setOnClickListener(this);

  }


  @Override
  public void onClick(View v) {
    int id = v.getId();
    switch (id) {
      case R.id.btn_click:
        JsonViewActivity.launch(MainActivity.this, "click.json");
        break;

      case R.id.btn_shape:
        JsonViewActivity.launch(MainActivity.this, "shape_selector.json");
        break;

      case R.id.btn_textview:
        JsonViewActivity.launch(MainActivity.this, "textview.json");
        break;
      case R.id.btn_img:
        JsonViewActivity.launch(MainActivity.this, "imageview.json");
        break;

      case R.id.btn_fl:
        JsonViewActivity.launch(MainActivity.this, "framelayout.json");
        break;

      case R.id.btn_ll:
        JsonViewActivity.launch(MainActivity.this, "linearLayout.json");
        break;

      case R.id.btn_rl:
        JsonViewActivity.launch(MainActivity.this, "relativeLayout.json");
        break;

      case R.id.btn_sv:
        JsonViewActivity.launch(MainActivity.this, "scrollview.json");
        break;

      case R.id.btn_hsv:
        JsonViewActivity.launch(MainActivity.this, "horizontalScrollview.json");
        break;
      default:
        break;
    }

  }
}
