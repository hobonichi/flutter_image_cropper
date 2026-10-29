package vn.hunghd.flutter.plugins.imagecropper;

import android.content.Intent;
import android.net.Uri;

import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.UCropView;

/**
 * UCropActivity that also reports the rotation angle the user applied.
 *
 * uCrop's result intent carries the crop offset and size (in the rotated bitmap's pixel
 * space) but not the angle, so the caller cannot restore or reproduce the crop without it.
 */
public class ImageCropperActivity extends UCropActivity {
    static final String EXTRA_OUTPUT_ANGLE = "vn.hunghd.flutter.plugins.imagecropper.OutputAngle";

    @Override
    protected void setResultUri(Uri uri, float resultAspectRatio, int offsetX, int offsetY, int imageWidth, int imageHeight) {
        UCropView cropView = findViewById(com.yalantis.ucrop.R.id.ucrop);
        float angle = cropView.getCropImageView().getCurrentAngle();
        setResult(RESULT_OK, new Intent()
                .putExtra(UCrop.EXTRA_OUTPUT_URI, uri)
                .putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, resultAspectRatio)
                .putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, imageWidth)
                .putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, imageHeight)
                .putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, offsetX)
                .putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, offsetY)
                .putExtra(EXTRA_OUTPUT_ANGLE, angle)
        );
    }
}
