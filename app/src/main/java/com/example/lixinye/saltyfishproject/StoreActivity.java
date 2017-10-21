package com.example.lixinye.saltyfishproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity implements View.OnClickListener {

    //搭配信息
    List<String> list_store=new ArrayList<String>();
    //当前搭配的位置
    int now_num=0;

    ImageView upCloth;
    ImageView downCloth;
    ImageButton leftButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
    public void Click()
    {
        upCloth=(ImageView)findViewById(R.id.up_cloth);
        downCloth=(ImageView)findViewById(R.id.down_cloth);
        //表示上一套收藏
        leftButton=(ImageButton)findViewById(R.id.left_next_icon);
        //leftButton.setOnClickListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.left_next_icon:
                changeSuit(-1);
                break;
            case R.id.right_next_icon:
                changeSuit(1);
                break;
            default:
                break;
        }
    }
    public void changeSuit(int flag)    //flag为1，表示往后看，flag为0，表示往前看
    {
        String up="";
        String dowm="";
        now_num+=flag;
        now_num+=flag;  //存储中按 上衣、下装依次存放
        now_num=(now_num+list_store.size())%list_store.size();  //取模 循环

        up=list_store.get(now_num);
        String path="/sdcard/Pictures/sweetWardrobe";   //图片的根目录
        //---------------------------------------------------------->不知道上述该路径是如何确定的

        String name=path+up+".jpg";
        //Bitmap代表一张位图，BitmapDrawable里封装的图片就是一个Bitmap对象．把Bitmap对象包装成BitmapDrawable对象，
        // 可以调用Bitmapdrawable的构造器
        //BitmapDrawable drawable = new BitmapDrawable(bitmap);初始化BitmapDrawable对象

        //如果要获取BitmapDrawable所包装的bitmap对象,可以调用getBitmap()方法
        //Bitmap bitmap = drawable.getBitmap();

        //如果需要访问其它存储路径的图片,需要借助于BitmapFactory来解析,创建Bitmap对象

        // BitmapFactory该类所有方法都是用来解码创建一个 bitmap 对象
        //该类的子类 options类 Options，该类用于解码Bitmap时的参数控制
        //inSample表示缩小bitmap的宽和高、降低分辨率，宽=宽/inSample，...像素下降为原来的(inSample*inSample)分之一

        //------------------------------------------------------------->理解似乎有问题！！！

        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inSampleSize = 4;
        Bitmap bm = BitmapFactory.decodeFile(name,option);
        upCloth.setImageBitmap(bm);//显示获取的图片
    }
}
