package com.byazt.gm;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.cp.n;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 1004, 1005})
public class TTMultiProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (n(uri) != null) {
            return n(uri).query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return n(uri) != null ? n(uri).getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (n(uri) != null) {
            return n(uri).insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (n(uri) != null) {
            return n(uri).delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (n(uri) != null) {
            return n(uri).update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private ITTProvider n(Uri uri) {
        if (TTAdSdk.getAdManager() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proto2_ittprovider", true);
        bundle.putInt("layerType", qg(uri));
        return new com.byazt.mp.n(TTAdSdk.getAdManager().getExtra(Function.class, bundle));
    }

    private int qg(Uri uri) {
        try {
            return Integer.parseInt(uri.getQueryParameter("layerType"));
        } catch (Exception unused) {
            return 0;
        }
    }
}
