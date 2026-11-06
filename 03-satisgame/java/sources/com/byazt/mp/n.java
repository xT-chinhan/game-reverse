package com.byazt.mp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.ITTProvider;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 19})
public class n implements ITTProvider {
    public Function<SparseArray<Object>, Object> n;

    public n(Object obj) {
        if (obj instanceof Function) {
            this.n = (Function) obj;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public void injectContext(Context context) {
        if (this.n != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999900);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-7999920, context);
            this.n.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public String getTableName() {
        if (this.n == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999901);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public void init() {
        if (this.n != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999902);
            sparseArray.put(-99999985, Void.class);
            this.n.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public String getType(Uri uri) {
        if (this.n == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999903);
        sparseArray.put(-99999985, String.class);
        sparseArray.put(-7999921, uri);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.n == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999904);
        sparseArray.put(-99999985, Cursor.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, strArr);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr2);
        sparseArray.put(-7999925, str2);
        return (Cursor) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (this.n == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999905);
        sparseArray.put(-99999985, Uri.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, contentValues);
        return (Uri) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        if (this.n != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999906);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            Integer num = (Integer) this.n.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (this.n != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999907);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999922, contentValues);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            Integer num = (Integer) this.n.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }
}
