package com.example.jobOfice.domain.offer;

import com.example.jobOfice.domain.offer.Ofer;
import com.example.jobOfice.domain.offer.OferRepository;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemeoryOferRepository implements OferRepository {
    Map<String, Ofer> inMemoryDataBase = new ConcurrentHashMap<>();

    @Override
    public Ofer save(Ofer ofer) throws DuplicateKeyException {
        if(inMemoryDataBase.containsKey(ofer.id())){
            throw new RuntimeException();
        }
        return inMemoryDataBase.put(ofer.id(),ofer);
    }

    @Override
    public Boolean isEmpty() {
        return inMemoryDataBase.isEmpty();

    }

    @Override
    public Ofer findOferById(String id) {
        return null;
    }

    @Override
    public List<Ofer> findAll() {
        return null;
    }

    @Override
    public List<Ofer> savelistOffOferts(List<Ofer> oferts) {
        return null;
    }
}
