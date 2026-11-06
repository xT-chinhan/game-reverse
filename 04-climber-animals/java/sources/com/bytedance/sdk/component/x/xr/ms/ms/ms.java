package com.bytedance.sdk.component.x.xr.ms.ms;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.ka;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ms {
    private static volatile ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private xr f1563ms;
    private Context xr;

    public static ms ms(Context context) {
        if (ah == null) {
            synchronized (ms.class) {
                if (ah == null) {
                    ah = new ms(context);
                }
            }
        }
        return ah;
    }

    private ms(Context context) {
        try {
            this.xr = context.getApplicationContext();
            if (this.f1563ms == null) {
                this.f1563ms = new xr();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.xr;
    }

    public class xr {
        public xr() {
        }

        private SQLiteDatabase ms(ka kaVar) {
            try {
                SQLiteDatabase sQLiteDatabaseMs = kaVar.xr().ms(kaVar.getContext());
                if (sQLiteDatabaseMs == null || !sQLiteDatabaseMs.isOpen()) {
                    return null;
                }
                sQLiteDatabaseMs.setLockingEnabled(false);
                return sQLiteDatabaseMs;
            } catch (Throwable th) {
                sl.ms(th);
                if (xr(kaVar)) {
                    throw th;
                }
                return null;
            }
        }

        public void ms(ka kaVar, String str) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
                if (sQLiteDatabaseMs != null) {
                    sQLiteDatabaseMs.execSQL(str);
                }
            } catch (Throwable th) {
                if (xr(kaVar)) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Cursor query(ka kaVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Object[] objArr = 0;
            try {
                SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
                return sQLiteDatabaseMs != null ? sQLiteDatabaseMs.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                sl.ms(th);
                C0255ms c0255ms = new C0255ms();
                if (xr(kaVar)) {
                    throw th;
                }
                return c0255ms;
            }
        }

        public int update(ka kaVar, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
                if (sQLiteDatabaseMs != null) {
                    return sQLiteDatabaseMs.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                sl.ms(e);
                if (xr(kaVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(ka kaVar, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
                if (sQLiteDatabaseMs != null) {
                    return sQLiteDatabaseMs.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                sl.ms(e);
                if (xr(kaVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void insert(ka kaVar, String str, String str2, List<com.bytedance.sdk.component.x.ms.xr> list) {
            JSONObject jSONObjectAb;
            SQLiteDatabase sQLiteDatabaseMs = null;
            try {
                try {
                    sQLiteDatabaseMs = ms(kaVar);
                    if (sQLiteDatabaseMs != null) {
                        sQLiteDatabaseMs.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.bytedance.sdk.component.x.ms.xr xrVar = list.get(i);
                            if (xrVar != null && (jSONObjectAb = xrVar.ab()) != null) {
                                contentValues.put("id", xrVar.ah());
                                String strXr = kaVar.d().xr(jSONObjectAb.toString());
                                if (!TextUtils.isEmpty(strXr)) {
                                    contentValues.put(f.a.d, strXr);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabaseMs.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabaseMs.setTransactionSuccessful();
                        com.bytedance.sdk.component.x.xr.ah.ah.ms("DBHelper", str + " insert list size=" + list.size(), kaVar);
                    }
                    if (sQLiteDatabaseMs != null) {
                        sQLiteDatabaseMs.endTransaction();
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.x.xr.ah.ah.ms("DBHelper", str + " insert list error=" + list.size(), kaVar);
                    sl.ms(e);
                    if (xr(kaVar)) {
                        throw e;
                    }
                    if (sQLiteDatabaseMs != null) {
                        sQLiteDatabaseMs.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseMs != null) {
                    sQLiteDatabaseMs.endTransaction();
                }
                throw th;
            }
        }

        public int delete(ka kaVar, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
                if (sQLiteDatabaseMs != null) {
                    return sQLiteDatabaseMs.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                sl.ms(e);
                if (xr(kaVar)) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean xr(ka kaVar) {
            SQLiteDatabase sQLiteDatabaseMs = ms(kaVar);
            return sQLiteDatabaseMs != null && sQLiteDatabaseMs.inTransaction();
        }
    }

    public xr ms() {
        return this.f1563ms;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.x.xr.ms.ms.ms$ms, reason: collision with other inner class name */
    private class C0255ms extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private C0255ms() {
        }
    }
}
