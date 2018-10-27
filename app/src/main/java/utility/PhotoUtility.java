package utility;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotoUtility {

    public static Intent takeFromCamera(){
        return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    }

    public static Intent takeFromGallery(){
        return new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    @BindingAdapter({"app:srcCompat"})
    public static void setImage(ImageView view, Uri photoUrl){

        Picasso.get()
                .load(photoUrl)
                .into(view);
    }
}
