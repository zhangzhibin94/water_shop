package com.zzb.water.shop.core.utils;

/**
 * @Author by 张志斌 .
 * @Date 10:34 2019/7/2
 */
public class IdUtils {
    /**
     * Snowflake算法生成id，需要保证服务器集群的时钟相同
     * @return
     */
    private synchronized Long getId() {
        long timestamp = System.currentTimeMillis();

        long lastTimestamp = -1L;
        long sequence = 0L;
        long sequenceBits = 12L;
        long sequenceMask = ~(-1L << sequenceBits);
        long workerIdBits = 5L;
        long dataCenterIdBits = 5L;
        long dataCenterIdShift = sequenceBits + workerIdBits;
        long workerIdShift = sequenceBits;
        long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
        long dataCenterId = 0L;
        long workerId = 0L;
        if(timestamp < -1L) {
            throw new RuntimeException(String.format("外部时钟发生变动，服务器拒绝了%d毫秒后的请求，请尝试重启服务。", lastTimestamp - timestamp));
        }

        if(lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0) {
                // 如果本毫秒内执行超过限定次数，则等待到下一毫秒继续执行，理论上不可能发生
                while(timestamp <= lastTimestamp) {
                    timestamp = timeGen();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        long seed = 1288834974657L;
        return ((timestamp - seed) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }


}