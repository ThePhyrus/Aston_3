package roman.bannikov.aston_3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;
import java.util.Arrays;


public class UseDefaultActivity extends AppCompatActivity {

    ImageView img;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initViews();
        getImage();
    }

    private void getImage() {
        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                String url = editText.getText().toString();
                new DownloadImage(img).execute(url);
                return true;
            }
            return false;
        });
    }

    private void initViews() {
        img = findViewById(R.id.ivImage);
        editText = findViewById(R.id.etUrl);
    }

    public void showToast() {
        Toast.makeText(getApplicationContext(), R.string.loading_error, Toast.LENGTH_LONG).show();
    }


    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(@NonNull String... urls) {
            String urlDisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                runOnUiThread(UseDefaultActivity.this::showToast);
                String TAG = getString(R.string.my_logs);
                Log.d(TAG, Arrays.toString(e.getStackTrace()));
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }


    }


}