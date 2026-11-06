package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    float a;
    long b;
    int c;
    int d;
    int e;
    Map<String, Double> f = new HashMap();
    boolean g;
    long h;
    long i;
    String j;
    private Context k;

    public a(Context context) {
        SharedPreferences sharedPreferences;
        this.a = 1000.0f;
        this.e = 6;
        this.i = 300000L;
        this.k = context;
        if (this.k == null || (sharedPreferences = this.k.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000L);
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "init fps. diff is " + this.a + ", count diff is " + this.e + ", dlealt time is " + this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<Map.Entry<String, Double>> it = this.f.entrySet().iterator();
        if (it != null) {
            JSONArray jSONArray = null;
            while (it.hasNext()) {
                Map.Entry<String, Double> next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.j);
                    jSONObject2.put("pF", jSONArray);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                efsJSONLog.put("fps", jSONObject2);
                EfsReporter reporter = PageManger.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
    }

    public final void a() {
        if (this.g) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "state is start!");
            }
        } else {
            this.g = true;
            if (PageManger.isDebug) {
                Log.i("PageManger-PageFPSImpl", "start, page is " + this.j);
            }
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.umeng.pagesdk.a.1
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    boolean z = PageManger.isDebug;
                    if (a.this.g) {
                        if (a.this.h == 0) {
                            a.this.h = System.currentTimeMillis();
                        }
                        if (System.currentTimeMillis() - a.this.h > a.this.i) {
                            a.this.b();
                            return;
                        }
                        if (a.this.b == 0) {
                            a.this.b = j;
                        }
                        float f = (j - a.this.b) / 1000000.0f;
                        if (f > a.this.a) {
                            double d = (((long) a.this.c) * 1000) / ((double) f);
                            a.this.c = 0;
                            a.this.b = 0L;
                            if (PageManger.isDebug) {
                                Log.i("PageManger-PageFPSImpl", "doFrame: " + d + ", map size is " + a.this.f.size() + ", page is " + a.this.j);
                            }
                            Map<String, Double> map = a.this.f;
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            map.put(sb.toString(), Double.valueOf(d));
                            a.this.d++;
                            if (a.this.d >= a.this.e) {
                                a.this.c();
                                a aVar = a.this;
                                aVar.d = 0;
                                if (aVar.f != null) {
                                    aVar.f.clear();
                                }
                            }
                        } else {
                            a.this.c++;
                        }
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                }
            });
        }
    }

    public final void b() {
        if (PageManger.isDebug) {
            Log.i("PageManger-PageFPSImpl", "stop, page is " + this.j);
        }
        c();
        this.g = false;
        this.h = 0L;
        this.b = 0L;
        this.c = 0;
        if (this.f != null) {
            this.f.clear();
        }
        this.d = 0;
    }
}
