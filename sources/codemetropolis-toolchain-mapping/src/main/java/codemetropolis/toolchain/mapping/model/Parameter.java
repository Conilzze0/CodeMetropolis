package codemetropolis.toolchain.mapping.model;

public class Parameter {

	String name;
	String value;
	
	public Parameter() {
		this("", "");
	}
	
	public Parameter(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
