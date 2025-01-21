package com.umutavci;

import java.util.*;

public class MusikStueckSammlung {
    Map<Musikstueck, String> map = new HashMap<>();

    public void musikStueckEinfügen(Musikstueck neu){
        if(map.values().contains(neu.titel)){
            throw new IllegalArgumentException("");
        }
        map.put(neu, neu.titel);
    }

    public List<Musikstueck> getAlleMusikStueckeNachTitel() {
        List<Musikstueck> all = new ArrayList<>(map.keySet().stream().toList());
        all.sort(new VergleicheMusikStueckTitel());
        return all;
    }
    public List<Musikstueck> getAlleMusikStueckeNachLaenge(){
        List<Musikstueck> all = new ArrayList<>( map.keySet().stream().toList());
        all.sort(Comparator.comparingInt(p -> p.getLaenge()));
        // all.sort((p1, p2) -> Integer.compare(p1.getLaenge(), p2.getLaenge()))
        return all;
    }
}

