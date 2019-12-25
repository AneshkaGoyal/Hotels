package ane.springmongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends MongoRepository<Hotel,String>,QuerydslPredicateExecutor<Hotel>{
    List<Hotel> findByPriceLessThan(int max);
    @Query(value = "{'address.city':?0}")
    List<Hotel>findByCity(String city);

    //Optional<Hotel> findById(String id);


}
