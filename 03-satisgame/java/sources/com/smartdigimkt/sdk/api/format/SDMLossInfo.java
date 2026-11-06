package com.smartdigimkt.sdk.api.format;

import com.smartdigimkt.r4.n;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMLossInfo {
    public static final int LOSS_REASON_CLIENT_BID_FAIL = 3;
    public static final int LOSS_REASON_EXPIRE = 4;
    public static final int LOSS_REASON_TIMEOUT = 2;
    private final SDMAdConst.CURRENCY currency;
    private final Map<String, Object> extraMap;
    private final LOSS_REASON lossReason;
    private final int lossReasonCode;
    private final SEAT_ID seatId;
    private final double winPrice;

    public enum LOSS_REASON {
        LOSS_TO_HIGHER_BID(1),
        LOSS_TO_MEDIA_TIMEOUT(5),
        LOSS_TO_MEDIA_BLOCK(6),
        LOSS_TO_OTHER(7);

        private final int code;

        LOSS_REASON(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum SEAT_ID {
        THIRD_PARTY_ADN(1),
        SELF_SALE(2);

        private final int code;

        SEAT_ID(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public SDMLossInfo(LOSS_REASON loss_reason, double d, SEAT_ID seat_id) {
        this(loss_reason, d, seat_id, SDMAdConst.CURRENCY.USD);
    }

    public static boolean isInternalLossReason(int i) {
        return i == 2 || i == 3 || i == 4;
    }

    public static SDMLossInfo newInternalLossInfo(int i) {
        return new SDMLossInfo(i, 0.0d, (SEAT_ID) null, SDMAdConst.CURRENCY.USD, (Map<String, Object>) null);
    }

    public SDMAdConst.CURRENCY getCurrency() {
        return this.currency;
    }

    public Map<String, Object> getExtraMap() {
        return this.extraMap;
    }

    public LOSS_REASON getLossReason() {
        return this.lossReason;
    }

    public int getLossReasonCode() {
        return this.lossReasonCode;
    }

    public SEAT_ID getSeatId() {
        return this.seatId;
    }

    public double getWinPrice() {
        return this.winPrice;
    }

    public SDMLossInfo(LOSS_REASON loss_reason, double d, SEAT_ID seat_id, SDMAdConst.CURRENCY currency) {
        this(loss_reason, d, seat_id, currency, (Map<String, Object>) null);
    }

    public double getWinPrice(SDMAdConst.CURRENCY currency) {
        double d = this.winPrice;
        SDMAdConst.CURRENCY currency2 = this.currency;
        if (d <= 0.0d) {
            return 0.0d;
        }
        return currency2 != null ? n.a(d, currency2, currency) : d;
    }

    public SDMLossInfo(LOSS_REASON loss_reason, double d, SEAT_ID seat_id, SDMAdConst.CURRENCY currency, Map<String, Object> map) {
        this.lossReason = loss_reason;
        this.lossReasonCode = loss_reason != null ? loss_reason.getCode() : 0;
        this.winPrice = d;
        this.seatId = seat_id;
        this.currency = currency;
        this.extraMap = map;
    }

    public SDMLossInfo(int i, double d, SEAT_ID seat_id, SDMAdConst.CURRENCY currency, Map<String, Object> map) {
        this.lossReason = null;
        this.lossReasonCode = i;
        this.winPrice = d;
        this.seatId = seat_id;
        this.currency = currency;
        this.extraMap = map;
    }
}
