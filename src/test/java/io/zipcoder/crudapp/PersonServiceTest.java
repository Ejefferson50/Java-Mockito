package io.zipcoder.crudapp;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

//    When the method you are testing return something
    @Test
    public void testCreate(){

        //Given
        Person person = new Person("aa", "bb");

        // 1. create mock
        PersonRepository mockRepo = mock(PersonRepository.class);

        // 2. what do you want the mock to do
        // here we're setting up the data to return
        long expectedId = 14;
        Person personToReturn = new Person("aa", "bb");
        personToReturn.setId(expectedId);

        //then we say when the method save get called with the
        //person then return the person we set up above
        when(mockRepo.save(person)).thenReturn(personToReturn);

        // 3. create the class you're testing
        PersonService service = new PersonService(mockRepo);

        // 4. call the method under test
        Person actual = service.create(person);

        // 5. verify the result
        // Because we said on step two that when our mock
        // get call with save, then it will return a person
        // with id 14.
        Assert.assertEquals(expectedId, actual.getId());
    }

    // When the method does not return anything
    @Test
    public void testUpdate(){

        //Given
        Person person = new Person("aa", "bb");

        // 1. create mock
        PersonRepository mockRepo = mock(PersonRepository.class);

        // notice I didn't mock out the return
        // because the service doesn't use the return object

        // 2. create the class you're testing
        PersonService service = new PersonService(mockRepo);

        // 3. call the method under test
        service.update(person);

        // 6. verify the result
        // Make sure the method save got call with the person
        verify(mockRepo).save(person);
    }
}
