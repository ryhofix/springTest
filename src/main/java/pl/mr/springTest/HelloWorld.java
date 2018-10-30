package pl.mr.springTest;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class HelloWorld {

    @Autowired
    public CustomerRepository customerRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "/add/{name}/{surname}", method = RequestMethod.GET)
    public String addCustomer(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPesel(UUID.randomUUID().toString());
        customerRepository.save(customer);
        return name + " | " + surname;
    }

    @RequestMapping(value = "/search/{surname}", method = RequestMethod.GET)
    public String getCustomers(@PathVariable("surname") String name) {
        return StringUtils.join(
                customerRepository
                        .findBySurname(name)
                        .stream()
                        .map(Customer::getName)
                        .collect(Collectors.toList()),
                ','
        );
    }

}
