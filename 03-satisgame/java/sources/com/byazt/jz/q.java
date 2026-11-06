package com.byazt.jz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.anythink.core.common.f.e;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2277, 5})
public class q {
    public String n() {
        return "t_sp";
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapQg;
        if (!uri.getPath().split("/")[2].equals("get_all") || (mapQg = s.qg(uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapQg.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = mapQg.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = "int";
            } else if (obj instanceof Long) {
                objArr[1] = "long";
            } else if (obj instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public String getType(Uri uri) {
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return new StringBuilder().append(s.n(uri.getQueryParameter("sp_file_name"), str2)).toString();
        }
        return s.n(uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get(e.a.d);
        if (obj != null) {
            s.n(uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            s.n(uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (s.n(uri.getQueryParameter("sp_file_name"), str2)) {
            s.qg(uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        insert(uri, contentValues);
        return 0;
    }
}
