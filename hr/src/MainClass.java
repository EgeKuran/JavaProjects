import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MainClass {
	
	public static void main(String[] args) {
		List<Person> people = Person.createShortList();
		
		System.out.println("Total Salaries:" + people.stream().mapToDouble(Person::getSalary).average().getAsDouble());
		people.stream().filter(t->t.getGender()==Gender.MALE).filter(t->t.getAge()>=50).forEach(p->System.out.println(p.getGivenName() +":"));
		List<String> givenNames = people.stream().map(Person::getGivenName).collect(Collectors.toList());
		givenNames.forEach(t ->System.out.println(t));		
	
		Optional<Person> p =people.stream().filter(t->t.getCity().equals("Smallville")).findFirst();
		
		System.out.println(p);
		// Keys not sorted
		Map<String, List<Person>> pData =people.stream().collect(Collectors.groupingBy(Person::getState));
		// Keys sorted
		Map<String, List<Person>> pDataSorted =  people.stream().collect(Collectors. groupingBy(Person:: getCity, TreeMap::new, Collectors.toList()));
		
		pData.keySet().forEach(key->{	 System.out.println(key);
			pData.get(key).forEach(Person::print); });
		
		System.out.println("-----------------------");
		
		pDataSorted.keySet().forEach(key->{	System.out.println(key);
		pDataSorted.get(key).forEach(Person::print); });
		
		Optional<Person>maxSalaryPer = people.stream().max(Comparator.comparing(Person::getSalary));
		System.out.println(maxSalaryPer );
		
		people.forEach(Person::print);
	}

}
