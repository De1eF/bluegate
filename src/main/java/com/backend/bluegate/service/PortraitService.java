package com.backend.bluegate.service;

import com.backend.bluegate.model.Portrait;

public interface PortraitService {
    Portrait getPortraitById(Long id);

    Portrait addPortrait(Portrait portrait);

    void updatePortrait(Long id, Portrait portrait);

    void deletePortrait(Long id);
}
