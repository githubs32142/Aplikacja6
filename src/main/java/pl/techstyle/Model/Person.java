package pl.techstyle.Model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Person {
	private int id;
	@NotNull(message="Imie nie może być puste. Prosze uzupełnić pole.")
	private String name;
	@NotNull(message="Nazwisko nie może być puste. Prosze uzupełnić pole.")
	private String surName;
	@NotNull(message="Wiek nie może być pusty. Prosze uzupełnić pole.")
	@Range(min=1,max=150, message="Wiek liczony jest w przedzaile od 0 do 150 lat")
	private  int  age;
	@NotNull(message="Waga nie może posiadać wartości pustej. Proszę uzupełnić pole")
	@Range(min=10,max=200, message="Waga mieści się w przedziale od 0 200 kg")
	private double weight;
	@NotNull(message="Wysokość nie może posiadać wartości pustej. Proszę uzupełnić pole")
	@Range(min=10,max=250, message="Wysokość mieści się w przedziale od 10 250 cm")
	private double height;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surName=" + surName + ", age=" + age + ", weight=" + weight
				+ ", height=" + height + "]";
	}
	public Person(int id, String name, String surName, int age, double weight, double height) {
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}

}
