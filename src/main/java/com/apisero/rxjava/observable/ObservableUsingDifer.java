package com.apisero.rxjava.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ObservableUsingDifer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingDifer.class);
	public static void main (String []args) {
		Observable<Integer> observableUsingDifer = Observable.defer(()->{
			return Observable.fromIterable(RxUtils.postiveNumbers(5));
		});
		observableUsingDifer.subscribe(new DemoObserver<Integer>());
		observableUsingDifer.subscribe(new DemoObserver<Integer>());

	}

}
