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
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SQLiteOpenHelper {
    public static c b;
    public static final Set c = Collections.synchronizedSet(new HashSet());
    public final ExecutorService a;

    public c(Context context) {
        super(context, "anr_data.db", (SQLiteDatabase.CursorFactory) null, 4);
        this.a = Executors.newSingleThreadExecutor();
    }

    public static synchronized c a(Context context) {
        if (b == null) {
            b = new c(context.getApplicationContext());
            if (f.a) {
                Log.d("AnrTimestampDbHelper", "AnrTimestampDbHelper instance created");
            }
        }
        return b;
    }

    public final JSONArray b(int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp FROM anr_timestamps WHERE timestamp >= ? ORDER BY timestamp DESC", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
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
                Log.e("AnrTimestampDbHelper", "getTimestampsWithinDays failed", th3);
            }
        }
        return jSONArray;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE anr_timestamps (id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, pending_sdks TEXT, source TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_timestamp ON anr_timestamps(timestamp)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anr_timestamps");
        sQLiteDatabase.execSQL("CREATE TABLE anr_timestamps (id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, pending_sdks TEXT, source TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX idx_timestamp ON anr_timestamps(timestamp)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anr_timestamps");
            sQLiteDatabase.execSQL("CREATE TABLE anr_timestamps (id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, pending_sdks TEXT, source TEXT)");
            sQLiteDatabase.execSQL("CREATE INDEX idx_timestamp ON anr_timestamps(timestamp)");
        } else if (i < 4) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE anr_timestamps ADD COLUMN source TEXT");
            } catch (Throwable th) {
                if (f.a) {
                    Log.e("AnrTimestampDbHelper", "onUpgrade add source column failed", th);
                }
            }
        }
    }

    public final void a(final long j, final String str) {
        final String strJoin;
        if (f.a) {
            Log.d("AnrTimestampDbHelper", "Inserting ANR timestamp: " + j + ", source: " + str + ", registeredSdks: " + c);
        }
        Set set = c;
        synchronized (set) {
            strJoin = TextUtils.join(",", set);
        }
        if (f.a) {
            Log.d("AnrTimestampDbHelper", "insertTimestamp: pendingSdks to save = " + strJoin);
        }
        this.a.execute(new Runnable() { // from class: com.varbto.internal.c$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, strJoin, str);
            }
        });
    }

    public final /* synthetic */ void a(long j, String str, String str2) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(j));
            contentValues.put("pending_sdks", str);
            contentValues.put("source", str2);
            writableDatabase.insert(com.anythink.core.common.d.s.m, null, contentValues);
            if (f.a) {
                Log.d("AnrTimestampDbHelper", "ANR timestamp inserted, source: " + str2 + ", pending SDKs: " + str);
            }
        } catch (Throwable th) {
            if (f.a) {
                Log.e("AnrTimestampDbHelper", "insertTimestamp failed", th);
            }
        }
    }

    public final boolean a(long j) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT 1 FROM anr_timestamps WHERE timestamp >= ? AND timestamp <= ? LIMIT 1", new String[]{String.valueOf(j - 10000), String.valueOf(j + 10000)});
            try {
                boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                cursorRawQuery.close();
                return zMoveToFirst;
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
                Log.e("AnrTimestampDbHelper", "existsTimestampNear failed", th3);
            }
            return false;
        }
    }

    public final void b(final long j, final String str, final b bVar) {
        if (f.a) {
            Log.d("AnrTimestampDbHelper", "Marking as sent, timestamp: " + j + ", SDK: " + str);
        }
        this.a.execute(new Runnable() { // from class: com.varbto.internal.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(j, str, bVar);
            }
        });
    }

    public final int a(int i) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM anr_timestamps WHERE timestamp >= ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) i) * 86400000))});
            try {
                int i2 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
                if (f.a) {
                    Log.d("AnrTimestampDbHelper", "ANR count within " + i + " days: " + i2);
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
                Log.e("AnrTimestampDbHelper", "getCountWithinDays failed", th3);
            }
            return 0;
        }
    }

    public final HashSet a(final String str) {
        final HashSet hashSet = new HashSet();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.a.execute(new Runnable() { // from class: com.varbto.internal.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, hashSet, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        if (f.a) {
            Log.d("AnrTimestampDbHelper", "getTimestampsPendingFor: result size=" + hashSet.size());
        }
        return hashSet;
    }

    public final /* synthetic */ void a(String str, Set set, CountDownLatch countDownLatch) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT timestamp,pending_sdks FROM anr_timestamps", null);
            try {
                if (f.a) {
                    Log.d("AnrTimestampDbHelper", "getTimestampsPendingFor: sdkName=" + str);
                }
                while (cursorRawQuery.moveToNext()) {
                    long j = cursorRawQuery.getLong(0);
                    String string = cursorRawQuery.getString(1);
                    if (f.a) {
                        Log.d("AnrTimestampDbHelper", "getTimestampsPendingFor: ts=" + j + " pending=" + string);
                    }
                    if (string != null && !string.isEmpty()) {
                        for (String str2 : string.split(",")) {
                            if (str2.trim().equals(str)) {
                                set.add(Long.valueOf(j));
                                if (!f.a) {
                                    break;
                                }
                                Log.d("AnrTimestampDbHelper", "getTimestampsPendingFor: matched ts=" + j);
                                break;
                            }
                        }
                    }
                }
                cursorRawQuery.close();
                countDownLatch.countDown();
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
            try {
                if (f.a) {
                    Log.e("AnrTimestampDbHelper", "getTimestampsPendingFor failed", th3);
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public final /* synthetic */ void a(long j, String str, b bVar) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT pending_sdks FROM anr_timestamps WHERE timestamp=?", new String[]{String.valueOf(j)});
                try {
                    String string = cursorRawQuery.moveToFirst() ? cursorRawQuery.getString(0) : null;
                    cursorRawQuery.close();
                    if (string != null && !string.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : string.split(",")) {
                            if (!str2.equals(str)) {
                                arrayList.add(str2);
                            }
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("pending_sdks", TextUtils.join(",", arrayList));
                        writableDatabase.update(com.anythink.core.common.d.s.m, contentValues, "timestamp=?", new String[]{String.valueOf(j)});
                        writableDatabase.setTransactionSuccessful();
                        if (arrayList.isEmpty() && bVar != null) {
                            if (f.a) {
                                Log.d("AnrTimestampDbHelper", "All SDKs reported, triggering file delete callback");
                            }
                            try {
                                bVar.a(j);
                            } catch (Throwable th) {
                                if (f.a) {
                                    Log.e("AnrTimestampDbHelper", "onDelete callback failed", th);
                                }
                            }
                        }
                        writableDatabase.endTransaction();
                        return;
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th2) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                writableDatabase.endTransaction();
                throw th4;
            }
        } catch (Throwable th5) {
            if (f.a) {
                Log.e("AnrTimestampDbHelper", "markAsSent failed", th5);
            }
        }
    }
}
