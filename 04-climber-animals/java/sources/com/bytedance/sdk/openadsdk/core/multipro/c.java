package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.re;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ITTProvider {
    private static List<ITTProvider> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile c f2925ms;
    private static WeakReference<Context> xr;

    private boolean xr(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    static {
        List<ITTProvider> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        ah = listSynchronizedList;
        listSynchronizedList.add(new ah());
        ah.add(new com.bytedance.sdk.openadsdk.core.multipro.ms.xr());
        ah.add(new com.bytedance.sdk.openadsdk.core.multipro.ah.ms());
        ah.add(new ms(new com.bytedance.sdk.component.x.xr.xr.xr.ms("csj")));
        Iterator<ITTProvider> it = ah.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    public static c ms(Context context) {
        if (context != null) {
            xr = new WeakReference<>(context.getApplicationContext());
        }
        if (f2925ms == null) {
            synchronized (c.class) {
                if (f2925ms == null) {
                    f2925ms = new c();
                }
            }
        }
        return f2925ms;
    }

    private c() {
    }

    private ITTProvider ms(Uri uri) {
        if (uri == null || !xr(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (ITTProvider iTTProvider : ah) {
            if (str.equals(iTTProvider.getTableName())) {
                return iTTProvider;
            }
        }
        return null;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = xr;
        return (weakReference == null || weakReference.get() == null) ? re.getContext() : xr.get();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        Iterator<ITTProvider> it = ah.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            ITTProvider iTTProviderMs = ms(uri);
            if (iTTProviderMs != null) {
                return iTTProviderMs.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        try {
            ITTProvider iTTProviderMs = ms(uri);
            if (iTTProviderMs != null) {
                return iTTProviderMs.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            ITTProvider iTTProviderMs = ms(uri);
            if (iTTProviderMs != null) {
                return iTTProviderMs.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            ITTProvider iTTProviderMs = ms(uri);
            if (iTTProviderMs != null) {
                return iTTProviderMs.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            ITTProvider iTTProviderMs = ms(uri);
            if (iTTProviderMs != null) {
                return iTTProviderMs.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
