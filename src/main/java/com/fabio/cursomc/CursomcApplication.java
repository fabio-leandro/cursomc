package com.fabio.cursomc;

import com.fabio.cursomc.domain.*;
import com.fabio.cursomc.domain.enums.CustomerType;
import com.fabio.cursomc.domain.enums.StatusPayment;
import com.fabio.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null,"Informatica");
		Category c2 = new Category(null, "Office");

		Product p1 = new Product(null, "Computer",2000.00);
		Product p2 = new Product(null,"Printer",800.00);
		Product p3 = new Product(null,"Mouse",80.00);

		c1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		c2.getProducts().addAll(List.of(p2));

		p1.getCategories().addAll(List.of(c1));
		p2.getCategories().addAll(Arrays.asList(c1,c2));
		p3.getCategories().addAll(List.of(c1));

		categoryRepository.saveAll(Arrays.asList(c1,c2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));

		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");

		City city1 = new City(null,"Belo Horizonte", s1);
		City city2 = new City(null, "Campinas", s2);
		City city3 = new City(null, "São Paulo", s2);

		stateRepository.saveAll(Arrays.asList(s1,s2));
		cityRepository.saveAll(Arrays.asList(city1,city2,city3));

		Customer cli1 = new Customer(null,"Maria Silva","maria@gmail.com","36378912377",
				CustomerType.PESSOAFISICA);

		cli1.getPhones().addAll(Arrays.asList("27363323","93838393"));

		Address e1 = new Address(null,"Rua Flores","300","Apto 203","Jardim",
				"38220834",cli1,city1);

		Address e2 = new Address(null,"Avenida Matos","105","Sala 800","Centro",
				"38777012",cli1,city2);

		cli1.getAddresses().addAll(Arrays.asList(e1,e2));

		customerRepository.save(cli1);
		addressRepository.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Demand ped1 = new Demand(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Demand ped2 = new Demand(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));
		Payment pagto1 = new CardPayment(null, StatusPayment.QUITADO, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new SlipPayment(null, StatusPayment.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pagto2);
		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

	}
}
