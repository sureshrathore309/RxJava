package com.apisero.rxjava.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ObservableUsingRange {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingRange.class);

	public static void main (String []args) {
		Observable observableUsingTimer = Observable.range(2, 10);
		observableUsingTimer.subscribe(new DemoObserver());
	}

}
