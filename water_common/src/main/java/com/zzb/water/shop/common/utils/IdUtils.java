package com.zzb.water.shop.common.utils;

/**
 * @Author by 张志斌 .
 * @Date 10:34 2019/7/2
 */
public class IdUtils {
    static final long lastTimestamp = -1L;
    static final long sequenceBits = 12L;
    static final long sequenceMask = ~(-1L << sequenceBits);
    static final long workerIdBits = 5L;
    static final long dataCenterIdBits = 5L;
    static final long dataCenterIdShift = sequenceBits + workerIdBits;
    static final long workerIdShift = sequenceBits;
    static final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    static final long dataCenterId = 0L;
    static final long workerId = 0L;
    /**
     * Snowflake算法生成id,单机中id是递增的，但集群中id不能保证递增
     * @return
     */
    public static synchronized Long getId() {
        long timestamp = System.currentTimeMillis();
        long sequence = 0L;
        if(timestamp < -1L) {
            throw new RuntimeException(String.format("外部时钟发生变动，服务器拒绝了%d毫秒后的请求，请尝试重启服务。", lastTimestamp - timestamp));
        }

        if(lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0) {
                // 如果本毫秒内执行超过限定次数，则等待到下一毫秒继续执行，理论上不可能发生
                while(timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        long seed = 1288834974657L;
        return ((timestamp - seed) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence;
    }

}
