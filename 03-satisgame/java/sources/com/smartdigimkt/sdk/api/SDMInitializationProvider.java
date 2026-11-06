package com.smartdigimkt.sdk.api;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.smartdigimkt.r3.c;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v3.a;
import com.smartdigimkt.v3.f;

/* JADX INFO: loaded from: classes3.dex */
public class SDMInitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
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
    public boolean onCreate() {
        try {
            Context context = getContext();
            if (context != null) {
                c.a().a((Application) context);
                SDKContext.getInstance().a(context.getApplicationContext());
            }
        } catch (Throwable unused) {
        }
        try {
            f fVarA = f.a();
            Context context2 = getContext();
            fVarA.getClass();
            com.smartdigimkt.q3.f.a().a(new a(fVarA, context2), 0L, 7);
            return true;
        } catch (Throwable unused2) {
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
