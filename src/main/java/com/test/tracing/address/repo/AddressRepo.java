package com.test.tracing.address.repo;

import com.test.dto.Address;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AddressRepo {

    private Map<String, Address> addressMap;

    public AddressRepo(){
        addressMap = new HashMap<String,Address>(){{
            put("15",new Address("1156FG", "56", "Zoonestein"));
            put("16",new Address("1166TY", "21", "Amstelveen"));
            put("17",new Address("2231ZX", "12", "Arenapoort"));
        }};

    }


    public Address getAddress(String id) {
        return addressMap.get(id);
    }
}
