package com.anythink.basead.mraid;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Handler.Callback {
    Context a;
    MraidBaseWebView c;
    protected Pattern d;
    protected String e;
    List<String> f = new ArrayList(Arrays.asList("open", ILivePush.ClickType.CLOSE, "unload", "useCustomClose", "expand"));
    Handler b = new Handler(Looper.getMainLooper(), this);

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public a(Context context) {
        this.a = context;
    }

    private void a(Pattern pattern) {
        this.d = pattern;
    }

    private void c(String str) {
        this.e = str;
    }

    private void a(MraidBaseWebView mraidBaseWebView) {
        this.c = mraidBaseWebView;
    }

    public final boolean a(String str) {
        if (!com.anythink.core.express.d.d.a(str)) {
            return false;
        }
        this.d = com.anythink.core.express.d.d.b(str);
        this.e = str;
        return true;
    }

    private String a() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void b(String str) {
        C0046a c0046aD;
        Object jsObject;
        byte b;
        if (TextUtils.isEmpty(str) || (c0046aD = d(str)) == null || (jsObject = this.c.getJsObject(c0046aD.b)) == null || !(jsObject instanceof h)) {
            return;
        }
        try {
            String str2 = c0046aD.c;
            switch (str2.hashCode()) {
                case -1289167206:
                    if (!str2.equals("expand")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case -840442113:
                    if (!str2.equals("unload")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 3417674:
                    if (!str2.equals("open")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 94756344:
                    if (!str2.equals(ILivePush.ClickType.CLOSE)) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1614272768:
                    if (!str2.equals("useCustomClose")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            String str3 = "{}";
            if (b == 0) {
                h hVar = (h) jsObject;
                if (!TextUtils.isEmpty(c0046aD.d)) {
                    str3 = c0046aD.d;
                }
                hVar.a(str3);
                return;
            }
            if (b == 1) {
                TextUtils.isEmpty(c0046aD.d);
                ((h) jsObject).a();
                return;
            }
            if (b == 2) {
                TextUtils.isEmpty(c0046aD.d);
                ((h) jsObject).b();
                return;
            }
            if (b == 3) {
                h hVar2 = (h) jsObject;
                if (!TextUtils.isEmpty(c0046aD.d)) {
                    str3 = c0046aD.d;
                }
                hVar2.b(str3);
                return;
            }
            if (b != 4) {
                return;
            }
            h hVar3 = (h) jsObject;
            if (!TextUtils.isEmpty(c0046aD.d)) {
                str3 = c0046aD.d;
            }
            hVar3.c(str3);
        } catch (Throwable unused) {
        }
    }

    private C0046a d(String str) {
        Set<String> setUnmodifiableSet;
        if (str == null) {
            return null;
        }
        C0046a c0046a = new C0046a();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains("mraid")) {
            return null;
        }
        String host = uri.getHost();
        c0046a.c = host;
        if (!this.f.contains(host) && this.c != null) {
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(this.c, host);
            com.anythink.core.express.b.a.a();
            com.anythink.core.express.b.a.a(this.c, host, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int iIndexOf = encodedQuery.indexOf(38, i);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
                i = iIndexOf + 1;
            } while (i < encodedQuery.length());
            setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : setUnmodifiableSet) {
                jSONObject.put(str2, uri.getQueryParameter(str2));
            }
            c0046a.d = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c0046a;
    }

    private static Set<String> a(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int iIndexOf = encodedQuery.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = encodedQuery.length();
            }
            int iIndexOf2 = encodedQuery.indexOf(61, i);
            if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
            i = iIndexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(C0046a c0046a) {
        byte b;
        Object jsObject = this.c.getJsObject(c0046a.b);
        if (jsObject != null && (jsObject instanceof h)) {
            try {
                String str = c0046a.c;
                switch (str.hashCode()) {
                    case -1289167206:
                        if (!str.equals("expand")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case -840442113:
                        if (!str.equals("unload")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 3417674:
                        if (!str.equals("open")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 94756344:
                        if (!str.equals(ILivePush.ClickType.CLOSE)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 1614272768:
                        if (!str.equals("useCustomClose")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                String str2 = "{}";
                if (b == 0) {
                    h hVar = (h) jsObject;
                    if (!TextUtils.isEmpty(c0046a.d)) {
                        str2 = c0046a.d;
                    }
                    hVar.a(str2);
                    return;
                }
                if (b == 1) {
                    TextUtils.isEmpty(c0046a.d);
                    ((h) jsObject).a();
                    return;
                }
                if (b == 2) {
                    TextUtils.isEmpty(c0046a.d);
                    ((h) jsObject).b();
                    return;
                }
                if (b == 3) {
                    h hVar2 = (h) jsObject;
                    if (!TextUtils.isEmpty(c0046a.d)) {
                        str2 = c0046a.d;
                    }
                    hVar2.b(str2);
                    return;
                }
                if (b != 4) {
                    return;
                }
                h hVar3 = (h) jsObject;
                if (!TextUtils.isEmpty(c0046a.d)) {
                    str2 = c0046a.d;
                }
                hVar3.c(str2);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.a$a, reason: collision with other inner class name */
    public class C0046a {
        public Object a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public C0046a() {
        }
    }
}
