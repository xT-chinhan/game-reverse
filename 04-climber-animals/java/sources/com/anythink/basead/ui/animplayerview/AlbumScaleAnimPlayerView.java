package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.d.g;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlbumScaleAnimPlayerView extends BaseMainAnimPlayerView {
    private boolean A;
    private List<Bitmap> B;
    private Paint C;
    private c h;

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final int e() {
        return TTAdConstant.INIT_LOCAL_FAIL_CODE;
    }

    static /* synthetic */ boolean d(AlbumScaleAnimPlayerView albumScaleAnimPlayerView) {
        albumScaleAnimPlayerView.A = false;
        return false;
    }

    public AlbumScaleAnimPlayerView(Context context) {
        this(context, null);
    }

    public AlbumScaleAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView, com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        this.B = list;
        super.init(wVar, xVar, z, list, eVar);
    }

    private void i() {
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{Color.parseColor("#DF4B32"), Color.parseColor("#800915")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.C = paint;
        paint.setShader(linearGradient);
    }

    private void j() {
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, AlbumScaleAnimPlayerView.this.e)) {
                if (AlbumScaleAnimPlayerView.this.h == null) {
                    AlbumScaleAnimPlayerView.this.h = new AlbumScaleAnimatorView(AlbumScaleAnimPlayerView.this.getContext().getApplicationContext());
                    AlbumScaleAnimPlayerView.this.h.setBitmapResources(AlbumScaleAnimPlayerView.this.B);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    AlbumScaleAnimPlayerView albumScaleAnimPlayerView = AlbumScaleAnimPlayerView.this;
                    albumScaleAnimPlayerView.addView((View) albumScaleAnimPlayerView.h, layoutParams);
                    AlbumScaleAnimPlayerView.this.h.addMainView(bitmap, new WrapRoundImageView[0]);
                }
                if (AlbumScaleAnimPlayerView.this.A) {
                    AlbumScaleAnimPlayerView.d(AlbumScaleAnimPlayerView.this);
                    if (AlbumScaleAnimPlayerView.this.h != null) {
                        AlbumScaleAnimPlayerView.this.h.start();
                    }
                }
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            AlbumScaleAnimPlayerView.this.a(g.a(g.l, g.T));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void a() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.start();
        } else {
            this.A = true;
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void b() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void c() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void d() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.release();
            this.h = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.C);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    protected final void a(Context context) {
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{Color.parseColor("#DF4B32"), Color.parseColor("#800915")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.C = paint;
        paint.setShader(linearGradient);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new AnonymousClass1());
    }
}
