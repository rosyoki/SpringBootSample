package com.rosyoki.spring.boot.sample.app.domain.postal;

import java.util.List;

public interface PostAlRepositry {
    public List<Postal> getPostAlDataByCity(City city);
    public Postal getPostDataByZip(NewZip newZip);
    public Postal getPostDataByCityTown(City city, Town town);
}
