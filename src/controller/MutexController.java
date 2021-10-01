package controller;

import br.com.leandrocolevati.filaint.Fila;

public class MutexController {

	public MutexController() {
		super();
	}
	
	public void semaphore(Fila f, int tid) {
		f.insert(tid);
	}
	
	public int acquire(Fila f) {
		int tid = f.remove();
		return tid;
	}
	
	public void run() {
		int tempo = (int)((Math.random() * 401) + 100);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int totalThreads(Fila f) {
		int tamanho = f.size();
		return tamanho;
	}
	
	public void listThreads(Fila f) {
		f.list();
	}

}
