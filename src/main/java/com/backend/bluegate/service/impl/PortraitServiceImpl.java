package com.backend.bluegate.service.impl;

import com.backend.bluegate.exception.ResourceNotFoundException;
import com.backend.bluegate.model.Portrait;
import com.backend.bluegate.repository.PortraitRepository;
import com.backend.bluegate.service.PortraitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PortraitServiceImpl implements PortraitService {
    private final PortraitRepository portraitRepository;

    @Override
    public Portrait getPortraitById(Long id) {
        return portraitRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("portrait not found"));
    }

    @Override
    public Portrait addPortrait(Portrait portrait) {
        return portraitRepository.save(portrait);
    }

    @Override
    public void updatePortrait(Long id, Portrait portrait) {
        getPortraitById(id);
        portrait.setId(id);
        portraitRepository.save(portrait);
    }

    @Override
    public void deletePortrait(Long id) {
        portraitRepository.delete(getPortraitById(id));
    }
}
