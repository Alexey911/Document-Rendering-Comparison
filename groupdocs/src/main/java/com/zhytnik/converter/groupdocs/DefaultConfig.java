package com.zhytnik.converter.groupdocs;

import com.groupdocs.conversion.config.IConfig;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
class DefaultConfig implements IConfig {
    @Override
    public String getLicensePath() {
        return null;
    }

    @Override
    public String getStoragePath() {
        return null;
    }

    @Override
    public String getFileSavePath() {
        return null;
    }
}
