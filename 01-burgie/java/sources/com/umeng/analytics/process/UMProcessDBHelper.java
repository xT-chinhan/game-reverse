package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    private class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.d, ""), (JSONArray) obj);
            return true;
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        mInstance.mContext = context;
        return mInstance;
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) throws Throwable {
        if (!AnalyticsConstants.SUB_PROCESS_EVENT || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(b.b(this.mContext, str));
        if (file.exists()) {
            this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
        } else {
            insertEvents(str, jSONArray);
        }
    }

    public void insertEvents(String str, JSONArray jSONArray) throws Throwable {
        if (!AnalyticsConstants.SUB_PROCESS_EVENT || TextUtils.isEmpty(str)) {
            return;
        }
        insertEvents_(str, datasAdapter(str, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) throws Throwable {
        if (!dbIsExists(str)) {
            return;
        }
        List<a> eventByProcess = readEventByProcess(str);
        if (!eventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, eventByProcess)) {
            deleteEventDatas(str, null, eventByProcess);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0155  */
    /* JADX WARN: Code duplicated, block: B:58:0x015a A[Catch: Throwable -> 0x0187, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Throwable -> 0x0187, blocks: (B:58:0x015a, B:73:0x0183), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:81:0x019b  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public JSONObject readMainEvents(long j, List<Integer> list) throws Throwable {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorQuery;
        JSONObject jSONObject = new JSONObject();
        String str = "";
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorQuery = sQLiteDatabaseA.query(com.umeng.analytics.process.a.InterfaceC0282a.a, null, null, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            while (cursorQuery.moveToNext()) {
                                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("__t"));
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("__i"));
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("__s"));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(com.umeng.analytics.process.a.InterfaceC0282a.f));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                if (!TextUtils.isEmpty(string)) {
                                    if (TextUtils.isEmpty(str)) {
                                        str = string4;
                                    }
                                    if (!TextUtils.isEmpty(string2) && i2 == 2049) {
                                        JSONObject jSONObject3 = new JSONObject(com.umeng.common.a.a().b(string2));
                                        String strOptString = jSONObject3.optString("pn");
                                        if (TextUtils.isEmpty(strOptString) || "unknown".equals(strOptString)) {
                                            jSONObject3.put("pn", this.mContext.getPackageName() + ":" + string3);
                                        }
                                        JSONArray jSONArrayOptJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                        if (q.a(jSONObject3) + q.a(jSONArrayOptJSONArray) > j || !str.equalsIgnoreCase(string4)) {
                                            break;
                                            break;
                                        }
                                        list.add(Integer.valueOf(i));
                                        jSONArrayOptJSONArray.put(jSONObject3);
                                        jSONObject2.put(string, jSONArrayOptJSONArray);
                                    }
                                }
                            }
                            if (jSONObject2.length() > 0) {
                                JSONArray jSONArray = new JSONArray();
                                Iterator<String> itKeys = jSONObject2.keys();
                                while (itKeys.hasNext()) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    String next = itKeys.next();
                                    jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                                    if (jSONObject4.length() > 0) {
                                        jSONArray.put(jSONObject4);
                                    }
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put("ekv", jSONArray);
                                }
                            }
                            sQLiteDatabaseA.setTransactionSuccessful();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                        } catch (Exception e) {
                            sQLiteDatabase = sQLiteDatabaseA;
                            try {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建子进程事件数据异常，清除数据库数据。");
                                sQLiteDatabase.execSQL("delete from __et_p");
                                sQLiteDatabase.setTransactionSuccessful();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                return jSONObject;
                            } catch (Throwable th2) {
                                th = th2;
                                sQLiteDatabaseA = sQLiteDatabase;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                    try {
                                        sQLiteDatabaseA.endTransaction();
                                    } catch (Throwable th3) {
                                    }
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                            throw th;
                        }
                    } else {
                        sQLiteDatabaseA.setTransactionSuccessful();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    }
                } catch (Exception e2) {
                    cursorQuery = null;
                } catch (Throwable th5) {
                    th = th5;
                    cursorQuery = null;
                }
            } catch (Throwable th6) {
            }
        } catch (Exception e3) {
            cursorQuery = null;
        } catch (Throwable th7) {
            th = th7;
            sQLiteDatabaseA = null;
            cursorQuery = null;
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054 A[PHI: r1
      0x0054: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = (r1v4 android.database.sqlite.SQLiteDatabase), (r1v8 android.database.sqlite.SQLiteDatabase) binds: [B:23:0x0052, B:9:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    sQLiteDatabaseA.delete(com.umeng.analytics.process.a.InterfaceC0282a.a, "id=?", new String[]{String.valueOf(it.next())});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (Exception e) {
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (Throwable th) {
                th = th;
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                throw th;
            }
        } catch (Exception e2) {
            sQLiteDatabaseA = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseA = null;
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066 A[PHI: r0
      0x0066: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = (r0v3 android.database.sqlite.SQLiteDatabase), (r0v7 android.database.sqlite.SQLiteDatabase) binds: [B:29:0x0064, B:15:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    public void deleteEventDatas(String str, String str2, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
            try {
                sQLiteDatabaseA.beginTransaction();
                int size = list.size();
                if (list == null || size <= 0) {
                    sQLiteDatabaseA.delete(com.umeng.analytics.process.a.InterfaceC0282a.a, null, null);
                } else {
                    for (int i = 0; i < size; i++) {
                        sQLiteDatabaseA.execSQL("delete from __et_p where rowid=" + list.get(i).a);
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (Exception e) {
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception e2) {
            sQLiteDatabaseA = null;
        } catch (Throwable th3) {
            sQLiteDatabaseA = null;
            th = th3;
        }
        c.a(this.mContext).b(str);
    }

    private boolean insertEvents_(String str, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    for (a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", aVar.b);
                            contentValues.put("__e", aVar.c);
                            contentValues.put("__t", Integer.valueOf(aVar.e));
                            contentValues.put(com.umeng.analytics.process.a.InterfaceC0282a.f, aVar.f);
                            contentValues.put("__av", aVar.g);
                            contentValues.put("__vc", aVar.h);
                            contentValues.put("__s", aVar.d);
                            sQLiteDatabaseA.insert(com.umeng.analytics.process.a.InterfaceC0282a.a, null, contentValues);
                        } catch (Exception e) {
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable th) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return true;
                } catch (Exception e2) {
                    if (sQLiteDatabaseA != null) {
                        try {
                            sQLiteDatabaseA.endTransaction();
                        } catch (Throwable th2) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable th4) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception e3) {
            sQLiteDatabaseA = null;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabaseA = null;
        }
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0074 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:21:0x006c, B:25:0x0074), top: B:57:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a3 A[Catch: Exception -> 0x009f, TRY_LEAVE, TryCatch #1 {Exception -> 0x009f, blocks: (B:39:0x009b, B:43:0x00a3), top: B:59:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c0 A[Catch: Exception -> 0x00bc, TRY_LEAVE, TryCatch #2 {Exception -> 0x00bc, blocks: (B:49:0x00b8, B:53:0x00c0), top: B:61:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v18, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v9 */
    public JSONObject readVersionInfoFromColumId(Integer num) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Throwable th;
        JSONObject jSONObject;
        Exception e;
        ?? Query;
        JSONObject jSONObject2 = null;
        try {
            try {
                sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Query = sQLiteDatabaseA.query(com.umeng.analytics.process.a.InterfaceC0282a.a, null, "rowid=?", new String[]{String.valueOf((Object) num)}, null, null, null);
                    if (Query != 0) {
                        try {
                            if (Query.moveToNext()) {
                                jSONObject = new JSONObject();
                                try {
                                    String string = Query.getString(Query.getColumnIndex("__av"));
                                    String string2 = Query.getString(Query.getColumnIndex("__vc"));
                                    if (!TextUtils.isEmpty(string)) {
                                        jSONObject.put("__av", string);
                                    }
                                    if (!TextUtils.isEmpty(string2)) {
                                        jSONObject.put("__vc", string2);
                                    }
                                    jSONObject2 = jSONObject;
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (Query != 0) {
                                        try {
                                            Query.close();
                                            if (sQLiteDatabaseA != null) {
                                                sQLiteDatabaseA.endTransaction();
                                            }
                                        } catch (Exception e3) {
                                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                            return jSONObject;
                                        }
                                    } else if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                    return jSONObject;
                                }
                            }
                        } catch (Exception e4) {
                            jSONObject = null;
                            e = e4;
                        }
                    }
                    if (Query != 0) {
                        try {
                            Query.close();
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                        } catch (Exception e5) {
                        }
                    } else if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Exception e6) {
                    e = e6;
                    jSONObject = null;
                    e = e;
                    Query = jSONObject;
                    e.printStackTrace();
                    if (Query != 0) {
                        Query.close();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } else if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    num = 0;
                    if (num != 0) {
                        try {
                            num.close();
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                        } catch (Exception e7) {
                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                            throw th;
                        }
                    } else if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e8) {
            e = e8;
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable th4) {
            sQLiteDatabaseA = null;
            th = th4;
            num = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2 A[Catch: Exception -> 0x00ce, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ce, blocks: (B:37:0x00ca, B:41:0x00d2), top: B:45:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private List<a> readEventByProcess(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorQuery;
        Exception e;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                sQLiteDatabaseA = c.a(this.mContext).a(str);
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorQuery = sQLiteDatabaseA.query(com.umeng.analytics.process.a.InterfaceC0282a.a, null, null, null, null, null, null);
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                try {
                                    a aVar = new a();
                                    aVar.a = cursorQuery.getInt(0);
                                    aVar.b = cursorQuery.getString(cursorQuery.getColumnIndex("__i"));
                                    aVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("__e"));
                                    aVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("__s"));
                                    aVar.e = cursorQuery.getInt(cursorQuery.getColumnIndex("__t"));
                                    aVar.f = cursorQuery.getString(cursorQuery.getColumnIndex(com.umeng.analytics.process.a.InterfaceC0282a.f));
                                    aVar.g = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                    aVar.h = cursorQuery.getString(cursorQuery.getColumnIndex("__vc"));
                                    arrayList.add(aVar);
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                    } catch (Exception e3) {
                                        c.a(this.mContext).b(str);
                                        throw th;
                                    }
                                } else if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.endTransaction();
                                }
                                c.a(this.mContext).b(str);
                                throw th;
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (Exception e4) {
                    cursorQuery = null;
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.endTransaction();
                        }
                    } else if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(str);
                    throw th;
                }
            } catch (Exception e5) {
            }
        } catch (Exception e6) {
            cursorQuery = null;
            e = e6;
            sQLiteDatabaseA = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseA = null;
            cursorQuery = null;
        }
        c.a(this.mContext).b(str);
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            if (new File(b.b(this.mContext, str)).exists()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private class a implements Serializable {
        int a;
        String b;
        String c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    private int getDataSource() {
        return 0;
    }

    private boolean processIsService(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
        }
    }
}
