package c1m.m2a.m1g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u {
    public static String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : str + str2;
    }

    private static boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(String str, Context context) {
        b.a().a("MetaAdUtil", "isSupportAdAction action: ", str);
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        Intent intent = new Intent(str);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        return a(context, intent);
    }
}
