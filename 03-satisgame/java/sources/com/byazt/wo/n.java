package com.byazt.wo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.anythink.core.common.f.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1668, 19})
public class n extends SQLiteOpenHelper {
    public static String n = "n";

    public n(Context context) {
        super(new com.byazt.qyu.n(context), "mediation_behavior.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            n(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gromore_prime_rit_adn_perform (id INTEGER PRIMARY KEY AUTOINCREMENT, adn_name TEXT NOT NULL , prime_rit TEXT NOT NULL , adn_rit TEXT NOT NULL ,ad_action TEXT NOT NULL ,time_stamp LONG DEFAULT 0)");
    }

    private void qg(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gromore_prime_rit_adn_perform ;");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.byazt.rb.qg.n(n, "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
            if (i > i2) {
                qg(sQLiteDatabase);
                n(sQLiteDatabase);
                com.byazt.rb.qg.n(n, "onUpgrade...Reverse installation Database reset - create table.....");
                return;
            }
            n(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    public void n(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString(MediationConstant.EXTRA_ADN_NAME);
            String asString2 = contentValues.getAsString(MediationConstant.KEY_GM_PRIME_RIT);
            String asString3 = contentValues.getAsString("adn_rit");
            String asString4 = contentValues.getAsString("ad_action");
            long jLongValue = contentValues.getAsLong(a.C0017a.m).longValue();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(MediationConstant.EXTRA_ADN_NAME, asString);
            contentValues2.put(MediationConstant.KEY_GM_PRIME_RIT, asString2);
            contentValues2.put("adn_rit", asString3);
            contentValues2.put("ad_action", asString4);
            contentValues2.put(a.C0017a.m, Long.valueOf(jLongValue));
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        writableDatabase.insert("gromore_prime_rit_adn_perform", null, contentValues2);
                        writableDatabase.close();
                    }
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    public Cursor n(String str, String[] strArr) {
        return getReadableDatabase().query("gromore_prime_rit_adn_perform", null, str, strArr, null, null, null);
    }

    public void qg(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("gromore_prime_rit_adn_perform", str, strArr);
        writableDatabase.close();
    }
}
