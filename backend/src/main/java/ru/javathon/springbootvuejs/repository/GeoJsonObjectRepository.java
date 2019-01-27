package ru.javathon.springbootvuejs.repository;

import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoJsonObjectRepository extends MongoRepository<GeoJsonObject, String> {
}
