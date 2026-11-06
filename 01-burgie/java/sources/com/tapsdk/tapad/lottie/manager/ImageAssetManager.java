package com.tapsdk.tapad.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tapsdk.tapad.lottie.ImageAssetDelegate;
import com.tapsdk.tapad.lottie.LottieImageAsset;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageAssetManager {
    private static final int MAX_DATA_URI_CHARS = 8388608;
    private static final int MAX_EMBEDDED_IMAGE_BYTES = 6291456;
    private static final int MAX_EMBEDDED_IMAGE_DIMENSION = 4096;
    private static final long MAX_EMBEDDED_IMAGE_PIXELS = 16777216;
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.imagesFolder;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.imagesFolder += '/';
            }
        }
        if (!(callback instanceof View)) {
            this.imageAssets = new HashMap();
            this.context = null;
        } else {
            this.context = ((View) callback).getContext();
            this.imageAssets = map;
            setDelegate(imageAssetDelegate);
        }
    }

    private static Bitmap decodeEmbeddedBitmap(String str) {
        if (str.length() > 8388608) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(str.indexOf(44) + 1), 0);
            if (bArrDecode.length != 0 && bArrDecode.length <= MAX_EMBEDDED_IMAGE_BYTES) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                int i = options.outWidth;
                int i2 = options.outHeight;
                long j = ((long) i) * ((long) i2);
                if (i > 0 && i2 > 0 && i <= 4096 && i2 <= 4096 && j <= MAX_EMBEDDED_IMAGE_PIXELS) {
                    try {
                        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, decodeOptions());
                    } catch (IllegalArgumentException e) {
                    } catch (OutOfMemoryError e2) {
                    }
                }
            }
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        }
    }

    private static BitmapFactory.Options decodeOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        return options;
    }

    private static Bitmap usableBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmapUsableBitmap = usableBitmap(lottieImageAsset.getBitmap());
        if (bitmapUsableBitmap != null) {
            return bitmapUsableBitmap;
        }
        synchronized (lottieImageAsset) {
            Bitmap bitmapUsableBitmap2 = usableBitmap(lottieImageAsset.getBitmap());
            if (bitmapUsableBitmap2 != null) {
                return bitmapUsableBitmap2;
            }
            ImageAssetDelegate imageAssetDelegate = this.delegate;
            if (imageAssetDelegate != null) {
                Bitmap bitmapUsableBitmap3 = usableBitmap(imageAssetDelegate.fetchBitmap(lottieImageAsset));
                if (bitmapUsableBitmap3 != null) {
                    lottieImageAsset.setBitmap(bitmapUsableBitmap3);
                }
                return bitmapUsableBitmap3;
            }
            String fileName = lottieImageAsset.getFileName();
            if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                Bitmap bitmapDecodeEmbeddedBitmap = decodeEmbeddedBitmap(fileName);
                if (bitmapDecodeEmbeddedBitmap != null) {
                    lottieImageAsset.setBitmap(bitmapDecodeEmbeddedBitmap);
                }
                return bitmapDecodeEmbeddedBitmap;
            }
            if (TextUtils.isEmpty(this.imagesFolder)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            BitmapFactory.Options optionsDecodeOptions = decodeOptions();
            try {
                InputStream inputStreamOpen = this.context.getAssets().open(this.imagesFolder + fileName);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, optionsDecodeOptions);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    if (bitmapDecodeStream == null) {
                        return null;
                    }
                    lottieImageAsset.setBitmap(bitmapDecodeStream);
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | IllegalArgumentException e) {
                return null;
            }
        }
    }

    public boolean hasSameContext(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    public void recycleBitmaps() {
        Iterator<Map.Entry<String, LottieImageAsset>> it = this.imageAssets.entrySet().iterator();
        while (it.hasNext()) {
            LottieImageAsset value = it.next().getValue();
            synchronized (value) {
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    value.setBitmap(null);
                }
            }
        }
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        synchronized (lottieImageAsset) {
            bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(bitmap);
        }
        return bitmap2;
    }
}
