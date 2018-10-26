package utility;

import android.content.Intent;
import android.provider.MediaStore;

public class PhotoUtility {

    public static Intent takeFromCamera(){
        return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    }

    public static Intent takeFromGallery(){
        return new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

}
