package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.q1.a;
import com.smartdigimkt.q1.m;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlbumScaleAnimPlayerView extends BaseMainAnimPlayerView {
    public m C;
    public boolean D;
    public List E;
    public Paint F;

    public AlbumScaleAnimPlayerView(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(Context context) {
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{Color.parseColor("#DF4B32"), Color.parseColor("#800915")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.F = paint;
        paint.setShader(linearGradient);
        com.smartdigimkt.i3.m.a(getContext()).a(new o(1, this.w), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new a(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.release();
            this.C = null;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.start();
        } else {
            this.D = true;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.stop();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public int getMinAnimDuration() {
        return TTAdConstant.INIT_LOCAL_FAIL_CODE;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, com.smartdigimkt.a3.a aVar, boolean z, List<Bitmap> list) {
        this.E = list;
        super.init(cVar, aVar, z, list);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.F != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.F);
        }
    }

    public AlbumScaleAnimPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        m mVar = this.C;
        if (mVar != null) {
            mVar.pause();
        }
    }
}
