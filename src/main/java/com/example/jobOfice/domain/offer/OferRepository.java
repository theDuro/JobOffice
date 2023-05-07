package com.example.jobOfice.domain.offer;

import java.util.List;

public interface OferRepository {
    Ofer save(Ofer ofer) ;

    Boolean isEmpty();
    Ofer findOferById(String id);
    List<Ofer> findAll();
    List<Ofer> savelistOffOferts(List<Ofer> oferts);

}
