package com.byazt.jc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 120, 13})
public class hw {
    public static boolean pr() {
        if (com.byazt.to.hn.getContext() == null) {
            return false;
        }
        return true;
    }

    private static ContentResolver hw() {
        try {
            if (pr()) {
                return com.byazt.to.hn.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Context getContext() {
        return com.byazt.to.hn.getContext();
    }

    private static String hn() {
        return c.hw + "/t_sp/";
    }

    private static String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=".concat(String.valueOf(str));
    }

    private static String hn(String str, String str2, String str3) {
        return hn() + str + "/" + str2 + hn(str3);
    }

    public static synchronized void pr(String str, String str2, Boolean bool) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("boolean", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.VALUE_FIELD, bool);
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized void pr(String str, String str2, String str3) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("string", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.VALUE_FIELD, str3);
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized void pr(String str, String str2, Integer num) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.VALUE_FIELD, num);
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized void pr(String str, String str2, Long l) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.VALUE_FIELD, l);
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized void pr(String str, String str2, Float f) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("float", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.VALUE_FIELD, f);
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static synchronized void pr(String str, String str2, Set<String> set) {
        if (pr()) {
            try {
                ContentResolver contentResolverHw = hw();
                if (contentResolverHw != null) {
                    Uri uri = Uri.parse(hn("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put(Constants.VALUE_FIELD, hashSet.toString());
                    contentResolverHw.update(uri, contentValues, null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static String hw(String str, String str2, String str3) {
        String type;
        if (!pr()) {
            return str3;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw == null || (type = contentResolverHw.getType(Uri.parse(hn("string", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type)) {
                return str3;
            }
            return type;
        } catch (Throwable th) {
        }
        return str3;
    }

    public static int pr(String str, String str2, int i) {
        String type;
        if (!pr()) {
            return i;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null && (type = contentResolverHw.getType(Uri.parse(hn("int", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
            return i;
        } catch (Throwable th) {
        }
        return i;
    }

    public static float pr(String str, String str2, float f) {
        String type;
        if (!pr()) {
            return f;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null && (type = contentResolverHw.getType(Uri.parse(hn("float", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
            return f;
        } catch (Throwable th) {
        }
        return f;
    }

    public static boolean pr(String str, String str2, boolean z) {
        String type;
        if (!pr()) {
            return z;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null && (type = contentResolverHw.getType(Uri.parse(hn("boolean", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
            return z;
        } catch (Throwable th) {
        }
        return z;
    }

    public static long pr(String str, String str2, long j) {
        String type;
        if (!pr()) {
            return j;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null && (type = contentResolverHw.getType(Uri.parse(hn("long", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
            return j;
        } catch (Throwable th) {
        }
        return j;
    }

    public static Set<String> hw(String str, String str2, Set<String> set) {
        String type;
        if (!pr()) {
            return set;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw == null || (type = contentResolverHw.getType(Uri.parse(hn("string_set", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
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
        } catch (Throwable th) {
        }
        return set;
    }

    public static boolean pr(String str, String str2) {
        String type;
        if (!pr()) {
            return false;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null && (type = contentResolverHw.getType(Uri.parse(hn("contain", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
            return false;
        } catch (Throwable th) {
        }
        return false;
    }

    public static void hw(String str, String str2) {
        if (!pr()) {
            return;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null) {
                contentResolverHw.delete(Uri.parse(hn("long", str2, str)), null, null);
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(String str) {
        if (!pr()) {
            return;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null) {
                contentResolverHw.delete(Uri.parse(hn() + "clean" + hn(str)), null, null);
            }
        } catch (Throwable th) {
        }
    }

    public static Map<String, ?> hw(String str) {
        Cursor cursorQuery;
        Object string;
        String string2;
        Object obj;
        if (!pr()) {
            return null;
        }
        try {
            ContentResolver contentResolverHw = hw();
            if (contentResolverHw != null) {
                cursorQuery = contentResolverHw.query(Uri.parse(hn() + "get_all" + hn(str)), null, null, null, null);
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
                                                obj = string2;
                                                hashSet.add(str4.replace("__COMMA__", ", "));
                                            }
                                            string = string2;
                                            obj = string2;
                                        }
                                        string = string2;
                                        obj = string2;
                                        obj = hashSet;
                                    }
                                    string = string2;
                                    obj = string2;
                                    string = obj;
                                }
                            } else if (string4.equalsIgnoreCase("boolean")) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string4.equalsIgnoreCase("int")) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string4.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string4.equalsIgnoreCase("float")) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else if (!string4.equalsIgnoreCase("string_set")) {
                                string = null;
                            } else {
                                string = cursorQuery.getString(columnIndex3);
                            }
                            string = string2;
                            map.put(string3, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable th) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            cursorQuery = null;
        }
        return null;
    }
}
