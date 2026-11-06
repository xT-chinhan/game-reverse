package com.smartdigimkt.q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.smartdigimkt.odopt.api.ATOaidBindHandler;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r.x;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    /* JADX WARN: Code duplicated, block: B:33:0x007f A[Catch: all -> 0x010a, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab A[Catch: all -> 0x010a, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b8 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5 A[Catch: all -> 0x00e9, Exception -> 0x00ee, TryCatch #5 {Exception -> 0x00ee, all -> 0x00e9, blocks: (B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:70:0x00c1, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00db A[Catch: all -> 0x00e9, Exception -> 0x00ee, TryCatch #5 {Exception -> 0x00ee, all -> 0x00e9, blocks: (B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:70:0x00c1, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f4 A[Catch: all -> 0x010a, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00fc A[Catch: all -> 0x010a, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0106 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #4 {all -> 0x010a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001a, B:10:0x0026, B:31:0x0079, B:33:0x007f, B:35:0x00ab, B:36:0x00b8, B:47:0x00ea, B:49:0x00ef, B:51:0x00f4, B:53:0x00fc, B:54:0x0106, B:14:0x0032, B:17:0x0040, B:20:0x0049, B:22:0x0053, B:26:0x005c, B:28:0x0068, B:39:0x00c1, B:41:0x00d5, B:43:0x00db, B:44:0x00e5), top: B:69:0x0010, inners: #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x011f  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static void a(Context context, a aVar) {
        String str;
        String upperCase;
        String string;
        Cursor cursorQuery;
        String strA = "";
        try {
            strA = new d(context).a;
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(strA)) {
                aVar.a(strA, false);
                return;
            }
            String str2 = Build.MANUFACTURER;
            String strA2 = a("ro.build.freeme.label");
            if (TextUtils.isEmpty(strA2) || !strA2.equalsIgnoreCase("FREEMEOS")) {
                String strA3 = a("ro.ssui.product");
                if (TextUtils.isEmpty(strA3) || strA3.equalsIgnoreCase("unknown")) {
                    String strA4 = a("ro.build.freeme.label");
                    if (TextUtils.isEmpty(strA4) || strA4.equalsIgnoreCase("unknown")) {
                        try {
                            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
                            str = "COOLPAD";
                        } catch (Exception unused2) {
                            if (a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE")) {
                                str = "COOLSEA";
                            } else if (!TextUtils.isEmpty(str2)) {
                                upperCase = str2.toUpperCase();
                                if (Arrays.asList("ASUS", "HUAWEI", BaseConstants.ROM_OPPO_UPPER_CONSTANT, "ONEPLUS", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO", "FREEME", "COOLPAD", "COOLSEA", "HONOR", "REALME").contains(upperCase)) {
                                    f.a().c(new c(aVar, context, upperCase));
                                } else if ("VIVO".equals(upperCase)) {
                                    string = null;
                                    try {
                                        cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                                        if (cursorQuery != null) {
                                            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.e.a.d)) : null;
                                            cursorQuery.close();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                    strA = string;
                                } else if ("NUBIA".equals(upperCase)) {
                                    strA = new x(context).a();
                                } else {
                                    ATOaidBindHandler.handleInitOaidBind(context, aVar);
                                }
                            }
                            if (TextUtils.isEmpty(strA)) {
                            }
                            aVar.a(strA, false);
                        }
                    } else {
                        str = "FREEME";
                    }
                } else {
                    str = "SSUI";
                }
            } else {
                str = "FERRMEOS";
            }
            str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                upperCase = str2.toUpperCase();
                if (Arrays.asList("ASUS", "HUAWEI", BaseConstants.ROM_OPPO_UPPER_CONSTANT, "ONEPLUS", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO", "FREEME", "COOLPAD", "COOLSEA", "HONOR", "REALME").contains(upperCase)) {
                    f.a().c(new c(aVar, context, upperCase));
                } else if ("VIVO".equals(upperCase)) {
                    string = null;
                    cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                    if (cursorQuery != null) {
                        if (cursorQuery.moveToNext()) {
                        }
                        cursorQuery.close();
                    }
                    strA = string;
                } else if ("NUBIA".equals(upperCase)) {
                    strA = new x(context).a();
                } else {
                    ATOaidBindHandler.handleInitOaidBind(context, aVar);
                }
            }
        } catch (Throwable th2) {
            if (TextUtils.isEmpty(strA)) {
                com.smartdigimkt.t.f.a(5, th2.getMessage());
            }
        }
        if (TextUtils.isEmpty(strA)) {
            aVar.a(strA, false);
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }
}
