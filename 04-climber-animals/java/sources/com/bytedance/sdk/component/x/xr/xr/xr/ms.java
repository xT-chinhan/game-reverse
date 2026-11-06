package com.bytedance.sdk.component.x.xr.xr.xr;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.x.ms.ab;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.ny;
import com.bytedance.sdk.component.x.xr.ms.ms.ah;
import com.bytedance.sdk.component.x.xr.ms.ms.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private ka ah;
    private ny d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1589ms;
    private Context xr;

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

    public ms(String str) {
        this.f1589ms = str;
        ab abVarAh = com.bytedance.sdk.component.x.xr.ms.ah(str);
        this.ah = abVarAh.ah();
        this.d = abVarAh.d();
    }

    private ka xr() {
        if (this.ah == null) {
            this.ah = com.bytedance.sdk.component.x.xr.ms.ah(this.f1589ms).ah();
        }
        return this.ah;
    }

    private ny ah() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.component.x.xr.ms.ah(this.f1589ms).d();
        }
        return this.d;
    }

    private static ContentResolver xr(ka kaVar) {
        try {
            if (kaVar.getContext() != null) {
                return kaVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ms(ka kaVar) {
        if (kaVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverXr = xr(kaVar);
            if (contentResolverXr != null) {
                contentResolverXr.getType(Uri.parse(ah(kaVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ms(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverXr = xr(kaVar);
            if (contentResolverXr != null) {
                contentResolverXr.getType(Uri.parse(ah(kaVar) + "adLogDispatch?event=" + ah.ms(xrVar.c())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("dispatch event Throwable:" + th.toString(), kaVar);
        }
    }

    public static void ms(String str, List<String> list, boolean z, ka kaVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(ah.ms(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(ah.ms(sb.toString())) + "&replace=" + String.valueOf(z) + "&extraMate=" + ah.ms(jSONObject.toString());
            ContentResolver contentResolverXr = xr(kaVar);
            if (contentResolverXr != null) {
                contentResolverXr.getType(Uri.parse(ah(kaVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void ms(String str, ka kaVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverXr = xr(kaVar);
            if (contentResolverXr != null) {
                contentResolverXr.getType(Uri.parse(ah(kaVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String ah(ka kaVar) {
        return d.ms(kaVar) + "/" + ("csj_mediation".equals(kaVar.ka()) ? "gromore_ad_log_event" : "ad_log_event") + "/";
    }

    public void ms(Context context) {
        this.xr = context;
    }

    public String ms() {
        return "csj_mediation".equals(this.f1589ms) ? "gromore_ad_log_event" : "ad_log_event";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getType(Uri uri) {
        JSONObject jSONObject;
        xr();
        ny nyVarAh = ah();
        if (nyVarAh == null) {
            com.bytedance.sdk.component.x.xr.ah.ah.d("getType center is null", xr());
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
                com.bytedance.sdk.component.x.xr.c.ms.ms(xr()).ms(uri.getQueryParameter("did"));
                return null;
            case 1:
                xr();
                nyVarAh.ms();
                return null;
            case 2:
                xr();
                return null;
            case 3:
                xr();
                com.bytedance.sdk.component.x.ms.xr xrVarD = com.bytedance.sdk.component.x.xr.d.ms.ms.d(ah.xr(uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT)));
                if (xrVarD != null) {
                    nyVarAh.ms(xrVarD);
                }
                return null;
            case 4:
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter2 = uri.getQueryParameter("track");
                    try {
                        jSONObject = new JSONObject(ah.xr(uri.getQueryParameter("extraMate")));
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    String[] strArrSplit = ah.xr(queryParameter2).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strXr = ah.xr(str2);
                            if (!TextUtils.isEmpty(strXr)) {
                                arrayList.add(strXr);
                            }
                        }
                        com.bytedance.sdk.component.x.xr.c.ms.ms(xr()).ms(queryParameter, arrayList, zBooleanValue, null, jSONObject);
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return null;
            default:
                return null;
        }
    }
}
