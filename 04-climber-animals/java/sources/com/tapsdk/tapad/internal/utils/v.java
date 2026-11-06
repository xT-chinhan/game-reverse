package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.tapsdk.tapad.BuildConfig;
import com.tapsdk.tapad.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class v {
    private static final List<String> c = Collections.synchronizedList(new ArrayList());
    private volatile String a = "";
    WeakReference<Context> b = null;

    class a implements Consumer<Boolean> {
        a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
        }
    }

    class b implements Consumer<Throwable> {
        b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class c implements ObservableOnSubscribe<Boolean> {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(Boolean.valueOf(v.this.c(this.a)));
                observableEmitter.onComplete();
            } catch (Throwable th) {
                observableEmitter.onError(th);
            }
        }
    }

    public static class d {
        static v a = new v();
    }

    public static v a() {
        return d.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean c(Context context) {
        BufferedSource bufferedSourceBuffer = null;
        try {
            try {
                try {
                    bufferedSourceBuffer = Okio.buffer(Okio.source(context.getAssets().open("whiteList.json")));
                    JSONArray jSONArray = new JSONArray(bufferedSourceBuffer.readUtf8());
                    c.clear();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                            c.add(jSONArray.getString(i));
                        }
                    }
                    if (bufferedSourceBuffer == null) {
                        return true;
                    }
                    try {
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } finally {
                    if (0 != 0) {
                        try {
                            bufferedSourceBuffer.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
                c.add(new URI(BuildConfig.BASE_SERVER_URL_CN).getHost());
                TapADLogger.e("load localWhiteList err, wl add main api only");
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Exception unused4) {
                    }
                }
                return false;
            }
        } catch (Exception unused5) {
            if (bufferedSourceBuffer != null) {
                bufferedSourceBuffer.close();
            }
            return false;
        }
    }

    private void d() {
        Matcher matcher = Pattern.compile("^Mozilla/([0-9.]+) \\(([^;]+; )+[^)]+\\) AppleWebKit/([0-9.]+) \\(KHTML, like Gecko\\) (Version/([0-9.]+) )?(Chrome|Safari|Firefox|Edge)/([0-9.]+)( Mobile Safari/([0-9.]+))?").matcher(this.a);
        while (matcher.find()) {
            this.a = matcher.group();
        }
    }

    private void d(Context context) {
        this.b = new WeakReference<>(context);
    }

    public String a(String str) {
        return (!TextUtils.isEmpty(str) && c(str)) ? Constants.b.d : "";
    }

    public void a(Context context) {
        d(context);
        b(context);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (Exception unused) {
                return;
            }
        }
        List<String> list = c;
        list.clear();
        list.addAll(arrayList);
    }

    public String b() {
        return this.a;
    }

    public String b(String str) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.f, Integer.class, -1)).intValue() != 1) {
            sb = new StringBuilder();
        } else {
            if (!c(str) || TextUtils.isEmpty(this.a)) {
                return !TextUtils.isEmpty(this.a) ? this.a : "";
            }
            sb = new StringBuilder();
        }
        return sb.append(this.a).append(" TapADNSdk/3.16.3.45").toString();
    }

    public void b(Context context) {
        Observable.create(new c(context)).subscribeOn(Schedulers.newThread()).subscribe(new a(), new b());
    }

    public void c() {
        String property;
        if (this.a == null || this.a.length() <= 0) {
            try {
                if (((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.f, Integer.class, 1)).intValue() == 1) {
                    WeakReference<Context> weakReference = this.b;
                    if (weakReference != null && weakReference.get() != null) {
                        property = WebSettings.getDefaultUserAgent(this.b.get());
                    }
                    d();
                }
                property = System.getProperty("http.agent");
                this.a = property;
            } catch (Throwable unused) {
                this.a = System.getProperty("http.agent");
            }
            d();
        }
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            List<String> list = c;
            if (i >= list.size()) {
                return false;
            }
            if (str.contains(list.get(i))) {
                return true;
            }
            i++;
        }
    }
}
