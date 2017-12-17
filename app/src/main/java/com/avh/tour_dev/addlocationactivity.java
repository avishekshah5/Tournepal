package com.avh.tour_dev;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;

import java.io.ByteArrayOutputStream;

public class addlocationactivity extends AppCompatActivity {
    ImageView image1, image2;
    Button addimage1, addimage2, save;
    EditText locationname, address1, description, accomodation, feature, route, addedby;
    Bitmap bitmap;
    DatabaseHelperLocate databaseHelper1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlocation);
        databaseHelper1 = new DatabaseHelperLocate(this);
        image1 = findViewById(R.id.imageview1);
        image2 = findViewById(R.id.imageview2);

        locationname = findViewById(R.id.locationview);
        address1 = findViewById(R.id.addressview);
        description = findViewById(R.id.descriptionview);
        accomodation = findViewById(R.id.accomodationview);
        feature = findViewById(R.id.featureview);
        route = findViewById(R.id.routeview);
        addedby = findViewById(R.id.addedby);
        addimage1= findViewById(R.id.addimg1);
        addimage2= findViewById(R.id.addimg2);

        save= findViewById(R.id.add);

        addimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });
        addimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog2();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationvalue = locationname.getText().toString();
                String routevalue = route.getText().toString();
                String addressvalue = address1.getText().toString();
                String descriptionvalue = description.getText().toString();
                String accomodationvalue = accomodation.getText().toString();
                String featurevalue = feature.getText().toString();
                String addedbyvalue = addedby.getText().toString();
                if (locationvalue.isEmpty()) {
                    locationname.setError("cannot be empty");
                } else if (addressvalue.isEmpty()) {
                    address1.setError("cannot be empty");
                } else if (descriptionvalue.isEmpty()) {
                    description.setError("cannot be empty");
                } else if (accomodationvalue.isEmpty()) {
                    accomodation.setError("cannot be empty");
                } else if (addedbyvalue.isEmpty()) {
                    addedby.setError("provide your id");
                } else {
                    ContentValues cv = new ContentValues();
                    cv.put("locationname", locationvalue);
                    cv.put("address1", addressvalue);
                    cv.put("description", descriptionvalue);
                    cv.put("accomodation", accomodationvalue);
                    cv.put("feature", featurevalue);
                    cv.put("route", routevalue);
                    cv.put("addedby", addedbyvalue);
                    cv.put("image1", getBlob(bitmap));
                    cv.put("image2", getBlob(bitmap));

                    databaseHelper1.insertlocation(cv);

                    Intent i = new Intent(addlocationactivity.this, locationlist.class);

                    startActivity(i);
                    Toast.makeText(addlocationactivity.this,"thank you your location is shared",Toast.LENGTH_LONG).show();


                }

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void showAlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Choose from Gallery or take picture");
        dialog.setMessage("From Gallery or Take Picutre");
        dialog.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, 102);


            }
        });
        dialog.setNegativeButton("Take Picture", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 101);

            }
        });
        dialog.show();
    }

    public void showAlertDialog2() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Choose from Gallery or take picture");
        dialog.setMessage("From Gallery or Take Picutre");
        dialog.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, 103);


            }
        });
        dialog.setNegativeButton("Take Picture", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 104);

            }
        });
        dialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 101 && data != null) {
            bitmap = (Bitmap) data.getExtras().get("data");
            image1.setImageBitmap(bitmap);

        }
       else if (requestCode == 104 && data != null) {
            bitmap = (Bitmap) data.getExtras().get("data");
            image2.setImageBitmap(bitmap);

        }

        else if (requestCode == 103 && data != null) {

            Uri pickedimage = data.getData();
            String[] filepath = {MediaStore.Images.Media.DATA};
            assert pickedimage != null;
            Cursor cursor1 = getContentResolver().query(pickedimage, filepath, null, null, null);
            assert cursor1 != null;
            cursor1.moveToFirst();
            int columnIndex = cursor1.getColumnIndex(filepath[0]);
            String imagepath = cursor1.getString(columnIndex);
            cursor1.close();
            Log.i("path,", "path:" + imagepath);

            bitmap = BitmapFactory.decodeFile(imagepath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100, bos);

            image2.setImageBitmap(bitmap);

        }



        else if (requestCode == 102 && data != null) {

            Uri pickedimage = data.getData();
            String[] filepath = {MediaStore.Images.Media.DATA};
            assert pickedimage != null;
            Cursor cursor1 = getContentResolver().query(pickedimage, filepath, null, null, null);
            assert cursor1 != null;
            cursor1.moveToFirst();
            int columnIndex = cursor1.getColumnIndex(filepath[0]);
            String imagepath = cursor1.getString(columnIndex);
            cursor1.close();
            Log.i("path,", "path:" + imagepath);

            bitmap = BitmapFactory.decodeFile(imagepath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100, bos);

            image1.setImageBitmap(bitmap);


        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public static byte[] getBlob(Bitmap bitmap) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        return bos.toByteArray();
    }

    public static Bitmap getBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    /*public Action getIndexApiAction() {
       / Thing object = new Thing.Builder()
                .setName("addlocationactivity Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }*/
}
