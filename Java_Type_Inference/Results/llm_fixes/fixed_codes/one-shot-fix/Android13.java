package androidExamples;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

//ID = 559902
public class Android13 {
    public static void main(String[] args) {
        Uri imageUri = null;
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        ByteArrayInputStream fileInputStream = new ByteArrayInputStream(bytes.toByteArray());
    }

    private static ContentResolver getContentResolver() {
        // TODO Auto-generated method stub
        return null;
    }
}