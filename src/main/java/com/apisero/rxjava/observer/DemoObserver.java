package com.apisero.rxjava.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observable.ObservableInJust;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoObserver implements Observer<String> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoObserver.class);

	public void onSubscribe(Disposable d) {
		LOGGER.info("onSubscribe");
	}

	public void onNext(String t) {
		LOGGER.info("onNext");
	}

	public void onError(Throwable e) {
		LOGGER.info("onError");
	}

	public void onComplete() {
		LOGGER.info("onComplete");
	}

}
