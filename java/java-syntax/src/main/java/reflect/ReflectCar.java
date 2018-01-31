package reflect;

public class ReflectCar {
	private String color;
	private String name;

	public ReflectCar(){}

	public ReflectCar(String name,String color){
			
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString(){
		return "col: "+color+" name: "+name;
	}

}
