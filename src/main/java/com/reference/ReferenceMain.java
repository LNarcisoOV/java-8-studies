package com.reference;

import java.util.Objects;

public class ReferenceMain {
	
	public static void main(String... args) {
		Reference ref1 = new Reference(1, "1");
		Reference ref2 = ref1;
		
		ref2.value = 2;
		ref2.name = "2";
		
		System.out.println(ref2 == ref1);
		System.out.println(ref1);
	}

}


class Reference {
	int value;
	String name;
	
	public Reference(int value, String name) {
		this.value = value;
		this.name = name;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reference other = (Reference) obj;
		return Objects.equals(name, other.name) && value == other.value;
	}



	@Override
	public String toString() {
		return "Reference [value=" + value + ", name=" + name + "]";
	}
	
	
}