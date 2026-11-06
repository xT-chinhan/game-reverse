package com.varbto.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SQLiteOpenHelper {
    public static i b;
    public static final HashSet c = new HashSet();
    public final ExecutorService a;

    public i(Context context) {
        super(context, "crash_data.db", (SQLiteDatabase.CursorFactory) null, 5);
        this.a = Executors.newSingleThreadExecutor();
    }

    public static synchronized i a(Context context) {
        if (b == null) {
            b = new i(context.getApplicationContext());
            if (f.a) {
                Log.d("CrashTimestampDbHelper", "CrashTimestampDbHelper instance created");
            }
        }
        return b;
    }

    public final JSONArray b(int i, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp FROM crash_timestamps WHERE timestamp >= ? AND category=? ORDER BY timestamp DESC", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000)), str});
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                while (cursorRawQuery.moveToNext()) {
                    jSONArray.put(simpleDateFormat.format(new Date(cursorRawQuery.getLong(0))));
                }
                cursorRawQuery.close();
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getTimestampsWithinDaysByCategory failed", th3);
            }
        }
        return jSONArray;
    }

    public final void c(final long j, final String str) {
        if (f.a) {
            Log.d("CrashTimestampDbHelper", "Inserting Crash timestamp: " + j);
        }
        this.a.execute(new Runnable() { // from class: com.varbto.internal.i$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(j, str);
            }
        });
    }

    public final /* synthetic */ void d(long j, String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(j));
            String strJoin = TextUtils.join(",", c);
            contentValues.put("pending_sdks", strJoin);
            contentValues.put("category", str);
            contentValues.put("server_status", (Integer) 0);
            contentValues.put("server_id", (String) null);
            writableDatabase.insert("crash_timestamps", null, contentValues);
            if (f.a) {
                Log.d("CrashTimestampDbHelper", "Crash timestamp inserted, pending SDKs: " + strJoin + ", category: " + str);
            }
        } catch (Throwable th) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "insertTimestamp failed", th);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE crash_timestamps (id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, pending_sdks TEXT, category TEXT, server_status INTEGER, server_id TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_crash_timestamp ON crash_timestamps(timestamp)");
        sQLiteDatabase.execSQL("CREATE TABLE crash_network_attributions (network_id TEXT NOT NULL, timestamp INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_network_id ON crash_network_attributions(network_id)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_network_ts ON crash_network_attributions(timestamp)");
        sQLiteDatabase.execSQL("CREATE TABLE crash_mediation_attributions (mediation_id TEXT NOT NULL, timestamp INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_mediation_id ON crash_mediation_attributions(mediation_id)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_mediation_ts ON crash_mediation_attributions(timestamp)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash_timestamps");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash_network_attributions");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash_mediation_attributions");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE crash_timestamps ADD COLUMN category TEXT");
            } catch (Throwable unused) {
            }
        }
        if (i < 3) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS crash_network_attributions (network_id TEXT NOT NULL, timestamp INTEGER NOT NULL)");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_network_id ON crash_network_attributions(network_id)");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_network_ts ON crash_network_attributions(timestamp)");
            } catch (Throwable unused2) {
            }
        }
        if (i < 4) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE crash_timestamps ADD COLUMN server_status INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE crash_timestamps ADD COLUMN server_id TEXT");
            } catch (Throwable unused3) {
            }
        }
        if (i < 5) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS crash_mediation_attributions (mediation_id TEXT NOT NULL, timestamp INTEGER NOT NULL)");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_mediation_id ON crash_mediation_attributions(mediation_id)");
                sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS idx_mediation_ts ON crash_mediation_attributions(timestamp)");
            } catch (Throwable unused4) {
            }
        }
    }

    public final HashMap c(int i) {
        HashMap map = new HashMap();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT network_id, COUNT(*) FROM crash_network_attributions WHERE timestamp>=? GROUP BY network_id", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
            while (cursorRawQuery.moveToNext()) {
                try {
                    map.put(cursorRawQuery.getString(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getNetworkCrashCountersWithinDays failed", th3);
            }
        }
        return map;
    }

    public final int a(int i) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM crash_timestamps WHERE timestamp >= ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
            try {
                int i2 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
                if (f.a) {
                    Log.d("CrashTimestampDbHelper", "Crash count within " + i + " days: " + i2);
                }
                cursorRawQuery.close();
                return i2;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getCountWithinDays failed", th3);
            }
            return 0;
        }
    }

    public final JSONArray d(int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp FROM crash_timestamps WHERE timestamp >= ? ORDER BY timestamp DESC", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                while (cursorRawQuery.moveToNext()) {
                    jSONArray.put(simpleDateFormat.format(new Date(cursorRawQuery.getLong(0))));
                }
                cursorRawQuery.close();
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getTimestampsWithinDays failed", th3);
            }
        }
        return jSONArray;
    }

    public final void b(final long j, final String str, final h hVar) {
        if (f.a) {
            Log.d("CrashTimestampDbHelper", "Marking Crash as sent, timestamp: " + j + ", SDK: " + str);
        }
        this.a.execute(new Runnable() { // from class: com.varbto.internal.i$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, str, hVar);
            }
        });
    }

    public final void b(final long j, final String str) {
        this.a.execute(new Runnable() { // from class: com.varbto.internal.i$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str, j);
            }
        });
    }

    public final /* synthetic */ void b(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("network_id", str);
            contentValues.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(j));
            writableDatabase.insert("crash_network_attributions", null, contentValues);
        } catch (Throwable th) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "insertNetworkAttribution failed", th);
            }
        }
    }

    public final int a(int i, String str) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM crash_timestamps WHERE timestamp >= ? AND category=?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000)), str});
            try {
                int i2 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
                if (f.a) {
                    Log.d("CrashTimestampDbHelper", "Crash count within " + i + " days for category " + str + ": " + i2);
                }
                cursorRawQuery.close();
                return i2;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getCountWithinDaysByCategory failed", th3);
            }
            return 0;
        }
    }

    public final void b(final int i, final String str, final long j) {
        this.a.execute(new Runnable() { // from class: com.varbto.internal.i$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, j);
            }
        });
    }

    public final HashMap b(int i) {
        HashMap map = new HashMap();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT mediation_id, COUNT(*) FROM crash_mediation_attributions WHERE timestamp>=? GROUP BY mediation_id", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
            while (cursorRawQuery.moveToNext()) {
                try {
                    map.put(cursorRawQuery.getString(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getMediationCrashCountersWithinDays failed", th3);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0038  */
    public final String a(long j) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT pending_sdks FROM crash_timestamps WHERE timestamp=?", new String[]{String.valueOf(j)});
            try {
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return null;
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getPendingSdks failed", th3);
            }
            return null;
        }
        if (f.a) {
            Log.e("CrashTimestampDbHelper", "getPendingSdks failed", th3);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    public final HashSet a(String str) {
        HashSet hashSet = new HashSet();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp,pending_sdks FROM crash_timestamps", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    long j = cursorRawQuery.getLong(0);
                    String string = cursorRawQuery.getString(1);
                    if (string != null && !string.isEmpty()) {
                        for (String str2 : string.split(",")) {
                            if (str2.equals(str)) {
                                hashSet.add(Long.valueOf(j));
                                break;
                            }
                            if (f.a) {
                                Log.e("CrashTimestampDbHelper", "getTimestampsPendingFor failed", th);
                            }
                            return hashSet;
                        }
                    }
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getTimestampsPendingFor failed", th3);
            }
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    public final HashSet a(String str, String str2) {
        HashSet hashSet = new HashSet();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp,pending_sdks,category FROM crash_timestamps", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    long j = cursorRawQuery.getLong(0);
                    String string = cursorRawQuery.getString(1);
                    String string2 = cursorRawQuery.getString(2);
                    if (string != null && !string.isEmpty() && str2.equals(string2)) {
                        for (String str3 : string.split(",")) {
                            if (str3.equals(str)) {
                                hashSet.add(Long.valueOf(j));
                                break;
                            }
                            if (f.a) {
                                Log.e("CrashTimestampDbHelper", "getTimestampsPendingForByCategory failed", th);
                            }
                            return hashSet;
                        }
                    }
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th3) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "getTimestampsPendingForByCategory failed", th3);
            }
        }
        return hashSet;
    }

    public final /* synthetic */ void a(long j, String str, h hVar) {
        try {
            String strA = a(j);
            if (strA != null && !strA.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : strA.split(",")) {
                    if (!str2.equals(str)) {
                        arrayList.add(str2);
                    }
                }
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("pending_sdks", TextUtils.join(",", arrayList));
                writableDatabase.update("crash_timestamps", contentValues, "timestamp=?", new String[]{String.valueOf(j)});
                if (!arrayList.isEmpty() || hVar == null) {
                    return;
                }
                if (f.a) {
                    Log.d("CrashTimestampDbHelper", "All Crash SDKs reported, triggering file delete callback");
                }
                try {
                    hVar.a(j);
                } catch (Throwable th) {
                    if (f.a) {
                        Log.e("CrashTimestampDbHelper", "onDelete callback failed", th);
                    }
                }
            }
        } catch (Throwable th2) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "markAsSent failed", th2);
            }
        }
    }

    public final /* synthetic */ void a(int i, String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("server_status", Integer.valueOf(i));
            contentValues.put("server_id", str);
            writableDatabase.update("crash_timestamps", contentValues, "timestamp=?", new String[]{String.valueOf(j)});
        } catch (Throwable th) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "updateServerStatus failed", th);
            }
        }
    }

    public final void a(final long j, final String str) {
        this.a.execute(new Runnable() { // from class: com.varbto.internal.i$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, j);
            }
        });
    }

    public final /* synthetic */ void a(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("mediation_id", str);
            contentValues.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(j));
            writableDatabase.insert("crash_mediation_attributions", null, contentValues);
        } catch (Throwable th) {
            if (f.a) {
                Log.e("CrashTimestampDbHelper", "insertMediationAttribution failed", th);
            }
        }
    }
}
