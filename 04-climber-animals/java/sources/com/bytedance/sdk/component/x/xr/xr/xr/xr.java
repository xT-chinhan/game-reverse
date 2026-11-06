package com.bytedance.sdk.component.x.xr.xr.xr;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.ny;
import com.bytedance.sdk.component.x.xr.ah;
import com.bytedance.sdk.component.x.xr.ms.ms.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static ah f1590ms;
    private ka ah;
    private ny d;
    private String xr;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private ka ms() {
        if (this.ah == null) {
            this.ah = com.bytedance.sdk.component.x.xr.ms.ah(this.xr).ah();
        }
        return this.ah;
    }

    private ny xr() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.component.x.xr.ms.ah(this.xr).d();
        }
        return this.d;
    }

    public static ah ms(ka kaVar) {
        try {
            if (f1590ms == null) {
                f1590ms = kaVar.d().zb();
            }
        } catch (Exception unused) {
        }
        return f1590ms;
    }

    public static void xr(ka kaVar) {
        if (kaVar == null) {
            return;
        }
        try {
            ah ahVarMs = ms(kaVar);
            if (ahVarMs != null) {
                ahVarMs.getType(Uri.parse(ah(kaVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ms(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar == null || kaVar == null) {
            return;
        }
        try {
            ah ahVarMs = ms(kaVar);
            if (ahVarMs != null) {
                ahVarMs.getType(Uri.parse(ah(kaVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.x.xr.ms.ms.ah.ms(xrVar.c())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("dispatch event Throwable:" + th.toString(), kaVar);
        }
    }

    public static void ms(String str, List<String> list, boolean z, ka kaVar) {
        if (list == null || list.isEmpty() || kaVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.x.xr.ms.ms.ah.ms(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.x.xr.ms.ms.ah.ms(sb.toString())) + "&replace=" + String.valueOf(z);
            ah ahVarMs = ms(kaVar);
            if (ahVarMs != null) {
                ahVarMs.getType(Uri.parse(ah(kaVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ms(String str, ka kaVar) {
        if (TextUtils.isEmpty(str) || kaVar == null) {
            return;
        }
        try {
            ah ahVarMs = ms(kaVar);
            if (ahVarMs != null) {
                ahVarMs.getType(Uri.parse(ah(kaVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String ah(ka kaVar) {
        return d.ms(kaVar) + "/ad_log_event/";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getType(Uri uri) {
        com.bytedance.sdk.component.x.ms.xr xrVarD;
        ms();
        ny nyVarXr = xr();
        if (nyVarXr == null) {
            return null;
        }
        byte b = 2;
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str.hashCode()) {
            case -482705237:
                b = str.equals("trackAdFailed") ? (byte) 0 : (byte) -1;
                break;
            case -171493183:
                b = str.equals("adLogStart") ? (byte) 1 : (byte) -1;
                break;
            case 964299715:
                if (!str.equals("adLogStop")) {
                    b = -1;
                }
                break;
            case 1025736635:
                b = str.equals("adLogDispatch") ? (byte) 3 : (byte) -1;
                break;
            case 1131732929:
                b = str.equals("trackAdUrl") ? (byte) 4 : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                com.bytedance.sdk.component.x.xr.c.ms.ms(ms()).ms(uri.getQueryParameter("did"));
                return null;
            case 1:
                ms();
                nyVarXr.ms();
                return null;
            case 2:
                ms();
                return null;
            case 3:
                ms();
                String queryParameter = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(queryParameter) && (xrVarD = com.bytedance.sdk.component.x.xr.d.ms.ms.d(com.bytedance.sdk.component.x.xr.ms.ms.ah.xr(queryParameter))) != null) {
                    xr().ms(xrVarD);
                }
                return null;
            case 4:
                ms();
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String[] strArrSplit = com.bytedance.sdk.component.x.xr.ms.ms.ah.xr(uri.getQueryParameter("track")).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strXr = com.bytedance.sdk.component.x.xr.ms.ms.ah.xr(str2);
                            if (!TextUtils.isEmpty(strXr)) {
                                arrayList.add(strXr);
                            }
                        }
                        com.bytedance.sdk.component.x.xr.c.ms.ms(ms()).ms(queryParameter2, arrayList, zBooleanValue, null, new JSONObject());
                    }
                    break;
                } catch (Throwable unused) {
                }
                return null;
            default:
                return null;
        }
    }
}
