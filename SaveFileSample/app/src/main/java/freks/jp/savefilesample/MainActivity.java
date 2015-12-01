package freks.jp.savefilesample;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button internalButton = (Button)findViewById(R.id.internal_button);
        internalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFileToInternalStorage();
            }
        });

        Button externalButton = (Button)findViewById(R.id.external_button);
        externalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFileToExternalStorage();
            }
        });

        Button publicButton = (Button)findViewById(R.id.public_button);
        publicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFileToPublicStorage();
            }
        });

        Button encodeButton = (Button)findViewById(R.id.encode_button);
        encodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputEncodedFile();
            }
        });
    }

    private void outputFileToInternalStorage() {
        String filename = "myfile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();

            show("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void outputFileToExternalStorage() {
        if (! isExternalStorageWritable()) {
            show("can not write");
        } else {
            File directory = getStorageDirectory(MainActivity.this, "sample");
            outputFile(directory);
        }
    }

    private void outputFileToPublicStorage() {
        if (! isExternalStorageWritable()) {
            show("can not write");
        } else {
            File directory;
            directory = getStoragePublicDirectory();
            outputFile(directory);
        }
    }

    private void outputFile(File directory) {
        File file = new File(directory, "test.txt");
        FileWriter fw = null;
        try {
            make_files_in_directory_visible_on_pc(file);

            fw = new FileWriter(file, true);
            fw.write("sample");
            fw.close();
            fw = null;

            show("create " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void outputEncodedFile() {
        File directory = getStorageDirectory(MainActivity.this, "sample");
        File file = new File(directory, "encode-sample.txt");
        make_files_in_directory_visible_on_pc(file);

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file, false), "SJIS")
            );
            out.append("sample");
            out.append(",");
            out.append("あああ");
            out.close();
            out = null;

            show("create " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private File getStorageDirectory(Context context, String directory) {
        File file = new File(context.getExternalFilesDir(null), directory);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                show("can not mkdir");
            }
        }
        return file;
    }

    private File getStoragePublicDirectory() {
        File file = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);

        if (!file.exists()) {
            if (!file.mkdirs()) {
                show("can not make" + file.getAbsolutePath());
            }
        }
        return file;
    }

    void make_files_in_directory_visible_on_pc(File file)
    {
        MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, null);
    }

    private void show(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
