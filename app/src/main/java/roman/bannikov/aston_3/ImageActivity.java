package roman.bannikov.aston_3;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class ImageActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initViews();
        showImage();
    }

    private void showImage() {
        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                String url = editText.getText().toString();
                Picasso.with(ImageActivity.this)
                        .load(url)
                        .networkPolicy(NetworkPolicy.NO_CACHE)
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .placeholder(R.drawable.ic_no_image)
                        .error(R.drawable.ic_error)
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Toast.makeText(
                                        ImageActivity.this,
                                        R.string.loading_error,
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                return true;
            }
            return false;
        });
    }

    private void initViews() {
        imageView = findViewById(R.id.ivImage);
        editText = findViewById(R.id.etUrl);
    }


}