package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p3 {
    public static Bitmap a(String str) {
        Bitmap frameAtTime;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("widevine://")) {
                        mediaMetadataRetriever.setDataSource(str, new Hashtable());
                    } else {
                        mediaMetadataRetriever.setDataSource(str);
                    }
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    frameAtTime = null;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                mediaMetadataRetriever.release();
                frameAtTime = null;
            } catch (RuntimeException e4) {
                e4.printStackTrace();
                mediaMetadataRetriever.release();
                frameAtTime = null;
            }
            if (frameAtTime == null) {
                return null;
            }
            int width = frameAtTime.getWidth();
            int height = frameAtTime.getHeight();
            int iMax = Math.max(width, height);
            if (iMax <= 512) {
                return frameAtTime;
            }
            float f = 512.0f / iMax;
            return Bitmap.createScaledBitmap(frameAtTime, Math.round(width * f), Math.round(f * height), true);
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }
}
