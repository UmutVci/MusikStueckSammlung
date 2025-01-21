package com.umutavci;

import java.util.Comparator;

public class VergleicheMusikStueckTitel implements Comparator<Musikstueck> {
    @Override
    public int compare(Musikstueck o1, Musikstueck o2) {
        return o1.titel.compareTo(o2.titel);
    }
}
