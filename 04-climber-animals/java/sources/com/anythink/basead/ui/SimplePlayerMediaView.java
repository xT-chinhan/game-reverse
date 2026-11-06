package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SimplePlayerMediaView extends FrameLayout implements a {
    protected com.anythink.basead.ui.component.a a;
    protected WebProgressBarView b;
    long c;
    a.InterfaceC0052a d;
    com.anythink.core.common.v.a.c e;
    f.b f;
    ImageView g;
    ImageView h;
    ImageView i;
    ImageView j;
    View k;
    View.OnClickListener l;
    boolean m;
    String n;
    boolean o;
    boolean p;
    int q;
    int r;
    private MuteImageView s;
    private final AtomicBoolean t;
    private final String u;
    private final String v;
    private final String w;
    private boolean x;
    private e y;

    public SimplePlayerMediaView(Context context) {
        this(context, null);
    }

    public SimplePlayerMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimplePlayerMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = false;
        this.t = new AtomicBoolean(false);
        this.u = "1";
        this.v = "2";
        this.w = "3";
        this.n = "1";
        this.o = true;
        this.p = false;
        this.q = 0;
        this.x = false;
        this.r = 1;
    }

    @Override // com.anythink.basead.ui.a
    public void initPlayerView(final w wVar, final x xVar, com.anythink.basead.ui.component.a.InterfaceC0058a interfaceC0058a, e eVar) {
        a();
        if (wVar != null && wVar.r() != null) {
            this.r = wVar.r().bL();
        }
        this.f = new f.b(this.r);
        this.y = eVar;
        this.b = (WebProgressBarView) findViewById(q.a(getContext(), "myoffer_player_view_progress_bar_id", "id"));
        this.g = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_resume_img_id", "id"));
        this.i = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_cover_img_id", "id"));
        this.j = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_cover_icon_id", "id"));
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimplePlayerMediaView.this.m = false;
                    SimplePlayerMediaView.this.g.setVisibility(8);
                    if (SimplePlayerMediaView.this.a != null) {
                        SimplePlayerMediaView.this.a.d();
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(q.a(getContext(), "myoffer_player_view_replay_img_id", "id"));
        this.h = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (SimplePlayerMediaView.this.a != null) {
                        SimplePlayerMediaView.this.a.n();
                        SimplePlayerMediaView.this.h.setVisibility(8);
                    }
                }
            });
        }
        this.q = xVar.o.Z() <= 0 ? 100 : xVar.o.Z();
        this.k = findViewById(q.a(getContext(), "myoffer_player_view_fail_id", "id"));
        com.anythink.basead.ui.component.a aVar = new com.anythink.basead.ui.component.a(this, xVar, wVar);
        this.a = aVar;
        aVar.o();
        this.a.a(interfaceC0058a);
        this.a.a(new BasePlayerView.a() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.3
            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(int i) {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void d() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void e() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void f() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a() {
                if (SimplePlayerMediaView.this.i != null) {
                    SimplePlayerMediaView.this.i.setVisibility(8);
                }
                if (SimplePlayerMediaView.this.j != null) {
                    SimplePlayerMediaView.this.j.setVisibility(8);
                }
                if (SimplePlayerMediaView.this.d != null) {
                    SimplePlayerMediaView.this.d.onVideoAdStartPlay(SimplePlayerMediaView.this.c);
                }
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(long j) {
                if (SimplePlayerMediaView.this.c > 0 && SimplePlayerMediaView.this.b != null) {
                    if (SimplePlayerMediaView.this.b.getVisibility() != 0) {
                        SimplePlayerMediaView.this.b.setVisibility(0);
                    }
                    SimplePlayerMediaView.this.b.setProgress((int) ((j * 100.0d) / SimplePlayerMediaView.this.c));
                }
                if (SimplePlayerMediaView.this.d != null) {
                    SimplePlayerMediaView.this.d.onProgressUpdate(j, SimplePlayerMediaView.this.c);
                }
                if (SimplePlayerMediaView.this.h != null) {
                    SimplePlayerMediaView.this.h.setVisibility(8);
                }
                if (SimplePlayerMediaView.this.k != null) {
                    SimplePlayerMediaView.this.k.setVisibility(8);
                }
                if (SimplePlayerMediaView.this.m || SimplePlayerMediaView.this.a == null) {
                    return;
                }
                f.b bVar = SimplePlayerMediaView.this.f;
                SimplePlayerMediaView simplePlayerMediaView = SimplePlayerMediaView.this;
                if (bVar.a(simplePlayerMediaView, simplePlayerMediaView.a.l(), 50, 0)) {
                    return;
                }
                SimplePlayerMediaView.this.a.d(2);
                SimplePlayerMediaView.this.c();
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void c() {
                if (SimplePlayerMediaView.this.c > 0 && SimplePlayerMediaView.this.b != null) {
                    if (SimplePlayerMediaView.this.b.getVisibility() != 0) {
                        SimplePlayerMediaView.this.b.setVisibility(0);
                    }
                    SimplePlayerMediaView.this.b.setProgress(100);
                }
                if (SimplePlayerMediaView.this.d != null) {
                    SimplePlayerMediaView.this.d.onVideoAdComplete();
                }
                if (SimplePlayerMediaView.this.h != null) {
                    SimplePlayerMediaView.this.h.setVisibility(0);
                }
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(com.anythink.basead.d.f fVar) {
                if (SimplePlayerMediaView.this.d != null) {
                    SimplePlayerMediaView.this.d.onVideoError(fVar.a(), fVar.b());
                }
                SimplePlayerMediaView.this.m = true;
                com.anythink.core.common.u.e.a(xVar, wVar, 2, fVar.c());
                if (SimplePlayerMediaView.this.a.i() > 0 && SimplePlayerMediaView.this.h != null) {
                    if (SimplePlayerMediaView.this.b != null) {
                        SimplePlayerMediaView.this.b.setVisibility(8);
                    }
                    SimplePlayerMediaView.this.h.setVisibility(0);
                } else if (SimplePlayerMediaView.this.k != null) {
                    SimplePlayerMediaView.this.k.setVisibility(0);
                }
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b(int i) {
                if ((SimplePlayerMediaView.this.x || xVar.o.H() == 0) && SimplePlayerMediaView.this.l != null) {
                    SimplePlayerMediaView.this.l.onClick(SimplePlayerMediaView.this);
                } else {
                    if (!String.valueOf(xVar.j).equals("0") || SimplePlayerMediaView.this.a == null || SimplePlayerMediaView.this.a.k() || !SimplePlayerMediaView.this.a.j()) {
                        return;
                    }
                    SimplePlayerMediaView.this.b();
                }
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b(long j) {
                SimplePlayerMediaView.this.c = j;
                if (j <= 0 || SimplePlayerMediaView.this.b == null) {
                    return;
                }
                SimplePlayerMediaView.this.b.setVisibility(0);
            }
        });
        if (!TextUtils.isEmpty(wVar.B()) && this.i != null) {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, wVar.B()), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.4
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, wVar.B())) {
                        if (SimplePlayerMediaView.this.j != null) {
                            SimplePlayerMediaView.this.j.setVisibility(8);
                        }
                        SimplePlayerMediaView.this.i.setImageBitmap(bitmap);
                    }
                }
            });
        }
        setAutoPlay(this.n);
        MuteImageView muteImageView = (MuteImageView) findViewById(q.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.s = muteImageView;
        if (muteImageView != null) {
            muteImageView.setMute(this.o);
            this.s.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (SimplePlayerMediaView.this.a == null || SimplePlayerMediaView.this.s == null) {
                        return;
                    }
                    if (!SimplePlayerMediaView.this.a.f()) {
                        SimplePlayerMediaView.this.s.setMute(true);
                        SimplePlayerMediaView.this.a.c(true);
                    } else {
                        SimplePlayerMediaView.this.s.setMute(false);
                        SimplePlayerMediaView.this.a.c(false);
                    }
                }
            });
        }
    }

    protected void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_simple_player_media_ad_view", "layout"), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.m = true;
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null && aVar.j()) {
            this.a.d(1);
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void resumeVideo() {
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            if (!this.m && this.f.a(this, aVar.l(), 50, 0)) {
                this.a.d();
            } else {
                c();
            }
        }
    }

    @Override // com.anythink.basead.ui.a
    public void pauseVideo() {
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            aVar.d(3);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setIsMuted(boolean z) {
        this.o = z;
        MuteImageView muteImageView = this.s;
        if (muteImageView != null) {
            muteImageView.setMute(z);
        }
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    @Override // com.anythink.basead.ui.a
    public void setAutoPlay(String str) {
        this.n = str;
        str.hashCode();
        boolean zD = true;
        switch (str) {
            case "1":
                break;
            case "2":
                zD = q.d(getContext());
                break;
            case "3":
            default:
                zD = false;
                break;
        }
        if (zD) {
            return;
        }
        b();
    }

    @Override // com.anythink.basead.ui.a
    public void setVideoListener(a.InterfaceC0052a interfaceC0052a) {
        this.d = interfaceC0052a;
    }

    @Override // com.anythink.basead.ui.a
    public void setATImproveClickViewController(com.anythink.basead.ui.improveclick.a aVar) {
        com.anythink.basead.ui.component.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    @Override // com.anythink.basead.ui.a
    public long getVideoCurrentPosition() {
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            return aVar.i();
        }
        return 0L;
    }

    @Override // com.anythink.basead.ui.a
    public void destroyPlayerView(int i) {
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            aVar.f(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null && !this.p) {
            this.p = true;
            aVar.a(this.o, (List<Bitmap>) null, this.y);
        }
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.anythink.core.common.v.a.c cVar = this.e;
        if (cVar != null) {
            cVar.b();
            this.e = null;
        }
        this.t.set(false);
        com.anythink.basead.ui.component.a aVar = this.a;
        if (aVar != null) {
            aVar.d(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e == null) {
            int i = this.r;
            getContext();
            this.e = new com.anythink.core.common.v.a.c(i, this.q);
        }
        if (this.m || this.t.get()) {
            return;
        }
        this.t.set(true);
        this.e.a(this, new com.anythink.core.common.v.a.a() { // from class: com.anythink.basead.ui.SimplePlayerMediaView.6
            @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
            public final int getImpressionMinPercentageViewed() {
                return 50;
            }

            @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
            public final void recordImpression(View view) {
                SimplePlayerMediaView.this.t.set(false);
                if (SimplePlayerMediaView.this.m || SimplePlayerMediaView.this.a == null) {
                    return;
                }
                SimplePlayerMediaView.this.a.d();
            }
        });
    }

    private void d() {
        com.anythink.core.common.v.a.c cVar = this.e;
        if (cVar != null) {
            cVar.b();
            this.e = null;
        }
        this.t.set(false);
    }

    @Override // com.anythink.basead.ui.a
    public void setPlayerOnClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setmIsPureMode(boolean z) {
        this.x = z;
    }
}
