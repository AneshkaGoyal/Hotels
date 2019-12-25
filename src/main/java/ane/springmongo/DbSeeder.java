package ane.springmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepo hotelRepo;

    public DbSeeder(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel maariot = new Hotel("12","mariot", (long) 23,new Address("paris","Europe"));
        Hotel taj = new Hotel("13","Taj", (long) 20,new Address("toronto","canada"));
        hotelRepo.deleteAll();
        hotelRepo.save(maariot);
        hotelRepo.save(taj);
    }
}
