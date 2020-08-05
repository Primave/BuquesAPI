package ar.com.ada.api.buquespuertos.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.buquespuertos.entities.Puerto;

@Repository
public interface PuertoRepositoy extends MongoRepository<Puerto,ObjectId> {

    Puerto findBy_id(ObjectId id);
    
    
}