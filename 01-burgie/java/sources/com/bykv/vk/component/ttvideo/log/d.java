package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.mg.hw;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements b {
    private com.bykv.vk.component.ttvideo.log.a a;
    private c c;
    private String e;
    private String f;
    private Context j;
    private int g = 0;
    public int h = 0;
    private int i = 0;
    private long k = -2147483648L;
    private f b = new f();
    private boolean d = true;

    private static class a implements Runnable {
        private f a;
        private Handler b = new Handler(Looper.getMainLooper());
        c c;

        /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.log.d$a$a, reason: collision with other inner class name */
        class RunnableC0245a implements Runnable {
            final /* synthetic */ JSONObject a;

            RunnableC0245a(a aVar, JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.instance.a(false, this.a);
            }
        }

        public a(f fVar, d dVar, c cVar) {
            this.a = fVar;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = this.a;
            if (fVar == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            JSONObject jSONObjectA = fVar.a(this.c);
            Handler handler = this.b;
            if (handler == null || handler.getLooper() == null) {
                e.instance.a(false, jSONObjectA);
            } else {
                this.b.post(new RunnableC0245a(this, jSONObjectA));
            }
        }
    }

    public d(Context context, com.bykv.vk.component.ttvideo.log.a aVar) {
        this.a = aVar;
        this.c = new c(aVar, context);
        this.j = context;
    }

    private void b() {
        this.i = 0;
        this.d = true;
        this.h = 0;
        this.k = -2147483648L;
    }

    private void c() {
        String strDecode;
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(this.e)) {
            strDecode = this.e;
        } else if (TextUtils.isEmpty(this.f)) {
            return;
        } else {
            strDecode = this.f;
        }
        try {
            strDecode = URLDecoder.decode(strDecode, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            sb = new StringBuilder("exception:");
            string = e.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        } catch (IllegalArgumentException e2) {
            sb = new StringBuilder("exception:");
            string = e2.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        }
        int iIndexOf = strDecode.indexOf("&l=");
        if (iIndexOf > 0) {
            int iIndexOf2 = strDecode.indexOf("&", iIndexOf + 1);
            int i = iIndexOf + 3;
            this.b.o = iIndexOf2 > 0 ? strDecode.substring(i, iIndexOf2) : strDecode.substring(i);
        }
    }

    private void d() {
        f fVar = this.b;
        if (fVar == null) {
            return;
        }
        if (fVar.b > 0 || this.k > 0) {
            int i = this.g;
            if (i > 0) {
                this.c.h = i;
            }
            SharedPreferences sharedPreferencesHw = hw.hw(this.j, "VideoEventLogger", 0);
            this.b.p = sharedPreferencesHw.getString("playersessionid", "");
            SharedPreferences.Editor editorEdit = sharedPreferencesHw.edit();
            editorEdit.putString("playersessionid", this.c.f);
            editorEdit.apply();
            f fVar2 = this.b;
            fVar2.n = this.c.f;
            fVar2.h = this.h;
            String str = this.e;
            if (str != null) {
                fVar2.k = str;
            }
            String str2 = this.f;
            if (str2 != null) {
                this.b.l = str2;
            }
            f fVar3 = this.b;
            fVar3.c = fVar3.b;
            fVar3.a = this.k;
            if (fVar3.e <= 0 && fVar3.d > 0) {
                fVar3.e = System.currentTimeMillis();
            }
            if (TextUtils.isEmpty(this.b.o)) {
                c();
            }
            EngineThreadPool.a().execute(new a(this.b, this, this.c));
            b();
        }
    }

    private void f(int i) {
        d();
        this.b = new f();
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a() {
        if (this.i != 4) {
            this.i = 2;
            this.d = false;
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.d = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002c  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != 5) {
            int i2 = this.i;
            if (i2 != 3 ? i2 != 4 : false) {
                this.c.a();
            }
        }
        if (this.d) {
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.f = jCurrentTimeMillis;
            } else {
                this.b.e = jCurrentTimeMillis;
            }
        } else {
            this.b.e = jCurrentTimeMillis;
        }
        f(i);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(long j, String str) {
        this.i = 1;
        this.c.a(str);
        if (this.k <= 0) {
            this.k = j;
        }
        this.d = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = this.i;
        boolean z = i2 != 3 ? i2 != 4 : false;
        this.i = 5;
        if (this.d) {
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.f = jCurrentTimeMillis;
            } else {
                if (error.c.equals(Error.VideoOwnPlayer) || error.c.equals(Error.VideoOSPlayer)) {
                    this.h++;
                }
                this.b.e = jCurrentTimeMillis;
            }
        } else {
            if (error.c.equals(Error.VideoOwnPlayer)) {
                this.h++;
            } else {
                this.h++;
            }
            this.b.e = jCurrentTimeMillis;
        }
        if (z) {
            this.c.a();
        }
        this.b.i = error.getType();
        this.b.j = error.a;
        f(4);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i, int i2) {
        if (error.c.equals(Error.VideoOwnPlayer) || error.c.equals(Error.VideoOSPlayer)) {
            this.h++;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str) {
        if (this.c == null || str == null || str.isEmpty()) {
            return;
        }
        this.c.b(str);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str, String str2) {
        this.e = str;
        c cVar = this.c;
        if (cVar != null) {
            cVar.g = str;
        }
        this.f = str2;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void b(int i) {
        this.b.m = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void c(int i) {
        if (this.i == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = this.i;
        boolean z = i2 != 4;
        if (i2 == 3) {
            z = false;
        }
        this.i = 0;
        if (this.d) {
            f fVar = this.b;
            if (fVar.b <= 0 || fVar.d > 0) {
                this.b.e = jCurrentTimeMillis;
            } else if (fVar.f <= 0) {
                fVar.f = jCurrentTimeMillis;
            }
        } else {
            this.b.e = jCurrentTimeMillis;
        }
        if (z) {
            this.c.a();
        }
        f(i);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void d(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 10) {
            f fVar = this.b;
            if (fVar.b <= 0) {
                fVar.b = jCurrentTimeMillis;
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void e(int i) {
        this.g = i;
        this.c.h = i;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void reset() {
        this.d = true;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.c = new c(this.a, this.j);
    }
}
