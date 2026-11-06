package com.byazt.wo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1668, 8})
public class s {
    public static volatile s n;
    public Uri qg;

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    private s() {
        if (com.byazt.qt.qg.getContext() != null) {
            this.qg = com.byazt.xp.n.n(Uri.parse("content://" + com.byazt.qt.qg.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform"), "gromore_prime_rit_adn_perform");
        }
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.byazt.qt.qg.getContext() == null || this.qg == null) {
            return;
        }
        ContentResolver contentResolver = com.byazt.qt.qg.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADN_NAME, str);
        contentValues.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put(a.C0017a.m, Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.qg, contentValues);
    }

    public List<qg> query(String str, String str2, long j, long j2) {
        String str3;
        String[] strArr;
        if (com.byazt.qt.qg.getContext() == null || this.qg == null) {
            return null;
        }
        ContentResolver contentResolver = com.byazt.qt.qg.getContext().getContentResolver();
        String[] strArr2 = {str, str2, String.valueOf(j), String.valueOf(j2)};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, String.valueOf(j), String.valueOf(j2)};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            strArr = strArr2;
        }
        Cursor cursorQuery = contentResolver.query(this.qg, null, str3, strArr, null);
        if (cursorQuery == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.EXTRA_ADN_NAME));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.KEY_GM_PRIME_RIT));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("adn_rit"));
                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_action"));
                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex(a.C0017a.m));
                qg qgVar = new qg();
                qgVar.s(string);
                qgVar.n(string2);
                qgVar.qg(string3);
                qgVar.q(string4);
                qgVar.n(j3);
                linkedList.add(qgVar);
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return linkedList;
    }

    public void n(String str, long j) {
        if (com.byazt.qt.qg.getContext() == null || this.qg == null || j <= 0) {
            return;
        }
        try {
            com.byazt.qt.qg.getContext().getContentResolver().delete(this.qg, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j)});
        } catch (IllegalStateException unused) {
        }
    }
}
