package concurrente.practica;

public class DummyTask extends Task{
	public DummyTask() {
		super();
	}

	public void exec() {
		System.out.println("DummyTask");
	}
}
