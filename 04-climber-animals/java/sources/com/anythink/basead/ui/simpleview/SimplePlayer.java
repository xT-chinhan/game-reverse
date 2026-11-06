package com.anythink.basead.ui.simpleview;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.b.f;
import com.anythink.basead.exoplayer.ad;
import com.anythink.basead.exoplayer.d;
import com.anythink.basead.exoplayer.h.o;
import com.anythink.basead.exoplayer.h.s;
import com.anythink.basead.exoplayer.i;
import com.anythink.basead.exoplayer.i.c;
import com.anythink.basead.exoplayer.j.q;
import com.anythink.basead.exoplayer.l.g;
import com.anythink.basead.exoplayer.w;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SimplePlayer extends RelativeLayout {
    public static final String TAG = "SimplePlayer";
    w.a a;
    g b;
    boolean c;
    boolean d;
    private ad e;
    private s f;
    private TextureView g;
    private boolean h;
    private String i;
    private String j;
    private final long k;
    private a l;

    public interface a {
        void a();

        void b();
    }

    static /* synthetic */ boolean c(SimplePlayer simplePlayer) {
        simplePlayer.h = false;
        return false;
    }

    public SimplePlayer(Context context) {
        this(context, null);
    }

    public SimplePlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimplePlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = "";
        this.j = "";
        this.k = 5000L;
        this.h = false;
        setBackgroundColor(Color.parseColor("#000000"));
        if (this.g == null) {
            TextureView textureView = new TextureView(getContext());
            this.g = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.g, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ad adVar = this.e;
        if (adVar != null) {
            if (adVar.J()) {
                this.e.m();
            }
            w.a aVar = this.a;
            if (aVar != null) {
                this.e.b(aVar);
            }
            g gVar = this.b;
            if (gVar != null) {
                this.e.b(gVar);
            }
            this.e.n();
            this.e = null;
        }
        this.l = null;
    }

    private void a() {
        this.h = false;
        setBackgroundColor(Color.parseColor("#000000"));
        if (this.g == null) {
            TextureView textureView = new TextureView(getContext());
            this.g = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.g, layoutParams);
        }
    }

    private void b() {
        if (this.g == null) {
            TextureView textureView = new TextureView(getContext());
            this.g = textureView;
            textureView.setKeepScreenOn(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.g, layoutParams);
        }
    }

    public void load(String str, boolean z) {
        String str2;
        this.j = str;
        f.a();
        this.i = f.a(3, str);
        this.d = false;
        if (!new File(this.i).exists() && TextUtils.isEmpty(this.j)) {
            e();
            return;
        }
        if (this.e == null) {
            this.e = i.a(new com.anythink.basead.exoplayer.f(getContext()), new c(), new d());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            this.a = anonymousClass2;
            this.e.a(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            this.b = anonymousClass3;
            this.e.a(anonymousClass3);
            this.e.a(1.0f);
            this.e.a(z);
            if (new File(this.i).exists()) {
                str2 = this.i;
            } else {
                str2 = this.j;
            }
            a(str2, false);
        }
        postDelayed(new Runnable() { // from class: com.anythink.basead.ui.simpleview.SimplePlayer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SimplePlayer.this.d) {
                    return;
                }
                SimplePlayer.this.e();
            }
        }, 5000L);
    }

    private void a(boolean z) {
        String str;
        if (this.e == null) {
            this.e = i.a(new com.anythink.basead.exoplayer.f(getContext()), new c(), new d());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            this.a = anonymousClass2;
            this.e.a(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            this.b = anonymousClass3;
            this.e.a(anonymousClass3);
            this.e.a(1.0f);
            this.e.a(z);
            if (new File(this.i).exists()) {
                str = this.i;
            } else {
                str = this.j;
            }
            a(str, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.simpleview.SimplePlayer$2, reason: invalid class name */
    final class AnonymousClass2 extends w.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.exoplayer.w.a, com.anythink.basead.exoplayer.w.c
        public final void onPlayerError(com.anythink.basead.exoplayer.g gVar) {
            String str;
            super.onPlayerError(gVar);
            boolean z = false;
            if (gVar != null) {
                int i = gVar.d;
                if (i == 0) {
                    str = "Play error, because have a SourceException.";
                    z = true;
                } else if (i != 1) {
                    str = i != 2 ? "Play error and ExoPlayer have not message." : "Play error, because have a UnexpectedException.";
                } else {
                    str = "Play error, because have a RendererException.";
                }
                if (gVar.getCause() != null && !TextUtils.isEmpty(gVar.getCause().getMessage())) {
                    String str2 = str + ",eception:" + gVar.getCause().getMessage();
                }
            }
            if (SimplePlayer.this.h && z) {
                String str3 = SimplePlayer.TAG;
                SimplePlayer.c(SimplePlayer.this);
                SimplePlayer.d(SimplePlayer.this);
                return;
            }
            String str4 = SimplePlayer.TAG;
        }

        @Override // com.anythink.basead.exoplayer.w.a, com.anythink.basead.exoplayer.w.c
        public final void onPlayerStateChanged(boolean z, int i) {
            super.onPlayerStateChanged(z, i);
            String str = SimplePlayer.TAG;
            if (i != 3) {
                return;
            }
            SimplePlayer.this.d = true;
            if (SimplePlayer.this.l != null) {
                SimplePlayer.this.l.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.simpleview.SimplePlayer$3, reason: invalid class name */
    final class AnonymousClass3 implements g {
        @Override // com.anythink.basead.exoplayer.l.g
        public final void a() {
        }

        AnonymousClass3() {
        }

        @Override // com.anythink.basead.exoplayer.l.g
        public final void a(int i, int i2) {
            SimplePlayer simplePlayer = SimplePlayer.this;
            simplePlayer.autoFitVideoSize(i, i2, simplePlayer.g);
        }
    }

    private String c() {
        if (new File(this.i).exists()) {
            return this.i;
        }
        return this.j;
    }

    public void autoFitVideoSize(int i, int i2, View view) {
        float f = i;
        float f2 = i2;
        float fMax = Math.max(f / view.getMeasuredWidth(), f2 / view.getMeasuredHeight());
        int iCeil = (int) Math.ceil(f / fMax);
        int iCeil2 = (int) Math.ceil(f2 / fMax);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = iCeil;
        layoutParams.height = iCeil2;
        view.setLayoutParams(layoutParams);
    }

    private void d() {
        this.e.a(this.f);
    }

    private void a(String str, boolean z) {
        while (true) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.e == null) {
                    e();
                    return;
                }
                this.h = TextUtils.equals(str, this.i);
                Uri uri = Uri.parse(str);
                if (str.toLowerCase().startsWith("http")) {
                    this.f = new o.c(new q("Anythink_ExoPlayer")).b(uri);
                    this.c = true;
                } else {
                    this.f = new o.c(new com.anythink.basead.exoplayer.j.o(getContext(), "Anythink_ExoPlayer")).b(uri);
                    this.c = false;
                }
                this.e.a(this.g);
                this.e.a(this.f);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                if (TextUtils.equals(str, this.j) || z) {
                    th.getMessage();
                    e();
                } else {
                    str = this.j;
                    z = true;
                }
            }
        }
        th.getMessage();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a aVar = this.l;
        if (aVar != null) {
            aVar.b();
        }
    }

    private boolean f() {
        return !new File(this.i).exists() && TextUtils.isEmpty(this.j);
    }

    public void stopVideo() {
        ad adVar = this.e;
        if (adVar == null || !adVar.J()) {
            return;
        }
        this.e.m();
    }

    public void setSimplePlayerViewListener(a aVar) {
        this.l = aVar;
    }

    private void g() {
        ad adVar = this.e;
        if (adVar != null) {
            if (adVar.J()) {
                this.e.m();
            }
            w.a aVar = this.a;
            if (aVar != null) {
                this.e.b(aVar);
            }
            g gVar = this.b;
            if (gVar != null) {
                this.e.b(gVar);
            }
            this.e.n();
            this.e = null;
        }
        this.l = null;
    }

    static /* synthetic */ void d(SimplePlayer simplePlayer) {
        simplePlayer.e.a(simplePlayer.f);
    }
}
