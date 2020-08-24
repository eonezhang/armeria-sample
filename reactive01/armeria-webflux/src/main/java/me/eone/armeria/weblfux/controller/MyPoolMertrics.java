package me.eone.armeria.weblfux.controller;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/13-10:21 AM
 */
@Data
@Accessors(chain = true)
public class MyPoolMertrics {
    int maxAllocatedSized;
    int maxPendingAcquiredSize;
    int acquiredSize;
    int idleSize;
    int pendingAcquiredSize;

}
