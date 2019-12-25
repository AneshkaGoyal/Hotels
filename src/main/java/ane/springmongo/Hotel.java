package ane.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotel")
public class Hotel {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Hotel(String id, String name, Long price,Address address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Long price;
    private Address address;

}
