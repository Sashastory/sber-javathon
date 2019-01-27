package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoJsonObjectRepository extends MongoRepository<GeoJsonObject, String> {
}
