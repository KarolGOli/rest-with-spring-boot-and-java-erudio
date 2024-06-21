package br.com.udemy.api.service;

import br.com.udemy.api.exceptions.ResourceNotFoundException;
import br.com.udemy.api.model.Person;
import br.com.udemy.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findByAll() {
        logger.info("Consultando uma lista de pessoas cadastradas.");

        return personRepository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Consultando uma pessoa!");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há cadastro nesse ID."));
    }

    public Person create(Person person) {
        logger.info("Criando o cadastro de uma pessoa!");
        return personRepository.save(person);

    }

    public Person update(Person person) {
        logger.info("Atualizando o cadastro de uma pessoa!");

        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro nesse ID."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deletando o cadastro de uma pessoa!");

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro nesse ID."));

        personRepository.delete(entity);
    }
}
