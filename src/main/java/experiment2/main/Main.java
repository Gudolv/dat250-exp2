package experiment2.main;

import experiment2.tables.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "bank";

    public static void main(String[] args){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setNumber(28);
        address.setStreet("Inndalsveien");

        person.getAddress().add(address);
        address.getPersons().add(person);

        em.persist(person);
        em.persist(address);

        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);

        Pincode pincode = new Pincode();

        pincode.setPincode("1234");
        em.persist(pincode);

        Pincode pincode1 = new Pincode();
        pincode1.setPincode("5678");
        em.persist(pincode1);

        CreditCard creditCard = new CreditCard();

        creditCard.setNumber(12345);
        creditCard.setBalance(-5000);
        creditCard.setLimit(-10000);
        em.persist(creditCard);

        creditCard.setCode(pincode);
        pincode.setCard(creditCard);
        creditCard.setBank(bank);
        person.getCliste().add(creditCard);
        bank.getCliste().add(creditCard);

        CreditCard creditCard2 = new CreditCard();

        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);
        em.persist(creditCard2);

        creditCard2.setCode(pincode1);
        pincode1.setCard(creditCard2);
        creditCard2.setBank(bank);
        person.getCliste().add(creditCard2);
        bank.getCliste().add(creditCard2);

        em.getTransaction().commit();

        em.close();




    }

}
