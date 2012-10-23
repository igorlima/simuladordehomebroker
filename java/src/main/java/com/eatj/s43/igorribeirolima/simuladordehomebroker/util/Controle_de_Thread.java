package com.eatj.s43.igorribeirolima.simuladordehomebroker.util;

import java.util.HashSet;
import java.util.Set;

public class Controle_de_Thread {
	private final Set<Runnable> threads = new HashSet<Runnable>();
	
	public final Long maximoThread;
	public static final int tempo_de_sono_da_thread = 3000;
	
	public Controle_de_Thread(){
		this(10L);
	}
	
	public Controle_de_Thread( Long maximo_de_thread ){
		this.maximoThread = maximo_de_thread;
	}
	
	public synchronized void incremento( Runnable thread ){
		threads.add( thread );
	}
	
	public synchronized void decremento( Runnable thread ){
		threads.remove( thread );
	}

	public synchronized Long getQteThread() {
		return new Long( threads.size() );
	}
	
	public synchronized boolean limiteMaximo(){
		return threads.size() > maximoThread.intValue();
	}
}
