package com.smartdigimkt.x3;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.byazt.af.x;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final String a = "b";
    public final Object b = new Object();
    public volatile String c = null;

    /* JADX WARN: Code duplicated, block: B:53:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ac A[RETURN] */
    public static String a(Context context, ArrayList arrayList, String str) {
        String str2;
        if (arrayList.size() == 0) {
            return "";
        }
        boolean z = false;
        try {
            int size = arrayList.size();
            str2 = "";
            boolean z2 = true;
            for (int i = 0; i < size; i++) {
                try {
                    String str3 = (String) arrayList.get(i);
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = str3.split("_")[0] + "_*";
                        }
                        int identifier = !TextUtils.isEmpty(str) ? context.getResources().getIdentifier(str3, "layout", str) : -1;
                        if (identifier <= 0) {
                            identifier = context.getResources().getIdentifier(str3, "layout", context.getPackageName());
                        }
                        if (identifier <= 0) {
                            if (z) {
                                return "";
                            }
                            return str2;
                        }
                        XmlResourceParser layout = null;
                        try {
                            layout = context.getResources().getLayout(identifier);
                            while (true) {
                                int next = layout.next();
                                if (next == 1) {
                                    break;
                                }
                                if (next == 2) {
                                    if (!x.n.equalsIgnoreCase(layout.getName())) {
                                        if (layout.getAttributeCount() >= 0) {
                                            break;
                                        }
                                    } else {
                                        if (layout.getAttributeCount() == 0) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                if (layout != null) {
                                    break;
                                }
                            } catch (Throwable th2) {
                                if (layout != null) {
                                    layout.close();
                                }
                                throw th2;
                            }
                        }
                        layout.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                }
            }
            z = z2;
        } catch (Throwable th4) {
            th = th4;
            str2 = "";
        }
        if (z) {
            return "";
        }
        return str2;
    }
}
