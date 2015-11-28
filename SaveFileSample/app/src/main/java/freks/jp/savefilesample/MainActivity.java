package freks.jp.savefilesample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button internalButton = (Button)findViewById(R.id.internal_button);
        internalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFile();
            }
        });

    }

    private void outputFile() {
        String filename = "myfile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();

            showSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSuccess() {
        Toast.makeText(MainActivity.this, "suceess", Toast.LENGTH_LONG).show();
    }
}
