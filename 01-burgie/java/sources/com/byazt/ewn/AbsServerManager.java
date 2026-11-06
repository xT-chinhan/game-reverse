package com.byazt.ewn;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 160, 1276})
public abstract class AbsServerManager extends ContentProvider {
    public static final String BUNDLE_BINDER = "binder";
    public static final String METHOD_QUERY_BINDER = "query_binder";
    public static final String PACKAGE_QUERY_BINDER = "package";
    public static final String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    public IBinder onBind(String str) {
        switch (str) {
            case "package":
                return com.byazt.qep.pr.hw();
            case "service":
                return com.byazt.wee.pr.hw();
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        IBinder iBinderOnBind;
        if (METHOD_QUERY_BINDER.equals(str) && (iBinderOnBind = onBind(str2)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(BUNDLE_BINDER, new pr(iBinderOnBind));
            return bundle2;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
