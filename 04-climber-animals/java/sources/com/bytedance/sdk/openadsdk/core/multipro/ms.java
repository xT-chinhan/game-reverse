package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ITTProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.x.xr.xr.xr.ms f2928ms;

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    public ms(com.bytedance.sdk.component.x.xr.xr.xr.ms msVar) {
        this.f2928ms = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            msVar.ms(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.ms();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.x.xr.xr.xr.ms msVar = this.f2928ms;
        if (msVar != null) {
            return msVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
