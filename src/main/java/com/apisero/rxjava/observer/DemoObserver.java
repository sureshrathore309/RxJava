package com.apisero.rxjava.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observable.ObservableInJust;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoObserver<T> implements Observer<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoObserver.class);

	public void onSubscribe(Disposable d) {
		LOGGER.info("onSubscribe");
	}

	public void onNext(T t) {
		LOGGER.info("onNext : " + t);
	}

	public void onError(Throwable e) {
		LOGGER.error("onError : "+ e.getMessage());
	}

	public void onComplete() {
		LOGGER.info("onComplete");
	}

}
