package com.bytedance.sdk.openadsdk.core.multipro.ms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.ab;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ITTProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f2929ms;

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.f2929ms = context;
    }

    private boolean ms(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context getContext() {
        Context context = this.f2929ms;
        return context == null ? re.getContext() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArrSplit;
        if (!ms(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str3 = strArrSplit[2];
            String str4 = strArrSplit[3];
            if ("ttopensdk.db".equals(str3)) {
                return ab.ms(getContext()).ms().query(str4, strArr, str, strArr2, null, null, str2);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (!ms(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 5) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[4];
            if ("ttopensdk.db".equals(str)) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        ab.ms(getContext()).ms().ms(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    ab.ms(getContext()).ms().ah();
                } else if ("transactionSetSuccess".equals(str2)) {
                    ab.ms(getContext()).ms().d();
                } else if ("transactionEnd".equals(str2)) {
                    ab.ms(getContext()).ms().ka();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (!ms(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            if ("ttopensdk.db".equals(str)) {
                ab.ms(getContext()).ms().insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit;
        if (!ms(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            if ("ttopensdk.db".equals(str2)) {
                return ab.ms(getContext()).ms().delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String[] strArrSplit;
        if (!ms(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            if ("ttopensdk.db".equals(str2)) {
                return ab.ms(getContext()).ms().update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }
}
