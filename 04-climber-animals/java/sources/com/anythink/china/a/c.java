package com.anythink.china.a;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.anythink.china.activity.TransparentActivity;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final String a = "android.permission.READ_PHONE_STATE";
    public static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";

    public interface a {
        void a();
    }

    private static void a(Context context, a aVar, String... strArr) {
        if (context != null) {
            int iNextInt = new Random().nextInt(1000000000);
            if (aVar != null) {
                TransparentActivity.e.put(Integer.valueOf(iNextInt), aVar);
            }
            Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
            intent.putExtra("type", 1000);
            intent.putExtra(TransparentActivity.b, iNextInt);
            intent.putExtra(TransparentActivity.d, strArr);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            return;
        }
        Log.i("PermissionManager", "Build.VERSION.SDK_INT below 23 does not require permission");
    }

    public static boolean a(Context context, String str) {
        try {
            return ActivityCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
