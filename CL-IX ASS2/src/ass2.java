import mpi.*;

public class ass2 {
	public static void main(String[] args) throws Exception {
		System.out.println("INside main");
		MPI.Init(args);
		System.out.println("Init called");
		int me = 	MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		System.out.println("HI FROM MPI ");
		MPI.Finalize();


	}
}
