import java.io.ByteArrayOutputStream;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import android.content.Context;
import android.content.ContentResolver;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        // TODO: Implement the getContentResolver method
        return null;
    }
}