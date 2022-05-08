package com.zhourup.zcourse.constant;

import com.google.common.collect.ImmutableSet;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * 通用常量
 *
 * @author zhourup
 * @date 2022/5/5 15:16
 */
public class CommonConst {

    public static final class CommonCollection {
        public static final Set<String> IGNORE_URL = ImmutableSet.of("/swagger");

        public static boolean contain(Set<String> ignores, String uri) {
            if (CollectionUtils.isEmpty(ignores)) {
                return false;
            }
            for (String ignoreUrl : ignores) {
                if (uri.startsWith(ignoreUrl)) {
                    return true;
                }
            }
            return false;
        }
    }
}
