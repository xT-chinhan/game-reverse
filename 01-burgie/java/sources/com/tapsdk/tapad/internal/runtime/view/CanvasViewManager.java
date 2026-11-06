package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes3.dex */
public class CanvasViewManager extends BaseViewManager<CanvasView, CanvasViewProps> {
    private static final String TAG = "CanvasViewManager";

    private int parseCanvasColor(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Color.parseColor(str.trim());
            } catch (Exception e) {
            }
        }
        return -1;
    }

    private CanvasView.FloatValue parseFloatValue(String str) {
        String strTrim = str.trim();
        if (!strTrim.startsWith("var:")) {
            return CanvasView.FloatValue.literal(Float.parseFloat(strTrim));
        }
        String strSubstring = strTrim.substring(4);
        int iIndexOf = strSubstring.indexOf(42);
        return iIndexOf > 0 ? CanvasView.FloatValue.variable(strSubstring.substring(0, iIndexOf).trim(), Float.parseFloat(strSubstring.substring(iIndexOf + 1).trim())) : CanvasView.FloatValue.variable(strSubstring);
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return "Canvas";
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<CanvasViewProps> getPropsClass() {
        return CanvasViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 6;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(CanvasView canvasView, CanvasViewProps canvasViewProps) {
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public CanvasView createView(Context context, String str) {
        return new CanvasView(context);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(CanvasView canvasView, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (str.startsWith("var_")) {
            try {
                canvasView.setVariable(str.substring(4), Float.parseFloat(str2));
            } catch (NumberFormatException e) {
                return;
            }
        }
        byte b = 8;
        if (str.startsWith("animate_")) {
            String strSubstring = str.substring(8);
            try {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length < 4) {
                    canvasView.animateVariable(strSubstring, Float.parseFloat(strArrSplit[0]), strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, strArrSplit.length > 2 ? strArrSplit[2] : LinearContainerViewManager.NAME);
                    return;
                }
                float f = Float.parseFloat(strArrSplit[0]);
                float f2 = Float.parseFloat(strArrSplit[1]);
                int i = Integer.parseInt(strArrSplit[2]);
                String str3 = strArrSplit[3];
                canvasView.setVariable(strSubstring, f);
                canvasView.animateVariable(strSubstring, f2, i, str3);
                return;
            } catch (Exception e2) {
                return;
            }
        }
        switch (str.hashCode()) {
            case -2053721731:
                b = !str.equals("clearCircle") ? (byte) -1 : (byte) 0;
                break;
            case -1430687443:
                b = !str.equals("clearStrokeArc") ? (byte) -1 : (byte) 1;
                break;
            case -1340766219:
                b = !str.equals("clearCommands") ? (byte) -1 : (byte) 2;
                break;
            case -1270966831:
                b = !str.equals("clearRect") ? (byte) -1 : (byte) 3;
                break;
            case -1093382440:
                b = !str.equals("fillArcVar") ? (byte) -1 : (byte) 4;
                break;
            case -854820401:
                b = !str.equals("fillArc") ? (byte) -1 : (byte) 5;
                break;
            case -729134585:
                b = !str.equals("fillRect") ? (byte) -1 : (byte) 6;
                break;
            case -20365062:
                b = !str.equals("strokeArc") ? (byte) -1 : (byte) 7;
                break;
            case 462434475:
                if (!str.equals("fillTriangle")) {
                    b = -1;
                }
                break;
            default:
                b = -1;
                break;
        }
        try {
            switch (b) {
                case 0:
                    String[] strArrSplit2 = str2.split(",");
                    canvasView.addClearCircle(Float.parseFloat(strArrSplit2[0]), Float.parseFloat(strArrSplit2[1]), Float.parseFloat(strArrSplit2[2]));
                    break;
                case 1:
                    String[] strArrSplit3 = str2.split(",");
                    canvasView.addClearStrokeArc(Float.parseFloat(strArrSplit3[0]), Float.parseFloat(strArrSplit3[1]), Float.parseFloat(strArrSplit3[2]), parseFloatValue(strArrSplit3[3]), parseFloatValue(strArrSplit3[4]), Float.parseFloat(strArrSplit3[5]));
                    break;
                case 2:
                    canvasView.clearCommands();
                    break;
                case 3:
                    String[] strArrSplit4 = str2.split(",");
                    canvasView.addClearRect(Float.parseFloat(strArrSplit4[0]), Float.parseFloat(strArrSplit4[1]), Float.parseFloat(strArrSplit4[2]), Float.parseFloat(strArrSplit4[3]));
                    break;
                case 4:
                    String[] strArrSplit5 = str2.split(",");
                    canvasView.addFillArcVar(Float.parseFloat(strArrSplit5[0]), Float.parseFloat(strArrSplit5[1]), Float.parseFloat(strArrSplit5[2]), strArrSplit5[3], strArrSplit5[4], parseCanvasColor(strArrSplit5[5]));
                    break;
                case 5:
                    String[] strArrSplit6 = str2.split(",");
                    canvasView.addFillArc(Float.parseFloat(strArrSplit6[0]), Float.parseFloat(strArrSplit6[1]), Float.parseFloat(strArrSplit6[2]), Float.parseFloat(strArrSplit6[3]), Float.parseFloat(strArrSplit6[4]), parseCanvasColor(strArrSplit6[5]));
                    break;
                case 6:
                    String[] strArrSplit7 = str2.split(",");
                    canvasView.addFillRect(Float.parseFloat(strArrSplit7[0]), Float.parseFloat(strArrSplit7[1]), Float.parseFloat(strArrSplit7[2]), Float.parseFloat(strArrSplit7[3]), parseCanvasColor(strArrSplit7[4]));
                    break;
                case 7:
                    String[] strArrSplit8 = str2.split(",");
                    canvasView.addStrokeArc(Float.parseFloat(strArrSplit8[0]), Float.parseFloat(strArrSplit8[1]), Float.parseFloat(strArrSplit8[2]), parseFloatValue(strArrSplit8[3]), parseFloatValue(strArrSplit8[4]), parseCanvasColor(strArrSplit8[5]), Float.parseFloat(strArrSplit8[6]));
                    break;
                case 8:
                    String[] strArrSplit9 = str2.split(",");
                    canvasView.addFillTriangle(Float.parseFloat(strArrSplit9[0]), Float.parseFloat(strArrSplit9[1]), Float.parseFloat(strArrSplit9[2]), Float.parseFloat(strArrSplit9[3]), Float.parseFloat(strArrSplit9[4]), Float.parseFloat(strArrSplit9[5]), parseCanvasColor(strArrSplit9[6]));
                    break;
            }
        } catch (Exception e3) {
        }
    }
}
