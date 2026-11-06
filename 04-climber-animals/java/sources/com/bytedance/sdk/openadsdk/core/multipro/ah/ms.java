package com.bytedance.sdk.openadsdk.core.multipro.ah;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.multipro.ka;
import com.bytedance.sdk.openadsdk.core.re;
import com.tencent.bugly.Bugly;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ITTProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f2883ms;

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static ContentResolver ka() {
        try {
            if (re.getContext() != null) {
                return re.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean ms(String str) {
        return ms(str, "checkFrequency");
    }

    public static boolean xr(String str) {
        return ms(str, "checkAggFrequency");
    }

    public static boolean ms(String str, String str2) {
        if (re.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverKa = ka();
            if (contentResolverKa != null) {
                return "true".equals(contentResolverKa.getType(Uri.parse(c() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean ms() {
        return ah("isSilent");
    }

    public static boolean xr() {
        return ah("isAggSilent");
    }

    public static boolean ah(String str) {
        if (re.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverKa = ka();
            if (contentResolverKa != null) {
                return "true".equals(contentResolverKa.getType(Uri.parse(c() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String ah() {
        return d("maxRit");
    }

    public static String d() {
        return d("maxAggRit");
    }

    public static String d(String str) {
        if (re.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverKa = ka();
            if (contentResolverKa != null) {
                return contentResolverKa.getType(Uri.parse(c() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String c() {
        return ka.xr + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.f2883ms = context;
    }

    private Context getContext() {
        Context context = this.f2883ms;
        return context == null ? re.getContext() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ka.ms().ms(uri.getQueryParameter("rit")) ? "true" : Bugly.SDK_IS_DEV;
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ka.ms().d() ? "true" : Bugly.SDK_IS_DEV;
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ka.ms().ka();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ms.ms().ms(uri.getQueryParameter("rit")) ? "true" : Bugly.SDK_IS_DEV;
        }
        if ("isAggSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ms.ms().d() ? "true" : Bugly.SDK_IS_DEV;
        }
        if ("maxAggRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.u.ms.ms().ka();
        }
        return null;
    }
}
