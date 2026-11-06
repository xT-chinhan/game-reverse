package com.byazt.byp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 19})
public class n implements com.byazt.lpr.q.n {
    public com.byazt.sf.s n;

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "ad_log_event";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public n(String str) {
    }

    public String n(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        byte b;
        JSONObject jSONObject;
        HashMap map;
        if (!((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                e = null;
            } catch (Exception e) {
                e = e;
            }
            com.byazt.hm.w.n("invalid_process", jSONObject2, e);
            return null;
        }
        this.n = com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou());
        try {
            String str = uri.getPath().split("/")[2];
            switch (str.hashCode()) {
                case -482705237:
                    if (str.equals("trackAdFailed")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                case -171493183:
                    if (str.equals("adLogStart")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case 964299715:
                    if (str.equals("adLogStop")) {
                        b = 4;
                    } else {
                        b = -1;
                    }
                    break;
                case 1025736635:
                    if (str.equals("adLogDispatch")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                case 1131732929:
                    if (str.equals("trackAdUrl")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                this.n.n(TextUtils.equals(uri.getQueryParameter("is_flush"), "true"));
            } else if (b == 1) {
                JSONObject jSONObject3 = new JSONObject(n(uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT)));
                this.n.n(jSONObject3.optJSONObject(NotificationCompat.CATEGORY_EVENT), (byte) jSONObject3.optInt("type"));
            } else if (b == 2) {
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter2 = uri.getQueryParameter("track");
                    String queryParameter3 = uri.getQueryParameter("extraMate");
                    String queryParameter4 = uri.getQueryParameter("extraMapJson");
                    try {
                        jSONObject = new JSONObject(n(queryParameter3));
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    try {
                        JSONObject jSONObject4 = new JSONObject(n(queryParameter4));
                        map = new HashMap();
                        try {
                            Iterator<String> itKeys = jSONObject4.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                map.put(next, jSONObject4.optString(next));
                            }
                        } catch (Exception unused2) {
                        }
                    } catch (Exception unused3) {
                        map = null;
                    }
                    HashMap map2 = map;
                    String[] strArrSplit = n(queryParameter2).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strN = n(str2);
                            if (!TextUtils.isEmpty(strN)) {
                                arrayList.add(strN);
                            }
                        }
                        this.n.n(queryParameter, arrayList, zBooleanValue, map2, jSONObject);
                    }
                } catch (Throwable unused4) {
                }
            } else if (b == 3) {
                this.n.n(uri.getQueryParameter("did"));
            } else if (b == 4) {
                this.n.n();
            }
        } catch (Exception e2) {
            com.byazt.hm.w.n("process_event", (JSONObject) null, e2);
        }
        return null;
    }
}
