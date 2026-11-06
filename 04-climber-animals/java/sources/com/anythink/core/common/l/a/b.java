package com.anythink.core.common.l.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.IATBaseAdAdapter;
import com.anythink.core.common.h.n;
import com.anythink.core.common.l.g.c;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements IATBaseAdAdapter {
    private static final String a = "b";
    private static final String b = "not support this format: %s";
    private IATBaseAdAdapter c;
    private Map<Integer, Class<? extends ATBaseAdAdapter>> d;
    private String e;

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }

    public b(IATBaseAdAdapter iATBaseAdAdapter) {
        this.c = iATBaseAdAdapter;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2, ATCustomLoadListener aTCustomLoadListener) {
        if (this.c != null) {
            this.c = a(map, map2);
            Object[] objArr = new Object[2];
            if (a()) {
                if (aTCustomLoadListener != null) {
                    aTCustomLoadListener.onAdLoadError("", this.e);
                    return;
                }
                return;
            }
            IATBaseAdAdapter iATBaseAdAdapter = this.c;
            if (iATBaseAdAdapter == null || aTCustomLoadListener == null) {
                aTCustomLoadListener = null;
            } else {
                com.anythink.core.common.l.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
                if (serverExtraInfo != null && serverExtraInfo.k()) {
                    aTCustomLoadListener = new c(aTCustomLoadListener, serverExtraInfo);
                }
            }
            iATBaseAdAdapter.setLoadListener(aTCustomLoadListener);
            this.c.loadCustomNetworkAd(context, map, map2);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        if (this.c == null) {
            return false;
        }
        this.c = a(map, map2);
        Object[] objArr = new Object[2];
        if (a()) {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(this.e), null);
            }
            return false;
        }
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter == null || aTBiddingListener == null) {
            aTBiddingListener = null;
        } else {
            com.anythink.core.common.l.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
            if (serverExtraInfo != null && serverExtraInfo.k()) {
                aTBiddingListener = new com.anythink.core.common.l.g.b(aTBiddingListener, serverExtraInfo);
            }
        }
        this.c.setBiddingListener(aTBiddingListener);
        return this.c.startBiddingRequest(context, map, map2, aTBiddingListener);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        if (this.c != null) {
            this.c = a(map, map2);
            Object[] objArr = new Object[1];
            if (!a()) {
                this.c.getBidRequestInfo(context, map, map2, aTBidRequestInfoListener);
            } else if (aTBidRequestInfoListener != null) {
                aTBidRequestInfoListener.onFailed(this.e);
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (this.c != null) {
            IATBaseAdAdapter iATBaseAdAdapterA = a(map, map2);
            this.c = iATBaseAdAdapterA;
            Object[] objArr = new Object[1];
            if (iATBaseAdAdapterA != null && iATBaseAdAdapterA.initNetworkObjectByPlacementId(context, map, map2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void internalFormatShow(Activity activity, ViewGroup viewGroup, ATCommonImpressionListener aTCommonImpressionListener) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            Object[] objArr = new Object[1];
            iATBaseAdAdapter.internalFormatShow(activity, viewGroup, aTCommonImpressionListener);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void setLoadListener(ATCustomLoadListener aTCustomLoadListener) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            Object[] objArr = new Object[1];
            iATBaseAdAdapter.setLoadListener(aTCustomLoadListener);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void setBiddingListener(ATBiddingListener aTBiddingListener) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            Object[] objArr = new Object[1];
            iATBaseAdAdapter.setBiddingListener(aTBiddingListener);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void parseGlobalParams(Map<String, Object> map, Map<String, Object> map2) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            Object[] objArr = new Object[1];
            iATBaseAdAdapter.parseGlobalParams(map, map2);
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter == null) {
            return false;
        }
        Object[] objArr = new Object[1];
        iATBaseAdAdapter.setUserDataConsent(context, z, z2);
        return false;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            Object[] objArr = new Object[1];
            iATBaseAdAdapter.destory();
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        Object[] objArr = new Object[1];
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        return iATBaseAdAdapter != null ? iATBaseAdAdapter.getNetworkPlacementId() : "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        Object[] objArr = new Object[1];
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        return iATBaseAdAdapter != null ? iATBaseAdAdapter.getNetworkSDKVersion() : "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        Object[] objArr = new Object[1];
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        return iATBaseAdAdapter != null ? iATBaseAdAdapter.getNetworkName() : "";
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        Object[] objArr = new Object[1];
        com.anythink.core.common.l.d.b serverExtraInfo = getServerExtraInfo();
        if (serverExtraInfo != null && serverExtraInfo.q() != null) {
            return serverExtraInfo.q();
        }
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            return iATBaseAdAdapter.getNetworkInfoMap();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        Object[] objArr = new Object[1];
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        return iATBaseAdAdapter != null && iATBaseAdAdapter.isAdReady();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public com.anythink.core.common.l.d.b getServerExtraInfo() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            return iATBaseAdAdapter.getServerExtraInfo();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public View getMixView() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            return iATBaseAdAdapter.getMixView();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean supportImpressionCallback() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        return iATBaseAdAdapter == null || iATBaseAdAdapter.supportImpressionCallback();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public Map<Integer, Class<? extends ATBaseAdAdapter>> getFormatAdapterMap() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            return iATBaseAdAdapter.getFormatAdapterMap();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void setTrackingInfo(n nVar) {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter == null || iATBaseAdAdapter.getTrackingInfo() != null || nVar == null) {
            return;
        }
        this.c.setTrackingInfo(nVar);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public n getTrackingInfo() {
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            return iATBaseAdAdapter.getTrackingInfo();
        }
        return null;
    }

    private boolean a() {
        return !TextUtils.isEmpty(this.e) || this.c == null;
    }

    private IATBaseAdAdapter a(Map<String, Object> map, Map<String, Object> map2) {
        IATBaseAdAdapter iATBaseAdAdapterA;
        Class<? extends ATBaseAdAdapter> cls;
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        if (iATBaseAdAdapter != null) {
            iATBaseAdAdapter.parseGlobalParams(map, map2);
        }
        com.anythink.core.common.l.d.b serverExtraInfo = getServerExtraInfo();
        if (serverExtraInfo != null && serverExtraInfo.k()) {
            int iB = serverExtraInfo.b();
            if (this.d == null) {
                this.d = getFormatAdapterMap();
            }
            Map<Integer, Class<? extends ATBaseAdAdapter>> map3 = this.d;
            if (map3 == null || map3.size() <= 0 || (cls = this.d.get(Integer.valueOf(iB))) == null) {
                this.e = String.format(b, Integer.valueOf(iB));
            } else {
                try {
                    iATBaseAdAdapterA = u.a(cls.getName());
                } catch (Throwable th) {
                    Log.e("anythink", th.getMessage());
                    this.e = th.getMessage();
                    iATBaseAdAdapterA = null;
                }
            }
            iATBaseAdAdapterA = null;
        } else {
            iATBaseAdAdapterA = this.c;
        }
        if (iATBaseAdAdapterA != null && iATBaseAdAdapterA != this.c) {
            try {
                serverExtraInfo.a(iATBaseAdAdapterA);
                if (serverExtraInfo.l()) {
                    int iIntValue = ((Integer) q.a(map, "nw_firm_id", 0)).intValue();
                    if (iIntValue == 39 && map2 != null) {
                        Object obj = map2.get("huawei_request_custom_dislike");
                        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : true;
                        map2.put("huawei_request_custom_dislike", Boolean.valueOf(zBooleanValue));
                        if (zBooleanValue && !map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                            map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 2);
                        }
                    }
                    if (!serverExtraInfo.g() || map == null) {
                        if (serverExtraInfo.f() && iIntValue == 2 && map2 != null && !map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                            map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 2);
                        }
                    } else if (iIntValue != 2) {
                        if (iIntValue != 6) {
                            if (iIntValue == 8) {
                                if (!map.containsKey("video_muted")) {
                                    map.put("video_muted", "1");
                                }
                            } else if (iIntValue == 28 && !map.containsKey("video_sound")) {
                                map.put("video_sound", 0);
                            }
                        } else if (!map.containsKey("video_muted")) {
                            map.put("video_muted", "0");
                        }
                    } else if (map2 != null && !map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                        map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 0);
                    }
                }
                iATBaseAdAdapterA.parseGlobalParams(map, map2);
                iATBaseAdAdapterA.setTrackingInfo(this.c.getTrackingInfo());
            } catch (Throwable unused) {
            }
        }
        Object[] objArr = new Object[2];
        return iATBaseAdAdapterA;
    }

    private static void a(com.anythink.core.common.l.d.b bVar, Map<String, Object> map, Map<String, Object> map2) {
        if (bVar.l()) {
            int iIntValue = ((Integer) q.a(map, "nw_firm_id", 0)).intValue();
            if (iIntValue == 39 && map2 != null) {
                Object obj = map2.get("huawei_request_custom_dislike");
                boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : true;
                map2.put("huawei_request_custom_dislike", Boolean.valueOf(zBooleanValue));
                if (zBooleanValue && !map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                    map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 2);
                }
            }
            if (!bVar.g() || map == null) {
                if (!bVar.f() || iIntValue != 2 || map2 == null || map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                    return;
                }
                map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 2);
                return;
            }
            if (iIntValue == 2) {
                if (map2 == null || map2.containsKey(ATAdConst.KEY.AD_CHOICES_PLACEMENT)) {
                    return;
                }
                map2.put(ATAdConst.KEY.AD_CHOICES_PLACEMENT, 0);
                return;
            }
            if (iIntValue == 6) {
                if (map.containsKey("video_muted")) {
                    return;
                }
                map.put("video_muted", "0");
            } else if (iIntValue == 8) {
                if (map.containsKey("video_muted")) {
                    return;
                }
                map.put("video_muted", "1");
            } else if (iIntValue == 28 && !map.containsKey("video_sound")) {
                map.put("video_sound", 0);
            }
        }
    }
}
