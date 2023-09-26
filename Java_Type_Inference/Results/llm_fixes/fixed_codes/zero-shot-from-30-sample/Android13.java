package androidExamples;

import android.net.Uri;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import android.content.ContentResolver;
import android.provider.MediaStore; // Add this import statement
import java.io.FileNotFoundException;

public class Android13 {
	public static void main(String[] args) {
			Uri imageUri = null;
			Bitmap bitmap = null;
			try {
				bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri); // Update this line
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