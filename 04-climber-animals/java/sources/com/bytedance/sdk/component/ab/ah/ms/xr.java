package com.bytedance.sdk.component.ab.ah.ms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static boolean ms() {
        return com.bytedance.sdk.component.ab.ah.getContext() != null;
    }

    private static ContentResolver xr() {
        try {
            if (ms()) {
                return com.bytedance.sdk.component.ab.ah.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.ab.ah.getContext();
    }

    private static String ah() {
        return ka.xr + "/t_sp/";
    }

    private static String ah(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    private static String ah(String str, String str2, String str3) {
        return ah() + str + "/" + str2 + ah(str3);
    }

    public static synchronized void ms(String str, String str2, Boolean bool) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah("boolean", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.d, bool);
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void ms(String str, String str2, String str3) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah("string", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.d, str3);
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void ms(String str, String str2, Integer num) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.d, num);
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void ms(String str, String str2, Long l) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.d, l);
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void ms(String str, String str2, Float f) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah("float", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.a.d, f);
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void ms(String str, String str2, Set<String> set) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    Uri uri = Uri.parse(ah("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put(f.a.d, hashSet.toString());
                    contentResolverXr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String xr(String str, String str2, String str3) {
        String type;
        if (!ms()) {
            return str3;
        }
        try {
            ContentResolver contentResolverXr = xr();
            return (contentResolverXr == null || (type = contentResolverXr.getType(Uri.parse(ah("string", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type)) ? str3 : type;
        } catch (Throwable unused) {
        }
    }

    public static int ms(String str, String str2, int i) {
        String type;
        if (!ms()) {
            return i;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null && (type = contentResolverXr.getType(Uri.parse(ah(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float ms(String str, String str2, float f) {
        String type;
        if (!ms()) {
            return f;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null && (type = contentResolverXr.getType(Uri.parse(ah("float", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean ms(String str, String str2, boolean z) {
        String type;
        if (!ms()) {
            return z;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null && (type = contentResolverXr.getType(Uri.parse(ah("boolean", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long ms(String str, String str2, long j) {
        String type;
        if (!ms()) {
            return j;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null && (type = contentResolverXr.getType(Uri.parse(ah("long", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static Set<String> xr(String str, String str2, Set<String> set) {
        String type;
        if (!ms()) {
            return set;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr == null || (type = contentResolverXr.getType(Uri.parse(ah("string_set", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String strSubstring = type.substring(1, type.length() - 1);
            String[] strArrSplit = strSubstring.split(", ");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(strSubstring)) {
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static boolean ms(String str, String str2) {
        String type;
        if (!ms()) {
            return false;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null && (type = contentResolverXr.getType(Uri.parse(ah("contain", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void xr(String str, String str2) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    contentResolverXr.delete(Uri.parse(ah("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(String str) {
        if (ms()) {
            try {
                ContentResolver contentResolverXr = xr();
                if (contentResolverXr != null) {
                    contentResolverXr.delete(Uri.parse(ah() + "clean" + ah(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> xr(String str) {
        Cursor cursorQuery;
        Object string;
        String string2;
        if (!ms()) {
            return null;
        }
        try {
            ContentResolver contentResolverXr = xr();
            if (contentResolverXr != null) {
                cursorQuery = contentResolverXr.query(Uri.parse(ah() + "get_all" + ah(str)), null, null, null, null);
                try {
                    HashMap map = new HashMap();
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("cursor_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("cursor_type");
                        int columnIndex3 = cursorQuery.getColumnIndex("cursor_value");
                        do {
                            String string3 = cursorQuery.getString(columnIndex);
                            String string4 = cursorQuery.getString(columnIndex2);
                            if (string4.equalsIgnoreCase("string")) {
                                string2 = cursorQuery.getString(columnIndex3);
                                String str2 = string2;
                                if (string2.contains("__COMMA__")) {
                                    String str3 = string2;
                                    if (string2.matches("\\[.*\\]")) {
                                        String strSubstring = string2.substring(1, string2.length() - 1);
                                        String[] strArrSplit = strSubstring.split(", ");
                                        HashSet hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(strSubstring)) {
                                            for (String str4 : strArrSplit) {
                                                string = string2;
                                                string = string2;
                                                hashSet.add(str4.replace("__COMMA__", ", "));
                                            }
                                            string = string2;
                                            string = string2;
                                        }
                                        string = string2;
                                        string = string2;
                                        string = hashSet;
                                    }
                                }
                            } else if (string4.equalsIgnoreCase("boolean")) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string4.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string4.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string4.equalsIgnoreCase("float")) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else {
                                string = string4.equalsIgnoreCase("string_set") ? cursorQuery.getString(columnIndex3) : null;
                            }
                            string = string2;
                            string = string2;
                            string = string2;
                            map.put(string3, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }
}
