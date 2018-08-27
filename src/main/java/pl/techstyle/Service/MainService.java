package pl.techstyle.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.techstyle.Model.Person;

@Service
public class MainService {

	List<Person> person= new ArrayList<>(); 
	
	public MainService() {
		person.add(new Person(1,"Jan", "Kowalski", 23, 76, 167));
		person.add(new Person(2,"Jan", "Nowak", 33, 73, 177));
		person.add(new Person(3,"Marek", "Juer", 55, 76, 175));
		person.add(new Person(4,"Andrzej", "Kowalski", 33, 74, 169));
		person.add(new Person(5,"Mariusz", "Mariuszyn", 23, 76, 164));
		person.add(new Person(6,"Jakub", "Kowalski", 53, 86, 177));
	}
	
	public List<Person> getAll(){
		return person;
	}
	public Person getPerson(int id) {
		return person.stream().filter((t)->{
			return t.getId()==id;
		} ).findFirst()
		.get();
	}
	public void editPerson(Person p) {
	for(int i=0;i<person.size();i++) {
		if(person.get(i).getId()==p.getId()) {
			person.set(i,p);
		}
	}
	}
}
