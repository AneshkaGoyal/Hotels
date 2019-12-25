package ane.springmongo;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
   private HotelRepo hrep;
    @Autowired
    public HotelController(HotelRepo hrep) {
        this.hrep = hrep;
    }

    @GetMapping("/getall")
    public List<Hotel> gethotel(){
        List<Hotel> ht = this.hrep.findAll();
        return hrep.findAll();
    }
    @PutMapping
    public void putHotel(@RequestBody Hotel hotel){
        hrep.insert(hotel);
    }
    @PostMapping
    public void postHotel(@RequestBody Hotel hotel){
        hrep.save(hotel);
    }
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable("id") String id){
        hrep.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<Hotel> findMyHotel(@PathVariable("id") String id){
        Optional<Hotel> hotel = hrep.findById(id);
        return hotel;
    }
    @GetMapping("/price/{max}")
    public List<Hotel> findByPrice(@PathVariable("max")int max){
        List<Hotel> hts = hrep.findByPriceLessThan(max);
        return hts;

    }
    @GetMapping("/mycity/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> ht = hrep.findByCity(city);
        return ht;
    }
    @GetMapping("/mycountry/{country}")
    public List<Hotel> getByCoutry(@PathVariable("country") String country){
        QHotel qhotel = new QHotel("hotel");
        BooleanExpression exp = qhotel.address.country.eq(country);
        List<Hotel> ht = (List<Hotel>) hrep.findAll(exp);
        return ht;
    }
    @GetMapping("/myhotel/{country}")
    public List<Hotel> getMyHotel(@PathVariable("country")String country){
        QHotel qhotel = new QHotel("hotel");
        BooleanExpression exp = qhotel.address.country.eq(country);
        BooleanExpression exp2 = qhotel.price.lt(25);
        List<Hotel> ht = (List<Hotel>) hrep.findAll(exp.and(exp2));
        return ht;
    }

}
