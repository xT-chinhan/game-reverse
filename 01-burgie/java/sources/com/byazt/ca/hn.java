package com.byazt.ca;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 20})
public final class hn {
    public static String pr(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String strEncodeToString = null;
        try {
            if (bitmap == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return strEncodeToString;
                }
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
        }
        return strEncodeToString;
    }

    public static Bitmap pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] hw(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
