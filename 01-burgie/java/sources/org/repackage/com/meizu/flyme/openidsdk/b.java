package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.mg.PluginConstants;
import com.tapsdk.tapad.group.constants.Constants;

/* JADX INFO: loaded from: classes3.dex */
class b {
    private static volatile b e;
    private static boolean f = false;
    private BroadcastReceiver h;
    OpenId a = new OpenId("udid");
    OpenId b = new OpenId("oaid");
    OpenId d = new OpenId("vaid");
    OpenId c = new OpenId("aaid");
    private SupportInfo g = new SupportInfo();

    private b() {
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(Constants.VALUE_FIELD);
                if (columnIndex >= 0) {
                    valueData.a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex(PluginConstants.KEY_ERROR_CODE);
                if (columnIndex2 >= 0) {
                    valueData.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.c = cursor.getLong(columnIndex3);
                    return valueData;
                }
                a("parseExpired fail, index < 0.");
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return valueData;
    }

    public static final b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    static void a(String str) {
        if (f) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        f = z;
    }

    private static boolean a(Context context) throws Throwable {
        a("querySupport version : 1.0.8");
        Uri uri = Uri.parse("content://com.meizu.flyme.openidsdk/");
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                boolean z = true;
                Cursor cursorQuery = contentResolver.query(uri, null, null, new String[]{"supported"}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return false;
                    }
                    return false;
                }
                try {
                    ValueData valueDataA = a(cursorQuery);
                    if (1000 == valueDataA.b && !"0".equals(valueDataA.a)) {
                        z = false;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return z;
                } catch (Exception e2) {
                    e = e2;
                    cursor = cursorQuery;
                    a("querySupport, Exception : " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String b(Context context, OpenId openId) throws Throwable {
        String str;
        Cursor cursorQuery;
        a("queryId : " + openId.c);
        Cursor cursor = null;
        str = null;
        str = null;
        String str2 = null;
        cursor = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{openId.c}, null);
                try {
                    try {
                        if (cursorQuery != null) {
                            ValueData valueDataA = a(cursorQuery);
                            str = valueDataA.a;
                            try {
                                openId.a(str);
                                openId.a(valueDataA.c);
                                openId.a(valueDataA.b);
                                a(openId.c + " errorCode : " + openId.d);
                                if (valueDataA.b != 1000) {
                                    b(context);
                                    if (!a(context, false)) {
                                        a("not support, forceQuery isSupported: ".concat(String.valueOf(a(context, true))));
                                    }
                                }
                                str2 = str;
                            } catch (Exception e2) {
                                e = e2;
                                cursor = cursorQuery;
                                a("queryId, Exception : " + e.getMessage());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return str;
                            }
                        } else if (a(context, false)) {
                            a("forceQuery isSupported : ".concat(String.valueOf(a(context, true))));
                        }
                        if (cursorQuery == null) {
                            return str2;
                        }
                        cursorQuery.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = cursor;
            }
        } catch (Exception e4) {
            e = e4;
            str = null;
        }
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.h = new a();
        context.registerReceiver(this.h, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    final boolean a(Context context, boolean z) throws Throwable {
        if (this.g.a() && !z) {
            return this.g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.g.a() && this.g.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.g.b();
        }
        this.g.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.g.a(zA);
        return zA;
    }
}
