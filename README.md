# AndroidJsonToNative
Create android native view with  just a single JSON


#### 1. 描述 
通过配置Json，翻译为Android Natvie原生控件

#### 2. Installing

```

compile 'com.joy.jsontonative:library:1.0.1'
```

#### 3. 当前支持的View or ViewGroup
1. TextView
2. Button
3. ImageView
4. LinearLayout
5. RelativeLayout
6. FrameLayout
7. ScrollView 
8. HorizontalScrollView


##### 1. 基础 View 属性
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|id|int||android:id||
|tag|string ||android:tag||
|visibility| string |三个值：visible,gone,invisible|android:visibility||
|width| string |支持格式：wrap，match，20(默认dp)，20px，20dp|android:layout_width|"width":"warp"<br>"width":"20dp"<br>"width":"20px"<br>"width":"20"<br>|
|height| string |支持格式：wrap，match，20(默认dp)，20px，20dp|android:layout_height|"height":"warp"<br>"height":"20dp"<br>"height":"20px"<br>"height":"20"<br>|
|minWidth| string |支持格式：20(默认dp)，20px，20dp|android:layout_minWidth|"minWidth":"20dp"<br>"minWidth":"20px"<br>"minWidth":"20"<br>|
|minHeight| string |支持格式：20(默认dp)，20px，20dp|android:layout_minHeight|"minHeight":"20dp"<br>"minHeight":"20px"<br>"minHeight":"20"<br>|
|maxWidth| string |支持格式：20(默认dp)，20px，20dp|android:layout_maxWidth|"maxWidth":"20dp"<br>"maxWidth":"20px"<br>"maxWidth":"20"<br>|
|maxHeight| string |支持格式：20(默认dp)，20px，20dp|android:layout_maxHeight|"maxHeight":"20dp"<br>"maxHeight":"20px"<br>"maxHeight":"20"<br>|
|paddingLeft| string |支持格式：20(默认dp)，20px，20dp|android:paddingLeft |"paddingLeft":"20dp"<br>"paddingLeft":"20px"<br>"paddingLeft":"20"<br>|
|paddingRight| string |支持格式：20(默认dp)，20px，20dp|android:paddingRight |"paddingRight":"20dp"<br>"paddingRight":"20px"<br>"paddingRight":"20"<br>|
|paddingTop| string |支持格式：20(默认dp)，20px，20dp|android:paddingTop |"paddingTop":"20dp"<br>"paddingTop":"20px"<br>"paddingTop":"20"<br>|
|paddingBottom| string |支持格式：20(默认dp)，20px，20dp|android:paddingBottom |"paddingBottom":"20dp"<br>"paddingBottom":"20px"<br>"paddingBottom":"20"<br>|
|marginLeft| string |支持格式：20(默认dp)，20px，20dp|android:layout_marginLeft|"marginLeft":"20dp"<br>"marginLeft":"20px"<br>"marginLeft":"20"<br>|
|marginRight| string |支持格式：20(默认dp)，20px，20dp|android:layout_marginRight|"marginRight":"20dp"<br>"marginRight":"20px"<br>"marginRight":"20"<br>|
|marginTop| string |支持格式：20(默认dp)，20px，20dp|android:layout_marginTop|"marginTop":"20dp"<br>"marginTop":"20px"<br>"marginTop":"20"<br>|
|marginBottom| string |支持格式：20(默认dp)，20px，20dp|android:layout_marginBottom|"marginBottom":"20dp"<br>"marginBottom":"20px"<br>"marginBottom":"20"<br>|
| layoutGravity | string|父布局为LinearLayout和FrameLayout时使用：center，center_horizontal，center_vertical，left，right，top，bottom，top_left，top_right，bottom_right，bottom_left|| "layoutGravity": "center_horizontal"|
| layoutWeight | int|父布局为LinearLayout使用||"layoutWeight": 1|
| alpha | int|透明度 0~255|android:alpha|"alpha":255|
|background| string |背景图片|android:background|"background":"ulr"|
|foreground| string |前景图片|android:foreground|"foreground":"ulr"|
|backgroundColor| string ||android:id|"backgroundColor": "#EEC591"|
|solidShapeAttr| json |||详见示例|
|gradientShapeAttr| json ||android:id||
|clickable| bool  |是否可点击|android: clickable |"clickable":false|
|click| json  |||详见示例|
|longClick| json  |||详见示例|




##### 1.1 Click属性

|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|actionType| string |和业务约定的事件类型|*|"actionType": "2"|
|args| string[] |参数|*|"args": ["Title", "I am remote mesage"]|

 1. click
 	
 	```
 	"click": {
          "actionType": "2",
          "args": ["parameter1", "parameter2"]
        }
 	```
 	
 2. longClick

 	```
 	"longClick": {
          "actionType": "2",
          "args": ["parameter1", "parameter2"]
        }
 	```
 	
##### 1.2 Shape和Selector属性配置

|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
| shape |String|形状| rectangle , oval , line , ring | "shape": "rectangle"<br>"shape": "oval"<br>"shape": "line"<br>"shape": "ring"<br>|
| strokeColor | string |边框颜色|<stroke android:width="1dp" android:color="#FFFFFF"|"strokeColor": "#EEC591"|
| strokeWidth | string |边框宽度|<stroke android:width="1dp" android:color="#FFFFFF"|"strokeWidth":"20dp"<br>"strokeWidth":"20px"<br>"strokeWidth":"20"<br>|
| solidColor | string |填充颜色| <solid android:color="#FFFFFF"|"solidColor": "#EEC591"|
| radius | string[] |圆角半径：依次为topLeftRadius，topRightRadius，bottomRightRadius，bottomLeftRadius||"radius": ["30dp", "30dp", "30dp", "30dp"]|
| gradientType | string|渐变样式:linear,radial,sweep| gradient android:type| "gradientType": "linear"|
| orientation | string|top_bottom，right_left，bottom_top，left_right，tr_bl，br_tl，bl_tr，tl_br| | "gradientType": "linear"|
| colorNormal | string |正常状态下Shape的颜色| |"colorNormal": "#EEC591"|
| colorPressed | string |按下状态下Shape的颜色||"colorPressed": "#EE3B3B"|
| colorsNormal | string |正常状态下Shape的颜色| | "colorsNormal": ["#EE6363", "#EE3A8C", "#EE00EE"]|
| colorsPressed | string |按下状态下Shape的颜色|| "colorsPressed": ["#EED5B7", "#EEC900", "#EEAEEE"]|

 1. solidShapeAttr:纯色的Shape
 
 	```
 	 "solidShapeAttr": {
          "shape": "rectangle",
          "strokeColor": "#EEC900",
          "strokeWidth": "1dp",
          "radius": ["30dp", "30dp", "30dp", "30dp"],
          "solidColor": "#FAEBD7"
        }
 	```
 	
 2. gradientShapeAttr:颜色渐变的Shape
 
 	```
 	 "gradientShapeAttr": {
          "shape": "rectangle",
          "strokeColor": "#EEC900",
          "strokeWidth": "1dp",
          "radius": ["30dp", "30dp", "30dp", "30dp"],
          "colors": ["#F0FFFF", "#EEEEE0", "#EE5C42"],
          "gradientType": "linear",
          "orientation": "top_bottom"
        }
 	```
 3. solidSelectorAttr:纯色的Selector

 
 	```
 	 "solidSelectorAttr": {
          "shape": "rectangle",
          "strokeColor": "#EEC900",
          "strokeWidth": "1dp",
          "radius": ["30dp", "30dp", "30dp", "30dp"],
          "colorNormal": "#EED2EE",
          "colorPressed": "#EE3B3B"
        }
 	```
 4. gradientSelectorAttr颜色渐变的Selector

 	```
 	 "gradientSelectorAttr": {
          "shape": "rectangle",
          "strokeColor": "#EEC900",
          "strokeWidth": "1dp",
          "radius": ["30dp", "30dp", "30dp", "30dp"],
          "colorsNormal": ["#EE6363", "#EE3A8C", "#EE00EE"],
          "colorsPressed": ["#EED5B7", "#EEC900", "#EEAEEE"],
          "gradientType": "linear",
          "orientation": "top_bottom"
        }
       
    ```
 5. 使用json示例：
 
 ```
{
  "name": "android.widget.LinearLayout",
  "attr": {
    "orientation": "vertical",
    "width": "match",
    "height": "match",
    "gravity": "center"

  },
  "children": [{
    "name": "android.widget.TextView",
    "attr": {
      "width": "200dp",
      "height": "50dp",
      "marginTop": "10dp",
      "marginBottom": "10dp",
      "text": "1. Shape rectangle 圆角无渐变有边框",
      "layoutGravity": "center_horizontal",
      "gravity": "center",
      "solidShapeAttr": {
        "shape": "rectangle",
        "strokeColor": "#EEC900",
        "strokeWidth": "1dp",
        "radius": ["30dp", "30dp", "30dp", "30dp"],
        "solidColor": "#FAEBD7"
      }
    }
  }, {
    "name": "android.widget.TextView",
    "attr": {
      "width": "60dp",
      "height": "60dp",
      "marginTop": "10dp",
      "marginBottom": "10dp",
      "text": "2",
      "layoutGravity": "center_horizontal",
      "gravity": "center",
      "solidShapeAttr": {
        "shape": "oval",
        "strokeColor": "#EEC900",
        "strokeWidth": "1dp",
        "solidColor": "#FAEBD7"
      }
    }
  }, {
    "name": "android.widget.TextView",
    "attr": {
      "width": "200dp",
      "height": "50dp",
      "marginTop": "10dp",
      "marginBottom": "10dp",
      "text": "3. 渐变Shape",
      "layoutGravity": "center_horizontal",
      "gravity": "center",
      "gradientShapeAttr": {
        "shape": "rectangle",
        "strokeColor": "#EEC900",
        "strokeWidth": "1dp",
        "radius": ["30dp", "30dp", "30dp", "30dp"],
        "colors": ["#FFFFCC", "#CCFFFF", "#FFCCCC"],
        "gradientType": "linear",
        "orientation": "top_bottom"
      }
    }
  }, {
    "name": "android.widget.TextView",
    "attr": {
      "width": "200dp",
      "height": "50dp",
      "marginTop": "10dp",
      "marginBottom": "10dp",
      "text": "4. selector 点击我看效果",
      "layoutGravity": "center_horizontal",
      "gravity": "center",
      "click": {
        "actionType": "1",
        "args": ["Hello Seal"]
      },
      "solidSelectorAttr": {
        "shape": "rectangle",
        "strokeColor": "#EEC900",
        "strokeWidth": "1dp",
        "radius": ["30dp", "30dp", "30dp", "30dp"],
        "colorNormal": "#FFCC99",
        "colorPressed": "#FFCCCC"
      }
    }
  }, {
    "name": "android.widget.Button",
    "attr": {
      "width": "200dp",
      "height": "50dp",
      "marginTop": "10dp",
      "marginBottom": "10dp",
      "text": "5. selector 渐变 点击我看效果",
      "layoutGravity": "center_horizontal",
      "gravity": "center",
      "click": {
        "actionType": "1",
        "args": ["Hello Seal", "I am remote mesage"]
      },
      "gradientSelectorAttr": {
        "shape": "rectangle",
        "strokeColor": "#EEC900",
        "strokeWidth": "1dp",
        "radius": ["30dp", "30dp", "30dp", "30dp"],
        "colorsNormal": ["#99CCCC", "#FFCC99", "#FFCCCC"],
        "colorsPressed": ["#FFCCCC", "#FFFF99", "#CCCCFF"],
        "gradientType": "linear",
        "orientation": "top_bottom"
      }
    }
  }]
}
 ```
 ![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/shape.gif) 

##### 2. TextView属性
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|textColor| string || android:textColor| "textColor": "#EEC591",|
|textSize|string |支持格式：16(默认sp)，16px，16sp|android:textSize|"textSize":"16"<br>"textSize":"16sp"<br>"textSize":"16px"<br>|
|text|string ||android:text| "text": "Hello"|
| gravity | string|支持：center，center_horizontal，center_vertical，left，right，top，bottom，top_left，top_right，bottom_right，bottom_left|| "gravity": "center_horizontal"|

1. 使用json示例：

```
{
  "name": "android.widget.LinearLayout",
  "attr": {
    "orientation": "vertical",
    "width": "match",
    "height": "match",
    "gravity": "center"

  },
  "children": [{
    "name": "android.widget.TextView",
    "attr": {
      "width": "match",
      "height": "100dp",
      "text": "gravity=center",
      "backgroundColor": "#CCCCCC",
      "textColor": "#0099CC",
      "textSize": "20sp",
      "gravity": "center"

    }
  }, {
    "name": "android.widget.TextView",
    "attr": {
      "width": "match",
      "height": "100dp",
      "marginTop": "10dp",
      "paddingRight": "10dp",
      "text": "gravity=bottom_right,paddingRight =10dp",
      "backgroundColor": "#FFCCCC",
      "textColor": "#996699",
      "textSize": "14sp",
      "gravity": "bottom_right"

    }
  }]
}
```

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/textview.png) 
 
##### 3. Button属性
ButtonViewAttr集成了TextViewAttr，支持以上TextView所有属性


##### 4. ImageView属性
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|src| string |图片url地址，client需要自定义获取图片的方式| android:src| "src": "url"|
|scaleType| string |支持：matrix，center，centerCrop，centerInside，fitCenter，fitEnd，fitStart，fitXY| android:scaleType| "scaleType": "centerCrop"|

1. 使用json示例：

```
{
  "name": "android.widget.LinearLayout",
  "attr": {
    "orientation": "vertical",
    "width": "match",
    "height": "match",
    "gravity": "center_horizontal"

  },
  "children": [{
    "name": "android.widget.ImageView",
    "attr": {
      "src": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559650317195&di=442894579f9977ab82aadf1796b02ef1&imgtype=0&src=http%3A%2F%2Fimages.warchina.com%2Fsrc%2F201609%2F4105bc8117.jpg",
      "scaleType": "centerInside",
      "width": "150dp",
      "height": "150dp"
    }

  }, {
    "name": "android.widget.ImageView",
    "attr": {
      "src": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560244992&di=eac196c60bcd20176ef13968acbbafdd&imgtype=jpg&er=1&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2F3894ddedd7c91e2412c24aa01dc98d22897e45e8.jpg",
      "scaleType": "centerInside",
      "width": "150dp",
      "height": "150dp"
    }

  }, {
    "name": "android.widget.ImageView",
    "attr": {
      "src": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559651240905&di=7809034e116d9b0be9ca8f3c48b30b9f&imgtype=0&src=http%3A%2F%2Fcartoon.zwbk.org%2FImageUploadTK%2F6346837811022550009116291302.jpg",
      "scaleType": "centerInside",
      "width": "wrap",
      "height": "wrap"
    }

  }]
}
```
![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/imageview.png) 

##### 5. FrameLayout属性：
这里是FrameLayout的children的属性

|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
| layoutGravity | string |center，center_horizontal，center_vertical，left，right，top，bottom，top_left，top_right，bottom_right，bottom_left|android: layoutGravity |"layoutGravity": "top_left"|


1. 使用json示例详见demo

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/frameLayout.png) 



##### 6. LinearLayout属性
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|orientation| string |支持：vertical，horizontal|android: orientation |"orientation": "horizontal"|
| gravity | string|支持：center，center_horizontal，center_vertical，left，right，top，bottom，top_left，top_right，bottom_right，bottom_left|| "gravity": "center_horizontal"|
|layoutWeight|int|| android:layout_weight|"layoutWeight": "1",|

1. 使用json示例详见demo

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/linearLayout.png) 

##### 7. RelativeLayout
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|alignParentLeft|bool|贴紧父元素的左边缘 |android:layout_alignParentLeft |"alignParentLeft":true|
|alignParentTop|bool|贴紧父元素的上边缘 |android:layout_alignParentTop |"alignParentTop":true|
|alignParentRight|bool|贴紧父元素的右边缘 |android:layout_alignParentRight |"alignParentRight":true|
|alignParentBottom|bool|贴紧父元素的下边缘 |android:layout_alignParentBottom |"alignParentBottom":true|
|centerInParent|bool|相对于父元素完全居中 |android:layout_centerInparent |"centerInParent":true|
|centerHorizontal|bool|水平居中 |android:layout_centerHrizontal |"centerHorizontal":true|
|centerVertical|bool| 垂直居中  |android:layout_centerVertical |"centerVertical":true|
|aboveID|int|在某元素的的上方 | android:layout_above|"aboveID":123456|
|belowID|int|在某元素的下方  | android:layout_below |"belowID":123456|
|toLeftOfID|int|在某元素的左边  | android:layout_toLeftOf |"toLeftOfID":123456|
|toRightOfID|int|在某元素的右边  |android:layout_toRightOf |"toRightOfID":123456|
|alignLeftID|int|本元素的左边缘和某元素的的左边缘对齐  | android:layout_alignLeft|"alignLeftID":123456|
|alignTopID|int|本元素的上边缘和某元素的的上边缘对齐  | android:layout_alignTop |"alignTopID":123456|
|alignRightID|int|本元素的右边缘和某元素的的右边缘对齐  | android:layout_alignRight |"alignRightID":123456|
|alignBottomID|int|本元素的下边缘和某元素的的下边缘对齐 | android:layout_alignBottom |"alignBottomID":123456|

1. 使用json示例详见demo

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/relativeLayout.png) 

##### 8. ScrollView
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|showScrollbar|bool|是否显示滚动条 | android:scrollbars |"showScrollbar":false|

1. 使用json示例详见demo

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/ScrollView.png) 


##### 9. HorizontalScrollView
|属性|type|说明|对应xml属性|示例|
|---|---|---|---|---|
|showScrollbar|bool|是否显示滚动条 | android:scrollbars |"showScrollbar":false|

1.使用json示例详见demo

![image](https://github.com/myjoybar/AndroidJsonToNative/blob/master/screenshots/HorizontalScrollView.png) 


##### 10. 自定义扩展

IPlugin中预留了和业务交互的方法

```
  void onViewClick(String type, String[] args);
  void onViewLongClick(String type, String[] args);
  void setBackground(View view, String url);
  void setForeground(View view, String url);
  void setImgSrc(ImageView imageView, String url);
  
```

通过调用 PluginInjector.getInstance().register(new PluginImpl(this))注册即可


