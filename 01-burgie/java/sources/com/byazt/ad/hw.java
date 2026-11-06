package com.byazt.ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.bu.hn;
import com.byazt.bu.x;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 13})
public class hw implements com.byazt.nq.hw.pr {
    public Context pr;

    @Override // com.byazt.nq.hw.pr
    public void injectContext(Context context) {
        this.pr = context;
    }

    @Override // com.byazt.nq.hw.pr
    public String getTableName() {
        return "t_db";
    }

    @Override // com.byazt.nq.hw.pr
    public void init() {
    }

    private boolean pr(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context getContext() {
        Context context = this.pr;
        return context == null ? a.getContext() : context;
    }

    @Override // com.byazt.nq.hw.pr
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArrSplit;
        if (!pr(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str3 = strArrSplit[2];
            String str4 = strArrSplit[3];
            x xVarPr = pr(str3);
            if (xVarPr != null) {
                return xVarPr.query(str4, strArr, str, strArr2, null, null, str2);
            }
            return null;
        }
        return null;
    }

    private x pr(String str) {
        if ("ttopensdk.db".equals(str)) {
            return hn.pr(getContext()).pr();
        }
        if ("ttopensdk2.db".equals(str)) {
            return com.byazt.bu.pr.pr(getContext()).pr();
        }
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (pr(uri) || (strArrSplit = uri.getPath().split("/")) == null || strArrSplit.length < 5) {
            return null;
        }
        String str = strArrSplit[2];
        String str2 = strArrSplit[4];
        x xVarPr = pr(str);
        if (xVarPr != null) {
            if ("execSQL".equals(str2)) {
                String queryParameter = uri.getQueryParameter("sql");
                if (!TextUtils.isEmpty(queryParameter)) {
                    xVarPr.pr(Uri.decode(queryParameter));
                }
            } else if ("transactionBegin".equals(str2)) {
                xVarPr.hn();
            } else if ("transactionSetSuccess".equals(str2)) {
                xVarPr.x();
            } else if ("transactionEnd".equals(str2)) {
                xVarPr.c();
            }
        }
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (pr(uri) || (strArrSplit = uri.getPath().split("/")) == null || strArrSplit.length < 4) {
            return null;
        }
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        x xVarPr = pr(str);
        if (xVarPr != null) {
            xVarPr.insert(str2, null, contentValues);
        }
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public int delete(Uri uri, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (pr(uri) || (strArrSplit = uri.getPath().split("/")) == null || strArrSplit.length < 4) {
            return 0;
        }
        String str2 = strArrSplit[2];
        String str3 = strArrSplit[3];
        x xVarPr = pr(str2);
        if (xVarPr != null) {
            xVarPr.delete(str3, str, strArr);
        }
        return 0;
    }

    @Override // com.byazt.nq.hw.pr
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (pr(uri) || (strArrSplit = uri.getPath().split("/")) == null || strArrSplit.length < 4) {
            return 0;
        }
        String str2 = strArrSplit[2];
        String str3 = strArrSplit[3];
        x xVarPr = pr(str2);
        if (xVarPr != null) {
            xVarPr.update(str3, contentValues, str, strArr);
        }
        return 0;
    }
}
