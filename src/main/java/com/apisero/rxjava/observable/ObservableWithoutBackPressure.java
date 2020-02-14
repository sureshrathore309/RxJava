package com.apisero.rxjava.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableWithoutBackPressure {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackPressure.class);

	public static void main(String[] args) {
		Observable<Integer> positiveNumberEvents = Observable.fromIterable(RxUtils.postiveNumbers(1000000))
				.repeat()
				.observeOn(Schedulers.newThread())
				.subscribeOn(Schedulers.newThread());
		positiveNumberEvents.subscribe(new DemoObserver<Integer>());
		RxUtils.sleep(10000);
	}
}
