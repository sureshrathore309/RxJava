package com.apisero.rxjava.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ObservableUsingTimer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingTimer.class);

	public static void main (String []args) {
		Observable observableUsingTimer = Observable.timer(5, TimeUnit.SECONDS);
		observableUsingTimer.subscribe(new DemoObserver());
		RxUtils.sleep(10000);
	}

}
