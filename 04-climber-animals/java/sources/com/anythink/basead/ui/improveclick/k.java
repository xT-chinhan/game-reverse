package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.specialnote.BaseSpecialNoteView;
import com.anythink.basead.ui.specialnote.ScreenSpecialNoteView;
import com.anythink.basead.ui.specialnote.SimpleSpecialNoteView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends c {
    BaseSpecialNoteView a;
    private long b;
    private boolean c = false;
    private boolean l = false;

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        int i2 = this.h;
        if (i2 == 4 || i2 == 5 || i2 == 6) {
            this.a = new SimpleSpecialNoteView(this.d);
        } else {
            this.a = new ScreenSpecialNoteView(this.d);
        }
        if (this.f == null || !String.valueOf(this.f.j).equals("4") || this.f.o == null) {
            return;
        }
        this.b = this.f.o.x();
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        if (i == 102) {
            this.l = true;
            return;
        }
        if (i == 103) {
            if (!a(map) && com.anythink.basead.b.e.a(this.e, this.f)) {
                a(7);
                return;
            }
            return;
        }
        if (i != 119) {
            switch (i) {
                case 112:
                    break;
                case 113:
                    this.c = true;
                    break;
                case 114:
                    if (com.anythink.basead.b.e.a(this.e, this.f)) {
                        if (this.h == 1) {
                            if (this.l) {
                                return;
                            }
                            a(6);
                            return;
                        }
                        a(6);
                        return;
                    }
                    a(5);
                    return;
                default:
                    return;
            }
            a();
            return;
        }
        a();
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
        BaseSpecialNoteView baseSpecialNoteView = this.a;
        if (baseSpecialNoteView != null) {
            baseSpecialNoteView.release();
        }
    }

    private void a(int i) {
        long jAi;
        long jAj;
        if (this.e.c() || this.c || this.a == null) {
            return;
        }
        if (i != 5) {
            if (i == 6) {
                if (!this.f.o.ag()) {
                    return;
                }
                jAi = this.f.o.ai();
                jAj = this.f.o.aj();
            } else {
                if (i != 7 || !this.f.o.ah()) {
                    return;
                }
                jAi = this.f.o.ak();
                jAj = this.f.o.al();
            }
        } else {
            if (!this.f.o.af()) {
                return;
            }
            jAi = this.f.o.ai();
            jAj = this.f.o.aj();
        }
        long j = this.b;
        long j2 = 0;
        if (j <= 0 || j >= jAi + jAj + 1000) {
            j2 = jAi;
        } else if (jAj + 1000 >= j) {
            jAj = j - 1000;
        } else {
            jAi = (j - jAj) - 1000;
            j2 = jAi;
        }
        a(i, j2, jAj);
    }

    private void a(final int i, final long j, final long j2) {
        if (j >= 0 && j2 >= 0) {
            t.b().b(new Runnable() { // from class: com.anythink.basead.ui.improveclick.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (k.this.a != null) {
                        if (k.this.a.getParent() == null) {
                            k.this.a.initSetting(k.this.g, i, new BaseSpecialNoteView.a() { // from class: com.anythink.basead.ui.improveclick.k.1.1
                                @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a
                                public final void a(int i2) {
                                    if (k.this.k != null) {
                                        k.this.k.a(i2, 4);
                                    }
                                }
                            }, j, j2);
                            k.this.g.addView(k.this.a);
                        } else if (i == 7 && com.anythink.basead.b.e.a(k.this.e, k.this.f) && !k.this.a.hasBeenShow()) {
                            k.this.a.pause();
                            k.this.a.reset(i, j, j2);
                            k.this.a.resume();
                        }
                    }
                }
            });
        }
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        BaseSpecialNoteView baseSpecialNoteView = this.a;
        if (baseSpecialNoteView != null) {
            baseSpecialNoteView.setLayoutParams(layoutParams);
        }
    }

    public final void a(long j) {
        if (this.f == null || TextUtils.equals(String.valueOf(this.f.j), "4")) {
            return;
        }
        this.b = j;
    }
}
