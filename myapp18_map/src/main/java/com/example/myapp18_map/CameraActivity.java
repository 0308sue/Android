package com.example.myapp18_map;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {

    Button cameraBtn,galleryBtn;
    ImageView resultImageView;
    String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraBtn =findViewById(R.id.cameraBtn);
        galleryBtn = findViewById(R.id.galleryBtn);
        resultImageView = findViewById(R.id.imageview);

        ActivityResultLauncher<Intent> gallerylauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                int calRatio = calculateInSampleSize((result.getData().getData()),300,300);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = calRatio;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(result.getData().getData());
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                    inputStream.close();

                    resultImageView.setImageBitmap(bitmap);
                }catch (Exception e){
                    Log.d("InputStream error>>",""+e.toString());
                }
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                Log.d("Images.Media >>", ""+MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                gallerylauncher.launch(intent);
            }
        });

        ActivityResultLauncher<Intent> cameralauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                resultImageView.setImageBitmap(bitmap);
            }
        });
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    File file = File.createTempFile("JREG_"+timeStamp,".jpg",storageDir);
                    filePath = file.getAbsolutePath();
                    Log.d("filePath >>>",""+filePath);
                    Uri photoUri = FileProvider.getUriForFile(getBaseContext(),"com.example.myapp18_map.fileprovider",file);

                    Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                    cameralauncher.launch(intent);
                }catch (IOException e){
                    Log.d("err >>>",""+e.toString());
                }


            }
        });
    }
    private int calculateInSampleSize(Uri fileUri,int reqWidth,int reqHeight){
        return 0;
    }
}

