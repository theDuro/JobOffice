package com.example.jobOfice.domain.offer;

import com.example.jobOfice.domain.offer.dto.OferDto;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OfferFacade {
    private final OferRepository oferRepository;
    private static final int NUMBER_OF_ELEMENTS_ADDED_WHEN_DATABASE_IS_EAMPTY=4;
    private static final int NUMBER_OF_ELEMENTS_ADDED_WHEN_DATABASE_IS_NOT_EAMPTY = 2;



    public OfferFacade(OferRepository oferRepository) {
        this.oferRepository = oferRepository;
    }
    public List<Ofer> getAllOfer(){
        return oferRepository.findAll();
    }
    public OferDto getOferById(String id) throws NotBoundException {
        return OferMaper.mapfromOfer(
                Optional.of(oferRepository
                        .findOferById(id))
                        .orElseThrow( NotBoundException::new)
        );
    }
    public void saveOfer(Ofer ofer){
        oferRepository.save(ofer);

    }
    public void saveOferts(List<Ofer> oferts){
        if(oferRepository.isEmpty()){
            oferts.stream()
                    .limit(NUMBER_OF_ELEMENTS_ADDED_WHEN_DATABASE_IS_EAMPTY)
                    .peek(this::saveOfer);
        }else {
            oferts.stream()
                    .limit(NUMBER_OF_ELEMENTS_ADDED_WHEN_DATABASE_IS_NOT_EAMPTY)
                    .peek(this::saveOfer);

        }



    }
    public List<OferDto> getRemoteJobs(){
        return oferRepository.findAll()
                .stream()
                .filter(ofer -> ofer.typeOfJob().equals(TypeOfJob.REMOTE))
                .map(OferMaper::mapfromOfer)
                .collect(Collectors.toList());         
    }


}
