package androidExamples;
import java.io.ByteArrayOutputStream;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import android.content.ContentResolver;
import java.io.FileNotFoundException;
import java.io.IOException;


//ID = 559902
public class Android13 {
	public static void main(String[] args) {
			Uri imageUri = null;
			Bitmap bitmap = null;
			try {
				bitmap = Media.getBitmap(getContentResolver(), imageUri);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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