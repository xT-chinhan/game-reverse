package com.byazt.iy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.sd.zo;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1110, 37})
public class pr implements com.byazt.nq.hw.pr {
    public com.byazt.fu.hn pr;

    public pr(String str) {
    }

    @Override // com.byazt.nq.hw.pr
    public void injectContext(Context context) {
    }

    @Override // com.byazt.nq.hw.pr
    public String getTableName() {
        return "ad_log_event";
    }

    @Override // com.byazt.nq.hw.pr
    public void init() {
    }

    public String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x004d  */
    @Override // com.byazt.nq.hw.pr
    public String getType(Uri uri) throws Throwable {
        JSONObject jSONObject;
        HashMap map;
        HashMap map2;
        if (!((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                e = null;
            } catch (Exception e) {
                e = e;
            }
            com.byazt.pj.uc.pr("invalid_process", jSONObject2, e);
            return null;
        }
        this.pr = com.byazt.lg.pr.pr(zo.nt().ny());
        try {
            byte b = 2;
            String str = uri.getPath().split("/")[2];
            switch (str.hashCode()) {
                case -482705237:
                    b = str.equals("trackAdFailed") ? (byte) 3 : (byte) -1;
                    break;
                case -171493183:
                    if (str.equals("adLogStart")) {
                        b = 0;
                    }
                    break;
                case 964299715:
                    if (str.equals("adLogStop")) {
                        b = 4;
                    }
                    break;
                case 1025736635:
                    if (str.equals("adLogDispatch")) {
                        b = 1;
                    }
                    break;
                case 1131732929:
                    if (str.equals("trackAdUrl")) {
                    }
                    break;
                default:
                    break;
            }
            switch (b) {
                case 0:
                    this.pr.pr(TextUtils.equals(uri.getQueryParameter("is_flush"), "true"));
                    break;
                case 1:
                    JSONObject jSONObject3 = new JSONObject(pr(uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT)));
                    this.pr.pr(jSONObject3.optJSONObject(NotificationCompat.CATEGORY_EVENT), (byte) jSONObject3.optInt("type"));
                    break;
                case 2:
                    try {
                        String queryParameter = uri.getQueryParameter("did");
                        boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                        String queryParameter2 = uri.getQueryParameter("track");
                        String queryParameter3 = uri.getQueryParameter("extraMate");
                        String queryParameter4 = uri.getQueryParameter("extraMapJson");
                        try {
                            jSONObject = new JSONObject(pr(queryParameter3));
                        } catch (Exception e2) {
                            jSONObject = null;
                        }
                        try {
                            JSONObject jSONObject4 = new JSONObject(pr(queryParameter4));
                            map = new HashMap();
                            try {
                                Iterator<String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    map.put(next, jSONObject4.optString(next));
                                }
                                map2 = map;
                            } catch (Exception e3) {
                                map2 = map;
                            }
                        } catch (Exception e4) {
                            map = null;
                        }
                        String[] strArrSplit = pr(queryParameter2).split(",");
                        if (strArrSplit.length > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (String str2 : strArrSplit) {
                                String strPr = pr(str2);
                                if (!TextUtils.isEmpty(strPr)) {
                                    arrayList.add(strPr);
                                }
                            }
                            this.pr.pr(queryParameter, arrayList, zBooleanValue, map2, jSONObject);
                        }
                    } catch (Throwable th) {
                    }
                    break;
                case 3:
                    this.pr.pr(uri.getQueryParameter("did"));
                    break;
                case 4:
                    this.pr.pr();
                    break;
            }
        } catch (Exception e5) {
            com.byazt.pj.uc.pr("process_event", (JSONObject) null, e5);
        }
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.nq.hw.pr
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
