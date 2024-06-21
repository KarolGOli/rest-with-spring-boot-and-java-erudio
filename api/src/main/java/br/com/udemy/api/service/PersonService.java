package br.com.udemy.api.service;

import br.com.udemy.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findByAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;


    }

    public Person findById(String id) {

        logger.info("Consultando uma pessoa!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Adriana");
        person.setLastName("Gomes");
        person.setAddress("São Carlos, São Paulo - Brasil");
        person.setGender("Feminino");

        return person;
    }

    public Person create(Person person) {
        logger.info("Criando o cadastro de uma pessoa!");
        return person;

    }

    public Person update(Person person) {
        logger.info("Atualizando o cadastro de uma pessoa!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deletando o cadastro de uma pessoa!");
    }

    private Person mockPerson (int i) {
        logger.info("Consultando uma lista de pessoas!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome: " + i);
        person.setLastName("Sobrenome: " + i);
        person.setAddress("Residente no Brasil: " + i);
        person.setGender("Feminino");

        return person;
    }

}
