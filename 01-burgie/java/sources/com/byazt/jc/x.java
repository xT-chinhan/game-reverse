package com.byazt.jc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 120, 121})
public class x {
    public String pr() {
        return "t_sp";
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapHw;
        if (uri.getPath().split("/")[2].equals("get_all") && (mapHw = hn.hw(uri.getQueryParameter("sp_file_name"))) != null) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
            for (String str3 : mapHw.keySet()) {
                Object[] objArr = new Object[3];
                objArr[0] = str3;
                Object obj = mapHw.get(str3);
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
        return null;
    }

    public String getType(Uri uri) {
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return new StringBuilder().append(hn.pr(uri.getQueryParameter("sp_file_name"), str2)).toString();
        }
        return hn.pr(uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get(Constants.VALUE_FIELD);
        if (obj != null) {
            hn.pr(uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            hn.pr(uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (hn.pr(uri.getQueryParameter("sp_file_name"), str2)) {
            hn.hw(uri.getQueryParameter("sp_file_name"), str2);
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
