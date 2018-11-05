package com.in28minutes.rest.webservices.controllers.versioning;


import com.in28minutes.rest.webservices.domain.versioning.Name;
import com.in28minutes.rest.webservices.domain.versioning.PersonV1;
import com.in28minutes.rest.webservices.domain.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
