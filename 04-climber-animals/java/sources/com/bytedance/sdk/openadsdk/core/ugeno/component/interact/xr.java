package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ao;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr {
    protected ah ah;
    protected boolean d = false;
    private EasyPlayableContainer ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final lm f3460ms;
    protected ms xr;

    protected abstract int ms();

    public abstract boolean ms(int i, int i2);

    public abstract ab xr();

    public xr(lm lmVar, ms msVar, ah ahVar) {
        this.f3460ms = lmVar;
        this.xr = msVar;
        this.ah = ahVar;
    }

    protected void ms(final ViewGroup viewGroup, final View view, final View view2, final boolean z, final boolean z2, final float[] fArr, final com.bytedance.sdk.openadsdk.core.b.xr xrVar) {
        final HashMap map = new HashMap();
        map.put(j.w.E, Integer.valueOf(ms()));
        if (viewGroup == null || view == null || view2 == null) {
            map.put("error_code", 102);
            this.ah.ms(false, (Map<String, Object>) map);
        } else {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (xr.this.ms(view.getWidth(), view.getHeight())) {
                        boolean[] zArr = {true};
                        ao aoVarMs = xr.this.ms(zArr, fArr, xrVar, view.getWidth(), view.getHeight());
                        if (!zArr[0]) {
                            xr.this.ms(xrVar);
                            return;
                        }
                        xr.this.ah.xr(xr.this.ms());
                        if (view2.getParent() != null) {
                            ((ViewGroup) view2.getParent()).removeView(view2);
                        }
                        xr.this.ka = new EasyPlayableContainer(re.getContext(), xr.this.xr(), aoVarMs, xr.this.f3460ms);
                        xr.this.ka.setTag("easy_pfwv");
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams.gravity = 17;
                        xr.this.ka.addView(view2, layoutParams);
                        map.put("container_name", viewGroup.getClass().getName());
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int[] iArr2 = new int[2];
                        viewGroup.getLocationInWindow(iArr2);
                        ViewGroup viewGroup2 = viewGroup;
                        if (viewGroup2 instanceof RelativeLayout) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
                            layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                            xr.this.ka.setLayoutParams(layoutParams2);
                            viewGroup.addView(xr.this.ka);
                            if (!z) {
                                viewGroup.setClipChildren(false);
                            }
                            if (z2) {
                                map.put("error_code", 105);
                            } else {
                                xr.this.ah.ms(true, (Map<String, Object>) map);
                                xr.this.ms(xrVar, aoVarMs);
                                return;
                            }
                        } else if (viewGroup2 instanceof FrameLayout) {
                            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                            layoutParams3.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                            xr.this.ka.setLayoutParams(layoutParams3);
                            viewGroup.addView(xr.this.ka);
                            if (!z) {
                                viewGroup.setClipChildren(false);
                            }
                            if (z2) {
                                map.put("error_code", 105);
                            } else {
                                xr.this.ah.ms(true, (Map<String, Object>) map);
                                xr.this.ms(xrVar, aoVarMs);
                                return;
                            }
                        }
                        xr.this.ah.ms(false, (Map<String, Object>) map);
                        return;
                    }
                    map.put("view_width", Integer.valueOf(view.getWidth()));
                    map.put("view_height", Integer.valueOf(view.getHeight()));
                    map.put("error_code", 103);
                    xr.this.ah.ms(false, (Map<String, Object>) map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao ms(boolean[] zArr, float[] fArr, com.bytedance.sdk.openadsdk.core.b.xr xrVar, float f, float f2) {
        ao aoVarMs = xrVar != null ? ao.ms(xrVar.xr()) : null;
        if (fArr == null) {
            if (aoVarMs == null) {
                return new ao(0.0d, 0.0d, ul.d(re.getContext(), f), ul.d(re.getContext(), f2));
            }
            return aoVarMs;
        }
        final ao aoVarMs2 = ms(fArr, f, f2);
        if (aoVarMs == null) {
            return aoVarMs2;
        }
        double dMs = ao.ms(aoVarMs, aoVarMs2);
        final double d = aoVarMs2.ah * aoVarMs2.d;
        final double d2 = aoVarMs.ah * aoVarMs.d;
        final ao aoVarXr = ao.xr(aoVarMs, aoVarMs2);
        final double d3 = aoVarXr != null ? aoVarXr.ah * aoVarXr.d : 0.0d;
        if (xrVar != null) {
            xrVar.ms(new com.bytedance.sdk.openadsdk.core.b.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xr.2
                @Override // com.bytedance.sdk.openadsdk.core.b.ah
                public JSONObject getMaxRectJson() {
                    return ao.ms(aoVarXr);
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.ah
                public double getExceedAreaRate() {
                    double d4 = d2;
                    if (d4 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d <= 0.0d) {
                        return -1.0d;
                    }
                    return (d3 - d4) / d4;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.ah
                public JSONObject getActualRectJson() {
                    return ao.ms(aoVarMs2);
                }
            });
        }
        if (d2 <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (d <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        double d4 = dMs / d;
        boolean z = d4 >= 0.8d;
        com.bytedance.sdk.component.utils.sl.ms("xeasy", "A:" + d2 + " B:" + d + " o:" + dMs + " R:" + d4);
        if (z) {
            return aoVarXr;
        }
        zArr[0] = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.b.xr xrVar, ao aoVar) {
        if (xrVar != null) {
            xrVar.ms(true, ao.ms(aoVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.b.xr xrVar) {
        if (xrVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.xr("xeasy", e.getMessage());
            }
            xrVar.ms(false, jSONObject);
        }
    }

    private ao ms(float[] fArr, float f, float f2) {
        int iD = ul.d(re.getContext(), f);
        int iD2 = ul.d(re.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iD - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        float f6 = (iD2 - f4) - fArr[2];
        return new ao(f3, f4, f5, f6 >= 0.0f ? f6 : 0.0f);
    }
}
