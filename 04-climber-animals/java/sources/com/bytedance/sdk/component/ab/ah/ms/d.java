package com.bytedance.sdk.component.ab.ah.ms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.anythink.core.common.e.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public String ms() {
        return "t_sp";
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapXr;
        if (!uri.getPath().split("/")[2].equals("get_all") || (mapXr = ah.xr(uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapXr.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = mapXr.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
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
            return new StringBuilder().append(ah.ms(uri.getQueryParameter("sp_file_name"), str2)).toString();
        }
        return ah.ms(uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get(f.a.d);
        if (obj != null) {
            ah.ms(uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            ah.ms(uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (ah.ms(uri.getQueryParameter("sp_file_name"), str2)) {
            ah.xr(uri.getQueryParameter("sp_file_name"), str2);
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
