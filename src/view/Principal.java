package view;

import br.com.leandrocolevati.filaint.Fila;
import controller.MutexController;

public class Principal {

	public static void main(String[] args) {

		Fila f = new Fila();
		MutexController mCont = new MutexController();
		
		int threads = (int)((Math.random() * 50) + 1);
		System.out.println("Threads entrando na seção crítica");
		for (int i = 0 ; i < threads ; i++) {
			int tid = (int)((Math.random() * 8001) + 1000);
			mCont.semaphore(f, tid);
		}
		
		System.out.println();
		System.out.println("====================================================");
		int totalThreads = mCont.totalThreads(f);
		System.out.println("Inicializadas "+totalThreads+" threads");
		System.out.println("====================================================");
		System.out.println();

		System.out.println();
		System.out.println("====================================================");
		mCont.listThreads(f);
		System.out.println("====================================================");
		System.out.println();
		
		System.out.println("====================================================");
		System.out.println("Início do processamento da seção crítica");
		System.out.println("====================================================");

		while (!f.isEmpty()) {
			int tid = mCont.acquire(f);
			System.out.println("TID #"+tid+" pegou o semáforo");
			System.out.println("TID #"+tid+" está rodando");
			mCont.run();
			System.out.println("TID #"+tid+" liberou o semáforo");
		}
		
		System.out.println("====================================================");
		System.out.println("Término do processamento da seção crítica");
		System.out.println("====================================================");

	}

}
