package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.gsonobject.yandex.YandexObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoYandexObjectRepository extends MongoRepository<YandexObject, String> {
}
