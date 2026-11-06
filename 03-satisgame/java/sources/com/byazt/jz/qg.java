package com.byazt.jz;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2277, 26})
public class qg {
    public static boolean n() {
        return com.byazt.uyg.s.getContext() != null;
    }

    private static ContentResolver qg() {
        try {
            if (n()) {
                return com.byazt.uyg.s.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        return com.byazt.uyg.s.getContext();
    }

    private static String s() {
        return l.qg + "/t_sp/";
    }

    private static String s(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    private static String s(String str, String str2, String str3) {
        return s() + str + "/" + str2 + s(str3);
    }

    public static synchronized void n(String str, String str2, Boolean bool) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("boolean", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.a.d, bool);
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, String str2, String str3) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("string", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.a.d, str3);
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, String str2, Integer num) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.a.d, num);
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, String str2, Long l) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.a.d, l);
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, String str2, Float f) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("float", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.a.d, f);
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void n(String str, String str2, Set<String> set) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    Uri uri = Uri.parse(s("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put(e.a.d, hashSet.toString());
                    contentResolverQg.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String qg(String str, String str2, String str3) {
        String type;
        if (!n()) {
            return str3;
        }
        try {
            ContentResolver contentResolverQg = qg();
            return (contentResolverQg == null || (type = contentResolverQg.getType(Uri.parse(s("string", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type)) ? str3 : type;
        } catch (Throwable unused) {
        }
    }

    public static int n(String str, String str2, int i) {
        String type;
        if (!n()) {
            return i;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null && (type = contentResolverQg.getType(Uri.parse(s("int", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float n(String str, String str2, float f) {
        String type;
        if (!n()) {
            return f;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null && (type = contentResolverQg.getType(Uri.parse(s("float", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean n(String str, String str2, boolean z) {
        String type;
        if (!n()) {
            return z;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null && (type = contentResolverQg.getType(Uri.parse(s("boolean", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long n(String str, String str2, long j) {
        String type;
        if (!n()) {
            return j;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null && (type = contentResolverQg.getType(Uri.parse(s("long", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static Set<String> qg(String str, String str2, Set<String> set) {
        String type;
        if (!n()) {
            return set;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg == null || (type = contentResolverQg.getType(Uri.parse(s("string_set", str2, str)))) == null || type.equals(AbstractJsonLexerKt.NULL) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
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

    public static boolean n(String str, String str2) {
        String type;
        if (!n()) {
            return false;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null && (type = contentResolverQg.getType(Uri.parse(s("contain", str2, str)))) != null && !type.equals(AbstractJsonLexerKt.NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void qg(String str, String str2) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    contentResolverQg.delete(Uri.parse(s("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(String str) {
        if (n()) {
            try {
                ContentResolver contentResolverQg = qg();
                if (contentResolverQg != null) {
                    contentResolverQg.delete(Uri.parse(s() + "clean" + s(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> qg(String str) {
        Cursor cursorQuery;
        Object string;
        String string2;
        if (!n()) {
            return null;
        }
        try {
            ContentResolver contentResolverQg = qg();
            if (contentResolverQg != null) {
                cursorQuery = contentResolverQg.query(Uri.parse(s() + "get_all" + s(str)), null, null, null, null);
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
                            } else if (string4.equalsIgnoreCase("int")) {
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
