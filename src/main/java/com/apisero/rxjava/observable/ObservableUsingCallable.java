package com.apisero.rxjava.observable;


import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ObservableUsingCallable {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCallable.class);

	public static String doSomething() {
		RxUtils.sleep(2000);
		return "Hello";
	}
	public static void main (String []args) {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return doSomething();
			}
		};		
		Observable.fromCallable(callable).subscribe(new DemoObserver<String>()); 
	}
}
