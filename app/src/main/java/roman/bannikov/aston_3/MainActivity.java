package roman.bannikov.aston_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnFlags;
    Button btnFindImage;
    Button btnUseDefault;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    private void initButtons() {

        btnFlags = findViewById(R.id.btnOpenFlags);
        btnFlags.setOnClickListener(v -> {
            Intent i = new Intent(this, FlagsActivity.class);
            startActivity(i);
        });

        btnFindImage = findViewById(R.id.btnUsePicasso);
        btnFindImage.setOnClickListener(v -> {
            Intent i = new Intent(this, ImageActivity.class);
            startActivity(i);
        });

        btnUseDefault = findViewById(R.id.btnUseDefault);
        btnUseDefault.setOnClickListener(v -> {
            Intent i = new Intent(this, UseDefaultActivity.class);
            startActivity(i);
        });

        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v -> finish());
    }
}