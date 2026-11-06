package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class DataBaseOperation {
    private static final String a = "VMS_SDK_DB";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "content://com.vivo.abe.exidentifier/guid";
    private static final String d = "value";
    private static final String e = "OAID";
    private static final String f = "AAID";
    private static final String g = "VAID";
    private static final String h = "OAIDBLACK";
    private static final String i = "OAIDSTATUS";
    private static final String j = "STATISTICS";
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = 4;
    private static final int p = 5;
    private static final int q = 6;
    private static final int r = 7;
    private static final String s = "UDID";
    private Context t;

    DataBaseOperation(Context context) {
        this.t = context;
    }

    boolean a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        if (i2 == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else {
            uri = i2 != 7 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            int iBulkInsert = this.t.getContentResolver().bulkInsert(uri, contentValuesArr);
            Log.d(a, "insert:" + iBulkInsert);
            return iBulkInsert != 0;
        } catch (Exception unused) {
            Log.e(a, "return insert is error");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007a A[Catch: Exception -> 0x009a, all -> 0x00a3, TRY_ENTER, TryCatch #0 {all -> 0x00a3, blocks: (B:26:0x007a, B:28:0x0080, B:29:0x008c, B:35:0x009a), top: B:45:0x0067 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0080 A[Catch: Exception -> 0x009a, all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:26:0x007a, B:28:0x0080, B:29:0x008c, B:35:0x009a), top: B:45:0x0067 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x008c A[Catch: Exception -> 0x009a, all -> 0x00a3, TRY_LEAVE, TryCatch #0 {all -> 0x00a3, blocks: (B:26:0x007a, B:28:0x0080, B:29:0x008c, B:35:0x009a), top: B:45:0x0067 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0093 A[PHI: r1 r9
      0x0093: PHI (r1v5 java.lang.String) = (r1v3 java.lang.String), (r1v7 java.lang.String) binds: [B:36:0x009f, B:30:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r9v7 android.database.Cursor) = (r9v6 android.database.Cursor), (r9v9 android.database.Cursor) binds: [B:36:0x009f, B:30:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v4 */
    String a(int i2, String str) {
        Uri uri;
        Uri uri2;
        ?? r9;
        Cursor cursorQuery;
        ?? r1 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            if (i2 == 0) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            } else if (i2 == 1) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
            } else if (i2 == 2) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
            } else if (i2 == 3) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
            } else {
                if (i2 != 4) {
                    if (i2 != 5) {
                        uri2 = null;
                        r9 = i2;
                    } else {
                        uri = Uri.parse(c);
                    }
                    if (uri2 == null) {
                        return null;
                    }
                    try {
                        cursorQuery = this.t.getContentResolver().query(uri2, null, null, null, null);
                        try {
                            if (cursorQuery != null) {
                                if (cursorQuery.moveToNext()) {
                                    string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                                }
                            } else {
                                Log.d(a, "return cursor is null,return");
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Exception unused) {
                            Log.e(a, "return cursor is error");
                            if (cursorQuery != null) {
                            }
                            return string;
                        }
                    } catch (Exception unused2) {
                        cursorQuery = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r1 != 0) {
                            r1.close();
                        }
                        throw th;
                    }
                    return string;
                }
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
            }
            if (uri2 == null) {
                return null;
            }
            cursorQuery = this.t.getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                }
            } else {
                Log.d(a, "return cursor is null,return");
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            r1 = r9;
        }
        uri2 = uri;
        r9 = uri;
    }

    boolean a(int i2, String str, String str2, String str3) {
        Uri uri = i2 != 6 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        if (uri == null) {
            return false;
        }
        try {
            int iDelete = this.t.getContentResolver().delete(uri, "packageName=? and uid=?", new String[]{str2, str3});
            Log.d(a, "delete:" + iDelete);
            return iDelete != 0;
        } catch (Exception unused) {
            Log.e(a, "return delete is error");
        }
    }
}
