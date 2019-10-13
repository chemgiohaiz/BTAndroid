package com.example.baitapandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tvMsg;
    GridView gv;
    TextView tvSoloMsg;
    //mảng lưu danh sách các id hình ảnh có sẵn
    Integer[] mThumbIds;
    //Adapter cho GridView
    MyImageADapter adapter = null;
    //Vì không tạo thêm 1 Activity nên lấy luôn 2 Id ở bên solo_picture.xml
    ImageView ivSoloPicture;
    Button btnBack;
    //Lưu Bundle backup cho MainActivity
    Bundle myBackupBundle;
    String[] listLink = new String[]{"https://nhaccuatui.com/",
            "https://mp3.zing.vn/", "https://fb.com/", "" +
            "https://github.com/", "https://www.youtube.com/channel/UCVJ6jQF0XOaBVTPCT-en2sw",
            "https://www.google.com/", "https://www.thegioididong.com/", "https://fptshop.com.vn/",
            "https://www.google.com/", "https://www.dienmayxanh.com/", "https://mivietnam.vn/", "https://www.vinamilk.com.vn/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_main);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        //gán mảng các Id hình ảnh cho mThumbIds
        mThumbIds = new Integer[]{R.drawable.logo1, R.drawable.logo2,
                R.drawable.logo3, R.drawable.logo4,
                R.drawable.logo5, R.drawable.logo6,
                R.drawable.logo7, R.drawable.logo8, R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12};
        gv = (GridView) findViewById(R.id.gridView1);
        //thiết lập Datasource cho Adapter
        adapter = new MyImageADapter(this, mThumbIds);
        //gán Adapter vào Gridview
        gv.setAdapter(adapter);
        //thiết lập sự kiện để mở từng hình ảnh chitiết
        gv.setOnItemClickListener(this);
    }

    //Show trên Internet
    public void onItemClick(AdapterView<?> arg0,
                            View arg1, int i, long l) {
        //gọi hàm xem hình ảnh chi tiết tại ví trí thứ arg2
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(listLink[i]));
        startActivity(intent);

    }
    //Show giao diện
    public void showdetail(int posistion) {
        //Không mở Activity mới mà chỉ thiết lập lại Layout
        setContentView(R.layout.picture);
        //Vừa gọi hàm trên thì màn hình sẽ thay đổi qua cái mới
        //ta lấy các control trong layout mới này
      /*  tvSoloMsg=(TextView) findViewById(R.id.tvSoloMsg);
        tvSoloMsg.setText((CharSequence) Uri.parse(listLink[posistion]));
        ivSoloPicture=(ImageView) findViewById(R.id.imgSolo);
        //thiết lập hình ảnh đang chọn lên ImageView mới
        ivSoloPicture.setImageResource(mThumbIds[posistion]);
        btnBack=(Button) findViewById(R.id.btnBack);
        //Thiết lập sự kiện click Back để phục hồi lại MainActivity
        //bằng cách gọi lại onCreate(myBackupBundle);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               // onCreate(myBackupBundle);
                finish();
            }
        });
    }*/
    }

}
