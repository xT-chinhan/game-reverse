package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ITTProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.ab.ah.ms.d f2882ms = new com.bytedance.sdk.component.ab.ah.ms.d();

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return this.f2882ms.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return this.f2882ms.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f2882ms.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.f2882ms.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f2882ms.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.f2882ms.update(uri, contentValues, str, strArr);
    }
}
