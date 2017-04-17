package huy.my_books.mode;

public class ActorMode {

	private int idActor;
	private String nameActor;
	private String age;

	public ActorMode() {
	}

	public ActorMode(int idActor, String nameActor, String age) {
		super();
		this.idActor = idActor;
		this.nameActor = nameActor;
		this.age = age;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public String getNameActor() {
		return nameActor;
	}

	public void setNameActor(String nameActor) {
		this.nameActor = nameActor;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
