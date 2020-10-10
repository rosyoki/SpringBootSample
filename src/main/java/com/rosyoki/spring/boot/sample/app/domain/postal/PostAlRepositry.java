package com.rosyoki.spring.boot.sample.app.domain.postal;

import java.util.List;
import java.util.Optional;

public interface PostAlRepositry {
    public List<Postal> getPostAlDataByCity(City city);
    public Optional<Postal> getPostDataByZip(NewZip newZip);
    public Optional<Postal> getPostDataByCityTown(City city, Town town);
}
