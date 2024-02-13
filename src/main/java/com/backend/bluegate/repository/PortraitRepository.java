package com.backend.bluegate.repository;

import com.backend.bluegate.model.Portrait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortraitRepository extends JpaRepository<Portrait, Long> {
}
