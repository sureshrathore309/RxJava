package com.apisero.rxjava.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;

import io.reactivex.Observable;

public class ObservableInJust {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableInJust.class);
	public static void main(String[] args) {
		Observable.just("a", "b", "c", "d", "e", "f", "g", "i", "j").subscribe(new DemoObserver());
		
	}
}