package com.example.sih;

import android.Manifest;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static String perc;
    Button uploadPhoto,takePhoto;
    public static Bitmap bitmap;
    TextView tv;
    public static String result;
    GPSTracker gps;
    public static String loc;
    int a;
    public static File file;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadPhoto=(Button)findViewById(R.id.btn_uploadphoto);
        takePhoto=(Button)findViewById(R.id.btn_takephoto);
        tv=(TextView)findViewById(R.id.res);

        /*ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null)
        {
            actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.mygradientactionbar));
        }*/

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Bajra", "This is Bajra");
        editor.putString("Cotton", "This is Cotton");
        editor.putString("Sugarcane", "This is Sugarcane");
        editor.putString("Rice", "This is Rice");
        editor.putString("Cotton", "This is Cotton");
        editor.putString("Watermelon", "This is Watermelon");
        editor.putString("Cabbage", "This is Cabbage");
        editor.putString("Wheat", "This is Wheat");
        //editor.putString("S", "This is Cotton");

        editor.commit();

        //location

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition willexecute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    imgpicker(0);
                    getLocation();
                    Excel ex = new Excel();
                    ex.main();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        uploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
                imgpicker(1);

            }
        });
    }

    public void imgpicker(int a){
        if(a == 0) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                takePictureIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                startActivityForResult(takePictureIntent, 1);
            }
        }
        if(a == 1){

            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/temp.jpeg");
            try {
                FileOutputStream fout = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 85, fout);
                fout.flush();
                fout.close();
                upload(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            File file = new File(getRealPathFromURI(getApplicationContext(),uri));

            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                //bitmap.compress(Bitmap.CompressFormat.PNG, 85, fout);
                FileOutputStream fout = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 85, fout);
                fout.flush();
                fout.close();
                upload(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void upload(File file){
        //Create a file object using file path
        // Create a request body with file and image media type
        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        Retrofit retrofit = RetrofitClient.getRetrofitClient(this);
        IMyService iMyService1 = retrofit.create(IMyService.class);
        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
        // Create MultipartBody.Part using file request-body,file name and part name
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), fileReqBody);
        //Create request body with text description and text media type
        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");
        //
        Call<MessageResult> uploadImage = iMyService1.uploadImage(part, description);
        uploadImage.enqueue(new Callback<MessageResult>() {
            @Override
            public void onResponse(Call<MessageResult> call, Response<MessageResult> response) {
                Log.d("my", response.body().getResult());
                Toast.makeText(MainActivity.this, "" + response.body().getResult(), Toast.LENGTH_SHORT).show();
                String accuracy=response.body().getResult();
                char [] ch=new char[accuracy.length()];
                for(int i=0;i<accuracy.length();i++)
                {
                    ch[i]=accuracy.charAt(i);
                }
                char percentage[] = new char[2];
                char res[] = new char[accuracy.length()-3];
                for(int i=0;i<2;i++)
                {
                    percentage[i] = ch[i];
                }
                int j=0;
                for(int i=3;i<accuracy.length();i++)
                {
                    res[j]=ch[i];
                    j++;
                }
                perc = String.valueOf(percentage);
                Log.d("perce" ,perc);
                //editor.putString(,perc );
                //editor.putString("Cotton", "This is Cotton");
                result = String.valueOf(res);
                Log.d("perce" ,result);
                Toast.makeText(MainActivity.this," "+perc,Toast.LENGTH_SHORT).show();
                //result = response.body().getResult();
                tv.setText(response.body().getResult());
                Intent start = new Intent(MainActivity.this,CropDetails.class);
                startActivity(start);
                Excel ex = new Excel();
                ex.main();
            }

            @Override
            public void onFailure(Call<MessageResult> call, Throwable throwable) {
                throwable.printStackTrace();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                tv.setText("Error");
            }
        });

    }

    public void getLocation(){

        gps = new GPSTracker(MainActivity.this);

        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            loc = "Location is - Lat: " + latitude + "\nLong: " + longitude;
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                    + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

    }

    public static String getRealPathFromURI(final Context context, final Uri uri) {


        // DocumentProvider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                // ExternalStorageProvider
                if (isExternalStorageDocument(uri)) {
                    final String docId = DocumentsContract.getDocumentId(uri);
                    final String[] split = docId.split(":");
                    final String type = split[0];

                    // This is for checking Main Memory
                    if ("primary".equalsIgnoreCase(type)) {
                        if (split.length > 1) {
                            return Environment.getExternalStorageDirectory() + "/" + split[1];
                        } else {
                            return Environment.getExternalStorageDirectory() + "/";
                        }
                        // This is for checking SD Card
                    } else {
                        return "storage" + "/" + docId.replace(":", "/");
                    }

                }
                // DownloadsProvider
                else if (isDownloadsDocument(uri)) {
                    String fileName = getFilePath(context, uri);
                    if (fileName != null) {
                        return Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName;
                    }

                    String id = DocumentsContract.getDocumentId(uri);
                    if (id.startsWith("raw:")) {
                        id = id.replaceFirst("raw:", "");
                        File file = new File(id);
                        if (file.exists())
                            return id;
                    }

                    final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                    return getDataColumn(context, contentUri, null, null);
                }
                // MediaProvider
                else if (isMediaDocument(uri)) {
                    final String docId = DocumentsContract.getDocumentId(uri);
                    final String[] split = docId.split(":");
                    final String type = split[0];

                    Uri contentUri = null;
                    if ("image".equals(type)) {
                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(type)) {
                        contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(type)) {
                        contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }

                    final String selection = "_id=?";
                    final String[] selectionArgs = new String[]{
                            split[1]
                    };

                    return getDataColumn(context, contentUri, selection, selectionArgs);
                }
            }
            // MediaStore (and general)
            else if ("content".equalsIgnoreCase(uri.getScheme())) {

                // Return the remote address
                if (isGooglePhotosUri(uri))
                    return uri.getLastPathSegment();

                return getDataColumn(context, uri, null, null);
            }
            // File
            else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }

        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    public static String getFilePath(Context context, Uri uri) {

        Cursor cursor = null;
        final String[] projection = {
                MediaStore.MediaColumns.DISPLAY_NAME
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, null, null,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }


    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }


    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
