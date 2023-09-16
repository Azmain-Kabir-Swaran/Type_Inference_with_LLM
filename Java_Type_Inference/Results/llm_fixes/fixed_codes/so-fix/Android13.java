package androidExamples;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//ID = 559902
public class Android13 {
    public static void main(String[] args) {
        Uri imageUri = null;
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 40, bytes);
        ByteArrayInputStream fileInputStream = new ByteArrayInputStream(bytes.toByteArray());
    }

    private static ContentResolver getContentResolver() {
        return null;
    }
}