package susanna.zoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;






public class Cage<T extends Animal> {
  static int lastId = 0;
  private Set<T> guests;
  private int id;
  private int max;
  
  
  public Cage(int max) {
	  guests = new HashSet<>(); // fra <> non ho bisogno di specificare nulla perché avevo già detto che è Animal 
      lastId += 1;
      this.id = lastId;
	  this.max = max;
  }


public int getId() {
	return id;
}
 
public boolean add(T animal) { //non serve controllare di non inserire due animali con lo stesso nome perchè tanto nel set non possono esserci due elementi uguali
	// TODO: reject duplicated name
	if(max == guests.size()) {
		return false;
	}
	guests.add(animal);
	return true;
}

public Optional<T> remuve(String name) {
	Iterator<T> it = guests.iterator();
	// TODO: 
	while(it.hasNext()) { //l'iteratore continua fin quando ho un successore nella mia sequenza
		T animal = it.next();
		if(animal.getName().equals(name)) {
			return Optional.of(animal);
		}
	}
	return Optional.empty();
}
// TODO:
  @Override
	public String toString() {
		return "{ Cage" + id + ": " + guests + "}" ; 
	}
}
