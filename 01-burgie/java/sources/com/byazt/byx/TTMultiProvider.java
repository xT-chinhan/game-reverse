package com.byazt.byx;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, 946, 947})
public class TTMultiProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (pr(uri) != null) {
            return pr(uri).query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return pr(uri) != null ? pr(uri).getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (pr(uri) != null) {
            return pr(uri).insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (pr(uri) != null) {
            return pr(uri).delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (pr(uri) != null) {
            return pr(uri).update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private ITTProvider pr(Uri uri) {
        if (TTAdSdk.getAdManager() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proto2_ittprovider", true);
        bundle.putInt("layerType", hw(uri));
        return new com.byazt.ul.pr(TTAdSdk.getAdManager().getExtra(Function.class, bundle));
    }

    private int hw(Uri uri) {
        try {
            return Integer.parseInt(uri.getQueryParameter("layerType"));
        } catch (Exception e) {
            return 0;
        }
    }
}
