package org.skinny.drive_to_work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> persons() {
        return repository.findAll();
    }
}
