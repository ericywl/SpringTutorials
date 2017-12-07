package com.mkyong.services;

import com.mkyong.model.Slot;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {

    private List<Slot> slots;

    public List<Slot> findByProfAlias(String username) {

        List<Slot> result = slots.stream()
                .filter(x -> x.getProfAlias().equalsIgnoreCase(username))
                .collect(Collectors.toList());

        return result;

    }

    @PostConstruct
    private void iniDataForTesting() {

        slots = new ArrayList<>();

        Slot slot1 = new Slot(LocalDateTime.of(2017, 12, 3, 9, 0), "OKA");
        Slot slot2 = new Slot(LocalDateTime.of(2017, 12, 4, 14, 0), "MAN");
        Slot slot3 = new Slot(LocalDateTime.of(2017, 12, 4, 15, 0), "DATTA");

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
    }

}
